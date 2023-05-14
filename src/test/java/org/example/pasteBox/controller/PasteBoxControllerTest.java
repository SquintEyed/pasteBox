package org.example.pasteBox.controller;

import org.example.pasteBox.dto.PasteBoxDto;
import org.example.pasteBox.dto.PasteBoxDtoBuilder;
import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.service.PasteBoxService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PasteBoxControllerTest {

    private final String HASH = "hash";

    @Mock
    private PasteBoxService pasteBoxService;

    @Mock
    private PasteBoxDtoBuilder pasteBoxDtoBuilder;

    @InjectMocks
    private PasteBoxController pasteBoxController;


    @Test
    void getLatestPastes() {

        List<PasteBoxEntity> entities = mock(List.class);
        List<PasteBoxDto> dtoEntities = mock(List.class);
        when(pasteBoxService.getAllPasteBoxes()).thenReturn(entities);

        List<PasteBoxDto> actual = pasteBoxController.getLatestPastes();

        assertNotNull(actual);
        verify(pasteBoxService).getAllPasteBoxes();

    }

    @Test
    void getByHash() {

        PasteBoxDto pasteBoxDto = mock(PasteBoxDto.class);
        PasteBoxEntity pasteBoxEntity = mock(PasteBoxEntity.class);
        when(pasteBoxService.getByHash(HASH)).thenReturn(pasteBoxEntity);
        when(pasteBoxDtoBuilder.makePasteBoxDto(pasteBoxEntity)).thenReturn(pasteBoxDto);

        PasteBoxDto actual = pasteBoxController.getByHash(HASH);

        assertNotNull(actual);
        assertEquals(actual, pasteBoxDto);
        verify(pasteBoxDtoBuilder).makePasteBoxDto(pasteBoxEntity);
        verify(pasteBoxService).getByHash(HASH);
    }

    @Test
    void createNewPasteBox() {

        PasteBoxEntity pasteBoxEntity = mock(PasteBoxEntity.class);
        when(pasteBoxService.save(pasteBoxEntity)).thenReturn(pasteBoxEntity);


    }
}