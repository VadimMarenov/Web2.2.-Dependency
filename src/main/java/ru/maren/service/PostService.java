package ru.maren.service;

import org.springframework.stereotype.Service;
import ru.maren.exception.NotFoundException;
import ru.maren.model.Post;
import ru.maren.repository.PostRepository;

import java.util.Collection;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}

