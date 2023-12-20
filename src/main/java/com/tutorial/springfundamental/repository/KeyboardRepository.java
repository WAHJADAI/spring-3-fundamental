package com.tutorial.springfundamental.repository;

import com.tutorial.springfundamental.model.KeyboardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.UUID;



@Repository
public interface KeyboardRepository extends JpaRepository<KeyboardModel, UUID> {
    List<KeyboardModel> findAllBy();
}
