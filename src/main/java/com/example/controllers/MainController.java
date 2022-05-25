package com.example.controllers;

import java.lang.ProcessBuilder.Redirect;

import com.example.entities.Empleado;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private DepartamentoService departamentoService;

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

    //Devuelve detalles empleado, definir idEmpleado y convertirlo con @PathVariable
    @GetMapping("/detalle/{idEmpleado}")
    public String detalleEmpleado(@PathVariable(name = "idEmpleado") Long idEmpleado, Model model){

        //Método que añade los datos al modelo pidiendolos al servicio
        model.addAttribute("empleado", empleadoService.findByIdEmpleado(idEmpleado));

        //Manda a la vista detalle.html los datos
        return "detalle";
    }

    //Método muestra el fomrulario y pasa un empleado vacio para rellenar
    @GetMapping("/alta/{idEmpleado}")
    public String mostrarFormulario(@PathVariable(name = "idEmpleado") Long idEmpleado, Model model){

        //Construir un empleado con sus datos con el id
        model.addAttribute("empleado", empleadoService.findByIdEmpleado(idEmpleado));

        //Pasar la lista de departamentos
        model.addAttribute("departamentos", departamentoService.findAll());

        return "altaEmpleado";

    }

    //Método muestra el fomrulario y pasa un empleado vacio para rellenar
    @GetMapping("/alta")
    public String mostrarFormularioVacio(Model model){

        //Pasar un empleado vacio
        model.addAttribute("empleado", new Empleado());

        //Pasar la lista de departamentos
        model.addAttribute("departamentos", departamentoService.findAll());

        return "altaEmpleado";


        }

    //Método recoge los datos del nuevo empleado
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute(name = "empleado") Empleado empleado){

        empleadoService.guardarEmpleado(empleado);
        return "redirect:/listar";

    }
    
}
