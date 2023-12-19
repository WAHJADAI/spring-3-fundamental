package com.tutorial.springfundamental.repository;

import com.tutorial.springfundamental.model.Keyboardmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.UUID;



@Repository
public interface KeyboardRepository extends JpaRepository<Keyboardmodel, UUID> {
    List<Keyboardmodel> findAll();
}
