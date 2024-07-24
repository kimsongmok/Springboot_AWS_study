package springPrac.springboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springPrac.springboot.domain.posts.Posts;
import springPrac.springboot.domain.posts.PostsRepository;
import springPrac.springboot.web.dto.PostsResponseDto;
import springPrac.springboot.web.dto.PostsSaveRequestDto;
import springPrac.springboot.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto){
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto){
    Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = " +id));

    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;

  }

  public PostsResponseDto findById (Long id){
    Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " +id));

    return new PostsResponseDto(entity);
  }
}
