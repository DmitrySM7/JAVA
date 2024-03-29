package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ArrayProcessHandler implements ProcessHandler {
    private Field field;
    private Helper helper;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;

    public ArrayProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
    }

    @Override
    public String generateString() throws IllegalAccessException {
        helper = new Processor();
        tabulationLevel = helper.firstStep(result, field, tabulationLevel, false);
        Object array = field.get(object);

        int i = 0;
        while (true) {
            try {
                helper.CollectionHelper(result, Array.get(array, i), tabulationLevel, false);
                i++;
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }

        tabulationLevel = helper.SecondStep(result, tabulationLevel, false);
        return result.toString();
    }
}
