package com.olamireDev.BlogRestAPI.exceptions;

public class PostNotFound extends RuntimeException{
    public PostNotFound(String message){
        super(message);
    }
}
