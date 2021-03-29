package com.curso.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl  implements UsuarioService{

	private List<Usuario> lista;
	
	
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "John", "Doe"));
		this.lista.add(new Usuario(2, "Pepa", "García"));
		this.lista.add(new Usuario(3, "Lalo", "Mena"));
		this.lista.add(new Usuario(4, "Luci", "Fernandez"));
		this.lista.add(new Usuario(5, "Pato", "González"));
		this.lista.add(new Usuario(6, "Paco", "Rodríguez"));
		this.lista.add(new Usuario(7, "Juan", "Gómez"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {

		
		for (Usuario usuario : this.lista) {
			if(usuario.getId().equals(id)) {
				return usuario;
			}
		}
		
		return null;
	}

}
