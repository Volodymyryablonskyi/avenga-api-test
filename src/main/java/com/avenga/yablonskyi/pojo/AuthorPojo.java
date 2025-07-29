package com.avenga.yablonskyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPojo implements BasePojo {

    private int id;
    private int idBook;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        AuthorPojo other = (AuthorPojo) that;
        return id == other.id && firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

}