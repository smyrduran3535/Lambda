package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));


        hepsiniYaz(list);
        negatifYazdir(list);
        pozitifYazdir(list);
        pozVeyaCift(list);
        System.out.println();
        karePrint(list);
        System.out.println();
        kupCiftPrint(list);
        System.out.println();
        sorted(list);
        System.out.println();
        tersSorted(list);
        System.out.println();
        System.out.println("pozKup5List(list) = " + pozKup5List(list));
        System.out.println("pozKareSon5DegilList(list) = " + pozKareSon5DegilList(list));
        System.out.println("toplam(list) = " + toplam(list));
        System.out.println("toplamReferans(list) = " + toplamReferans(list));
        System.out.println("toplamReferans2(list) = " + toplamReferans2(list));


    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void hepsiniYaz(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));
    }

    //negatiflleri yazdir
    public static void negatifYazdir(List<Integer> list) {
        list.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));
    }

    //pozitiflerden ciftleri yazd
    public static void pozitifYazdir(List<Integer> list) {
        list.stream().filter(t -> t > 0 && t % 2 == 0).forEach(t -> System.out.print(t + " "));
    }

    //pozitif ve cift olanlar
    public static void pozVeyaCift(List<Integer> list) {
        System.out.println(list.
                stream().filter(t -> t % 2 == 0 || t > 0).collect(Collectors.toList()));
    }

    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    public static void karePrint(List<Integer> list) {
        list.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));
    }

    public static void kupCiftPrint(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }

    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
// Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir
// (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    ////S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım!!!!!!!!!!!!!!!!!!!!!!!!!TEKRARSIZ YAZDIRIR
    public static void kareTekrarsizPrint(List<Integer> list) {
        list.stream().map(t -> t * t).distinct().forEach(C01::yazdir);
    }

    public static void yazdir(int a) {
        System.out.print(a + " ");
    }

    public static void sorted(List<Integer> list) {//kucukten=-12 -8 -5 -2 0 1 5 5 6 8 9 12 15
        list.stream().sorted().forEach(C01::yazdir);
    }

    public static void tersSorted(List<Integer> list) {//buyukten kucuge ters sırala yapar=15 12 9 8 6 5 5 1 0 -2 -5 -8 -12
        list.stream().sorted(Comparator.reverseOrder()).forEach(C01::yazdir);
    }

    // // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5List(List<Integer> l) {
        return l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());//collect liste cevirir
    }

    ////S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKareSon5DegilList(List<Integer> l) {
        return l.stream().filter(t -> t > 0).map(t -> t * t).filter(t -> t % 10 != 5).collect(Collectors.toList());
    }

    // S13 :list elemanlarini toplamini bulalim
    public static Integer toplam(List<Integer> l) {
        return l.stream().reduce(0, (a, b) -> a + b);
    }

    //referanse ile;
    public static Integer toplamReferans(List<Integer> l) {
        return l.stream().reduce(0, Math::addExact);
    }

    public static Integer toplamReferans2(List<Integer> l) {
        return l.stream().reduce(0, Integer::sum);
    }

    //poz toplamları:
    public static Integer toplamReferans2Poz(List<Integer> l) {
        return l.stream().filter(t -> t > 0).reduce(0, Integer::sum);
    }














}