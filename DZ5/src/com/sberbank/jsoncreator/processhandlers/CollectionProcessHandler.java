package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Collection;

public class CollectionProcessHandler implements ProcessHandler {

    private Field field;
    private Helper helper;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;

    public CollectionProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
    }

    @Override
    public String generateString() throws IllegalAccessException {
        helper = new Processor();
        tabulationLevel = helper.firstStep(result,field,tabulationLevel, false);
        Collection<?> collection = (Collection<?>) field.get(object);
        for (Object obj : collection) {
            helper.CollectionHelper(result, obj, tabulationLevel, false);
        }
        result.deleteCharAt(result.length() - 1);
        result.append("\n");
        tabulationLevel--;
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        result.append("]");
        return result.toString();
    }
}
