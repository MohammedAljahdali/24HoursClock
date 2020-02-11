package com.mohammed;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Mohammed\\Development\\DATA2");
        Scanner scanner = new Scanner(file);
        ArrayList<String> times = new  ArrayList<>();
        while (scanner.hasNext()) {
            times.add(scanner.next());
        }
        ArrayList<String> timesConverted = new  ArrayList<>();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Mohammed\\Development\\OUT2");
        PrintStream printStream = new PrintStream(fileOutputStream);
        for (int i = 0; i < times.size(); i++) {
            String xm = "";
            String time = times.get(i);
            String[] hoursMins = time.split(":");
            int hours = Integer.parseInt(hoursMins[0]);
            if (hours > 12) {
                xm = "PM";
                hours = hours - 12;
            } else if (hours == 12) {
                xm = "PM";
            } else {
                xm = "AM";
            }
            int mins = Integer.parseInt(hoursMins[1]);
            if (hours < 10)
                printStream.println("0"+hours+":"+mins+" "+xm);
            else if (mins < 10)
                printStream.println(hours+":"+"0"+mins+" "+xm);
            else if (mins < 10 && hours < 10)
                printStream.println("0"+hours+":"+"0"+mins+" "+xm);
            else
                printStream.println(hours+":"+mins+" "+xm);
        }

    }
}
