import LambdaPractice.C01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucDilim", "guvec", "kokorec", "kusleme", "arapAsi", "waffle", "kunefe"));
        silama(menu);
        System.out.println();
        characterTekrarsz(menu);
        System.out.println();
        charSayisiSirala(menu);
        System.out.println();
        harfSayisi7denAzControl(menu);
        System.out.println();
        wIleBaslayanEl(menu);
        System.out.println();
        xIleBitenVarMi(menu);
        System.out.println();
        karakterEnByk1(menu);
    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void silama(List<String> yemek) {
        yemek.
                stream().
                map(String::toUpperCase).
                sorted().//dogal sıralandı
                distinct().//elemanları tekrarsız olmasını saglar
                forEach(t -> System.out.print(t + " "));//Lambda01::yazdir olmaz param int cunku
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void characterTekrarsz(List<String> yemek) {
        yemek.
                stream().
                map(String::length).//akısı kelimelerin uzunlıugu olarak guncelledim
                sorted(Comparator.reverseOrder()).//sot sıraladı
                distinct().//tekrarsız
                forEach(Lambda01::yazdir);//parametre string oldugu icin yazdır methodo calısır
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void charSayisiSirala(List<String> yemek) {
        yemek.
                stream().//akıs saglandı
                sorted(Comparator.comparing(String::length)).//string ifadeleri karakter sayısına kck->byk sıradık
                forEach(Lambda01::yazdir);//parametre string oldugu icin yazdır methodo calısır
    }
// ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin hepsinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzControl(List<String> yemek) {
        System.out.println(yemek.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harfden olusuyor" : "List elemanları 7 harften buyuk");

    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanEl(List<String> yemek) {
        System.out.println(yemek.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "List elemanlari w ile baslayan harfden olusuyor" : "List elemanları w ile baslayan yok");

    }

    public static void xIleBitenVarMi(List<String> yemek) {
        System.out.println(yemek.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten bir eleman var" : "x ile biten yok ");
    }
// Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterEnByk(List<String> yemek) {
        System.out.println(yemek.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).//karakt sayısına gore tersden sıralandı
                        limit(1));//ilk eleman en byk elemandır     referans adres gelir burdan
        //2.yol:
    }
    public static void karakterEnByk1(List<String> yemek) {
        Stream<String> sonHal =yemek.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).reversed()).
                limit(1);//limit methodunundonen degeri string yapıdadır
        System.out.println(Arrays.toString(sonHal.toArray()));
        //sonhalçtoArray()----> Stream olan akıs Array e cevirdi
        //Arrays.toString(sonHal.toArray()) :ARRAY STRİNG YAPIYA CEVRİLDİ
    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void listElSonHarfSiralaIlkElHaric(List<String> yemek){
        yemek.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).forEach(t-> System.out.println(t.substring(0,1)));
    }
    public static void listElSonHarfSiralaIlkElHaric1(List<String> yemek){
        yemek.stream(). // akış sağlandı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). // son harfine göre alfabetik sıralandı
                skip(1). // akışdaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdir); // ekrana print edildi
    }
}



