package com.aladdin.controller;

import com.aladdin.dao.ArticleDao;
import com.aladdin.entity.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/article")
public class MybatisController {

    @Autowired
    ArticleDao articleDao;

    @GetMapping("/list")
    public PageInfo<Article> articlePage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        //PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效
        PageHelper.startPage(pageNo, pageSize);
        List<Article> articleList = articleDao.selectByExample(null);
//        return PageInfo.of(articleList);
        return PageHelper.startPage(1, 10).doSelectPageInfo(() -> articleDao.selectByExample(null));
    }
}
