package com.petshare.petshare_api.repository;

import com.petshare.petshare_api.entity.ApplicationUser;
import com.petshare.petshare_api.entity.Like;
import com.petshare.petshare_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(ApplicationUser applicationUser, Post post);
    List<Like> findByPost(Post post);
}
