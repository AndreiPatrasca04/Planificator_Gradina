package gradina;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public abstract class Figura implements Desenabil {
    protected int x, y;          
    protected Color c;
    protected boolean marcat = false;

    public Figura(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public Figura(BufferedReader br) throws IOException {
        x = Integer.parseInt(br.readLine().trim());
        y = Integer.parseInt(br.readLine().trim());
        c = new Color(Integer.parseInt(br.readLine().trim()));
    }

    protected void salveazaComun(PrintStream ps, int cod) {
        ps.println(cod);
        ps.println(x);
        ps.println(y);
        ps.println(c.getRGB());
    }

    protected Color transparent() {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), 110);
    }

    protected abstract void deseneazaForma(Graphics2D g);

    protected void deplaseaza(int dx, int dy) { }

    @Override
    public final void deseneaza(Graphics2D g) {
        deseneazaForma(g);
        if (marcat)
            deseneazaMarcaj(g);
    }

    protected void deseneazaMarcaj(Graphics2D g) {
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(2));
        g.drawLine(x - DELTA, y, x + DELTA, y);
        g.drawLine(x, y - DELTA, x, y + DELTA);
    }

    @Override
    public void marcheaza(boolean m) {
        marcat = m;
    }

    @Override
    public void muta(int xm, int ym) {
        int dx = xm - x;
        int dy = ym - y;
        x = xm;
        y = ym;
        deplaseaza(dx, dy);
    }

    @Override
    public boolean aproape(int xm, int ym) {
        return Math.abs(xm - x) < DELTA && Math.abs(ym - y) < DELTA;
    }
}