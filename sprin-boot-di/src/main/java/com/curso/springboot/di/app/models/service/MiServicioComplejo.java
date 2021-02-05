package com.curso.springboot.di.app.models.service;

import org.springframework.stereotype.Service;


@Service("miServicioComplejo")
public class MiServicioComplejo  implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutando algun proceso importante complicado...";
	}

}
