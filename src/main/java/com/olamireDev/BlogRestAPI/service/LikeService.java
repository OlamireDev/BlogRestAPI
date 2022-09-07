package com.olamireDev.BlogRestAPI.service;

import com.olamireDev.BlogRestAPI.model.Like;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {

    Long getLikeCount(Long postId);

    void addLike(Like like);

    void deleteLike(Long id);
}
