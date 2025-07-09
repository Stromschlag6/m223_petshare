package com.petshare.petshare_api.controller;

import com.petshare.petshare_api.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/posts")
public class PostController {

    private List<Post> posts = List.of(
            new Post(1L, "Mein Hund", "So süß!", 1L),
            new Post(2L, "Meine Katze", "Schläft immer!", 2L)
    );

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        return ResponseEntity.ok("Post erstellt (statisch)");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
