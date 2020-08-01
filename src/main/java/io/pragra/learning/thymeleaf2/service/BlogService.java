package io.pragra.learning.thymeleaf2.service;

import io.pragra.learning.thymeleaf2.domain.Blog;
import io.pragra.learning.thymeleaf2.repo.BlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class BlogService {

    private BlogRepo repo;

    public BlogService(BlogRepo repo) {
        this.repo = repo;
    }

    public Blog createBlog(Blog blog) {
        if(blog.getTitle().isEmpty()){
            throw new RuntimeException("Title must be set");
        }
        return this.repo.save(blog);
    }

    public int countAll() {
        return this.repo.countAll();
    }

    public List<Blog> getAll(){
        return this.repo.findAll();
    }

    public Blog getById(Long id){
        return this.repo.findById(id)
                .orElseThrow(()->new RuntimeException("Invalid Id or No Data"));
    }
}
