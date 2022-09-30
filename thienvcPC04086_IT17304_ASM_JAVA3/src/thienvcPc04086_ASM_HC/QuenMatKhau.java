/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thienvcPc04086_ASM_HC;

import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**

 * @author ADMIN
 */
public class QuenMatKhau extends javax.swing.JFrame {

    Connection ketNoi;
    
    public QuenMatKhau() {
        initComponents();
        txtUsernameMK.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtPassworMK.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtConfirmMK.setBackground(new java.awt.Color(0, 0, 0, 1));
        lblLoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void KetNoiCSDL() throws SQLException {
        //code cố đinh cái nào cũng lấy cái này

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName = IT17304";
            String user = "sa";
            String pass = "123456";
            ketNoi = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi kết nối CSDL");
        }
    }
    public void QuenMk() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT *FROM TaiKhoan";
        int i = 0;
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next()) {
            if (txtUsernameMK.getText().trim().equals(ketQua.getString(1))){
                i=1;
                break;
            }
        }
        
        if(i==1){
            sql="Update TaiKhoan set MatKhau = ? where TenDangNhap = ?";
            cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setString(1, txtPassworMK.getText());
            cauLenh.setString(2, txtUsernameMK.getText());
            int a = cauLenh.executeUpdate();
            JOptionPane.showMessageDialog(this, "Tao thanh cong");
            new DangNhap().setVisible(true);
            dispose();
        }else{
             JOptionPane.showMessageDialog(this, "Ko thanh cong");
             txtUsernameMK.requestFocus();
             txtPassworMK.setText("");
             txtConfirmMK.setText("");
        }
        ketNoi.close();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTaoMatKhauMoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsernameMK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassworMK = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmMK = new javax.swing.JPasswordField();
        btnQuayVe = new javax.swing.JButton();
        lblLoi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTaoMatKhauMoi.setText("Tạo Mật Khẩu Mới");
        btnTaoMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMatKhauMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnTaoMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUÊN MẬT KHẨU");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 340, -1));

        jLabel2.setText("Username:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        txtUsernameMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUsernameMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMKMouseClicked(evt);
            }
        });
        getContentPane().add(txtUsernameMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 290, -1));

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        txtPassworMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassworMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassworMKMouseClicked(evt);
            }
        });
        getContentPane().add(txtPassworMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 290, -1));

        jLabel4.setText("Confirm:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        txtConfirmMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtConfirmMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfirmMKMouseClicked(evt);
            }
        });
        getContentPane().add(txtConfirmMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 290, -1));

        btnQuayVe.setText("<<");
        btnQuayVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayVeActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuayVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));
        getContentPane().add(lblLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 290, 18));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhcoffeXoaNen.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhNenban.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMatKhauMoiActionPerformed

        if (txtUsernameMK.getText().equals("")) {

            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để Username ");

        } else if (txtPassworMK.getText().equals("")) {
            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để chống Password");

        } else if (txtConfirmMK.getText().equals("")) {
            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để chống ConfirmDK");

        } else if (!txtPassworMK.getText().equals(txtConfirmMK.getText())) {

            lblLoi.setForeground(Color.red);
            lblLoi.setText("Vui lòng nhập Password với Confirm giống nhau");

        } else {
            int ketQua = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn nhớ Mật khẩu này chứ", "Không", JOptionPane.YES_NO_OPTION);
            if (ketQua == JOptionPane.YES_NO_OPTION) {
                try {
                    QuenMk();
                  
                } catch (SQLException ex) {
                    Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

        }


    }//GEN-LAST:event_btnTaoMatKhauMoiActionPerformed

    private void btnQuayVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayVeActionPerformed
        new DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayVeActionPerformed

    private void txtUsernameMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMKMouseClicked
        lblLoi.setText("");
    }//GEN-LAST:event_txtUsernameMKMouseClicked

    private void txtPassworMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassworMKMouseClicked
       lblLoi.setText("");
    }//GEN-LAST:event_txtPassworMKMouseClicked

    private void txtConfirmMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfirmMKMouseClicked
       lblLoi.setText("");
    }//GEN-LAST:event_txtConfirmMKMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayVe;
    private javax.swing.JButton btnTaoMatKhauMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblLoi;
    private javax.swing.JPasswordField txtConfirmMK;
    private javax.swing.JPasswordField txtPassworMK;
    private javax.swing.JTextField txtUsernameMK;
    // End of variables declaration//GEN-END:variables
}
