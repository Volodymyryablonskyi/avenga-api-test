package com.avenga.yablonskyi.testdata;

import com.avenga.yablonskyi.dto.AuthorPojo;
import com.avenga.yablonskyi.util.Randomizer;

public class AuthorsTestData implements BaseTestData {

    private final String FIRST_NAME_TEMPLATE = "First Name %s";
    private final String LAST_NAME_TEMPLATE = "Last Name %s";

    @Override
    public AuthorPojo generateExisting() {
        int id = getExistingId();
        int idBook = getExistingId();
        return AuthorPojo.builder()
                .id(id)
                .idBook(idBook)
                .firstName(String.format(FIRST_NAME_TEMPLATE, id))
                .lastName(String.format(LAST_NAME_TEMPLATE, id))
                .build();
    }

    @Override
    public AuthorPojo generateForUpdate() {
        int id = getExistingId();
        int idBook = getExistingId();
        return AuthorPojo.builder()
                .id(id)
                .idBook(idBook)
                .firstName(String.format(Randomizer.getRandomAlphabetic(7), id))
                .lastName(String.format(Randomizer.getRandomAlphabetic(8), id))
                .build();
    }

    @Override
    public AuthorPojo generateNotExisting() {
        int id = getNotExistingId();
        int idBook = getNotExistingId();
        return AuthorPojo.builder()
                .id(id)
                .idBook(idBook)
                .firstName(String.format(FIRST_NAME_TEMPLATE, id))
                .lastName(String.format(LAST_NAME_TEMPLATE, id))
                .build();
    }

    @Override
    public AuthorPojo generateInvalid() {
        int id = getNotExistingId();
        int idBook = getNotExistingId();
        return AuthorPojo.builder()
                .id(id)
                .idBook(idBook)
                .build();
    }

}