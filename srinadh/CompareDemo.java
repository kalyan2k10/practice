package srinadh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Emp implements Comparable<Emp> {
    int id;
    String name;
    public Emp(int id,String name){
        this.id = id;
        this.name =name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.id + "-->" + this.name;
    }


    @Override
    public int compareTo(Emp o) {
        return o.id-this.id;
    }
}
public class CompareDemo {
    public static void main(String[] args){
        Emp e1 = new Emp(1,"kalyan");
        Emp e2 = new Emp(2,"Srinath");

        ArrayList<Emp> al = new ArrayList<>();
        al.add(e1);
        al.add(e2);

        al.sort((o2,o1) -> o1.name.compareTo(o2.name));
        //Collections.sort(al);
        System.out.println(al);
        System.out.println("kalyan".compareTo("srinath"));
    }
}
