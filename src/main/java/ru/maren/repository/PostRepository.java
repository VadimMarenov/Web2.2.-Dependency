package ru.maren.repository;

import org.springframework.stereotype.Repository;
import ru.maren.model.Post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private AtomicLong idCounter = new AtomicLong();
    private ConcurrentMap<Long, Post> allPosts;

    public PostRepository() {
        this.allPosts = new ConcurrentHashMap<>();
    }

    public Collection<Post> all() {
        return allPosts.values().stream()
                .filter(post -> !post.isRemoved())
                .collect(Collectors.toCollection(ArrayList<Post>::new));
    }

    public Optional<Post> getById(long id) {
        if (!allPosts.get(id).isRemoved()) {
            return allPosts.get(id) != null ? Optional.of(allPosts.get(id)) : Optional.empty();
        } else
            return Optional.empty();
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            long id = idCounter.incrementAndGet();
            post.setId(id);
            allPosts.put(id, post);
        } else {
            allPosts.put(post.getId(), post);
        }
        return post;

    }

    public void removeById(long id) {
        if (allPosts.get(id) != null) {
            allPosts.get(id).setRemoved(true);
        }
    }
}
