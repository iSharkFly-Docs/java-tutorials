package com.ossez.toolkits.codebank.tests;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * String Test Case
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class EmptyQuickTest {
    private static final String VOWEL_A = "a";
    private static final String VOWEL_E = "e";
    private static final String VOWEL_I = "i";
    private static final String VOWEL_O = "o";
    private static final String VOWEL_U = "u";


    @BeforeEach
    protected void setUp() throws Exception {
    }

    @AfterEach
    protected void tearDown() throws Exception {
    }

    @Test
    public void testMain() {
        Integer[] nums = {2, 7, 11, 15};

        Integer target = 9;

        String s1 = "Question, what kind of bear is best?";
        String s2 = "That's a ridiculous question!";
        String s3 = "False.";
        String s4 = "Black bear is the best bear.";

        List<String> inputStr = new ArrayList<>();
        inputStr.add(RegExUtils.replaceAll(s1, "[^a-zA-Z\\s]", "").toLowerCase());
        inputStr.add(RegExUtils.replaceAll(s2, "[^a-zA-Z\\s]", "").toLowerCase());
        inputStr.add(RegExUtils.replaceAll(s3, "[^a-zA-Z\\s]", "").toLowerCase());
        inputStr.add(RegExUtils.replaceAll(s4, "[^a-zA-Z\\s]", "").toLowerCase());

        HashMap<String, List<String>> wordsMap = new HashMap<>();

        for (int i = 0; i < inputStr.size(); i++) {
            String words = inputStr.get(i);
            List<String> wordsList = List.of(StringUtils.split(inputStr.get(i)));
            for (int j = 0; j < wordsList.size(); j++) {
                String word = wordsList.get(j);
                List<String> inStr = new ArrayList<>();
                if (wordsMap.get(word) != null) {
                    inStr = wordsMap.get(word);
                }
                inStr.add("" + (i + 1));
                wordsMap.put(word, inStr);

            }
        }

        TreeMap<Integer, List<String>> countMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, List<String>> stringListEntry : wordsMap.entrySet()) {
            Integer wordCount = stringListEntry.getValue().size();
            List<String> wordsList = new ArrayList<>();
            if (countMap.get(wordCount) != null) {
                wordsList = countMap.get(wordCount);

            }
            wordsList.add(stringListEntry.getKey());
            countMap.put(wordCount, wordsList);
        }

        for (Map.Entry<Integer, List<String>> integerListEntry : countMap.entrySet()) {
            List<String> outputList = integerListEntry.getValue();
            for (int i = 0; i < outputList.size(); i++) {
                List<String> sList = wordsMap.get(outputList.get(i));
                log.debug("{}[{}:{}]", outputList.get(i), integerListEntry.getKey(), sList.stream().distinct().collect(Collectors.toList()));
            }

        }

    }

    private Boolean hasVowels(String str) {

        str = StringUtils.trimToEmpty(str);
        str = StringUtils.lowerCase(str);
        str = StringUtils.remove(str, " ");

        if (StringUtils.contains(str, VOWEL_A)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_E)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_I)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_O)) {
            return Boolean.TRUE;
        } else if (StringUtils.contains(str, VOWEL_U)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

}
