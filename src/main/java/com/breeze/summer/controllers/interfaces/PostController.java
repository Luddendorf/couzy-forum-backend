package com.breeze.summer.controllers.interfaces;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.Post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PostController {
	@Operation(summary = "Save a new post to DB", tags = {"Post"})
	@ApiResponses(
		value = {
		  @ApiResponse(
			responseCode = "200",
			description = "Successfully saved a new post",
			headers = @Header(name = "Content-Type"),
			content = @Content(schema = @Schema(implementation = Post.class))
		  ),
		  @ApiResponse(
			responseCode = "500",
			description = "Failed to save a new post"
		  )
		})
	Post addPost(HttpServletRequest request, Post newPost);
	
	@Operation(summary = "Update a post using post ID", tags = {"Post"})
	@ApiResponses(
		value = {
		  @ApiResponse(
			responseCode = "200",
			description = "Post was updated successfully",
			content = @Content(schema = @Schema(implementation = Post.class))
		  ),
		  @ApiResponse(
			responseCode = "404",
			description = "No post with given post ID was found."
		  ),
		  @ApiResponse(
			responseCode = "500",
			description = "Failed to update a post with provided post ID"
		  )
		})
	Post updatePost(HttpServletRequest request, Post updatedPost);
	
	
	@Operation(summary = "Find a list of post using parameters", tags = {"Post"})
	@ApiResponses(
		value = {
		  @ApiResponse(
			responseCode = "200",
			description = "Found list of posts that satisfy given parameters",
			content = @Content(array = @ArraySchema(schema = @Schema(implementation = Post.class)))
		  ),
		  @ApiResponse(
			responseCode = "404",
			description = "No posts with given parameters were found."
		  ),
		  @ApiResponse(
			responseCode = "500",
			description = "Failed to return list of posts to user"
		  )
		})
	List<Post> findPostsByFilter(FilterPost filter);
}
