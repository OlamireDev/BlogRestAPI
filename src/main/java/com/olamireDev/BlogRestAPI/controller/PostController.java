package com.olamireDev.BlogRestAPI.controller;

import com.olamireDev.BlogRestAPI.model.Post;
import com.olamireDev.BlogRestAPI.service.PostService;
import com.olamireDev.BlogRestAPI.serviceImpl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/blog")
public class PostController {

    private PostService postService;

    public PostController(PostServiceImpl postService){
        this.postService = postService;
    }

    @GetMapping(value  = "")
    public List<Post> getAllBlogs(){
        return postService.getAllPost();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createPost(@RequestBody Post post){
        postService.create(post);
    }


    @GetMapping(value = "/{category}")
    public List<Post> getCategoryBlogs(@PathVariable ("category") String cat){
        return  postService.getCategoryPost(cat);
    }

    @GetMapping(value = "info/{id}")
    public Optional<Post> getBlog(@PathVariable ("id") String id){
        return  postService.getPost(Long.valueOf(id));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "info/{id}")
    public void editBlog(@RequestBody Post post, @PathVariable("id") Long id){
        post.setId(id);
        postService.updatePost(post);
    }
    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping(value = "info/{id}")
    public void deleteBlog(@PathVariable ("id") String id){
        postService.delete(Long.valueOf(id));
    }

}
