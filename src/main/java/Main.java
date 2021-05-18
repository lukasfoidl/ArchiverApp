import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String file = "Test.txt";
        File f=new File(file);
        if (f.exists()) {
            System.out.println("File exists");
            f.renameTo(new File(f.getName() + getDateString() + getFileExtension(f)));
            f=new File(file);
        } else {
            System.out.println("File does not exist");
        }


    }

    private static String getDateString() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String strDate= formatter.format(date);
        return strDate;
    }

    //https://stackoverflow.com/questions/3571223/how-do-i-get-the-file-extension-of-a-file-in-java
    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}
