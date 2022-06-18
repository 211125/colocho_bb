package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.dto.request.CreateCommentRequest;
import com.escuelita.demo.dto.request.CreateUserRequest;
import com.escuelita.demo.dto.request.UpdateCommentRequest;
import com.escuelita.demo.dto.request.UpdateUserRequest;
import com.escuelita.demo.dto.response.CommentResponse;
import com.escuelita.demo.dto.response.UserResponse;

import java.util.List;

public interface ICommentService {
    CommentResponse getComment(Long id);
    void create(CreateCommentRequest request);

    List<CommentResponse> list();

    void delete(Long id);

    CommentResponse update(UpdateCommentRequest request, Long id);
}
