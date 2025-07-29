package com.avenga.yablonskyi.testdata;

import com.avenga.yablonskyi.dto.BookPojo;
import com.avenga.yablonskyi.util.Randomizer;

import java.time.OffsetDateTime;

public class BooksTestData implements BaseTestData {

    private final String TITLE_TEMPLATE = "Book %s";
    private final String DESCRIPTION = "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n";
    private final String EXCERPT = "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n" +
            "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n" +
            "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n" +
            "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n" +
            "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n";

    private String getPublishDateFormatted() {
        return OffsetDateTime.now().withNano(0).toString();
    }

    @Override
    public BookPojo generateExisting() {
        int id = getExistingId();
        return BookPojo.builder()
                .id(id)
                .title(String.format(TITLE_TEMPLATE, id))
                .description(DESCRIPTION)
                .pageCount(id * 100)
                .excerpt(EXCERPT)
                .publishDate(getPublishDateFormatted())
                .build();
    }

    @Override
    public BookPojo generateForUpdate() {
        int id = getExistingId();
        return BookPojo.builder()
                .id(id)
                .title(String.format(TITLE_TEMPLATE, id + Randomizer.getRandomNumberInRange(1, 100)))
                .description(Randomizer.getRandomAlphabetic(30))
                .pageCount(Randomizer.getRandomNumberInRange(300, 1000))
                .excerpt(Randomizer.getRandomAlphabetic(300))
                .publishDate(getPublishDateFormatted())
                .build();
    }

    @Override
    public BookPojo generateNotExisting() {
        int id = getNotExistingId();
        return BookPojo.builder()
                .id(id)
                .title(String.format(TITLE_TEMPLATE, id))
                .description(DESCRIPTION)
                .pageCount(id * 100)
                .excerpt(EXCERPT)
                .publishDate(getPublishDateFormatted())
                .build();
    }

    @Override
    public BookPojo generateInvalid() {
        int id = getNotExistingId();
        return BookPojo.builder()
                .id(id)
                .pageCount(id * 100)
                .publishDate(getPublishDateFormatted())
                .build();
    }

}