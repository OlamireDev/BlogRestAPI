package com.olamireDev.BlogRestAPI.serviceImpl;

import com.olamireDev.BlogRestAPI.model.Post;
import com.olamireDev.BlogRestAPI.repository.PostRepository;
import com.olamireDev.BlogRestAPI.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl extends PostService {


    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        super(postRepository);
    }

    @Override
    public List<Post> getAllPost() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public List<Post> getCategoryPost(String cat) {
        return postRepository.findAllByCategory(cat);
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return Optional.ofNullable(postRepository.findById(id).orElse(null));
    }

    @Override
    public void create(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Post post){
       Post newPost =postRepository.findById(post.getId()).orElse(null);//throw error
        if(post.getTitle().length() > 0){
            newPost.setId(post.getId());
        }
        if(post.getContent().length() > 0){
            newPost.setContent(post.getContent());
        }
        if(post.getCategory().length() > 0){
            newPost.setCategory(post.getCategory());
        }
        postRepository.save(newPost);

    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
