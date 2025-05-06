package com.bbva.demodbalternate.service;

import com.bbva.demodbalternate.model.Application;
import com.bbva.demodbalternate.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository solicitudRepository;

    
    public List<Application> findAll() {
        return solicitudRepository.findAll();
    }


    public <S extends Application> S save(S entity) {
        return solicitudRepository.save(entity);
    }


    public Optional<Application> findById(String s) {
        return solicitudRepository.findById(s);
    }



}
