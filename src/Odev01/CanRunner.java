package Odev01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*Create 4 objects by using Can class(
           private String season;
           private String courseName;
           private int averageScore;
           private int numberOfStudents;        ) */
public class CanRunner {
    public static final String yesil="\u001B[32m";
    public static final String kirmizi="\u001B[31m";
    public static final String siyah="\u001B[30m";

    public static void main(String[] args) {
        Can person1 = new Can("Winter", "Java Day", 98, 324);
        Can person2 = new Can("Spring", "Python Day", 85, 154);
        Can person3 = new Can("Summer", "Sql", 97, 100);
        Can person4 = new Can("Autumn", "Delphi Day", 99, 467);

        List<Can> myList= Odev01(person1, person2, person3, person4);
        System.out.println("\n" + kirmizi + "Check if all average scores are less than 98" + yesil);
        head();
        checkAverageScoreLessThan98(myList);

        System.out.println("\n" + kirmizi + "Check if all course names contain \"Day\" word" + yesil);
        head();
        checkCourseNameContainDayWord(myList);

        System.out.println("\n" + kirmizi + "Check if any number of students is 154" + yesil);
        head();
        checkAnyNumberOfStudentsIs154(myList);

        System.out.println("\n" + kirmizi + "Check if any season is Winter" + yesil);
        head();
        checkAnySeasonIsWinter(myList);

        System.out.println("\n" + kirmizi + "Check if no number of students is 100" + yesil);
        head();
        checkNoNumberOfStudentsIs100(myList);

        System.out.println("\n" + kirmizi + "Sort the elements in natural order according to the average score" + yesil);
        head();
        sortNaturalOrderAccordingToTheAverageScore(myList);

        System.out.println("\n" + kirmizi + "Sort the elements in reverse order according to the number of students" + yesil);
        head();
        sortReverseOrderAccordingToTheNumberOfStudents(myList);

        System.out.println("\n" + kirmizi + "Sort the elements in reverse order according to the course name" + yesil);
        head();
        sortReverseOrderAccordingToTheCourseName(myList);
    }

    private static void head(){
        System.out.printf("%s %15s %15s %20s%n","Season", "Course Name", "Average Score", "NumberOfStudents" + siyah);
    }

    private static void yazdir(Can myList) {
        System.out.printf("%s %15s %10s %18s%n", myList.getSeason(),myList.getCourseName(),myList.getAverageScore(),myList.getNumberOfStudents());
        // %n alt satira geciriyor
        //System.out.println(myList.getSeason() + " " + myList.getCourseName() + " " + myList.getAverageScore() + " " + myList.getNumberOfStudents());
    }

    //Add them into a list
    public static List<Can> Odev01(Can person1, Can person2, Can person3, Can person4) {
        List<Can> myList = new ArrayList<>();
        myList.add(person1);
        myList.add(person2);
        myList.add(person3);
        myList.add(person4);
        for (Can w : myList) {
            System.out.println(w);
        }
        return myList;
    }

    //Check if all average scores are less than 98
    public static void checkAverageScoreLessThan98(List<Can> myList) {
        myList.stream().filter(t -> t.getAverageScore() < 98).forEach(CanRunner::yazdir);
    }

    //Check if all course names contain "Day" word
    public static void checkCourseNameContainDayWord(List<Can> myList) {
        myList.stream().filter(t -> t.getCourseName().contains("Day")).forEach(CanRunner::yazdir);
    }

    //Check if any number of students is 154
    public static void checkAnyNumberOfStudentsIs154(List<Can> myList) {
        myList.stream().filter(t -> t.getNumberOfStudents() == 154).forEach(CanRunner::yazdir);
    }

    //Check if any season is Winter
    public static void checkAnySeasonIsWinter(List<Can> myList){
        myList.stream().filter(t -> t.getSeason().equals("Winter")).forEach(CanRunner::yazdir);
    }

    //Check if no number of students is 100
    public static void checkNoNumberOfStudentsIs100(List<Can> myList){
        myList.stream().filter(t -> t.getNumberOfStudents()==100).forEach(CanRunner::yazdir);
    }

    //Sort the elements in natural order according to the average score
    public static void sortNaturalOrderAccordingToTheAverageScore(List<Can> myList){
        List<Can> sortedList = myList.stream().sorted(Comparator.comparingInt(Can::getAverageScore)).collect(Collectors.toList());
        sortedList.forEach(CanRunner::yazdir);
    }

    //Sort the elements in reverse order according to the number of students
    public static void sortReverseOrderAccordingToTheNumberOfStudents(List<Can> myList){
        List<Can> sortedList = myList.stream().sorted(Comparator.comparingInt(Can::getNumberOfStudents).reversed()).collect(Collectors.toList());
        sortedList.forEach(CanRunner::yazdir);
    }

    //Sort the elements in reverse order according to the course name
    public static void sortReverseOrderAccordingToTheCourseName(List<Can> myList){
        List<Can> sortedList = myList.stream().sorted(Comparator.comparing(Can::getCourseName).reversed()).collect(Collectors.toList());
        sortedList.forEach(CanRunner::yazdir);
    }


}

