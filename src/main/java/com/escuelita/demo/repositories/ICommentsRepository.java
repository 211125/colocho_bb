package com.escuelita.demo.repositories;

import com.escuelita.demo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentsRepository extends JpaRepository<Comment,Long> {

}
