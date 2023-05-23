package com.breeze.summer.services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.Post;
import com.breeze.summer.repositories.PostRepository;
import com.breeze.summer.utils.exception.CouzyForumException;

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
	
  public List<Post> findPostsByFilter(FilterPost filter) throws CouzyForumException {
//	Integer pageNumber = filter.getCurrentPageNumber();
//	Integer postsPerPage = filter.getPostsPerPage();
	
//    Pageable sortedByTitle = PageRequest.of(0, 3, Sort.by("title"));
//
//    Pageable sortedByCreatedDatetimeDesc = PageRequest.of(0, 3, Sort.by("createdDatetime").descending());
	String title = filter.getTitle();
	Long userId = filter.getUserId();
    if (title.length() < 3) {
    	// throw new CouzyForumException("Title cannot be shorter than 3 symbols.");
    	return null;
    }
    
    Pageable postPageable = 
      PageRequest.of(filter.getCurrentPageNumber(), filter.getPostsPerPage(),
    		  Sort.by(filter.getSortDirection(), filter.getSortBy())
    		  .and(Sort.by("title")));
    
    if (StringUtils.isNotBlank(title) && Objects.nonNull(userId)) {
    	return postRepository.findAllByFilterWithTitleAndUserId(filter.getFromDatetime(),
    			filter.getToDatetime(), title, userId, postPageable);
    }
    if (StringUtils.isNotBlank(title)) {
    	return postRepository.findAllByFilterWithTitle(filter.getFromDatetime(),
    			filter.getToDatetime(), title, postPageable);
    }
    if (Objects.nonNull(userId)) {
    	return postRepository.findAllByFilterWithUserId(filter.getFromDatetime(),
    			filter.getToDatetime(), userId, postPageable);
    }
    return null;
	}
}
