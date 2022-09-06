package com.olamireDev.BlogRestAPI.service;

import com.olamireDev.BlogRestAPI.model.Post;
import com.olamireDev.BlogRestAPI.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class PostService {

    public  PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }



    public List<Post> getAllPost(){
        return  null;
    }

    public List<Post>  getCategoryPost(String cat){
        return null;
    }

    public Optional<Post> getPost(Long id){
        return null;
    }

    public void create(Post post) {
    }

    public void updatePost(Post post){}

    public void delete(Long id) {
    }
}
