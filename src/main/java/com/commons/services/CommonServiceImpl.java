package com.commons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R repository;

    /**
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
