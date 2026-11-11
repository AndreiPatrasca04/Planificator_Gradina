package gradina;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class Alee extends Figura {
    private static final int LATIME = 8;        
    private static final int DIST_MIN = 6;       // intre doua puncte

    // culorile flori
    private static final Color[] FLORI = {
        new Color(255, 215, 0),     // galben
        new Color(220, 30, 40),     // rosu
        new Color(150, 60, 190),    // mov
        new Color(255, 130, 190),   // roz
        new Color(255, 255, 255),   // alb
        new Color(255, 140, 0)      // porto
    };

    private ArrayList<Point> puncte = new ArrayList<>();

    public Alee(int x, int y, Color c) {
        super(x, y, c);
        puncte.add(new Point(x, y));
    }

    public Alee(BufferedReader br) throws IOException {
        super(br);
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int px = Integer.parseInt(br.readLine().trim());
            int py = Integer.parseInt(br.readLine().trim());
            puncte.add(new Point(px, py));
        }
    }

    @Override
    public void salveaza(PrintStream ps) {
        salveazaComun(ps, 3);        // cod 3 = alee
        ps.println(puncte.size());
        for (Point p : puncte) {
            ps.println(p.x);
            ps.println(p.y);
        }
    }

    @Override
    public void redimensioneaza(int xm, int ym) {
        Point ultimul = puncte.get(puncte.size() - 1);
        if (ultimul.distance(xm, ym) >= DIST_MIN)
            puncte.add(new Point(xm, ym));
    }

    @Override
    protected void deplaseaza(int dx, int dy) {
        for (Point p : puncte)
            p.translate(dx, dy);
    }

    @Override
    public boolean aproape(int xm, int ym) {
        for (Point p : puncte)
            if (Math.abs(xm - p.x) < DELTA && Math.abs(ym - p.y) < DELTA)
                return true;
        return false;
    }

    @Override
    protected void deseneazaForma(Graphics2D g) {
        if (puncte.size() == 1) {
            Point p = puncte.get(0);
            g.setColor(c);
            g.fillOval(p.x - LATIME / 2, p.y - LATIME / 2, LATIME, LATIME);
            return;
        }

        Path2D.Float cale = new Path2D.Float();
        Point p0 = puncte.get(0);
        cale.moveTo(p0.x, p0.y);
        if (puncte.size() == 2) {
            Point p1 = puncte.get(1);
            cale.lineTo(p1.x, p1.y);
        } else {
            for (int i = 1; i < puncte.size() - 1; i++) {
                Point p = puncte.get(i);
                Point q = puncte.get(i + 1);
                cale.quadTo(p.x, p.y, (p.x + q.x) / 2f, (p.y + q.y) / 2f);
            }
            Point ultim = puncte.get(puncte.size() - 1);
            cale.lineTo(ultim.x, ultim.y);
        }
        g.setColor(c.darker());
        g.setStroke(new BasicStroke(LATIME + 4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(cale);
        g.setColor(c);
        g.setStroke(new BasicStroke(LATIME, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(cale);

        g.setStroke(new BasicStroke(1));
        for (int i = 0; i < puncte.size(); i++) {
            Random rnd = new Random(i * 977L + 13);
            if (rnd.nextInt(100) >= 60)
                continue;                                    

            Point p = puncte.get(i);
            double unghi = rnd.nextDouble() * 2 * Math.PI;
            double dist = rnd.nextDouble() * (LATIME / 2.0 - 3);
            int fx = (int) (p.x + dist * Math.cos(unghi));
            int fy = (int) (p.y + dist * Math.sin(unghi));
            int raza = 2 + rnd.nextInt(2);                  
            Color culoare = FLORI[rnd.nextInt(FLORI.length)];

            g.setColor(culoare);
            g.fillOval(fx - raza, fy - raza, 2 * raza, 2 * raza);
            g.setColor(culoare.darker());
            g.drawOval(fx - raza, fy - raza, 2 * raza, 2 * raza);
        }
    }
}