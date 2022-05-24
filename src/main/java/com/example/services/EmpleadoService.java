package com.example.services;

import java.util.List;

import com.example.entities.Empleado;

public interface EmpleadoService {
    
    public List<Empleado> findAll();

    public Empleado findByIdEmpleado(Long id); 

    public void guardarEmpleado(Empleado empleado);
}
