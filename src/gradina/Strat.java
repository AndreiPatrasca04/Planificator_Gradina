package gradina;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class Strat extends Figura {
    private int l, h;

    public Strat(int x, int y, int l, int h, Color c) {
        super(x, y, c);
        this.l = l;
        this.h = h;
    }

    public Strat(BufferedReader br) throws IOException {
        super(br);
        l = Integer.parseInt(br.readLine().trim());
        h = Integer.parseInt(br.readLine().trim());
    }

    @Override
    public void salveaza(PrintStream ps) {
        salveazaComun(ps, 1);        // cod 1 = strat
        ps.println(l);
        ps.println(h);
    }

    @Override
    public void redimensioneaza(int xm, int ym) {
        l = 2 * Math.abs(xm - x);
        h = 2 * Math.abs(ym - y);
    }

    @Override
    protected void deseneazaForma(Graphics2D g) {
        int st = x - l / 2;      
        int sus = y - h / 2;     
        Color inchis = c.darker();

        // 1. umplerea si conturul stratului
        g.setColor(transparent());
        g.fillRect(st, sus, l, h);
        g.setColor(c);
        g.setStroke(new BasicStroke(2));
        g.drawRect(st, sus, l, h);

        // 2. linii pe lung
        int randuri = 4;
        g.setColor(inchis);
        g.setStroke(new BasicStroke(2));
        for (int i = 1; i <= randuri; i++) {
            int yr = sus + h * i / (randuri + 1);
            g.drawLine(st + 4, yr, st + l - 4, yr);
        }

        // 3. puncte
        Random rnd = new Random(7);
        int nrPuncte = (l * h) / 350;            
        g.setColor(inchis);
        for (int i = 0; i < nrPuncte; i++) {
            int px = st + 4 + rnd.nextInt(Math.max(1, l - 8));
            int py = sus + 4 + rnd.nextInt(Math.max(1, h - 8));
            int raza = 1 + rnd.nextInt(2);       // raza 1 sau 2
            g.fillOval(px - raza, py - raza, 2 * raza, 2 * raza);
        }
    }
}