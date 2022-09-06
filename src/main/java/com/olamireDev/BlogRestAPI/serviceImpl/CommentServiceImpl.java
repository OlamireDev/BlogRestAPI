package com.olamireDev.BlogRestAPI.serviceImpl;

import com.olamireDev.BlogRestAPI.model.Comment;
import com.olamireDev.BlogRestAPI.repository.CommentRepository;
import com.olamireDev.BlogRestAPI.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    @Override
    public Iterable<Comment> getPostComment(Long id) {
        return commentRepository.findAllByPostId(id);
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void editComment(Comment comment) {
        if(comment.getContent().length() > 0) {
            Comment oldComment =  getComment(comment.getId());
            oldComment.setContent(comment.getContent());
            commentRepository.save(oldComment);
        }
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void newComment(Comment comment) {
        commentRepository.save(comment);
    }


}
