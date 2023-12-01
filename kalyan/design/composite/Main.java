package kalyan.design.composite;

public class Main {
    public static void main(String[] args){
        Directory dr = new Directory();

        File f1 = new File();
        f1.fileName = "f1";

        File f2 = new File();
        f2.fileName = "f2";
        Directory dr1 = new Directory();
        dr1.directoryName.add(f2);

        dr.directoryName.add(f1);
        dr.directoryName.add(dr1);

        dr.ls();

    }
}
