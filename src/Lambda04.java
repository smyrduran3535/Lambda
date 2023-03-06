import Odev02.LambdaPractice.Universty;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {
        /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */


        Universty u01 = new Universty("bogazici", "mayematik", 571, 93);
        Universty u02 = new Universty("itu", "mayematik", 600, 81);
        Universty u03 = new Universty("istanbul", "hukuk", 1400, 71);
        Universty u04 = new Universty("marmara", "bilgisayar muh", 1000, 77);
        Universty u05 = new Universty("odtu", "gemi muh", 333, 74);
        List<Universty> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println(notOrt74bykCtrlPrint(unv));
        System.out.println(matBolumVarMi(unv));
        System.out.println(ogrSayşSirala(unv));

    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74bykCtrlPrint(List<Universty> unv ){
       return unv.
               stream().
               allMatch(t -> t.getNotOrtalamasi() > 74);//hepsi saglarsa sartı :true en az biri saglamazsa : false
    }
//task 02-->universite'lerde herhangi birinde(demek anymatch demektir) "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universty> unv){
       return unv.
               stream().//5 tane univt. geldi akısa
               anyMatch(t->t.getBolum().//objelerin bolum isimleri alındı herhengi biri denildigi icin
                       toLowerCase().//nasıl yazıldıgı bilemeyebiliriz o yuzden garantiye almak icin
                       contains("mat"));
    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universty> ogrSayşSirala(List<Universty> unv){
    return     unv.//Lisr<Integer> olsaydı;1,2,3, gelirdi...Universy old icin;u01,u02,u03... den objeler gelir
            stream().
            sorted(Comparator.comparing(Universty::getOgrenciSayisi).reversed()).//unv ogrenci sayısına gore sıralandı
            collect(Collectors.toList());//stream yapısı list yapısına donusturuldu
        //Comparator.comparing:bunun icine ne gonderirsen ona gore sıralar..kck->byk ama tersi;reversed ile...
        //collect(Collectors.toList()): stream yapısını istediigimiz gibi sıralarız

    }
public static int matBolumSayisi(List<Universty> unv){
    return (int) unv.//count :long dondugu icin;return(int) yaptık...casting...
             stream().
             filter(t->t.getBolum().
                     contains("mat")).
             count();//secilen unv. sayısını aldım

}
//task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
public static OptionalInt ogrcSayisi550BykMaxNotOrt(List<Universty> unv) {
    return unv.
            stream().
            filter(t -> t.getOgrenciSayisi() > 550).
            mapToInt(t -> (int) t.getNotOrtalamasi()).max();
}


public static OptionalInt ogrcSayisi1050AzMinNotOrt(List<Universty> unv){
       return   unv.
               stream().
               filter(t-> t.getOgrenciSayisi()<1050).
               mapToInt(t->(int)t.getNotOrtalamasi()).
               min();
}

}

