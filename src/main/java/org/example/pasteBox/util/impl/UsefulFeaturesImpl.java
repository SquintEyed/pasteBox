package org.example.pasteBox.util.impl;

import org.example.pasteBox.entity.PasteBoxEntity;
import org.example.pasteBox.entity.enums.ExpirationTime;
import org.example.pasteBox.util.UsefulFeatures;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsefulFeaturesImpl implements UsefulFeatures {

    private static int salt = 1222166;

    @Override
    public String generateHash() {
        return Integer.toHexString(salt++);
    }

    @Override
    public boolean checkTimeOfLife(PasteBoxEntity pasteBox) {

        int countDayExpirationTime = 1;
        int countWeekExpirationTime = 1;
        int countMonthExpirationTime = 1;
        int unlimitedExpirationTime = 10;

        LocalDateTime actualTime = LocalDateTime.now();
        LocalDateTime timeOfLife = null;
        ExpirationTime expirationTime = pasteBox.getExpirationTime();

        if (expirationTime.toString().equals("day")) {
            timeOfLife = pasteBox.getCreateTime().plusDays(countDayExpirationTime);
        }

        else if (expirationTime.toString().equals("week")){
            timeOfLife = pasteBox.getCreateTime().plusWeeks(countWeekExpirationTime);
        }

        else if (expirationTime.toString().equals("month")){
            timeOfLife = pasteBox.getCreateTime().plusMonths(countMonthExpirationTime);
        }

        else if (expirationTime.toString().equals("allTime")){
            timeOfLife = pasteBox.getCreateTime().plusYears(unlimitedExpirationTime);
        }

        return actualTime.isBefore(timeOfLife);
    }
}
