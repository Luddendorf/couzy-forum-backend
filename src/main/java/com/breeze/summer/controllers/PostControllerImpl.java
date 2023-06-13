package com.breeze.summer.controllers;

import com.breeze.summer.controllers.interfaces.PostController;
import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.FoundPosts;
import com.breeze.summer.dto.Post;
import com.breeze.summer.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.breeze.summer.utils.ControllerUtil.getIpFromRequest;

@RestController
@RequestMapping("post")
public class PostControllerImpl implements PostController {

    @Autowired
    private final PostService postService;

    @Autowired
    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "new")
    public Post addPost(HttpServletRequest request, @RequestBody Post newPost) {
        return postService.addPost(newPost, getIpFromRequest(request));
    }

    @PostMapping("update")
    public Post updatePost(HttpServletRequest request, @RequestBody Post updatedPost) {
        return postService.updatePost(updatedPost, getIpFromRequest(request));
    }

    @PostMapping("search")
    public FoundPosts findPostsByFilter(@RequestBody FilterPost filter) {
        return postService.findPostsByFilter(filter);
    }

}
