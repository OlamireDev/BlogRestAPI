package com.olamireDev.BlogRestAPI.repository;

import com.olamireDev.BlogRestAPI.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    Iterable<Comment> findAllByPostId(Long id);

    Iterable<Comment> findCommentsByContentContainingIgnoreCase(String KeyWord);
}
