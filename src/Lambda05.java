import java.util.Scanner;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
System.out.println(topla(5));
System.out.println(toplacincix(5));
        System.out.println(toplaCift(5));
        ilkXPozitifCiftSayiToplayan(20);
        ilkXPozTekTamSayiTop(15);
        Scanner scanner=new Scanner(System.in);
        int istenenSayi=scanner.nextInt();
        int x=scanner.nextInt();
istenenSayiIlkXkuvvetPrint(3,2);
istenilenSayininFaktoriyel(5);
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
    // tamsayilari toplayan bir program create ediniz.
    //structured
    public static int topla(int a) {
        int toplam = 0;
        for (int i = 0; i <= a; i++) {
            toplam += i;
        }
        return toplam;
    }
    //functional
    public static int toplacincix(int x) {//List<Integer> x
        return IntStream.
                range(1, x + 1).//1,2,3 dersek stream akısı saglanır.ama 3 gelmiycek.enson kapsam dısı :
                // range(a,b)-->a dan b ye kadar (b DAHİL DEGİL)int degerler akısa alınıdı.
                        sum();//akıstan gelenler toplandı
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int a) {
        return IntStream.
                range(1, a + 1).filter(t -> t % 2 == 0).sum();//2.yol
    }
    public static int toplaCift1(int a) {
     return   IntStream.
                rangeClosed(1,a).
                filter(Lambda01::cirtBul).
                sum();

    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXPozitifCiftSayiToplayan(int a){
       return IntStream.
               range(1,a*2).
               filter(Lambda01::cirtBul).
               limit(a).
               sum();
       /*IntStream.
       iterate(1,t->t+2).//sonsuza kadar gider bu...ama lim ile bir yerde durdurmak lazım...elemanları ;2,4,6,8,10,......
        limit(a).// a ile sınırlıyoruz
        sum();*/
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXPozTekTamSayiTop(int a){
      return   IntStream.
                iterate(1,t->t+2).// 1,3,5,7,9,11,13....
                limit(a).//ilk a tek tam sayi ile sınırlandırıldı
                sum();


    }
    //TASK 05 --> 2'nin ilk ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
/*public static int ikiIlkKuvvetYazdr(int a){
   return IntStream.
            iterate(2,t->t*2).
            limit(a).forEach(Lambda01::yazdir);
}

 */
    public static void ikiIlkKuvvetYazdr1(int a){
        IntStream.
                iterate(2,t->t*2).
                limit(a).
                forEach(Lambda01::yazdir);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
public static void istenenSayiIlkXkuvvetPrint(int istenenSayi,int x){
        IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).forEach(Lambda01::yazdir);

}
//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenilenSayininFaktoriyel(int istenilenSayi){
       return IntStream.rangeClosed(1,istenilenSayi).reduce(1,(t,u)->t*u);
    }
    }
