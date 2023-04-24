package tests;

import org.junit.jupiter.api.Test;

import ejercicios.CountWords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.HashMap;

public class TestCountWords {

    @Test
    void testEmptyText() {
        Map<String, Integer> expected = new HashMap<>();
        
        Map<String, Integer> result = CountWords.countWords("");
        assertEquals(expected, result);
    }

    @Test
    void testSingleWord() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hola", 1);
        
        Map<String, Integer> result = CountWords.countWords("hola");
        assertEquals(expected, result);
    }

    @Test
    void testMultipleWords() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hola", 3);
        expected.put("como", 1);
        expected.put("estas", 1);
        
        Map<String, Integer> result = CountWords.countWords("hola como estas hola hola");
        assertEquals(expected, result);
    }
}

