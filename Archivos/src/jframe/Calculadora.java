
package jframe;

import java.awt.Color;

public class Calculadora extends javax.swing.JFrame {

    public Calculadora() {
        initComponents();
       this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pantalla = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dividir = new javax.swing.JButton();
        cuadrado = new javax.swing.JButton();
        pi = new javax.swing.JButton();
        resetear = new javax.swing.JButton();
        n7 = new javax.swing.JButton();
        n8 = new javax.swing.JButton();
        n9 = new javax.swing.JButton();
        multiplicar = new javax.swing.JButton();
        n4 = new javax.swing.JButton();
        n5 = new javax.swing.JButton();
        n6 = new javax.swing.JButton();
        restar = new javax.swing.JButton();
        n1 = new javax.swing.JButton();
        n2 = new javax.swing.JButton();
        n3 = new javax.swing.JButton();
        sumar = new javax.swing.JButton();
        signo = new javax.swing.JButton();
        n0 = new javax.swing.JButton();
        coma = new javax.swing.JButton();
        resultado = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("0");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(370, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pantalla.setBackground(new java.awt.Color(255, 255, 255));
        pantalla.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        pantalla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pantalla.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setSize(500, 500);
        jPanel3.setLayout(new java.awt.GridLayout(5, 5, 5, 5));

        dividir.setBackground(Color.WHITE);
        dividir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dividir.setText("/");
        dividir.setBackground(Color.white);
        dividir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dividir.setFocusable(false);
        dividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dividirActionPerformed(evt);
            }
        });
        jPanel3.add(dividir);

        cuadrado.setBackground(Color.WHITE);
        cuadrado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cuadrado.setText("x²");
        cuadrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuadrado.setFocusable(false);
        cuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadradoActionPerformed(evt);
            }
        });
        jPanel3.add(cuadrado);

        pi.setBackground(Color.WHITE);
        pi.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pi.setText("π");
        pi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pi.setFocusable(false);
        jPanel3.add(pi);

        resetear.setBackground(Color.WHITE);
        resetear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        resetear.setText("C");
        resetear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetear.setFocusable(false);
        jPanel3.add(resetear);

        n7.setBackground(Color.WHITE);
        n7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n7.setText("7");
        n7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n7.setFocusable(false);
        jPanel3.add(n7);

        n8.setBackground(Color.WHITE);
        n8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n8.setText("8");
        n8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n8.setFocusable(false);
        jPanel3.add(n8);

        n9.setBackground(Color.WHITE);
        n9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n9.setText("9");
        n9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n9.setFocusable(false);
        n9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n9ActionPerformed(evt);
            }
        });
        jPanel3.add(n9);

        multiplicar.setBackground(Color.WHITE);
        multiplicar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        multiplicar.setText("×");
        multiplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        multiplicar.setFocusable(false);
        jPanel3.add(multiplicar);

        n4.setBackground(Color.WHITE);
        n4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n4.setText("4");
        n4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n4.setFocusable(false);
        jPanel3.add(n4);

        n5.setBackground(Color.WHITE);
        n5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n5.setText("5");
        n5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n5.setFocusable(false);
        jPanel3.add(n5);

        n6.setBackground(Color.WHITE);
        n6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n6.setText("6");
        n6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n6.setFocusable(false);
        jPanel3.add(n6);

        restar.setBackground(Color.WHITE);
        restar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        restar.setText("-");
        restar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restar.setFocusable(false);
        jPanel3.add(restar);

        n1.setBackground(Color.WHITE);
        n1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n1.setText("1");
        n1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n1.setFocusable(false);
        jPanel3.add(n1);

        n2.setBackground(Color.WHITE);
        n2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n2.setText("2");
        n2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n2.setFocusable(false);
        jPanel3.add(n2);

        n3.setBackground(Color.WHITE);
        n3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n3.setText("3");
        n3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n3.setFocusable(false);
        jPanel3.add(n3);

        sumar.setBackground(Color.WHITE);
        sumar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sumar.setText("+");
        sumar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sumar.setFocusable(false);
        jPanel3.add(sumar);

        signo.setBackground(Color.WHITE);
        signo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        signo.setText("-/+");
        signo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signo.setFocusable(false);
        jPanel3.add(signo);

        n0.setBackground(Color.WHITE);
        n0.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        n0.setText("0");
        n0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        n0.setFocusable(false);
        jPanel3.add(n0);

        coma.setBackground(Color.WHITE);
        coma.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        coma.setText(",");
        coma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        coma.setFocusable(false);
        jPanel3.add(coma);

        resultado.setBackground(new java.awt.Color(0, 51, 255));
        resultado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        resultado.setForeground(new java.awt.Color(255, 255, 255));
        resultado.setText("=");
        resultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resultado.setFocusable(false);
        jPanel3.add(resultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadradoActionPerformed

    private void dividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dividirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dividirActionPerformed

    private void n9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coma;
    private javax.swing.JButton cuadrado;
    private javax.swing.JButton dividir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton multiplicar;
    private javax.swing.JButton n0;
    private javax.swing.JButton n1;
    private javax.swing.JButton n2;
    private javax.swing.JButton n3;
    private javax.swing.JButton n4;
    private javax.swing.JButton n5;
    private javax.swing.JButton n6;
    private javax.swing.JButton n7;
    private javax.swing.JButton n8;
    private javax.swing.JButton n9;
    private javax.swing.JLabel pantalla;
    private javax.swing.JButton pi;
    private javax.swing.JButton resetear;
    private javax.swing.JButton restar;
    private javax.swing.JButton resultado;
    private javax.swing.JButton signo;
    private javax.swing.JButton sumar;
    // End of variables declaration//GEN-END:variables
}
