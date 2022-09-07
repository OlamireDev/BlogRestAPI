package com.olamireDev.BlogRestAPI.repository;

import com.olamireDev.BlogRestAPI.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
        List<Post> findAllByCategory(String Category);

        Iterable<Post> findPostByTitleContainsIgnoreCase(String keyWord);
}
