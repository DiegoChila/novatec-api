package com.novatec.test.utils;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

    public static ArrayList<String> notFoundById() {
        List<String> error = new ArrayList<>();
        error.add("Id no existe");
        return (ArrayList<String>) error;
    }
}
