package com.aladdin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lgc
 **/

//集合名
@Document(collection = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {
    private String id;
    @Indexed
    private String author;
    @Field(value = "title")
    private String title;
    private String content;
    //创建自动赋值
    @CreatedDate
    private LocalDateTime createTime;
}
