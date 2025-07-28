package com.avenga.yablonskyi.endpoints;

public class AuthorsEndpoints extends BaseEndpoint {

    private static final String AUTHORS = API_V1 + "/Authors";

    @Override
    public String getAll() {
        return AUTHORS;
    }

    @Override
    public String getById(int id) {
        return AUTHORS + "/" + id;
    }

}
