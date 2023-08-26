package com.breeze.summer.dto.auth;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.time.ZonedDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long couzyUserId;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 3, max = 40)
  @Pattern(regexp = "^\\w([._'\\s-](?![._])|\\w){3,40}\\w$")
  @Column(name = "nick")
  private String userName;

  @NotBlank
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*\\W).{8,20}$")
  private String password;

  @NotBlank
  @Column(name = "user_role")
  private String role;

  boolean active;

  @CreatedDate
  @Column(name = "created", updatable = false)
  private ZonedDateTime created;

  @LastModifiedDate
  private ZonedDateTime updated;
}
