package IO;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Terminal {
    final static int COLOR_BLACK = 0;
    final static int COLOR_RED = 1;
    final static int COLOR_GREEN = 2;
    final static int COLOR_YELLOW = 3;
    final static int COLOR_BLUE = 4;
    final static int COLOR_MAGENTA = 5;
    final static int COLOR_CYAN = 6;
    final static int COLOR_WHITE = 7;

    static Scanner sc = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);

    static void setIO(InputStream o, PrintStream p){
        sc = new Scanner(o);
        out = p;
    }

    //clears and homes the cursor
    static void clear(){
        out.println("\u001b[2J\u001b[H");
    }

    static void print(String output){
        out.print(output);
    }

    static void println(String output){
        print(output + "\n");
        out.flush();
    }

    static String getString(){
        return sc.nextLine();
    }

    static void setCol(int color, boolean fill){
        int num = 30 + color + (fill ? 10 : 0);
        out.print("\u001b[" + num + "m");
    }
}
