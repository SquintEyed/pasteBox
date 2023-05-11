package org.example.pasteBox.controller;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.entity.enums.Status;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pasteBox")
public class PasteBoxController {

    @GetMapping("/")
    public List<String> getLastPastes(){

        return new ArrayList<>();
    }

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable(name = "hash") String hash){

        return "Hello World" + hash;
    }

    @PostMapping("/")
    public PasteBoxEntity createNewPasteBox(@RequestParam(name = "data") String data,
                                            @RequestParam(name = "time") Long time){

        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setData(data);
        pasteBoxEntity.setExpirationTimeSeconds(time);

        return pasteBoxEntity;
    }
}
