package com.olamireDev.BlogRestAPI.controller;

import com.olamireDev.BlogRestAPI.model.Comment;
import com.olamireDev.BlogRestAPI.service.CommentService;
import com.olamireDev.BlogRestAPI.serviceImpl.CommentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
    @GetMapping(value ="/{id}/comments")
    public Iterable<Comment> getPostComments(@PathVariable("id") String id){
        return commentService.getPostComment(Long.valueOf(id));
    }

    @GetMapping(value = "/comment/{id}")
    public Comment getComment(@PathVariable("id") Long id){
        return commentService.getComment(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/comment/{id}")
    public void EditComment(@RequestBody Comment comment, @PathVariable("id") Long id){
        comment.setId(id);
        commentService.editComment(comment);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/comment/{id}")
    public void deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value ="/comment")
    public void newComment(@RequestBody Comment comment){
        commentService.newComment(comment);
    }

}
