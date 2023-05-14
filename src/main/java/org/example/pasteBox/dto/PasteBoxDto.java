package org.example.pasteBox.dto;

import lombok.*;
import org.example.pasteBox.entity.enums.Status;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteBoxDto {

    private String data;

    private Status status;

}
