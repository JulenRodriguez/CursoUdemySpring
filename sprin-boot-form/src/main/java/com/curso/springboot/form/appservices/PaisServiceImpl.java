package com.curso.springboot.form.appservices;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService{

	private List<Pais> lista;
	
	public PaisServiceImpl() {
		this.lista = Arrays.asList(
				new Pais(1, "ES", "España"),
				new Pais(2, "MX", "Mexico"),
				new Pais(3, "CH", "Chile"),
				new Pais(4, "AR", "Argentina"),
				new Pais(5, "PE", "Perú"),
				new Pais(6, "CO", "Colombia"),
				new Pais(7, "VE", "Venezuela"));
	}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		for (Pais pais : this.lista) {
			if(id == pais.getId()) {
				return pais;
			}
		}
		return null;
	}

}
