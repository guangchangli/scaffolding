package com.aladdin.dao;

import com.aladdin.entity.Article;
import com.aladdin.entity.ArticleExample;
import org.springframework.stereotype.Repository;

/**
 * ArticleDao继承基类
 */
@Repository
public interface ArticleDao extends MyBatisBaseDao<Article, Long, ArticleExample> {

}