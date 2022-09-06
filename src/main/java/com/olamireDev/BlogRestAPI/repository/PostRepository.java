package com.olamireDev.BlogRestAPI.repository;

import com.olamireDev.BlogRestAPI.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
        public List<Post> findAllByCategory(String Category);
}
