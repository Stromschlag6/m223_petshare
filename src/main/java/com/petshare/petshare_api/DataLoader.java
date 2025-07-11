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
            ApplicationUserRepository applicationUserRepository,
            PostRepository postRepository,
            CommentRepository commentRepository,
            LikeRepository likeRepository
    ) {
        return args -> {
            // 🧑‍💻 1. Users
            ApplicationUser applicationUser1 = new ApplicationUser("alice", "alice@example.com");
            ApplicationUser applicationUser2 = new ApplicationUser("bob", "bob@example.com");
            applicationUserRepository.save(applicationUser1);
            applicationUserRepository.save(applicationUser2);

            // 📝 2. Posts
            Post post1 = new Post("First post!", applicationUser1);
            Post post2 = new Post("Hello from Bob", applicationUser2);
            postRepository.save(post1);
            postRepository.save(post2);

            // 💬 3. Comments
            Comment comment1 = new Comment("Nice post!", applicationUser2, post1);
            Comment comment2 = new Comment("Thanks!", applicationUser1, post1);
            commentRepository.save(comment1);
            commentRepository.save(comment2);

            // ❤️ 4. Likes
            Like like1 = new Like(applicationUser2, post1);
            Like like2 = new Like(applicationUser1, post2);
            likeRepository.save(like1);
            likeRepository.save(like2);
        };
    }
}
