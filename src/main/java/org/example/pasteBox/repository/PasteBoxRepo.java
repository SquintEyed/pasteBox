package org.example.pasteBox.repository;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasteBoxRepo extends JpaRepository<PasteBoxEntity, Long> {

    PasteBoxEntity findByHash(String hash);

    PasteBoxEntity save(PasteBoxEntity pasteBox);

    List<PasteBoxEntity> findAll();

}
