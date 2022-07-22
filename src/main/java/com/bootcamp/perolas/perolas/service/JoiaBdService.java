package com.bootcamp.perolas.perolas.service;

import com.bootcamp.perolas.perolas.model.JoiaBD;
import com.bootcamp.perolas.perolas.repository.IJoiaBdRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoiaBdService implements IJoiaBdService{

    private final IJoiaBdRespository jewelRepo;

    public JoiaBdService(IJoiaBdRespository jewelRepo) {
        this.jewelRepo = jewelRepo;
    }

    @Override
    @Transactional
    public JoiaBD saveJewels(JoiaBD jewel) {
        jewelRepo.save(jewel);
        return jewel;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoiaBD> getAllJewels() {
        return jewelRepo.findAll();
    }

    @Override
    @Transactional
    public void deleteJewel(long numero_id) {
        jewelRepo.deleteById(numero_id);
    }

    @Override
    @Transactional(readOnly = true)
    public JoiaBD getById(long numero_id) {
        return jewelRepo.findById(numero_id).orElse(null);
    }
}
