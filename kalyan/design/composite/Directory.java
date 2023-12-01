package kalyan.design.composite;

import java.util.*;

public class Directory implements FileSystem{
    List<FileSystem> directoryName = new ArrayList<>();

    @Override
    public void ls() {
        for(FileSystem fs : directoryName) {
            fs.ls();
        }
    }
}
