package com.escuelita.demo.repositories;

import com.escuelita.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT user.* FROM user_commet"+
      "INNER JOIN users ON user_id = users_coment.user_id"+
         "WHERE uses_comment.comment_id= :commentid", nativeQuery = true)
    List<User> getAllUserBYCommentid(Long commentid);
}
