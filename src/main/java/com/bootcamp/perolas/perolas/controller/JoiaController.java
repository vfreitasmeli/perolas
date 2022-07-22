package com.bootcamp.perolas.perolas.controller;

import com.bootcamp.perolas.perolas.model.JoiaBD;
import com.bootcamp.perolas.perolas.service.IJoiaBdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joia")
public class JoiaController {

    @Autowired
    private IJoiaBdService jewelService;

    @PostMapping("/inserir")
    public ResponseEntity<JoiaBD> createJewel(@RequestBody JoiaBD jewel) {
        JoiaBD newJewel = jewelService.saveJewels(jewel);

        return ResponseEntity.status(HttpStatus.CREATED).body(jewelService.saveJewels(jewel));
    }

    @GetMapping
    public ResponseEntity<List<JoiaBD>> getAllJewels() {

        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoiaBD> getById(@PathVariable long id) {

        Optional<JoiaBD> jewelFounded = Optional.ofNullable(jewelService.getById(id));

        return jewelFounded.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> deleteJewel(@RequestParam long numero_id) {
        Optional<JoiaBD> jewelFounded = Optional.ofNullable(jewelService.getById(numero_id));

        if(jewelFounded.isPresent()) {
            jewelService.deleteJewel(numero_id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    // TODO: missing update method and exceptions
}
