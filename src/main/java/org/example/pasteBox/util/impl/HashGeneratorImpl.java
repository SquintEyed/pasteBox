package org.example.pasteBox.util.impl;

import org.example.pasteBox.util.HashGenerator;
import org.springframework.stereotype.Service;

@Service
public class HashGeneratorImpl implements HashGenerator {

    private static int salt = 1222166;

    @Override
    public String generateHash() {
        return Integer.toHexString(salt++);
    }
}
