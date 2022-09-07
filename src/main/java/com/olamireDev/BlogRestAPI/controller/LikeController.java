package com.olamireDev.BlogRestAPI.controller;

import com.olamireDev.BlogRestAPI.model.Like;
import com.olamireDev.BlogRestAPI.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {
    LikeService likeService;

    @GetMapping(value = "s/{id}")
    public Long getLikes(@PathVariable("id") Long id){
        return likeService.getLikeCount(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "")
    public void addLike(@RequestBody Like like){
        likeService.addLike(like);
    }

    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping (value = "/{id}")
    public void deleteLike(@PathVariable("id") Long id){
        likeService.deleteLike(id);
    }
}
