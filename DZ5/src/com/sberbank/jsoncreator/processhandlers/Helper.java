package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;

public interface Helper {
    Integer firstStep(StringBuilder result, Field field, Integer tabulationLevel, Boolean isCurlyBraces);
    void CollectionHelper(StringBuilder result, Object obj, Integer tabulationLevel, Boolean isMap);
    Integer SecondStep(StringBuilder result, Integer tabulationLevel, Boolean isCurlyBraces);
}
