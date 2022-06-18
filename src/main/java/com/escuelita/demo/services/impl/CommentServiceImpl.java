package com.escuelita.demo.services.impl;

import com.escuelita.demo.dto.request.CreateCommentRequest;
import com.escuelita.demo.dto.request.UpdateCommentRequest;
import com.escuelita.demo.dto.response.CommentResponse;
import com.escuelita.demo.entities.Comment;
import com.escuelita.demo.repositories.ICommentsRepository;
import com.escuelita.demo.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentsRepository repository;

    @Override
    public CommentResponse getComment(Long id) {
        Optional <Comment> commentOptional = repository.findById(id);
        if (commentOptional.isPresent()){
         // Comment from = commentOptional.get();
            Comment comment = commentOptional.get();
            CommentResponse from = this.from(comment);
          return from;
        }
        throw new RuntimeException("not Comment");
    }

    @Override
    public void create(CreateCommentRequest request) {
       Comment comment = from(request);
        repository.save(comment);
    }

    @Override
    public List<CommentResponse> list() {
        List<Comment> comments = repository.findAll();
        List<CommentResponse> commentResponses = from(comments);
        return commentResponses;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CommentResponse update(UpdateCommentRequest request, Long id) {
        Optional<Comment> optionalComment = repository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            Comment updated = from(request, comment);
            Comment saved = repository.save(updated);
            CommentResponse response = from(saved);
            return response;
        }
        throw new RuntimeException(" no se actualizó");
    }

    private Comment from(UpdateCommentRequest request, Comment comment) {
        comment.setComment(request.getComment());
        return comment;
    }

    private List<CommentResponse> from(List<Comment> comments) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            CommentResponse response = from(comment);
           commentResponses.add(response);
        }
        return commentResponses;
    }

    private Comment from(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setComment(request.getComment());
        return comment;
    }

    private CommentResponse from(Comment comment) {
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setComment(comment.getComment());
        return response;
    }

}
