package gradina;

import java.awt.Graphics2D;
import java.io.PrintStream;

public interface Desenabil {
    final int DELTA = 10;                    

    void deseneaza(Graphics2D g);
    void redimensioneaza(int xm, int ym);
    void muta(int xm, int ym);
    boolean aproape(int xm, int ym);
    void marcheaza(boolean m);
    void salveaza(PrintStream ps);
}