/*
 * package com.study.springboot.dto;
 * 
 * public class PostDTO { private Long id; private String title; private String
 * content; private String userName;
 * 
 * // 생성자 public PostDTO(Long id, String title, String content, String userName)
 * { this.id = id; this.title = title; this.content = content; this.userName =
 * userName; }
 * 
 * public PostDTO() {}
 * 
 * // Getters and Setters public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getTitle() { return title; }
 * 
 * public void setTitle(String title) { this.title = title; }
 * 
 * public String getContent() { return content; }
 * 
 * public void setContent(String content) { this.content = content; }
 * 
 * public String getUserName() { return userName; }
 * 
 * public void setUserName(String userName) { this.userName = userName; } }
 */
package com.study.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String userId;
}


