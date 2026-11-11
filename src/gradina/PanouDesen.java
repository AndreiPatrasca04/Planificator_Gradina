package gradina;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanouDesen extends JPanel {
    private final ArrayList<Desenabil> desenabile = new ArrayList<>();

    public PanouDesen() {
        setBackground(new Color(196, 232, 170));   
    }

    public ArrayList<Desenabil> getDesenabile() {
        return desenabile;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Desenabil d : desenabile)
            d.deseneaza(g2);
    }
}