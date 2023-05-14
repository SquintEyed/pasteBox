package org.example.pasteBox.controller;

import org.example.pasteBox.dto.PasteBoxDto;
import org.example.pasteBox.dto.PasteBoxDtoBuilder;
import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.entity.enums.ExpirationTime;
import org.example.pasteBox.entity.enums.Status;
import org.example.pasteBox.service.PasteBoxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pasteBox")
public class PasteBoxController {

    private final String HOST = "http://localhost:8081/pasteBox/";

    private final PasteBoxService pasteBoxService;

    private final PasteBoxDtoBuilder pasteBoxDtoBuilder;

    public PasteBoxController(PasteBoxService pasteBoxService,
                              PasteBoxDtoBuilder pasteBoxDtoBuilder) {
        this.pasteBoxService = pasteBoxService;
        this.pasteBoxDtoBuilder = pasteBoxDtoBuilder;
    }


    @GetMapping("/")
    public List<PasteBoxDto> getLatestPastes(){

        List<PasteBoxEntity> pasteBoxes = pasteBoxService.getAllPasteBoxes();

        return pasteBoxes.stream()
                .map(paste -> pasteBoxDtoBuilder.makePasteBoxDto(paste))
                .collect(Collectors.toList());
    }

    @GetMapping("/{hash}")
    public PasteBoxDto getByHash(@PathVariable(name = "hash") String hash){

        PasteBoxEntity paste = pasteBoxService.getByHash(hash);

        return pasteBoxDtoBuilder.makePasteBoxDto(paste);
    }

    @PostMapping("/")
    public String createNewPasteBox(@RequestParam(name = "data", required = true) String data,
                                    @RequestParam(name = "expirationTime", required = true) String time){

    PasteBoxEntity persistPasteBox = pasteBoxService.create(data, time);

    pasteBoxService.save(persistPasteBox);

    return HOST + persistPasteBox.getHash();
    }
}
