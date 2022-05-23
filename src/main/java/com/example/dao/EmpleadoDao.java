package com.example.dao;

import java.util.List;

import com.example.entities.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Long> {
    //Query para buscar empleados por un salario que damos por parametro
    @Query(value = "select salario from Empleado fetch :idEmpleado", nativeQuery = true)
    public List<Empleado> findBySalario(double salario);
}
