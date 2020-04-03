package com.aladdin.dao;

import com.aladdin.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lgc
 **/
public interface ArticleRepository extends MongoRepository<Article,String> {

    Article findByAuthor(String author);
}
