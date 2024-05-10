package com.cognizant.collector.jirazephyr.util;

import org.springframework.util.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Util {

    public static LocalDate getDateFromString(String dateAsString) {

        LocalDate date = null;

        if(StringUtils.hasLength(dateAsString)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy", Locale.ENGLISH);
            date = LocalDate.parse(dateAsString.trim(), formatter);

        }

        return date;

    }


















}
