package com.avenga.yablonskyi.dto;

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
    private String idBook;
    private String firstName;
    private String lastName;
}