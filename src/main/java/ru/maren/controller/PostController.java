package ru.maren.controller;

import org.springframework.web.bind.annotation.*;
import ru.maren.model.Post;
import ru.maren.service.PostService;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("api/posts")
public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Post> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id) throws IOException {
       return service.getById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
       return service.save(post);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) throws IOException {
        service.removeById(id);
    }
}
