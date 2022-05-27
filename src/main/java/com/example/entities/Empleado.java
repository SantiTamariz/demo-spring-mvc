package com.example.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   private String nombre;
   private String primerApellido;

   
   private String segundoApellido;
   
   private Double salario;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
   private Departamento departamento;


   
}
