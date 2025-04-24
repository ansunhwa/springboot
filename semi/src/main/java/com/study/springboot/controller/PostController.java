package com.study.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.CommentDTO;
import com.study.springboot.dto.PostDTO;
import com.study.springboot.entity.Comment;
import com.study.springboot.entity.Post;
import com.study.springboot.entity.User;
import com.study.springboot.repository.PostRepository;
import com.study.springboot.repository.UserRepository;
import com.study.springboot.service.CommentService;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000") // React 앱이 실행되는 포트 설정
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CommentService commentService;

    // 게시글 작성 (POST 메서드)
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody Post post) {
        try {
            User user = userRepository.findById(post.getUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            post.setUser(user);  // user 객체 설정

            Post savedPost = postRepository.save(post);  // id 자동 생성

            // PostDTO 생성하여 반환
            PostDTO postDTO = new PostDTO(savedPost.getId(), savedPost.getTitle(), savedPost.getContent(), user.getName(), user.getUserId());
            return new ResponseEntity<>(postDTO, HttpStatus.CREATED); // 201 상태 코드
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 상태 코드
        }
    }

    // 모든 게시글 조회 (GET 메서드)
    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        try {
            List<Post> posts = postRepository.findAllByOrderByIdDesc();
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 상태 코드
            }

            List<PostDTO> postDTOs = posts.stream()
                    .map(post -> new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getUser().getName(), post.getUser().getUserId()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(postDTOs, HttpStatus.OK); // 200 상태 코드
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 상태 코드
        }
    }

    // 게시글 상세 조회 (GET /posts/{id} 메서드 추가)
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Long id) {
        try {
            Post post = postRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Post not found"));
            PostDTO postDTO = new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getUser().getName(), post.getUser().getUserId());
            return new ResponseEntity<>(postDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 상태 코드
        }
    }
    
    //댓글달기
    @PostMapping("/{postId}/comments")
    public ResponseEntity<?> createComment(
    		  @PathVariable("postId") Long postId,
              @RequestBody CommentDTO commentDTO) {
          try {
              commentService.saveComment(postId, commentDTO);
              return new ResponseEntity<>(HttpStatus.CREATED);
          } catch (Exception e) {
              e.printStackTrace();
              return new ResponseEntity<>("댓글 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
    
    
    //댓글목록조회
    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(
            @PathVariable("postId") Long postId) {  
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    
    
    // 본인 댓글 삭제
    @PostMapping("/{postId}/comments/{commentId}/delete")
    public ResponseEntity<?> deleteComment(
    	    @PathVariable("postId") Long postId,  // 이렇게 이름 명시
    	    @PathVariable("commentId") Long commentId,
    	    @RequestBody CommentDTO dto) {
    	    try {
    	    	System.out.println("댓글 삭제 요청 도착 - postId: " + postId + ", commentId: " + commentId + ", 요청자: " + dto.getUserId());
    	        commentService.deleteComment(commentId, dto.getUserId());
    	        return ResponseEntity.ok().build();
    	    } catch (RuntimeException e) {
    	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한 없음");
    	    }
    	}
    
    
    
    
}











