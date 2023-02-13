package com.example.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

//+-----------+-------------+------+-----+---------+----------------+
//| Field     | Type        | Null | Key | Default | Extra          |
//+-----------+-------------+------+-----+---------+----------------+
//| id        | int         | NO   | PRI | NULL    | auto_increment |
//| user_name | varchar(50) | YES  |     | NULL    |                |
//| password  | varchar(50) | YES  |     | NULL    |                |
//| roles     | varchar(50) | YES  |	 | NULL	   |
 //+-----------+-------------+------+-----+---------+----------------+



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class Users implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long user_id;
	
	@Column(name="user_name")
	private String username;
	@Column(name="last_name")
	private String lastname;

	@Column(name="password")
	private String password;

	@Column(name="first_name")
	private String firstname;

	@Column(name="email")
	private String email;


	@Column(name="user_role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return 	List.of(new SimpleGrantedAuthority(role.name()));
	}
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getUserid() {
		return user_id;
	}

	public void setUserid(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
