import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*

      1)  Lambda --> method create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak Maps'lerde kullanılmaz.

*/
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStractured(sayi);
        System.out.println("\n**********");
        printElFunctional(sayi);
        System.out.println("\n**********");
        printElFunctional1(sayi);
        System.out.println("\n**********");
        printElFunctional2(sayi);
        System.out.println("\n**********");
        printCiftElFuntional(sayi);
        System.out.println("\n**********");
        printCiftElStructured(sayi);
        System.out.println("\n**********");
        printCiftOtzKckFuntional(sayi);
        System.out.println("\n**********");
        printCiftOtzBykFuntional(sayi);
    }
    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
    // aralarında bosluk olacak sekilde print ediniz.

    public static void printElStractured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }

    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                forEach((t) -> System.out.print((t + " ")));//lambda expression

    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                forEach(System.out::print);//method referance
        //sytem classına git out clasından print methodunu cagır demek "::"
    }

    //kendimiz bir method olusturalımve bunu cagıralım
    public static void yazdir(int a) {
        System.out.print(a + " ");
    }
    public static void yazdir(String a) {
        System.out.print(a + " ");

    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                forEach(Lambda01::yazdir);//Lambda01.yazdir boylede yazılır ama yanına nokta koyup method cagıramayız

    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFuntional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0).//lambda expression var method referance a cevirelim
                forEach(Lambda01::yazdir);//filtreleme yapar bolunenleri alır suzer
    }

    //TASK  : structurell Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }

    }
    //yukarıdaki Taski filter() kısmını method referance ile yapalim:
    public static boolean cirtBul(int a){
        return a%2==0;
    }
    public static void printCiftElFuntional1(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::cirtBul).
                forEach(Lambda01::yazdir);
    }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzKckFuntional(List<Integer> sayi) {
        sayi.
                stream().
                //filter(t->t%2==0).filter(t->t<34). =boyle decagırabiliriz
                        filter(t -> t % 2 == 0 && t < 34).
                forEach(Lambda01::yazdir);
    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzBykFuntional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0 || t > 34).
                forEach(Lambda01::yazdir);
    }
}
