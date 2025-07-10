package com.petshare.petshare_api.repository;

import com.petshare.petshare_api.entity.Comment;
import com.petshare.petshare_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
