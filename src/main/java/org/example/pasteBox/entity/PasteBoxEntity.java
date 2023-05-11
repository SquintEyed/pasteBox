package org.example.pasteBox.entity;

import lombok.*;
import org.example.pasteBox.entity.enums.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class PasteBoxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    private Long expirationTimeSeconds;

    private Status status = Status.PUBLIC;


}
