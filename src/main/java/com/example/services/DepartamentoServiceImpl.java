package com.example.services;

import java.util.List;

import com.example.dao.DepartamentoDao;
import com.example.entities.Departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    DepartamentoDao departamentoDao;

    @Override
    public List<Departamento> findAll() {
        return departamentoDao.findAll();
    }
    
}
