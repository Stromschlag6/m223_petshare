package com.petshare.petshare_api.repository;

import com.petshare.petshare_api.entity.ApplicationUser;
import com.petshare.petshare_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(ApplicationUser applicationUser);
}
