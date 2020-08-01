package io.pragra.learning.thymeleaf2.controller;

import io.pragra.learning.thymeleaf2.domain.Blog;
import io.pragra.learning.thymeleaf2.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    private BlogService service;

    public IndexController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAllBlogs(Model model){
        model.addAttribute("title", "Personal Blogs by Pr");
        model.addAttribute("blogs", service.getAll());
        return "index";
    }


    @PostMapping("/save")
    public String saveBlog(@ModelAttribute("blogForm") Blog blog, Model model){
        this.service.createBlog(blog);
        return "index";
    }
}
