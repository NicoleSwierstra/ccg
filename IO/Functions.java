package IO;

import java.io.IOException;

public class Functions {
    public static int[] toCol = {7, 7, 7, 1, 1, 1, 1, 3, 3, 3, 6, 3, 3, 3, 1, 1, 1, 1, 7, 7, 7};

    static float barfloat = 0.0f;
    public static float skillBar(){
        barfloat = 0.0f;
        Thread t = new Thread(()->{
            for(int j = 0; j <= 20; j++){
                barfloat = 0.05f * j;
                Terminal.print("\r[");
                for(int i = 0; i <= 20; i++){
                    if (j == i) Terminal.setStyleType(true, false, false, false);
                    else Terminal.setStyleType(false, false, false, false);
                    Terminal.setCol(toCol[i], false);
                    Terminal.print("#");
                }
                Terminal.setStyleType(false, false, false, false);
                Terminal.print("]");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
            barfloat = 0;
            Terminal.print("\nattack failure! press enter to continue");
        });
        t.start();
        Terminal.getString();
        t.interrupt();
        return barfloat;
    }
}
