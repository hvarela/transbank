package com.prueba.transbank.infrastructure.repository.RDBMS;


import com.prueba.transbank.infrastructure.entities.UserEntity;
import com.prueba.transbank.infrastructure.entities.VentasEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface VentasRepository extends Repository<VentasEntity, Integer>{

    List<UserEntity> findAll();

    UserEntity save(UserEntity resourceEntity);

    @Query(name = "VentasRepository.findByproductId")
    Optional<UserEntity> findByNamePassword(String name, String password);
}
