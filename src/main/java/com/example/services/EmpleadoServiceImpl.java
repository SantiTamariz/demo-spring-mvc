package com.example.services;

import java.util.List;

import com.example.dao.EmpleadoDao;
import com.example.entities.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    //@Autowired
    //Forma de que Spring cree el objeto empleadoDao en el beans.xml y permitir usar los
    //métodos de la interfaz EmpleadoDao sin necesidad de instanciarlas. Además se pueden usar 
    //los metodos de las clases que extiende la interfaz EmpleadoDao

    //Inyección por tipo
    @Autowired
    private EmpleadoDao empleadoDao;

    //Inyección por constructor, pero no se puede por constructor ya que EmpleadoDao es interfaz
    //@Autowired
    //private EmpleadoDao empleadoDao
    //public EmpleadoServiceImpl(EmpleadoDao empleadoDao){
    //this.empleadoDao = new EmpleadoDao();
    //}

    @Override
    public List<Empleado> findAll() {
        return this.empleadoDao.findAll();
    }

    //Recibe un tipo opcional y con .get lo transformamos en tipo Empleado
    @Override
    public Empleado findByIdEmpleado(Long id) {
        return empleadoDao.findById(id).get();
    }
    
}
