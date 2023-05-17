package org.example.pasteBox.service.impl;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.exception.NotFoundException;
import org.example.pasteBox.repository.PasteBoxRepo;
import org.example.pasteBox.util.UsefulFeatures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PasteBoxServiceImplTest {

    private final String HASH = "aa";

    @InjectMocks
    private PasteBoxServiceImpl pasteBoxService;

    @Mock
    private PasteBoxRepo pasteBoxRepo;

    @Mock
    private UsefulFeatures usefulFeatures;

    @Test
    void getByHash_ShouldBeFindPaste_WhenPasteExist() {

        PasteBoxEntity entity = mock(PasteBoxEntity.class);
        when(pasteBoxRepo.findByHash(HASH)).thenReturn(entity);
        when(usefulFeatures.checkTimeOfLife(entity)).thenReturn(true);

        PasteBoxEntity actual = pasteBoxService.getByHash(HASH);

        assertThrows(NotFoundException.class, () -> pasteBoxService.getByHash(anyString()));
        assertEquals(entity,actual);
        assertNotNull(actual);
        verify(pasteBoxRepo).findByHash(HASH);
    }

    @Test
    void save_ShouldBeCallRepo() {

        PasteBoxEntity entity = mock(PasteBoxEntity.class);

        pasteBoxService.save(entity);

        verify(pasteBoxRepo).save(entity);
    }

    @Test
    void getAllPasteBoxes_ShouldBeFindPastes() {

        List<PasteBoxEntity> entities = mock(List.class);
        PasteBoxEntity entity = mock(PasteBoxEntity.class);
        List<PasteBoxEntity> sortedPastes = mock(List.class);
        when(pasteBoxRepo.findAll()).thenReturn(entities);
        when(usefulFeatures.getListActualPastes(entities)).thenReturn(sortedPastes);

        List<PasteBoxEntity> actualEntities = pasteBoxService.getAllPasteBoxes();

        assertEquals(sortedPastes, actualEntities);
        verify(pasteBoxRepo).findAll();
    }
}