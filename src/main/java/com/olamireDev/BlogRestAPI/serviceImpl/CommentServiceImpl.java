package com.olamireDev.BlogRestAPI.serviceImpl;

import com.olamireDev.BlogRestAPI.model.Comment;
import com.olamireDev.BlogRestAPI.repository.CommentRepository;
import com.olamireDev.BlogRestAPI.service.CommentService;
import lombok.AllArgsConstructor;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;


    @Override
    public Iterable<Comment> getPostComment(Long id) {
        return commentRepository.findAllByPostId(id);
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(()
                -> new CommandAcceptanceException("cannot get comment with id: "+id));
    }

    @Override
    public void editComment(Comment comment) {
        if (comment.getContent().length() > 0) {
            Comment oldComment = getComment(comment.getId());
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

    @Override
    public Iterable<Comment> searchComment(String keyWord) {
        return commentRepository.findCommentsByContentContainingIgnoreCase(keyWord);
    }

}

