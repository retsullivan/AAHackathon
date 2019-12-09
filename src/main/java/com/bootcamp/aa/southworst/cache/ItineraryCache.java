package com.bootcamp.aa.southworst.cache;

import com.bootcamp.aa.southworst.models.ItineraryInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ItineraryCache {

    private static final HashMap<String, ItineraryInfo> ITINERARY_CACHE = new HashMap();

    public static void addItemToCache(ItineraryInfo itineraryInfo) {
        ITINERARY_CACHE.put(itineraryInfo.getRecordLocator(), itineraryInfo);
    }

    public static String getRecordLocator() {
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }

}
