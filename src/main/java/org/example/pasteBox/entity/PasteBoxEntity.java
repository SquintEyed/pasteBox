package org.example.pasteBox.entity;

import lombok.*;
import org.example.pasteBox.entity.enums.ExpirationTime;
import org.example.pasteBox.entity.enums.Status;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Comparator;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Table(name = "paste_box_entity")
public class PasteBoxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data")
    private String data;

    @Column(name = "hash")
    private String hash;

    @Builder.Default
    private LocalDateTime createTime = LocalDateTime.now();

    @Column(name = "expiration_time")
    @Enumerated(value = EnumType.STRING)
    private ExpirationTime expirationTime;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.PUBLIC;

}
