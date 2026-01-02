package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
  private Long id;
  private String title;
  private String content;

  // 생성자는 "@AllArgsConstructor"로 대체
//  public ArticleForm(String title, String content) {
//    this.title = title;
//    this.content = content;
//  }

  // toString()은 "@ToString"으로 대체
//  @Override
//  public String toString() {
//    return "ArticleForm{" +
//        "title='" + title + '\'' +
//        ", content='" + content + '\'' +
//        '}';
//  }

  // DTO -> Entity
  public Article toEntity() {
    return new Article(id,title,content);
  }
}
