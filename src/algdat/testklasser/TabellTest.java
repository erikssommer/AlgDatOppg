package algdat.testklasser;

import algdat.hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @org.junit.jupiter.api.Test
    void bytt() {
    }

    @org.junit.jupiter.api.Test
    void randPerm() {
    }

    @org.junit.jupiter.api.Test
    void sort() {
        int[] liste1 = {76,3,2,7,32,4,2,7,8,3};
        Tabell.sort(liste1);

        assertEquals("[2, 2, 3, 3, 4, 7, 7, 8, 32, 76]", Arrays.toString(liste1));

        Integer[] liste2 = {76,3,2,7,32,4,2,7,8,3};
        Tabell.sort(liste2);

        assertEquals("[2, 2, 3, 3, 4, 7, 7, 8, 32, 76]", Arrays.toString(liste2));
    }

    @org.junit.jupiter.api.Test
    void testRandPerm() {
    }

    @org.junit.jupiter.api.Test
    void maks() {
        int[] a = {4,5,6,4,2,6,8,9,2,1};
        int[] b = {};
        assertThrows(NoSuchElementException.class, () -> Tabell.maks(a, 3, 3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Tabell.maks(a, -3, 3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Tabell.maks(a, 2, 18));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Tabell.maks(a, 6, 2));
        assertThrows(IllegalArgumentException.class, () -> Tabell.maks(b));
    }

    @org.junit.jupiter.api.Test
    void testMaks() {
    }

    @org.junit.jupiter.api.Test
    void min() {
    }

    @org.junit.jupiter.api.Test
    void testMin() {
    }

    @org.junit.jupiter.api.Test
    void testBytt() {
    }

    @org.junit.jupiter.api.Test
    void skriv() {
    }

    @org.junit.jupiter.api.Test
    void testSkriv() {
    }

    @org.junit.jupiter.api.Test
    void skrivln() {
    }

    @org.junit.jupiter.api.Test
    void testSkrivln() {
    }

    @org.junit.jupiter.api.Test
    void fratilKontroll() {
        int[] a = {4,3,2,5,3,2,6,8,4};
        Tabell.fratilKontroll(a.length, 3, 5);
    }

    @org.junit.jupiter.api.Test
    void vhKontroll() {
    }
}