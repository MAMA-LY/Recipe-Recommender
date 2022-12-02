package com.BrainFood.Collectors;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class UnitTester {
    @Test
    public void testMerger(){
        List<String> a = Arrays.asList("2","5");
        List<String> b = null;
        List<String> c = Arrays.asList("1","9");

        System.out.println(Stream
                .of(a, b, c)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .toList());
    }
}
