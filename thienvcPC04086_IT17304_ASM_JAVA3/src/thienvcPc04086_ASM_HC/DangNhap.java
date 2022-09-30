/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thienvcPc04086_ASM_HC;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DangNhap extends javax.swing.JFrame {

    Connection ketNoi;

    public DangNhap() {
        initComponents();
        txtUsername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtPassword.setBackground(new java.awt.Color(0, 0, 0, 1));
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

    public void DangNhap() throws SQLException {
        int KetQua = 0;
        KetNoiCSDL();
        String sql = "Select * from TaiKhoan where TenDangNhap like (?) and MatKhau like (?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtUsername.getText());
        cauLenh.setString(2, txtPassword.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        if (ketQua.next() == true) {
            // JOptionPane.showMessageDialog(this, "Đăng Nhập Thành công");

            if (ketQua.getString(3).equals("nhanvien")) {
                new QuanLi().setVisible(true);
                dispose();
            }

            if (ketQua.getString(3).equals("quanly")) {
                new Main().setVisible(true);
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Đăng Nhập Không Thành công");
        }
        ketNoi.close();
    }
//     new Menu().setVisible(true);
//                 dispose();
//    new QLQuanCF().setVisible(true);
//                 dispose();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblLoi = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblQuenMatKhau = new javax.swing.JLabel();
        lblChuaCoTaiKhoan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassword1 = new javax.swing.JPasswordField();
        btnLogin1 = new javax.swing.JButton();
        lblQuenMatKhau1 = new javax.swing.JLabel();
        lblChuaCoTaiKhoan1 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        lblLoi1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 320, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhcoffeXoaNen.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 370, 391));

        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 290, -1));

        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 290, -1));

        lblLoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 290, 21));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, 33));

        lblQuenMatKhau.setText("Quên mật khẩu");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseExited(evt);
            }
        });
        getContentPane().add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        lblChuaCoTaiKhoan.setText("Đăng ký");
        lblChuaCoTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChuaCoTaiKhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChuaCoTaiKhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChuaCoTaiKhoanMouseExited(evt);
            }
        });
        getContentPane().add(lblChuaCoTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 60, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhNen.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 490));

        jLabel6.setText("Username:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jLabel7.setText("Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 320, -1));

        txtPassword1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassword1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassword1MouseClicked(evt);
            }
        });
        getContentPane().add(txtPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 290, -1));

        btnLogin1.setText("Login");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, 33));

        lblQuenMatKhau1.setText("Quên mật khẩu");
        lblQuenMatKhau1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhau1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMatKhau1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMatKhau1MouseExited(evt);
            }
        });
        getContentPane().add(lblQuenMatKhau1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        lblChuaCoTaiKhoan1.setText("Đăng ký");
        lblChuaCoTaiKhoan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChuaCoTaiKhoan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChuaCoTaiKhoan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChuaCoTaiKhoan1MouseExited(evt);
            }
        });
        getContentPane().add(lblChuaCoTaiKhoan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 60, -1));

        txtUsername1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUsername1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsername1MouseClicked(evt);
            }
        });
        getContentPane().add(txtUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 290, -1));

        lblLoi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLoi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 290, 21));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUsername.getText().equals("")) {

            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để Username ");

        } else if (txtPassword.getText().equals("")) {
            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để chống Password");

        } else {
            try {
                DangNhap();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblQuenMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseEntered
        lblQuenMatKhau.setText("<html> <u> Quên Mật Khẩu </u> </html> ");
        lblQuenMatKhau.setForeground(Color.red);
    }//GEN-LAST:event_lblQuenMatKhauMouseEntered

    private void lblQuenMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseExited
        lblQuenMatKhau.setText("<html> <u> Quên Mật Khẩu </u> </html> ");
        lblQuenMatKhau.setForeground(Color.black);
    }//GEN-LAST:event_lblQuenMatKhauMouseExited

    private void lblChuaCoTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTaiKhoanMouseEntered
        lblChuaCoTaiKhoan.setText("<html> <u> Đăng Ký </u> </html> ");
        lblChuaCoTaiKhoan.setForeground(Color.red);
    }//GEN-LAST:event_lblChuaCoTaiKhoanMouseEntered

    private void lblChuaCoTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTaiKhoanMouseExited
        lblChuaCoTaiKhoan.setText("<html> <u> Đăng Ký </u> </html> ");
        lblChuaCoTaiKhoan.setForeground(Color.black);
    }//GEN-LAST:event_lblChuaCoTaiKhoanMouseExited

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        new QuenMatKhau().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void lblChuaCoTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTaiKhoanMouseClicked
        new DangKy().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblChuaCoTaiKhoanMouseClicked

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked
        lblLoi.setText("");
    }//GEN-LAST:event_txtUsernameMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        lblLoi.setText("");
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtPassword1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassword1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassword1MouseClicked

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void lblQuenMatKhau1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhau1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuenMatKhau1MouseClicked

    private void lblQuenMatKhau1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhau1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuenMatKhau1MouseEntered

    private void lblQuenMatKhau1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhau1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuenMatKhau1MouseExited

    private void lblChuaCoTaiKhoan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTaiKhoan1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblChuaCoTaiKhoan1MouseClicked

    private void lblChuaCoTaiKhoan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTaiKhoan1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblChuaCoTaiKhoan1MouseEntered

    private void lblChuaCoTaiKhoan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTaiKhoan1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblChuaCoTaiKhoan1MouseExited

    private void txtUsername1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsername1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsername1MouseClicked

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblChuaCoTaiKhoan;
    private javax.swing.JLabel lblChuaCoTaiKhoan1;
    private javax.swing.JLabel lblLoi;
    private javax.swing.JLabel lblLoi1;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblQuenMatKhau1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables
}
