package com.escuelita.demo.controllers;

import com.escuelita.demo.dto.request.CreateCommentRequest;
import com.escuelita.demo.dto.request.UpdateCommentRequest;
import com.escuelita.demo.dto.response.CommentResponse;
import com.escuelita.demo.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService service;
    @GetMapping("{id}")
    public CommentResponse get(@PathVariable Long id) {
        return service.getComment(id);
    }
    @GetMapping("list")
    public List<CommentResponse> list(){return service.list();}

    @PostMapping()
    public void create(@RequestBody CreateCommentRequest request){ service.create(request); }

    @DeleteMapping("{id}")
    public void delite(@PathVariable Long id){service.delete(id);}

    @PutMapping("{id}")
    public CommentResponse update(@PathVariable Long id, @RequestBody UpdateCommentRequest request){
        return service.update(request,id);
    }


}
