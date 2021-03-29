package com.curso.springboot.app.models.dao;

import java.util.List;

import com.curso.springboot.app.models.entity.Cliente;

public interface ClienteDao {

	public List<Cliente> findAll();
}
