package org.example.pasteBox.controller;

import org.example.pasteBox.dto.PasteBoxDto;
import org.example.pasteBox.dto.PasteBoxDtoBuilder;
import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.entity.enums.Status;
import org.example.pasteBox.service.PasteBoxService;
import org.example.pasteBox.util.HashGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pasteBox")
public class PasteBoxController {

    private final String HOST = "http://localhost:8081/pasteBox/";

    private final PasteBoxService pasteBoxService;

    private final HashGenerator hashGenerator;

    private final PasteBoxDtoBuilder pasteBoxDtoBuilder;

    public PasteBoxController(PasteBoxService pasteBoxService,
                              PasteBoxDtoBuilder pasteBoxDtoBuilder,
                              HashGenerator hashGenerator) {
        this.pasteBoxService = pasteBoxService;
        this.hashGenerator = hashGenerator;
        this.pasteBoxDtoBuilder = pasteBoxDtoBuilder;
    }


    @GetMapping("/")
    public List<PasteBoxDto> getLatestPastes(){

        List<PasteBoxEntity> pasteBoxes = pasteBoxService.getAllPasteBoxes();

        return pasteBoxes.stream()
                .sorted((p1,p2) -> p2.getCreateTime().compareTo(p1.getCreateTime()))
                .map(paste -> pasteBoxDtoBuilder.makePasteBoxDto(paste))
                .limit(10)
                .collect(Collectors.toList());
    }

    @GetMapping("/{hash}")
    public PasteBoxDto getByHash(@PathVariable(name = "hash") String hash){

        PasteBoxEntity paste = pasteBoxService.getByHash(hash);

        return pasteBoxDtoBuilder.makePasteBoxDto(paste);
    }

    @PostMapping("/")
    public String createNewPasteBox(@RequestParam(name = "data") String data,
                                    @RequestParam(name = "time") Long time){

    PasteBoxEntity persistPasteBox = PasteBoxEntity.builder()
            .data(data)
            .expirationTimeSeconds(time)
            .status(Status.PUBLIC)
            .hash(hashGenerator.generateHash())
            .build();

    pasteBoxService.save(persistPasteBox);

    return HOST + persistPasteBox.getHash();
    }
}
