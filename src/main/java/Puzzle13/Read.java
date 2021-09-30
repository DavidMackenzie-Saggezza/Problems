package Puzzle13;

import java.io.*;

public class Read {
    // I think file stays open as long as the class is being used.
    // Alternative would be to use RandomAccessFile in the read method and keep track of location of pointer.
    // Problem with this would be that the file could change between reads.
    FileReader fileReader;

    public Read(String fileName){
        try {
            this.fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public String read(int n) throws IOException {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int nextChar = fileReader.read();
            if (nextChar == -1) {
                return string.toString();
            }
            string.append(Character.toString((char) nextChar));
        }
        return string.toString();
    }
}
