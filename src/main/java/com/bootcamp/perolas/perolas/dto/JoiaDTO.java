package com.bootcamp.perolas.perolas.dto;


import com.bootcamp.perolas.perolas.model.JoiaBD;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class JoiaDTO {
    private long numero_id;


    public JoiaDTO(JoiaBD jewel) {
        this.numero_id = jewel.getNumero_id();
    }
}
