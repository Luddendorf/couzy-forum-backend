package com.breeze.summer.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.breeze.summer.dto.FilterPost;
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
	
	public Post updatePost(Post updatedPost, String authorIp) {
		updatedPost.setIp(authorIp);
		return postRepository.save(updatedPost);
	}
	
  public List<Post> findPostsByFilter(FilterPost filter) {
//	Integer pageNumber = filter.getCurrentPageNumber();
//	Integer postsPerPage = filter.getPostsPerPage();
	
//    Pageable sortedByTitle = PageRequest.of(0, 3, Sort.by("title"));
//
//    Pageable sortedByCreatedDatetimeDesc = PageRequest.of(0, 3, Sort.by("createdDatetime").descending());

    Pageable postPageable = 
      PageRequest.of(filter.getCurrentPageNumber(), filter.getPostsPerPage(),
    		  Sort.by(filter.getSortDirection(), filter.getSortBy())
    		  .and(Sort.by("title")));
    
    return postRepository.findAllByFilter(filter.getFromDatetime(), filter.getToDatetime(),
    		filter.getTitle(), filter.getUserId(), postPageable);
	}
}
