package org.example.pasteBox.service;

import org.example.pasteBox.entity.PasteBoxEntity;

import java.util.List;

public interface PasteBoxService {

    PasteBoxEntity getByHash(String hash);

    PasteBoxEntity create(PasteBoxEntity pasteBox);

    List<PasteBoxEntity> getAllLastPasteBoxes(int count);
}
