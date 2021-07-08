package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
/*
        Beach aa = new Beach("aa", 1, 2);
        Beach bb = new Beach("bb", 10, 21);
        System.out.println(aa.compareTo(bb));
*/
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int i=0;
        if (this.distance > o.distance)
            i--;
        else if (this.distance < o.distance)
            i++;

        if (this.quality > o.quality)
            i++;
        else if (this.quality < o.quality)
            i--;

        return i;
    }
}
