package com.olamireDev.BlogRestAPI.repository;

import com.olamireDev.BlogRestAPI.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    public Iterable<Comment> findAllByPostId(Long id);
}
