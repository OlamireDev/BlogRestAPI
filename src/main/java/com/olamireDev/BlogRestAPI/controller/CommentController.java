package com.olamireDev.BlogRestAPI.controller;

import com.olamireDev.BlogRestAPI.model.Comment;
import com.olamireDev.BlogRestAPI.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;

    @GetMapping(value ="/s/{id}") //get all comments related to a post id
    public Iterable<Comment> getPostComments(@PathVariable("id") Long id){
        return commentService.getPostComment(id);
    }

    @GetMapping(value = "/{id}") //get a particular comment
    public Comment getComment(@PathVariable("id") Long id){
        return commentService.getComment(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/{id}")
    public void EditComment(@RequestBody Comment comment, @PathVariable("id") Long id){
        comment.setId(id);
        commentService.editComment(comment);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/{id}")
    public void deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value ="")
    public void newComment(@RequestBody Comment comment){
        commentService.newComment(comment);
    }

    @GetMapping(value ="/search={word}")
    public Iterable<Comment> searchComments(@PathVariable ("word") String keyWord){
        return commentService.searchComment(keyWord);
    }

}
