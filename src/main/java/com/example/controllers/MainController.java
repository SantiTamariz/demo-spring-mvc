package com.example.controllers;

import com.example.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class MainController {

    //Se hace inyección de dependecia con SpringBOoot en @Autowired 
    //Crea el elemento bean empleadoService para poder usar sus métodos sin necesidad de instanciarlo
    //Así solo lo instancia cuando es necesario y lo usa SpringBoot
    @Autowired
    private EmpleadoService empleadoService;

    //El metodo recibe un modelo del framework vacio, FUNCIONA PERO USAMOS EL SIGUIENTE
    //@GetMapping("/listar")
    public String listarEmpleadoMalo(Model model){

        //Método añade los datos al modelo pidiendolos al servicio por el atributo empleados
        model.addAttribute("empleados", empleadoService.findAll());

        //Devolvemos la lista.html que va a recoger el modelo.
        return "listar";
    }
    
    //Crear un modelo
    @GetMapping("/listar") 
    public ModelAndView listarEmpleado(){

        String saludo = "Hola mundo";

        //Modelo nuevo asignado a la vista
        ModelAndView maw = new ModelAndView("listar");

        //Añadir al modelo del atributo empleados cogidos los datos del servicio
        maw.addObject("empleados", empleadoService.findAll());
        maw.addObject("saludo", saludo);

        //Retornar modelo a la vista
        return maw;
    }
}
