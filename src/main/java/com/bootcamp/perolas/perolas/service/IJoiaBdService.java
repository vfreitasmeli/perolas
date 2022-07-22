package com.bootcamp.perolas.perolas.service;

import com.bootcamp.perolas.perolas.model.JoiaBD;

import java.util.List;

public interface IJoiaBdService {

    public JoiaBD saveJewels(JoiaBD jewel);
    public List<JoiaBD> getAllJewels();
    public void deleteJewel(long numero_id);
    public JoiaBD getById(long numero_id);
}
