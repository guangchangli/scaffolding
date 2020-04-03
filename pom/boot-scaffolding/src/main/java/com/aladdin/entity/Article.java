package com.aladdin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lgc
 **/
@Entity
@Table(name = "article")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Cacheable
public class Article {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, unique = false, length = 50)
    private String title;
    @Column(name = "author", length = 30)
    private String author;
    @Column(length = 200)
    private String content;
    //@Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //Transient 不映射
    //@Enumerated(EnumType.STRING)  数据库存储枚举对应数据
    //length 只对 string 类型有效果
}
