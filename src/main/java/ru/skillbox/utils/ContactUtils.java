package ru.skillbox.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactUtils {

    private ContactUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> getParamArray(String paramLine) {
        String[] param = paramLine.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < param.length; i++) {
            if (param[i].isBlank()) {
                continue;
            }
            result.add(param[i]);
        }
        return result;
    }

    public static String getCommandName(List<String> params) {
        if (params.isEmpty()) {
            return "";
        }
        return params.get(0).toLowerCase();
    }
}
