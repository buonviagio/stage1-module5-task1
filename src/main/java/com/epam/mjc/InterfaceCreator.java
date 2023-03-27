package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                if (!(Character.isAlphabetic(str.charAt(0)) && Character.isUpperCase(str.charAt(0)))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return param -> {
            int element;
            int length = param.size();
            for (int i = 0; i < length; i++) {
                element = param.get(i);
                if (element % 2 == 0) {
                    param.add(element);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            String[] arrayString;
            for (String str : values) {
                arrayString = str.split(" ");
                if ((Character.isAlphabetic(str.charAt(0)) && Character.isUpperCase(str.charAt(0)))
                        && (str.endsWith(".")) && (arrayString.length > 3)) {
                    result.add(str);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String str : x) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(x);
            list.addAll(y);
            return list;
        };
    }
}
