package Odev02.LambdaPractice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    public static void main(String[] args) {

        List<String> ulkeler = new ArrayList<>(Arrays.asList("Canada", "ABD", "Turkey", "Germany", "Uganda"));

        lessFifeLengthPrintFunct(ulkeler);
        System.out.println("\n********");
        lessFifeLengthPrintStrc(ulkeler);
    }

    public static void lessFifeLengthPrintFunct(List<String> ulkeler){
        ulkeler.stream().
                filter(t -> t.startsWith("A") && t.length()<5).
                map(t->t.toUpperCase()).forEach(t-> System.out.print(t + " "));
    }
    public static void lessFifeLengthPrintStrc(List<String> ulkeler){
        for (String w: ulkeler){
            if (w.length()<5&&w.startsWith("A")){
                System.out.println(w.toUpperCase());
            }
        }
    }

}
/*
List<String> list = new ArrayList<>();
        list.add("Angie");
        list.add("Andy");
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");

        System.out.println(list.stream()
                .filter(t->t.startsWith("A"))
                .filter(t->t.length()<5)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

    }
 */