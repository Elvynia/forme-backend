package fr.elvynia.tool.forme.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Account implements UserDetails {

	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Responsability", joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "companyId", referencedColumnName = "id"))
	private List<Company> companies;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String password;

	@ManyToOne
	@JoinColumn(name = "roleId", referencedColumnName = "id")
	private Role role;

	@Transient
	private String token;

	@Column
	private String username;

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(this.role);
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public Integer getId() {
		return this.id;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return this.password;
	}

	public Role getRole() {
		return this.role;
	}

	public String getToken() {
		return this.token;
	}

	@Override
	public String getUsername() {
		return this.username;
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

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty
	public void setPassword(String pasword) {
		this.password = pasword;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
