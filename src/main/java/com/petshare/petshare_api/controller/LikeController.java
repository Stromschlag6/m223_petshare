package com.petshare.petshare_api.controller;

import com.petshare.petshare_api.entity.Like;
import com.petshare.petshare_api.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;

    @GetMapping
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeRepository.save(like);
    }
}