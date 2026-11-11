package gradina;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;


public class Interfata extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interfata.class.getName());

   
        Color c = new Color(34, 139, 34);   // verde
    Desenabil d;                        
    Desenabil selectat;                 

    public Interfata() {
        initComponents();
        setLocationRelativeTo(null);
        lblCuloare.setBackground(c);
    }

    private void deselecteaza() {
        if (selectat != null) {
            selectat.marcheaza(false);
            selectat = null;
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panou = new gradina.PanouDesen();
        panelUnelete = new javax.swing.JPanel();
        toggleCopac = new javax.swing.JToggleButton();
        toggleStrat = new javax.swing.JToggleButton();
        toggleIaz = new javax.swing.JToggleButton();
        toggleAlee = new javax.swing.JToggleButton();
        btnCuloare = new javax.swing.JButton();
        lblCuloare = new javax.swing.JLabel();
        btnSterge = new javax.swing.JButton();
        btnCurata = new javax.swing.JButton();
        btnSalveaza = new javax.swing.JButton();
        btnIncarca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planificator de grădină");

        panou.setPreferredSize(new java.awt.Dimension(700, 500));
        panou.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panouMouseDragged(evt);
            }
        });
        panou.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panouMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panouMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panouLayout = new javax.swing.GroupLayout(panou);
        panou.setLayout(panouLayout);
        panouLayout.setHorizontalGroup(
            panouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panouLayout.setVerticalGroup(
            panouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        getContentPane().add(panou, java.awt.BorderLayout.LINE_START);

        panelUnelete.setBorder(javax.swing.BorderFactory.createTitledBorder("Unelte"));
        panelUnelete.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        buttonGroup1.add(toggleCopac);
        toggleCopac.setText("Copac");
        toggleCopac.addActionListener(this::toggleCopacActionPerformed);
        panelUnelete.add(toggleCopac);

        buttonGroup1.add(toggleStrat);
        toggleStrat.setText("Strat");
        panelUnelete.add(toggleStrat);

        buttonGroup1.add(toggleIaz);
        toggleIaz.setText("Iaz");
        panelUnelete.add(toggleIaz);

        buttonGroup1.add(toggleAlee);
        toggleAlee.setText("Alee");
        panelUnelete.add(toggleAlee);

        btnCuloare.setText("Culoare");
        btnCuloare.addActionListener(this::btnCuloareActionPerformed);
        panelUnelete.add(btnCuloare);

        lblCuloare.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCuloare.setOpaque(true);
        panelUnelete.add(lblCuloare);

        btnSterge.setText("Sterge");
        btnSterge.addActionListener(this::btnStergeActionPerformed);
        panelUnelete.add(btnSterge);

        btnCurata.setText("Curata Tot");
        btnCurata.addActionListener(this::btnCurataActionPerformed);
        panelUnelete.add(btnCurata);

        btnSalveaza.setText("Salveaza");
        btnSalveaza.addActionListener(this::btnSalveazaActionPerformed);
        panelUnelete.add(btnSalveaza);

        btnIncarca.setText("Incarca");
        btnIncarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIncarcaMousePressed(evt);
            }
        });
        btnIncarca.addActionListener(this::btnIncarcaActionPerformed);
        panelUnelete.add(btnIncarca);

        getContentPane().add(panelUnelete, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggleCopacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleCopacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toggleCopacActionPerformed

    private void btnCuloareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuloareActionPerformed
        Color nou = JColorChooser.showDialog(this, "Alege culoarea", c);
        if (nou != null) {                 
            c = nou;
            lblCuloare.setBackground(c);
        }
    }//GEN-LAST:event_btnCuloareActionPerformed

    private void btnStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStergeActionPerformed
        if (selectat != null) {
            panou.getDesenabile().remove(selectat);
            selectat = null;
            panou.repaint();
        }
    }//GEN-LAST:event_btnStergeActionPerformed

    private void btnCurataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurataActionPerformed
        panou.getDesenabile().clear();
        selectat = null;
        panou.repaint();
    }//GEN-LAST:event_btnCurataActionPerformed

    private void btnSalveazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalveazaActionPerformed
        try (PrintStream ps = new PrintStream(new FileOutputStream("gradina.txt"))) {
            for (Desenabil des : panou.getDesenabile())
                des.salveaza(ps);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Eroare la salvare: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalveazaActionPerformed

    private void btnIncarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncarcaActionPerformed
        try (BufferedReader br = new BufferedReader(new FileReader("gradina.txt"))) {
            ArrayList<Desenabil> citite = new ArrayList<>();
            String linie;
            while ((linie = br.readLine()) != null) {
                int cod = Integer.parseInt(linie.trim());
                switch (cod) {
                    case 0: citite.add(new Copac(br)); break;
                    case 1: citite.add(new Strat(br)); break;
                    case 2: citite.add(new Iaz(br)); break;
                    case 3: citite.add(new Alee(br)); break;
                }
            }
            panou.getDesenabile().clear();
            panou.getDesenabile().addAll(citite);
            selectat = null;
            panou.repaint();
        } catch (IOException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Eroare la incarcare: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnIncarcaActionPerformed

    private void btnIncarcaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncarcaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIncarcaMousePressed

    private void panouMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panouMouseReleased
        buttonGroup1.clearSelection();     
        d = null;
    }//GEN-LAST:event_panouMouseReleased

    private void panouMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panouMouseDragged
        int xm = evt.getX();
        int ym = evt.getY();
        if (d != null)
            d.redimensioneaza(xm, ym);     
        else if (selectat != null)
            selectat.muta(xm, ym);         
        panou.repaint();
    }//GEN-LAST:event_panouMouseDragged

    private void panouMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panouMousePressed
        int xm = evt.getX();
        int ym = evt.getY();
        d = null;

        if (toggleCopac.isSelected())
            d = new Copac(xm, ym, 1, c);
        else if (toggleStrat.isSelected())
            d = new Strat(xm, ym, 1, 1, c);
        else if (toggleIaz.isSelected())
            d = new Iaz(xm, ym, 1, 1, c);
        else if (toggleAlee.isSelected())
            d = new Alee(xm, ym, c);

        deselecteaza();
        if (d != null) {
            // desenare: adaug figura
            panou.getDesenabile().add(d);
        } else {
            // selectare: caut figura de sub cursor 
            ArrayList<Desenabil> lista = panou.getDesenabile();
            for (int i = lista.size() - 1; i >= 0; i--) {
                if (lista.get(i).aproape(xm, ym)) {
                    selectat = lista.get(i);
                    selectat.marcheaza(true);
                    break;
                }
            }
        }
        panou.repaint();
    }//GEN-LAST:event_panouMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Interfata().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuloare;
    private javax.swing.JButton btnCurata;
    private javax.swing.JButton btnIncarca;
    private javax.swing.JButton btnSalveaza;
    private javax.swing.JButton btnSterge;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblCuloare;
    private javax.swing.JPanel panelUnelete;
    private gradina.PanouDesen panou;
    private javax.swing.JToggleButton toggleAlee;
    private javax.swing.JToggleButton toggleCopac;
    private javax.swing.JToggleButton toggleIaz;
    private javax.swing.JToggleButton toggleStrat;
    // End of variables declaration//GEN-END:variables
}
