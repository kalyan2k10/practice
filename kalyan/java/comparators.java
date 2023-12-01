package kalyan.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Emp {
    public int getNo() {
        return no;
    }

    int no;
    String name;
    public Emp(int no, String name){
        this.no = no;
        this.name = name;
    }
    public String toString(){
        return no + ":" + name;
    }
}
public class comparators {
    public static void main(String[] args){
        List<Emp> al = new ArrayList<>();
        al.add(new Emp(4,"hi"));
        al.add(new Emp(2,"how"));
        al.add(new Emp(0,"are"));

        Collections.sort(al, Comparator.comparing(Emp::getNo));
        System.out.println(al);
    }
}
