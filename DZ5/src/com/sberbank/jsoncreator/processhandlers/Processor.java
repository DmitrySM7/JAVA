package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;

public class Processor implements Helper {

    @Override
    public Integer firstStep(StringBuilder result, Field field, Integer tabulationLevel, Boolean isCurlyBraces) {
        field.setAccessible(true);
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        result.append("\"").append(field.getName()).append("\"").append(": ");
        if (!isCurlyBraces) {
            result.append("[");
        } else {
            result.append("{");
        }
        tabulationLevel++;
        return tabulationLevel;
    }

    @Override
    public void CollectionHelper( StringBuilder result, Object obj, Integer tabulationLevel, Boolean isMap) {
        result.append("\n");
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        if (!isMap) {
            result.append("\"").append(obj).append("\"");
        } else {
            result.append("\"").append(((Map.Entry<?,?>) obj).getKey()).append("\"").append(": ").append("\"")
                    .append(((Map.Entry<?,?>) obj).getValue()).append("\"");
        }
        result.append(",");
    }

    @Override
    public Integer SecondStep(StringBuilder result, Integer tabulationLevel, Boolean isCurlyBraces) {
        tabulationLevel--;
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        if (!isCurlyBraces) {
            result.append("]");
        } else {
            result.append("}");
        }
        return tabulationLevel;
    }
}
