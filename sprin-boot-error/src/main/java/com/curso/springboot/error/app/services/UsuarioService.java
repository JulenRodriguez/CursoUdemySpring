package com.curso.springboot.error.app.services;

import java.util.List;

import com.curso.springboot.error.app.models.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
}
