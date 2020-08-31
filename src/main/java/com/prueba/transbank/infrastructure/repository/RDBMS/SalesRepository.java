package com.prueba.transbank.infrastructure.repository.RDBMS;


import com.prueba.transbank.infrastructure.entitys.SalesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface SalesRepository extends Repository<SalesEntity, Integer>{

    List<SalesEntity> findAll();

    SalesEntity save(SalesEntity resourceEntity);

    @Query(name = "SalesRepository.findByproductId")
    Optional<SalesEntity> findByNamePassword(String name, String password);
}
