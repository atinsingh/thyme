package io.pragra.learning.thymeleaf2.repo;

import io.pragra.learning.thymeleaf2.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
    @Query("select count(p) from Blog p")
    Integer countAll();
}
