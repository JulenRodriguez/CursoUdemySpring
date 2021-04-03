package com.curso.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.app.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{


}
