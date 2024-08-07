package springPrac.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostsRepository extends JpaRepository<Posts, Long> {
  //@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
  List<Posts> findAllByOrderByIdDesc();
}
