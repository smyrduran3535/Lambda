import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("\n*********");
        tekElKupBirFazla(sayi);
        System.out.println("\n*********");
        enMaxElBul(sayi);//Optional[15]
        System.out.println("\n*********");
        ciftElKareMaxPrint(sayi);
        System.out.println("\n*********");
        tumElToplamıPrint(sayi);
        System.out.println("\n*********");
        tumElCarpımıPrint(sayi);
        System.out.println("\n*********");
        minBulPrint(sayi);//
        System.out.println("\n*********");
        bestenBykTekKckPrint(sayi);
        System.out.println("\n*********");
        ciftElKareKckBykSirala(sayi);
        System.out.println();

    }
// Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
// ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::cirtBul).//akıstaki ciftsayıları filtreledik
                map(t -> t * t).//filtrelenen sayıların kareleri geldi 16,4,36;map sunu saglar;streamdeki akısı(elemanlara) baska tıplere(yani kareye) donusturur
                forEach(Lambda01::yazdir);
    }

    // Task 2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekElKupBirFazla(List<Integer> sayi) {
        sayi.
                stream().//4, 2, 6, 11, -5, 7, 3, 15
                filter(t -> t % 2 != 0).//11,-5,7,3,15
                map(t -> (t * t * t) + 1).//akısın icindekş elemanlar degisiyor
                forEach(Lambda01::yazdir);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftElKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::cirtBul).
                map(Math::sqrt).//donen deger double yazdır metodu kull.maz lambda 01deki
                forEach(t -> System.out.println(t + " "));//for each ile yazdrdk.yazdır metodu kabul etmedigi icin boyle yaptık

    }
// Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void enMaxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.stream().
                reduce(Math::max);//burdan sadece 1 deger gelicek diyoruz..eger benım resultım tek bir deger ise reducuterminal operatoru kull
        System.out.println(maxSayi);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftElKareMaxPrint(List<Integer> sayi) {
        System.out.println(sayi.//optinal almadan da Optional[36] bu sekilde cıktı alıyoruz
                stream().
                filter(Lambda01::cirtBul).
                map(a -> a * a).
                reduce(Integer::max));//Math max class a gore daha hızlı calısır Integer max  class ı
        //reduce :sadece tek deger icin kullanılır


    }
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void tumElToplamıPrint(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);//reducad a2 parametleli islem yapılacaksa  elemanlarda biri etkisizdir
        System.out.println("toplam = " + toplam);
        /*
* a ilk degerini her zaman atanan degerden (ilk parametre) alır,
    bu örnekte 0 oluyor
* b degerini her zamana  stream()'dan akısdan alır
* a ilk degerinden sonraki her değeri action(işlem)'dan alır

*/

    }

    public static void tumElCarpımıPrint(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::cirtBul).
                reduce(1, (a, b) -> (a * b))); //lambda exp


        System.out.println(sayi.
                stream().
                filter(Lambda01::cirtBul).
                reduce(Math::multiplyExact));//method referans kull


    }// Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

    public static void minBulPrint(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                reduce(Integer::min));//Optional[-5] Math::min da yazılır

        //3.yol method yaparak ternary ile
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMirac));
    }

    public static int byMirac(int a, int b) {//en kucuk olanı handle ediyoruz

        return a < b ? a : b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykTekKckPrint(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::byMirac));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftElKareKckBykSirala(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::cirtBul).//once cıft sayıları buluyoruz
                map(t -> (t * t)).//karelerini aldım
                sorted().//akıs icindeki sayıları natural order olarak sıralar
                forEach(Lambda01::yazdir);//akisdaki sayilari ekrana yazdim
    }

    public static int tumElToplamPrint(List<Integer> l) {
        int toplam = l.stream().reduce(0, (a, b) -> a + b);
    return toplam;
    }
}