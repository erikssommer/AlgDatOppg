package algdat.testklasser;

import algdat.datastrukturer.Tabell;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static algdat.datastrukturer.Tabell.*;
import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @Test
    void bytt() {
        int[] liste = {3,4};

        Tabell.bytt(liste, 0, 1);

        assertEquals("[4, 3]", Arrays.toString(liste));
    }

    @Test
    void randPerm() {
    }

    @Test
    void testRandPerm() {
    }

    @Test
    void maks() {
        int[] a = {4,5,6,4,2,6,8,9,2,1};
        int[] b = {};
        assertThrows(NoSuchElementException.class, () -> Tabell.maks(a, 3, 3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Tabell.maks(a, -3, 3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Tabell.maks(a, 2, 18));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Tabell.maks(a, 6, 2));
        assertThrows(IllegalArgumentException.class, () -> Tabell.maks(b));
    }

    @Test
    void testMaks() {
    }

    @Test
    void min() {
    }

    @Test
    void testMin() {
    }

    @Test
    void testBytt() {
    }

    @Test
    void skriv() {
    }

    @Test
    void testSkriv() {
    }

    @Test
    void skrivln() {
    }

    @Test
    void testSkrivln() {
    }

    @Test
    void sort() {
        int[] liste1 = {76,3,2,7,32,4,2,7,8,3};
        Tabell.sort(liste1);

        assertEquals("[2, 2, 3, 3, 4, 7, 7, 8, 32, 76]", Arrays.toString(liste1));

        Integer[] liste2 = {76,3,2,7,32,4,2,7,8,3};
        Tabell.sort(liste2);

        assertEquals("[2, 2, 3, 3, 4, 7, 7, 8, 32, 76]", Arrays.toString(liste2));
    }

    @Test
    void testSort() {
    }

    @Test
    void fratilKontroll() {
        int[] a = {4,3,2,5,3,2,6,8,4};
        Tabell.fratilKontroll(a.length, 3, 5);
    }

    @Test
    void vhKontroll() {
    }

    @Test
    void nestmaks() {
    }

    @Test
    void nestMaks() {
    }

    @Test
    void nestMaksSF() {
    }

    @Test
    void nestMaksSB() {
    }

    @Test
    void sortering() {
    }

    @Test
    void nestMaksTR() {
    }

    @Test
    void kopier() {
    }

    @Test
    void snu() {
    }

    @Test
    void testSnu() {
    }

    @Test
    void testSnu1() {
    }

    @Test
    void nestePermutasjon() {
    }

    @Test
    void binarySearch() {
    }

    @Test
    void inversjoner() {
    }

    @Test
    void utvalgssortering() {
    }

    @Test
    void testUtvalgssortering() {
    }

    @Test
    void selectionSort() {
    }

    @Test
    void usortertsok() {
    }

    @Test
    void linearsok() {
    }

    @Test
    void linearsokReturSisteVerdi() {
    }

    @Test
    void testLinearsok() {
    }

    @Test
    void kvadratrotsok() {
    }

    @Test
    void binaersokV1() {
    }

    @Test
    void binaersokV2() {
    }

    @Test
    void binaersokV3() {
    }

    @Test
    void testBinaersokV1() {
    }

    @Test
    void testBinaersokV2() {
    }

    @Test
    void testBinaersokV3() {
    }

    @Test
    void innsettingssortering() {
    }

    @Test
    void testInnsettingssortering() {
    }

    @Test
    void innsettingssorteringV2() {
    }

    @Test
    void shell() {
    }

    @Test
    void erSortert() {
    }

    @Test
    void testMaks1() {
    }

    @Test
    void testMaks2() {
    }

    @Test
    void testMaks3() {
    }

    @Test
    void testMaks4() {
    }

    @Test
    void testMaks5() {
    }

    @Test
    void testInnsettingssortering1() {
    }

    @Test
    void testSkriv1() {
    }

    @Test
    void testSkriv2() {
    }

    @Test
    void testSkrivln1() {
    }

    @Test
    void testBytt1() {
    }

    @Test
    void randPermInteger() {
    }

    @Test
    void f() {
    }

    @Test
    void testF() {
    }

    @Test
    void testInnsettingssortering2() {
    }

    @Test
    void testMaks6() {
    }

    @Test
    void testMaks7() {
    }

    @Test
    void testUtvalgssortering1() {
    }

    @Test
    void kvikksortering() {
    }

    @Test
    void parter() {
        Integer[] liste = {11,2,17,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,5};
        Tabell.parter(liste, 6, Comparator.naturalOrder());
        Tabell.parter(liste, 10, Comparator.naturalOrder());
        Tabell.parter(liste, 15, Comparator.naturalOrder());
        assertEquals("[5, 2, 4, 1, 3, 8, 6, 7, 9, 11, 12, 13, 14, 10, 16, 20, 18, 17, 19, 15]",
                Arrays.toString(liste));
    }

    @Test
    void testParter() {
    }

    @Test
    void sParter() {
    }

    @Test
    void flettesortering() {
    }

    @Test
    void a() {
    }

    @Test
    void tverrsum() {
    }

    @Test
    void tverrsumURek() {
    }

    @Test
    void tverrsumUtskrift() {
    }

    @Test
    void sifferrot() {
    }

    @Test
    void euklid() {
    }

    @Test
    void euklidUtskrift() {
    }

    @Test
    void sum() {
    }

    @Test
    void testSum() {
    }

    @Test
    void testSum1() {
    }

    @Test
    void fib() {
    }

    @Test
    void fibUtskrivt() {
    }

    @Test
    void sumkvadrattall() {
    }

    @Test
    void testSum2() {
    }

    @Test
    void storst() {
    }

    @Test
    void fak() {
    }

    @Test
    void kvikksortering0() {
    }
}