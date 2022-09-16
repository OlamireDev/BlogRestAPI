package com.olamireDev.BlogRestAPI.controller;

import com.olamireDev.BlogRestAPI.model.Post;
import com.olamireDev.BlogRestAPI.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value ="/blog")
public class PostController {

    private PostService postService;


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
    public Post getBlog(@PathVariable ("id") Long id){
        System.out.println("for debuggin");
        return  postService.getPost(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "info/{id}")
    public void editBlog(@RequestBody Post post, @PathVariable("id") Long id){
        post.setId(id);
        postService.updatePost(post);
    }
    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping(value = "info/{id}")
    public void deleteBlog(@PathVariable ("id") Long id){
        postService.delete(id);
    }

    @GetMapping(value ="/search={word}")
    public Iterable<Post> searchComments(@PathVariable("word") String word){
        return postService.search(word);
    }
}
