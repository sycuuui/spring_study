package com.example.spring.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
//블로그 글 수정 요청 받을 DTO
public class UpdateArticleRequest {
    private String title;
    private String content;
}
