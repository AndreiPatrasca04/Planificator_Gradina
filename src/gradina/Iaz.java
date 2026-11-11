package gradina;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class Iaz extends Figura {
    private int l, h;

    public Iaz(int x, int y, int l, int h, Color c) {
        super(x, y, c);
        this.l = l;
        this.h = h;
    }

    public Iaz(BufferedReader br) throws IOException {
        super(br);
        l = Integer.parseInt(br.readLine().trim());
        h = Integer.parseInt(br.readLine().trim());
    }

    @Override
    public void salveaza(PrintStream ps) {
        salveazaComun(ps, 2);        // cod 2 = iaz
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
        // 1. apa 
        g.setColor(transparent());
        g.fillOval(x - l / 2, y - h / 2, l, h);

        // 2. pietricelele
        double a = l / 2.0;      // orizontala
        double b = h / 2.0;      // verticala

        double perimetru = Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
        int n = Math.max(6, (int) (perimetru / 8));   

        Random rnd = new Random(42);

        g.setStroke(new BasicStroke(1));
        for (int i = 0; i < n; i++) {
            double t = 2 * Math.PI * i / n + (rnd.nextDouble() - 0.5) * 0.15;
            int px = (int) (x + a * Math.cos(t));
            int py = (int) (y + b * Math.sin(t));

            int raza = 3 + rnd.nextInt(4);       
            int gri = 90 + rnd.nextInt(120);      
            Color griPietricica = new Color(gri, gri, gri);

            g.setColor(griPietricica);
            g.fillOval(px - raza, py - raza, 2 * raza, 2 * raza);
            g.setColor(griPietricica.darker());   
            g.drawOval(px - raza, py - raza, 2 * raza, 2 * raza);
        }
    }
}