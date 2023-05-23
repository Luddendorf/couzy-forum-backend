package com.breeze.summer.controllers;

import static com.breeze.summer.utils.ControllerUtil.getIpFromRequest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.breeze.summer.dto.Category;
import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.Post;
import com.breeze.summer.services.CategoryService;
import com.breeze.summer.services.PostService;
import com.breeze.summer.utils.exception.CouzyForumException;

@RestController
@RequestMapping("post")
public class PostController {

	@Autowired
	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
    @PostMapping(value="new")
    public Post addPost(HttpServletRequest request, @RequestBody Post newPost) {
    	return postService.addPost(newPost, getIpFromRequest(request));
    }
    
    @PostMapping("update")
    public Post updatePost(HttpServletRequest request, @RequestBody Post updatedPost) {
    	return postService.updatePost(updatedPost, getIpFromRequest(request));
    }
    
    @PostMapping("search")
    public List<Post> findPostsByFilter(@RequestBody FilterPost filter) {
    	return postService.findPostsByFilter(filter);

    }
}
