package org.example.pasteBox.util;

import org.example.pasteBox.entity.PasteBoxEntity;

import java.util.List;

public interface UsefulFeatures {

    String generateHash();

    List<PasteBoxEntity> getListActualPastes(List<PasteBoxEntity> pastes);

    boolean checkTimeOfLife(PasteBoxEntity pasteBox);
}
