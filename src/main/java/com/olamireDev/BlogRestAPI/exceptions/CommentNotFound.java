package com.olamireDev.BlogRestAPI.exceptions;

public class CommentNotFound  extends RuntimeException{

    public CommentNotFound(String message){
        super(message);
    }
}
