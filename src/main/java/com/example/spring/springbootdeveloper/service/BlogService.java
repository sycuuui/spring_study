package com.example.spring.springbootdeveloper.service;

import com.example.spring.springbootdeveloper.dto.AddArticleReqest;
import com.example.spring.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.spring.repository.BlogRepository;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메소드
    public Article save(AddArticleReqest request){
        return blogRepository.save(request.toEntity());
    }

    //데이터베이스에 저장되어있는 글 모두 가져오기
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}
