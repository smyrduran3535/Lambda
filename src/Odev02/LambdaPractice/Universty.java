package Odev02.LambdaPractice;

public class Universty {//pojo class : field lar olur icinde..erisimi private yap
    private String university,bolum;
    private int ogrenciSayisi;
    private double notOrtalamasi;
//pm siz Cons
    public Universty() {
    }
//param Const.


    public Universty(String university, String bolum, int ogrenciSayisi, int notOrtalamasi) {
        this.university = university;
        this.bolum = bolum;
        this.ogrenciSayisi = ogrenciSayisi;
        this.notOrtalamasi = notOrtalamasi;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrenciSayisi() {
        return ogrenciSayisi;
    }

    public void setOgrenciSayisi(int ogrenciSayisi) {
        this.ogrenciSayisi = ogrenciSayisi;
    }

    public double getNotOrtalamasi() {
        return notOrtalamasi;
    }

    public void setNotOrtalamasi(double notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
    }

    @Override
    public String toString() {
        return "Universty{" +
                "university='" + university + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrenciSayisi=" + ogrenciSayisi +
                ", notOrtalamasi=" + notOrtalamasi +
                '}';
    }

}
