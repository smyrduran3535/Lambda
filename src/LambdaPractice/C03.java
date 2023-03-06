package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C03 {
    public static void main(String[] args) {
        Apartman daire1=new Apartman("dogu",3,4000);
        Apartman daire2=new Apartman("bati",2,2500);
        Apartman daire3=new Apartman("guney",1,3500);
        Apartman daire4=new Apartman("dogu",5,3000);

        List<Apartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));
        //dogu cephesindeki kiralık daireleri kiralarına göre sıralayın
    }public static void kiralikDaireFiyaGoreSira(List<Apartman> kiralikDaireler){
        kiralikDaireler.
                stream().
                filter(t->t.getCephe().equalsIgnoreCase("dogu")).
                sorted(Comparator.comparing(Apartman::getKira)).
                forEach(t-> System.out.println());

    }
    public static void doguKirayaSirala(List<Apartman>list){
        list.stream().
                filter(t->t.getCephe().equalsIgnoreCase("dogu")).//cephesi dogu olan daireleri filtreledim
                sorted(Comparator.comparing(Apartman::getKira)).forEach(System.out::println);

    }
//kat sayısı 2den cok olan dairelerin kiralarını listeleyın
    public static List<Integer> kat2denCokKiraList(List<Apartman>list){
      return   list.stream().filter(t->t.getKatSayisi()>2).map(t->t.getKira()).collect(Collectors.toList());

    }
}
