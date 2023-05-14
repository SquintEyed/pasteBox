package org.example.pasteBox.util;

import org.example.pasteBox.entity.PasteBoxEntity;

public interface UsefulFeatures {

    String generateHash();

    boolean checkTimeOfLife(PasteBoxEntity pasteBox);
}
