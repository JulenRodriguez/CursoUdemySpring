package com.curso.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("miServicioSimple")
public class MiServicio  implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutando algun proceso importante simple...";
	}

}
