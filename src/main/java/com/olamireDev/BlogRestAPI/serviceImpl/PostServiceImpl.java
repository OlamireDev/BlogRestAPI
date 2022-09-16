package com.olamireDev.BlogRestAPI.serviceImpl;

import com.olamireDev.BlogRestAPI.exceptions.PostNotFound;
import com.olamireDev.BlogRestAPI.model.Post;
import com.olamireDev.BlogRestAPI.repository.PostRepository;
import com.olamireDev.BlogRestAPI.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {



   private final PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public List<Post> getCategoryPost(String cat) {
        return postRepository.findAllByCategory(cat);
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFound("The post you want to retrieve or edit does no exist"));
    }
    @Override
    public void create(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Post post){
       Post newPost =postRepository.findById(post.getId()).orElseThrow(()
               -> new PostNotFound("The post you want to retrieve or edit does no exist"));
        if(post.getTitle().length() > 0){
            newPost.setTitle(post.getTitle());
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

    @Override
    public Iterable<Post> search(String keyWord) {
       return postRepository.findPostByTitleContainsIgnoreCase(keyWord);
    }
}
