package com.aladdin.controller;

import com.aladdin.common.ResponseResult;
import com.aladdin.common.ResponseResultBuilder;
import com.aladdin.dao.ArticleRepository;
import com.aladdin.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {
    /**
     * 使用 save和insert都可以进行插入
     * 区别：当存在"_id"时
     * insert 插入已经存在的id时 会异常
     * save 则会进行更新
     * save 就是不存在插入 存在更新
     */

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

    @GetMapping("/get")
    public List<Article> get(@RequestParam(value = "author") String author) {
        //查找 article根据Criteria 改造查询条件
        Query query = new Query(Criteria.where("author").is(author));
        List<Article> articles = mongoTemplate.find(query, Article.class);
        Article byAuthor = articleRepository.findByAuthor(author);
        return articles;
    }

    @GetMapping("/getByAuthor")
    public Article getByAuthor(@RequestParam(value = "author") String author) {
        Article byAuthor = articleRepository.findByAuthor(author);
        return byAuthor;
    }
}
