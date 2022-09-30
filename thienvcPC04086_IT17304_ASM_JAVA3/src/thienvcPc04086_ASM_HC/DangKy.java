/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thienvcPc04086_ASM_HC;

import java.awt.Color;
import java.awt.Cursor;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DangKy extends javax.swing.JFrame {

    Connection ketNoi;

    public DangKy() {
        initComponents();
        txtUsernameDK.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtPassworDK.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtConfirmDK.setBackground(new java.awt.Color(0, 0, 0, 1));
        lblLoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rdoNhanVien.setSelected(true);
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

    public void DangKyTaiKhoan() throws SQLException {
        KetNoiCSDL();
        String sql = "INSERT INTO TaiKhoan VALUES (?,?,?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtUsernameDK.getText());
        cauLenh.setString(2, txtPassworDK.getText());
        cauLenh.setString(3, txtUsernameDK.getText());

        if (rdoNhanVien.isSelected() == true) {
            cauLenh.setString(3, "nhanvien");
        }

        if (rdoAdmin.isSelected() == true) {
            cauLenh.setString(3, "admin");
        }

        int ketQua = cauLenh.executeUpdate();
        if (ketQua > 0) {
            JOptionPane.showMessageDialog(this, "Đăng Ký Thành Công");
            new DangNhap().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "ĐĂng Ký Tài Khoản Thất Bại");
        }
        ketNoi.close();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsernameDK = new javax.swing.JTextField();
        txtPassworDK = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmDK = new javax.swing.JPasswordField();
        btnTaoTaiKhoang = new javax.swing.JButton();
        lblLoi = new javax.swing.JLabel();
        btnQuayVe = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoAdmin = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ĐĂNG KÝ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 210, -1));

        jLabel2.setText("Username:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        txtUsernameDK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUsernameDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameDKMouseClicked(evt);
            }
        });
        getContentPane().add(txtUsernameDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 280, -1));

        txtPassworDK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassworDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassworDKMouseClicked(evt);
            }
        });
        getContentPane().add(txtPassworDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 280, -1));

        jLabel4.setText("Confirm:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        txtConfirmDK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtConfirmDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfirmDKMouseClicked(evt);
            }
        });
        txtConfirmDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmDKActionPerformed(evt);
            }
        });
        getContentPane().add(txtConfirmDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 280, -1));

        btnTaoTaiKhoang.setText("Tạo tài Khoảng");
        btnTaoTaiKhoang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTaiKhoangActionPerformed(evt);
            }
        });
        getContentPane().add(btnTaoTaiKhoang, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, -1, -1));

        lblLoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 280, 18));

        btnQuayVe.setText("<<");
        btnQuayVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayVeActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuayVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhcoffeXoaNen.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, 370));

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");
        getContentPane().add(rdoNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        buttonGroup1.add(rdoAdmin);
        rdoAdmin.setText("Admin");
        getContentPane().add(rdoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhNen.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoTaiKhoangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoTaiKhoangActionPerformed

        if (txtUsernameDK.getText().equals("")) {

            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để Username ");

        } else if (txtPassworDK.getText().equals("")) {
            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để chống Password");

        } else if (txtConfirmDK.getText().equals("")) {
            lblLoi.setForeground(Color.red);
            lblLoi.setText("Không Được để chống Confirm");

        } else if (!txtPassworDK.getText().equals(txtConfirmDK.getText())) {

            lblLoi.setForeground(Color.red);
            lblLoi.setText("Vui lòng nhập Password với Confirm giống nhau");

        } else {
            int ketQua = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn đắng ký chứ", "Không", JOptionPane.YES_NO_OPTION);
            if (ketQua == JOptionPane.YES_NO_OPTION) {
                try {
                    DangKyTaiKhoan();
                } catch (SQLException ex) {
                    Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Đăng ký thành công");
            }

        }


    }//GEN-LAST:event_btnTaoTaiKhoangActionPerformed

    private void btnQuayVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayVeActionPerformed
        new DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayVeActionPerformed

    private void txtConfirmDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmDKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmDKActionPerformed

    private void txtUsernameDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameDKMouseClicked
        lblLoi.setText("");
    }//GEN-LAST:event_txtUsernameDKMouseClicked

    private void txtPassworDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassworDKMouseClicked
        lblLoi.setText("");
    }//GEN-LAST:event_txtPassworDKMouseClicked

    private void txtConfirmDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfirmDKMouseClicked
        lblLoi.setText("");
    }//GEN-LAST:event_txtConfirmDKMouseClicked

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
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayVe;
    private javax.swing.JButton btnTaoTaiKhoang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblLoi;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JPasswordField txtConfirmDK;
    private javax.swing.JPasswordField txtPassworDK;
    private javax.swing.JTextField txtUsernameDK;
    // End of variables declaration//GEN-END:variables
}
