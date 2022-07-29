package com.bootcamp.perolas.perolas.repository;

import com.bootcamp.perolas.perolas.model.JoiaBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoiaBdRespository extends JpaRepository<JoiaBD, Long> {
    JoiaBD findByMaterial(String material);
}
