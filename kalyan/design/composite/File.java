package kalyan.design.composite;

public class File implements FileSystem{
    String fileName;
    @Override
    public void ls() {
        System.out.println("filename is " + fileName);
    }
}
