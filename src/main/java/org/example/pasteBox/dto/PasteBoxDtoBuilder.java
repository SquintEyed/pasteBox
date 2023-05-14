package org.example.pasteBox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.pasteBox.entity.PasteBoxEntity;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class PasteBoxDtoBuilder {

    public PasteBoxDto makePasteBoxDto(PasteBoxEntity paste) {
        return PasteBoxDto.builder()
                .data(paste.getData())
                .status(paste.getStatus())
                .build();
    }
}
