package com.curso.springboot.app.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.springboot.app.models.entity.Cliente;
import com.curso.springboot.app.models.service.ClienteService;
import com.curso.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam (name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4);
		
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		
		PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);
		
		model.addAttribute("page", pageRender);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Model model) {
		
		Cliente cliente = new Cliente();
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Formulario de Cliente");
		
		return "form";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) {
		
		
		if(id <= 0) {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}
		
		Cliente cliente = clienteService.findOne(id);
		
		if(cliente == null) {
			flash.addFlashAttribute("error", "El ID de cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		return "form";
		
	}
	
	@PostMapping("/form")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash,SessionStatus status) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		
		String mensajeFlash;

		
		if (cliente.getId() != null) {
			mensajeFlash = "Cliente editado con exito!";
		}else {
			mensajeFlash = "Cliente creado con exito!";
		}
		
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Has subido correctamente '" + foto.getOriginalFilename() + "'");
				
				cliente.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {
				
			}
		}
		
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			clienteService.delete(id);
		}
		
		flash.addFlashAttribute("success", "Cliente eliminado con exito");
		return "redirect:/listar";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value="id") Long id,Model model, RedirectAttributes flash) {
		
		Cliente cliente = clienteService.findOne(id);
		if(cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Detalle cliente: " + cliente.getNombre());
		
		return "ver";
	}
}
