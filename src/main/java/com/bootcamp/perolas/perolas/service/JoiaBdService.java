package com.bootcamp.perolas.perolas.service;

import com.bootcamp.perolas.perolas.dto.JoiaDTO;
import com.bootcamp.perolas.perolas.exeception.BadRequestException;
import com.bootcamp.perolas.perolas.exeception.NotFoundException;
import com.bootcamp.perolas.perolas.model.JoiaBD;
import com.bootcamp.perolas.perolas.repository.IJoiaBdRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class JoiaBdService implements IJoiaBdService{

    @Autowired
    private IJoiaBdRespository jewelRepo;

    @Override
    public JoiaDTO saveJewels(JoiaBD jewel) {
        if(jewel.getNumero_id() > 0) {
            throw new BadRequestException("A joia não pode ser cadastrada com id");
        }
        return new JoiaDTO(jewelRepo.save(jewel));
    }

    @Override
    public JoiaBD updateJewel(JoiaBD jewel) {
        getById(jewel.getNumero_id());
        return jewelRepo.save(jewel);
    }


    @Override
    @Transactional(readOnly = true)
    public List<JoiaBD> getAllJewels() {
        return jewelRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public JoiaBD getById(long numero_id) {
        return jewelRepo.findById(numero_id)
                .orElseThrow(() -> new NotFoundException("Joia não encontrada. Id: " + numero_id));
    }

    @Override
    public JoiaBD updatePartial(long numero_id, Map<String, Object> changes) {
        JoiaBD jewelFounded = getById(numero_id);

        changes.forEach((attribute, value) -> {
            switch (attribute) {
                case "material": jewelFounded.setMaterial((String) value); break;
                case "peso": jewelFounded.setPeso((double)value); break;
                case "quilates": jewelFounded.setPeso((int) value); break;
            }
        });

        return jewelRepo.save(jewelFounded);
    }

    @Override
    @Transactional(readOnly = true)
    public JoiaBD findByMaterial(String material) {
       return jewelRepo.findByMaterial(material);
    }

    @Override
    @Transactional
    public void deleteJewel(long numero_id) {
        getById(numero_id);
        jewelRepo.deleteById(numero_id);
    }


}
