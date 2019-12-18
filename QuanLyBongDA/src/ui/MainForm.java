/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JDialog;

/**
 *
 * @author Dat Ngo
 */
public class MainForm extends javax.swing.JFrame {
    public static final long DELAY = 100;
    public static final AdminMenuForm adminForm = new AdminMenuForm();
    public static final QuanLyCauThuForm qlct = new QuanLyCauThuForm();
    public static final QuanLyHLVForm qlhlv = new QuanLyHLVForm();
    public static final QuanLyCauLacBoForm qlclb = new QuanLyCauLacBoForm();
    public static final QuanLySanVanDongForm qlsvd = new QuanLySanVanDongForm();
    public static final QuanLyLichThiDauForm qlltd = new QuanLyLichThiDauForm();   
    public static final TimKiemCLBForm tkclb = new TimKiemCLBForm();
    public static final TimKiemCauThuForm tkct = new TimKiemCauThuForm();
    public static final TimKiemHLVForm tkhlv = new TimKiemHLVForm();
    public static final TimKiemSVDForm tksvd = new TimKiemSVDForm();
    public static final TimKiemLichThiDauForm tkltd = new TimKiemLichThiDauForm();
    public static final ChiTietTranDau cttd = new ChiTietTranDau();
    public static final ThongKeKetQua tkkq = new ThongKeKetQua();
    public static final ThongKeSanVanDong tksvd1 = new ThongKeSanVanDong();
    public static final ThongKeSoCauThuCauLacBo tksctclb = new ThongKeSoCauThuCauLacBo();
    public static final BangXepHangForm bxh = new BangXepHangForm();
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 610));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(155, 155));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, 150, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(790, 140));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 10, 810, 140));

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel5.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 160, 810, 390));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 160, 150, 390));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.jpg"))); // NOI18N
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        jMenu1.setText("File");

        jMenuItem1.setText("Đăng xuất");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("About");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("View");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        new DangNhapForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
       
    }//GEN-LAST:event_formComponentShown



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel15;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    protected static javax.swing.JTabbedPane jTabbedPane1;
    protected static javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}