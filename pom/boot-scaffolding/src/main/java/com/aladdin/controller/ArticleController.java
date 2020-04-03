package com.aladdin.controller;

import com.aladdin.common.ResponseResult;
import com.aladdin.common.ResponseResultBuilder;
import com.aladdin.dao.ArticleRepository;
import com.aladdin.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/list")
    public Page<Article> list(@RequestParam(value = "pageNo") int pageNo,
                              @RequestParam(value = "pageSize") int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by("createTime"));
        //数据库操作获取查询结果
        Page<Article> articlePage = articleRepository.findAll(pageable);
        //将查询结果转换为List
        List<Article> articleList = articlePage.getContent();
        return articlePage;
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody Article article) {
        Article save = articleRepository.save(article);
        return ResponseResultBuilder.success(save);
    }

    @GetMapping("/sort")
    public ResponseResult sort() {
        List<Article> createTime = articleRepository.findAll(Sort.by("createTime"));

        List<Article> all = articleRepository.findAll(Sort.by("author").ascending()
                .and(Sort.by("createTime").descending()));
        return ResponseResultBuilder.success(all);
    }

}
