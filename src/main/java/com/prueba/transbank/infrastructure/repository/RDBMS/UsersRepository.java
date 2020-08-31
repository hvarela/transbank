package com.prueba.transbank.infrastructure.repository.RDBMS;


import com.prueba.transbank.infrastructure.entitys.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UsersRepository extends Repository<UserEntity, Integer>{

    List<UserEntity> findAll();

    @Query(name = "UsersRepository.findByNamePassword")
    Optional<UserEntity> findByNamePassword(String name, String password);
}
