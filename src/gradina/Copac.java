package gradina;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Copac extends Figura {
    private int r;  

    public Copac(int x, int y, int r, Color c) {
        super(x, y, c);
        this.r = r;
    }

    public Copac(BufferedReader br) throws IOException {
        super(br);
        r = Integer.parseInt(br.readLine().trim());
    }

    @Override
    public void salveaza(PrintStream ps) {
        salveazaComun(ps, 0);        // cod 0 = copac
        ps.println(r);
    }

    @Override
    public void redimensioneaza(int xm, int ym) {
        r = (int) Math.sqrt((x - xm) * (x - xm) + (y - ym) * (y - ym));
    }

    @Override
    protected void deseneazaForma(Graphics2D g) {
        Color maro = new Color(110, 70, 30);

        // dimensiunile tulpinii
        int latimeTulpina = Math.max(4, r / 3);
        int inaltimeTulpina = r;                  // cat de jos coboara sub coroana
        int xTulpina = x - latimeTulpina / 2;
        int yTulpina = y + r / 2;                 // porneste din interiorul coroanei

        // 1. tulpina 
        g.setColor(maro);
        g.fillRect(xTulpina, yTulpina, latimeTulpina, inaltimeTulpina);
        g.setColor(maro.darker());
        g.setStroke(new BasicStroke(2));
        g.drawRect(xTulpina, yTulpina, latimeTulpina, inaltimeTulpina);

        // 2. coroana:
        int rm = r * 2 / 3;                      
        g.setColor(c);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
        g.fillOval(x - r - rm / 3, y - rm / 2, 2 * rm, 2 * rm);
        g.fillOval(x + r / 3 - rm / 2 + rm / 3, y - rm / 2, 2 * rm, 2 * rm);

        // 3. contur pentru coroana principala
        g.setColor(c.darker());
        g.drawOval(x - r, y - r, 2 * r, 2 * r);
    }
}