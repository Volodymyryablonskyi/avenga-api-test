package com.avenga.yablonskyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookPojo implements BasePojo {

    private int id;
    private String title;
    private String description;
    private int pageCount;
    private String excerpt;
    private String publishDate;

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        BookPojo other = (BookPojo) that;
        return id == other.id &&
                pageCount == other.pageCount &&
                title.equals(other.title) &&
                description.equals(other.description) &&
                excerpt.equals(other.excerpt);
    }

}