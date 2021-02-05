package com.curso.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

@Service
public class MiServicio {
	
	public String operacion() {
		return "ejecutando algun proceso importante...";
	}

}
