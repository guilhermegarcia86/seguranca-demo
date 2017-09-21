package br.com.exemplo.seguranca.jwt.segurancademo.controllers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String email;

    @Column
    private String senha;

    @Column
    private String nome;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Role> roles = new ArrayList<Role>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getPassword() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getUsername() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
    }
}