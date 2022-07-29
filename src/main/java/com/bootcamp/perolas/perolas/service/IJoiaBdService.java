package com.bootcamp.perolas.perolas.service;

import com.bootcamp.perolas.perolas.dto.JoiaDTO;
import com.bootcamp.perolas.perolas.model.JoiaBD;

import java.util.List;
import java.util.Map;

public interface IJoiaBdService {

    JoiaDTO saveJewels(JoiaBD jewel);
    JoiaBD updateJewel(JoiaBD jewel);
    List<JoiaBD> getAllJewels();
    void deleteJewel(long numero_id);
    JoiaBD getById(long numero_id);

    JoiaBD updatePartial(long numero_id, Map<String, Object> changes);

    JoiaBD findByMaterial(String material);
}
