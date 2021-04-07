package com.curso.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.curso.springboot.app.models.entity.Cliente;

public interface ClienteDao extends PagingAndSortingRepository<Cliente, Long>{


}
