package com.olamireDev.BlogRestAPI.repository;


import com.olamireDev.BlogRestAPI.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

   Long countByPostId(Long id);
}
