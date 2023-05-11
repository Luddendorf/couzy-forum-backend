package com.breeze.summer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breeze.summer.dto.Post;
import com.breeze.summer.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post addPost(Post newPost, String authorIp) {
		newPost.setIp(authorIp);
		return postRepository.save(newPost);
	}
}
