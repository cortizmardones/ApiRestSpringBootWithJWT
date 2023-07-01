package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.InterfacePersonaDao;
import com.example.demo.model.Persona;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MVCController {
	
	//Logger logger = LoggerFactory.getLogger(MVCController.class);
	
	@Value("${index.saludo}")
	private String messageApplicationProperties;
	
	@Autowired
	private InterfacePersonaDao interfacePersonaDao;
	
    @GetMapping("/home")
    public String inicio(Model model){
    	log.info("Ejecutando el controlador MVC /home");
    	
    	model.addAttribute("messageApplicationProperties", messageApplicationProperties);
        
        Persona persona = new Persona();
        persona.setNombre("Carlos");
        persona.setApellido("Ortiz");
        persona.setEmail("cortizmardones@gmail.com");
        persona.setTelefono("958586705");
        model.addAttribute("persona", persona);
    	
        //ELEMENTOS DESDE LA BDD.
        List<Persona> personList = interfacePersonaDao.findAll();
        model.addAttribute("personList", personList);
    
        return "index";
    }
    
}
