package com.example.spring.springbootdeveloper.service;

import com.example.spring.springbootdeveloper.dto.AddArticleReqest;
import com.example.spring.domain.Article;
import com.example.spring.springbootdeveloper.dto.UpdateArticleRequest;
import jakarta.transaction.Transactional;
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

    //글 하나 조회하기
    public Article findById(long id){
        //findById 메소드 - JPA에서 제공함
        return blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found"+id));
    }

    //글 삭제하기
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    //글 수정하기
    @Transactional // 트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"+id));
        article.update(request.getTitle(),request.getContent());

        return article;
    }
}
