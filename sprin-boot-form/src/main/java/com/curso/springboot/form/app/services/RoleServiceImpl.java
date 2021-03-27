package com.curso.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService{

	private List<Role> roles;
	
	public RolesServiceImpl() {
		this.roles = new ArrayList<>();
		this.roles.add(new Role(1, "Administador", "ROLE_ADMIN"));
		this.roles.add(new Role(2, "Usuario", "ROLE_USER"));
		this.roles.add(new Role(3, "Moderador", "ROLE_MODERATOR"));
		
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		for (Role role : roles) {
			if(id == role.getId()) {
				return role;
			}
		}
		return null;
	}
}
