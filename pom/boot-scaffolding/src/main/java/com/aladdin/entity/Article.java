package com.aladdin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lgc
 **/
@Document(collection = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {
    private String id;
    @Indexed
    private String author;
    private String title;
    private String content;
    //创建自动赋值
    @CreatedDate
    private LocalDateTime createTime;
}
