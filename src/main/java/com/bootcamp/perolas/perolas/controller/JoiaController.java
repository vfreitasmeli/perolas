package com.bootcamp.perolas.perolas.controller;

import com.bootcamp.perolas.perolas.dto.JoiaDTO;
import com.bootcamp.perolas.perolas.model.JoiaBD;
import com.bootcamp.perolas.perolas.service.IJoiaBdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/joia")
public class JoiaController {

    @Autowired
    private IJoiaBdService jewelService;

    @GetMapping("/{id}")
    public ResponseEntity<JoiaBD> getById(@PathVariable long id) {
        return ResponseEntity.ok(jewelService.getById(id));
    }

    @GetMapping("/material/{material}")
    public ResponseEntity<JoiaBD> findByMaterial(@PathVariable String material) {
        return ResponseEntity.ok(jewelService.findByMaterial(material));
    }

    @PostMapping("/inserir")
    public ResponseEntity<JoiaDTO> createJewel(@RequestBody JoiaBD jewel) {

        return ResponseEntity.status(HttpStatus.CREATED).body(jewelService.saveJewels(jewel));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<JoiaBD> updateJewel(@RequestBody JoiaBD jewel) {

        return ResponseEntity.ok(jewelService.updateJewel(jewel));
    }
    @PatchMapping("/atualizar/{numero_id}")
    public ResponseEntity<JoiaBD> updatePartial(@PathVariable long numero_id, @RequestBody Map<String, Object> changes) {

        return ResponseEntity.ok(jewelService.updatePartial(numero_id, changes));
    }

    @GetMapping
    public ResponseEntity<List<JoiaBD>> getAllJewels() {

        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @DeleteMapping("/excluir") //localhost:8080/joia/excluir?numero_id=4
    public ResponseEntity<Void> deleteJewel(@RequestParam long numero_id) {
            jewelService.deleteJewel(numero_id);
            return ResponseEntity.noContent().build();
    }

}
