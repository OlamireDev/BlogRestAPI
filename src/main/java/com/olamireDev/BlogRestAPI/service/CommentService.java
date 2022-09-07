package com.olamireDev.BlogRestAPI.service;

import com.olamireDev.BlogRestAPI.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    Iterable<Comment> getPostComment(Long id);

    Comment getComment(Long id);

    void editComment(Comment comment);

    void deleteComment(Long id);

    void newComment(Comment comment);

    Iterable<Comment> searchComment(String keyWord);
}
