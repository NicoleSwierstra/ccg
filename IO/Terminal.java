package IO;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Terminal {
    public final static int COLOR_BLACK = 0;
    public final static int COLOR_RED = 1;
    public final static int COLOR_GREEN = 2;
    public final static int COLOR_YELLOW = 3;
    public final static int COLOR_BLUE = 4;
    public final static int COLOR_MAGENTA = 5;
    public final static int COLOR_CYAN = 6;
    public final static int COLOR_WHITE = 7;

    static Scanner sc = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);

    public static void setIO(InputStream o, PrintStream p){
        sc = new Scanner(o);
        out = p;
    }

    //clears and homes the cursor
    public static void clear(){
        out.println("\u001b[2J\u001b[H");
    }

    public static void print(String output){
        out.print(output);
    }

    public static void println(String output){
        print(output + "\n");
        out.flush();
    }

    public static void printWithWidth(String output, int width){
        Scanner oscanner = new Scanner(output);
        String token;
        int currentwidth = 0;
        while(oscanner.hasNext()){
            token = oscanner.next();
            if(currentwidth + token.length() >= width){
                int spaceleft = width - currentwidth;
                while(spaceleft-- > 0)
                    out.printf("%c",' ');
                out.print("\n");
                currentwidth = 0;
            }
            out.print(token + " ");
            currentwidth += token.length() + 1;
        }
        oscanner.close();
    }

    public static String getString(){
        return sc.nextLine();
    }

    public static void setCol(int color, boolean fill){
        int num = 30 + color + (fill ? 10 : 0);
        out.print("\u001b[" + num + "m");
    }

    public static void setStyleType(boolean bold, boolean italic, boolean underline, boolean reversed){
        System.out.print(
            (bold      ? "\u001b[1m" : "\u001b[22m") +
            (italic    ? "\u001b[3m" : "\u001b[23m") +
            (underline ? "\u001b[4m" : "\u001b[24m") +
            (reversed  ? "\u001b[7m" : "\u001b[27m")
        );
    }
}
