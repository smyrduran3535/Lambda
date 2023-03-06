package LambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");
        //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    }

    public static List<String> ilkHarfBuyukGerisiKucuk(List<String> list) {
        return list.stream().map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase()).collect(Collectors.toList());
        //List<String> i list tipinde string değer döndürsün diye mi oluşturduk
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ilkHarfEveyaC(List<String> list) {
        return list.stream().filter(t -> t.startsWith("e") || t.startsWith("c")).collect(Collectors.toList());
        /*
            return list.stream().filter(t -> t.substring(0,1) == "e" || t.substring(0,1) == "c").collect(Collectors.toList());
3.yol
public static List<String> ilkHarfeVeC(List<String> l){
    return l.stream().filter(t->t.startsWith("e")||t.startsWith("c")).collect(Collectors.toList());
}
         */
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basVeSonaYildizEkle(List<String> list) {
        list.stream().map(t -> "*" + t + "*").forEach(Utils::yazString);

    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlanlardanList(List<String> list) {
        return list.stream().filter(t -> t.toLowerCase().contains("e")).collect(Collectors.toList());

    }
    //S5: tum 'l' leri silelim yazdiralim
    public static void lLeriSil(List<String> list) {
       list.stream().map(t->t.replaceAll("l","")).forEach(Utils::yazString);
    }
    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print
    public static void IkinciHarfeGoresiralaCharSayisiByk(List<String> list){
        list.stream().sorted(Comparator.comparing(t->t.charAt(1))).limit(5).sorted(Comparator.comparing(String::length)).findFirst();
    }
    public static void ikiHrfSiraIlk5elChEnByk(List<String>liste){
        System.out.println(liste.
                stream().
                sorted(Comparator.comparing(t -> t.charAt(1))).//list elemanlarını 2.harfe gore sırala
                        limit(5).//ilk 5 eleman akısa devam etti
                        sorted(Comparator.comparing(t->t.toString().length()).//akıstan gelen 5 elemanı uzunluklarına gore ters sıraladım
                        reversed()).
                findFirst());//akıstan gelen ılk elemanı aldım Optional[String]
    }

}