package com.olamireDev.BlogRestAPI.service;

import com.olamireDev.BlogRestAPI.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {


    List<Post> getAllPost();

    List<Post>  getCategoryPost(String cat);

    Post getPost(Long id);

    void create(Post post);

    void updatePost(Post post);

    void delete(Long id);

    Iterable<Post> search(String keyWord);
}
