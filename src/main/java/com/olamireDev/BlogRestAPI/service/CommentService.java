package com.olamireDev.BlogRestAPI.service;

import com.olamireDev.BlogRestAPI.model.Comment;

public interface CommentService {

    public Iterable<Comment> getPostComment(Long id);

    Comment getComment(Long id);

    void editComment(Comment comment);

    void deleteComment(Long id);

    void newComment(Comment comment);
}
