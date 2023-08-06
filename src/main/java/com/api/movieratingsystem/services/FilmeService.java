package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;
    public List<FilmeModel> findAll(){
        return repository.findAll();
    }
}
