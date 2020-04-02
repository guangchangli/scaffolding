package com.aladdin.controller;

import com.aladdin.common.ResponseResult;
import com.aladdin.common.ResponseResultBuilder;
import com.aladdin.dao.ArticleRepository;
import com.aladdin.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
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
    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/save")
    public String saveArticle(@RequestBody Article article) {
        mongoTemplate.save(article);
        return HttpStatus.OK.getReasonPhrase();
    }

    @GetMapping("/list")
    public ResponseResult<List<Article>> getAll() {
        List<Article> all = mongoTemplate.findAll(Article.class);

        return ResponseResultBuilder.success(all);
    }

    @GetMapping("/list1")
    public List<Article> getAll1() {
        return articleRepository.findAll();
    }
}
