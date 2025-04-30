package com.bbva.demodbalternate.service;

import com.bbva.demodbalternate.model.Solicitud;
import com.bbva.demodbalternate.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class SolicitudService implements SolicitudRepository {
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public List<Solicitud> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Solicitud> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Solicitud> findAllById(Iterable<String> strings) {
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
    public void delete(Solicitud entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Solicitud> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Solicitud> S save(S entity) {
        return solicitudRepository.save(entity);
    }

    @Override
    public <S extends Solicitud> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Solicitud> findById(String s) {
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
    public <S extends Solicitud> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Solicitud> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Solicitud> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Solicitud getOne(String s) {
        return null;
    }

    @Override
    public Solicitud getById(String s) {
        return null;
    }

    @Override
    public <S extends Solicitud> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Solicitud> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Solicitud> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Solicitud> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Solicitud> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Solicitud> boolean exists(Example<S> example) {
        return false;
    }
}
