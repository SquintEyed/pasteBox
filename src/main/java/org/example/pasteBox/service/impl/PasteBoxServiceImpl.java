package org.example.pasteBox.service.impl;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.entity.enums.ExpirationTime;
import org.example.pasteBox.entity.enums.Status;
import org.example.pasteBox.exception.NotFoundException;
import org.example.pasteBox.repository.PasteBoxRepo;
import org.example.pasteBox.service.PasteBoxService;
import org.example.pasteBox.util.UsefulFeatures;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PasteBoxServiceImpl implements PasteBoxService {

    private final PasteBoxRepo pasteBoxRepo;

    private final UsefulFeatures usefulFeatures;

    public PasteBoxServiceImpl(PasteBoxRepo pasteBoxRepo, UsefulFeatures usefulFeatures) {
        this.pasteBoxRepo = pasteBoxRepo;
        this.usefulFeatures = usefulFeatures;
    }


    @Override
    public PasteBoxEntity getByHash(String hash) {

        PasteBoxEntity pasteBox = pasteBoxRepo.findByHash(hash);
        if (Objects.isNull(pasteBox)) {
            throw new NotFoundException(String.format("Paste with  hash=%s not found",hash));
        }

        if (!usefulFeatures.checkTimeOfLife(pasteBox)) {
            throw new NotFoundException(String.format("Time of life this paste(hash=%s) already over", hash));
        }

        return pasteBox;
    }

    @Override
    public PasteBoxEntity save(PasteBoxEntity pasteBox) {
        return pasteBoxRepo.save(pasteBox);
    }

    @Override
    public List<PasteBoxEntity> getAllPasteBoxes() {

        List<PasteBoxEntity> pasteBoxes = pasteBoxRepo.findAll();

        return usefulFeatures.getListActualPastes(pasteBoxes);
    }

    @Override
    public PasteBoxEntity create(String data, String time){

        PasteBoxEntity persistPasteBox = PasteBoxEntity.builder()
                .data(data)
                .expirationTime(ExpirationTime.setActualExpirationTime(time))
                .status(Status.PUBLIC)
                .hash(usefulFeatures.generateHash())
                .build();

        return persistPasteBox;
    }
}
