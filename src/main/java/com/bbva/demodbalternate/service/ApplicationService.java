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
public class ApplicationService implements ApplicationRepository {
    @Autowired
    private ApplicationRepository solicitudRepository;

    @Override
    public List<Application> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public List<Application> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Application> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Application> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Application entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Application> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Application> S save(S entity) {
        return solicitudRepository.save(entity);
    }

    @Override
    public <S extends Application> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Application> findById(String s) {
        return solicitudRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Application> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Application> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Application> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Application getOne(String s) {
        return null;
    }

    @Override
    public Application getById(String s) {
        return null;
    }

    @Override
    public <S extends Application> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Application> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Application> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Application> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Application> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Application> boolean exists(Example<S> example) {
        return false;
    }
}
