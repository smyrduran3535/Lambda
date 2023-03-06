import LambdaPractice.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Odev03 {
    public static void main(String[] args) {

        ucTen10eKadarPrint(10);
        System.out.println(ucIle10ArasiSum(10));
        System.out.println(dokuzFaktryl(9));
        System.out.println("============");
        System.out.println(alti100EkadarSum(10));
        System.out.println(besCiftSayiMulply(5));
dorttenByk6TekTamSayiMultiply(6);
    }

    //1-)Konsolda 3'ten 10'a kadar tam sayılar nasıl yazdırılır
    public static void ucTen10eKadarPrint(int l) {
        IntStream.range(3, l + 1).forEach(Utils::yazInteger);
    }

    //2-)3 ile 10 Arası Tam Sayıların Toplamı Nasıl Bulunur?
    public static int ucIle10ArasiSum(int l) {
        return IntStream.range(3, l + 1).sum();
    }

    //3-)9 faktöriyel nasıl bulunur
    public static int dokuzFaktryl(int l) {
        return IntStream.range(1, 10).reduce(1, (a, b) -> a * b);
    }

    //4-)6'dan 100'e kadar olan tek tam sayıların toplamı nasıl bulunur?
    public static int alti100EkadarSum(int l) {
        return IntStream.range(6, 100 + 1).sum();
    }

    //5-)İlk 5 çift sayının çarpımı nasıl bulunur
    public static int besCiftSayiMulply(int l) {
        return IntStream.range(1, 5 * 2).filter(Lambda01::cirtBul).limit(5).sum();
    }

    //6-)4'ten büyük 6 tek tam sayının çarpımı nasıl bulunur?
public static void dorttenByk6TekTamSayiMultiply(int l){

}
}