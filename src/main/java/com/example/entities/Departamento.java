package com.example.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Departamento implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String nombre;

   //mappedBy pones de donde es la relación padre
   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "departamento")
   private List<Empleado> empleados;

    

}
