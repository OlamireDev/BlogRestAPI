package com.olamireDev.BlogRestAPI.controller;


import com.olamireDev.BlogRestAPI.exceptions.CommentNotFound;
import com.olamireDev.BlogRestAPI.exceptions.PostNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogExceptionHandler {

     @ExceptionHandler(CommentNotFound.class)
    public String commentNotFound(CommentNotFound ex){
         return ex.getMessage();
     }

     @ExceptionHandler(PostNotFound.class)
    public String PostNotFound(PostNotFound ex){
         return ex.getMessage();
     }
}
