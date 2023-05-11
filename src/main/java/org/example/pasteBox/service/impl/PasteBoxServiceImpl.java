package org.example.pasteBox.service.impl;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.repository.PasteBoxRepo;
import org.example.pasteBox.service.PasteBoxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasteBoxServiceImpl implements PasteBoxService {

    private final PasteBoxRepo pasteBoxRepo;

    public PasteBoxServiceImpl(PasteBoxRepo pasteBoxRepo) {
        this.pasteBoxRepo = pasteBoxRepo;
    }

    @Override
    public PasteBoxEntity getByHash(String hash) {
        return null;
    }

    @Override
    public PasteBoxEntity create(PasteBoxEntity pasteBox) {
        return null;
    }

    @Override
    public List<PasteBoxEntity> getAllLastPasteBoxes(int count) {
        return null;
    }
}
