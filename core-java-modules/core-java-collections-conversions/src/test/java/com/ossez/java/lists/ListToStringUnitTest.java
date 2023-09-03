package com.ossez.java.lists;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

public class ListToStringUnitTest {

    @Test
    public void whenListToString_thenPrintDefault() {
        List<Integer> intLIst = Arrays.asList(1, 2, 3);
        System.out.println(intLIst);
    }

    @Test
    public void whenCollectorsJoining_thenPrintCustom() {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        System.out.println(intList.stream()
            .map(n -> String.valueOf(n))
            .collect(Collectors.joining("-", "{", "}")));
    }
    
    @Test
    public void whenStringUtilsJoin_thenPrintCustom() {
        List<Integer> intList = Arrays.asList(1, 2, 3);
       System.out.println(StringUtils.join(intList, "|"));

//        Object obj1  = new Integer(100);
//        System.out.println(obj1.toString());

//        ToStringBuilder.reflectionToString(intList);

        Country country = new Country("United States", "North America", 4000000);
        System.out.println(ReflectionToStringBuilder.toString(intList));
        }



    class Country {
        private String name;
        private String continent;
        private int population;

        public Country(String name, String continent, int population) {
            this.name = name;
            this.continent = continent;
            this.population = population;
        }
    }

}
