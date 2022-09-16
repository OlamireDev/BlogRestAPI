package com.olamireDev.BlogRestAPI.serviceImpl;

import com.olamireDev.BlogRestAPI.model.Like;
import com.olamireDev.BlogRestAPI.repository.LikeRepository;
import com.olamireDev.BlogRestAPI.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public Long getLikeCount(Long id) {
        return likeRepository.countByPostId(id);
    }

    @Override
    public void addLike(Like like) {
        likeRepository.save(like);
    }

    @Override
    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
