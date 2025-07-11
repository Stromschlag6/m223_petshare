package com.petshare.petshare_api;

import com.petshare.petshare_api.entity.*;
import com.petshare.petshare_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            UserRepository userRepository,
            PostRepository postRepository,
            CommentRepository commentRepository,
            LikeRepository likeRepository
    ) {
        return args -> {
            // 🧑‍💻 1. Users
            User user1 = new User("alice", "alice@example.com");
            User user2 = new User("bob", "bob@example.com");
            userRepository.save(user1);
            userRepository.save(user2);

            // 📝 2. Posts
            Post post1 = new Post("First post!", user1);
            Post post2 = new Post("Hello from Bob", user2);
            postRepository.save(post1);
            postRepository.save(post2);

            // 💬 3. Comments
            Comment comment1 = new Comment("Nice post!", user2, post1);
            Comment comment2 = new Comment("Thanks!", user1, post1);
            commentRepository.save(comment1);
            commentRepository.save(comment2);

            // ❤️ 4. Likes
            Like like1 = new Like(user2, post1);
            Like like2 = new Like(user1, post2);
            likeRepository.save(like1);
            likeRepository.save(like2);
        };
    }
}
