package com.curso.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.springboot.app.models.service.UploadFileService;

@SpringBootApplication
public class SprinBootDataJpaApplication implements CommandLineRunner{

	@Autowired
	UploadFileService uploadFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(SprinBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		uploadFileService.deleteAll();
		uploadFileService.init();
	}

}
