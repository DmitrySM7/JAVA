package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Map;

public class MapProcessHandler implements ProcessHandler {
    private Field field;
    private Helper helper;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;

    public MapProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
    }

    @Override
    public String generateString() throws IllegalAccessException {
        helper = new Processor();
        tabulationLevel = helper.firstStep(result,field,tabulationLevel, true);
        Map<?, ?> map = (Map<?, ?>) field.get(object);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            helper.CollectionHelper(result, entry, tabulationLevel, true);
        }
        result.append("\n");
        tabulationLevel--;
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        result.append("}");
        return result.toString();
    }
}
