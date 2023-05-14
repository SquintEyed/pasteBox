package org.example.pasteBox.service.impl;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.exception.NotFoundException;
import org.example.pasteBox.repository.PasteBoxRepo;
import org.example.pasteBox.service.PasteBoxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PasteBoxServiceImpl implements PasteBoxService {

    private final PasteBoxRepo pasteBoxRepo;

    public PasteBoxServiceImpl(PasteBoxRepo pasteBoxRepo) {
        this.pasteBoxRepo = pasteBoxRepo;
    }

    @Override
    public PasteBoxEntity getByHash(String hash) {

        PasteBoxEntity optionalPasteBoxEntity = pasteBoxRepo.findByHash(hash);
        if (Objects.isNull(optionalPasteBoxEntity)) {
            throw new NotFoundException(String.format("Paste with  hash=%s not found",hash));
        }
        return optionalPasteBoxEntity;
    }

    @Override
    public PasteBoxEntity save(PasteBoxEntity pasteBox) {
        return pasteBoxRepo.save(pasteBox);
    }

    @Override
    public List<PasteBoxEntity> getAllPasteBoxes() {
        return pasteBoxRepo.findAll();
    }
}
