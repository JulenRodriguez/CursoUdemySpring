package com.curso.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.springboot.di.app.models.domain.ItemFactura;
import com.curso.springboot.di.app.models.domain.Producto;

@Configuration
public class AppConfig {

	@Bean
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(linea1, linea2);
	}
}
