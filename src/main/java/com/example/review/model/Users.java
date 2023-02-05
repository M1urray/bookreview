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


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class Users implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="id")
	private UUID userid;
	
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
}
