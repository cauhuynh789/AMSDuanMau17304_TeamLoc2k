/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thienvcPc04086_ASM_HC;


import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection ketNoi;
      String DuongDan = null;
    private String Duongdan;


    public Main() {
        initComponents();
        tenCot();
    }

    public void tenCot() {
        model = new DefaultTableModel();
        model.addColumn("MSNV");
        model.addColumn("Tên nhân viên");
        model.addColumn("Tuổi");
        model.addColumn("Gamil");
        model.addColumn("Lương");
        model.addColumn("Hình");
        tblSinhVien.setModel(model);
    }

    public void KetNoiCSDL() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName = IT17304";
            String user = "sa";
            String pass = "123456";
            ketNoi = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        txtMSNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTuoiNV = new javax.swing.JTextField();
        txtGmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        txtDuongDan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản Lí Nhân Viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 324, 56));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel2.setText("Mã NV : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel4.setText("Gmail:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel5.setText("Tên NV :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel6.setText("Tuổi NV :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 800, 230));

        txtMSNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMSNVActionPerformed(evt);
            }
        });
        getContentPane().add(txtMSNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 313, -1));
        getContentPane().add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 313, -1));
        getContentPane().add(txtTuoiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 313, -1));

        txtGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 313, -1));

        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });
        getContentPane().add(txtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 313, -1));

        btnThoat.setText("Đăng Xuất");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 820, -1, -1));

        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, -1, -1));

        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, -1, -1));

        btnXoa.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, -1, -1));

        btnLoad.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, -1, -1));

        btnThem.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel9.setText("Lương :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        lblHinhAnh.setBackground(new java.awt.Color(102, 102, 255));
        lblHinhAnh.setOpaque(true);
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });
        getContentPane().add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 220, 200));
        getContentPane().add(txtDuongDan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 310, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel3.setText("Hình");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhNenban.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailActionPerformed

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int choice = javax.swing.JOptionPane.showConfirmDialog(this, "Ban co muon thoat không");
        if (choice == javax.swing.JOptionPane.YES_OPTION) {
            if (choice == javax.swing.JOptionPane.YES_OPTION) {
                new DangNhap().setVisible(true);
                this.dispose();
            } else {
                this.dispose();
            }
        } else {

        }
    }//GEN-LAST:event_btnThoatActionPerformed
    public void LoadDuLieu() throws SQLException {
        KetNoiCSDL();
        model.setRowCount(0); //xoá dữ liệu của bảng
        String sql = "SELECT * FROM NhanVien";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            String msnv = ketQua.getString(1);
            String hoTen = ketQua.getString(2);
            int tuoinv = ketQua.getInt(3);
            String gmail = ketQua.getString(4);
            int luong = ketQua.getInt(5);
            String Hinh =ketQua.getString(6);
            model.addRow(new Object[]{msnv, hoTen, tuoinv, gmail, luong,Hinh});
        }
        ketNoi.close();
    }
    public void them() throws SQLException{
        KetNoiCSDL();
        String sql = "INSERT INTO NhanVien VALUES(?,?,?,?,?,?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMSNV.getText());
        cauLenh.setString(2, txtTenNV.getText());
        cauLenh.setInt(3, Integer.parseInt(txtTuoiNV.getText()));
        cauLenh.setString(4,txtGmail.getText());
        cauLenh.setInt(5, Integer.parseInt(txtLuong.getText()));
        cauLenh.setString(6, txtDuongDan.getText());
        cauLenh.executeUpdate();
        ketNoi.close();
        }
    

    public boolean KiemTraTrungMa() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT MaNV FROM NhanVien WHERE MaNV=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMSNV.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtMSNV.getText().equalsIgnoreCase(ketQua.getString(1))) {
                return true;
            }
        }
        ketNoi.close();
        return false;
    }

    public void capNhat() throws SQLException {
        int viTri = tblSinhVien.getSelectedRow();
        if (viTri >= 0) {
            KetNoiCSDL();
            String sql = "UPDATE NhanVien set TenNV=?, TuoiNV=?,GMAIL=? ,Luong=? , Hinh =? WHERE MaNV = ?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setString(1, txtTenNV.getText());
            cauLenh.setInt(2, Integer.parseInt(txtTuoiNV.getText()));
            cauLenh.setString(3, txtGmail.getText());
            cauLenh.setInt(4, Integer.parseInt(txtLuong.getText()));
             cauLenh.setString(5, txtDuongDan.getText());
            cauLenh.setString(6, txtMSNV.getText());        
            cauLenh.executeUpdate();
            ketNoi.close();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Chua chon");
        }

    }

    public void xoa0NhapLieu() {
        txtMSNV.setText("");
        txtTenNV.setText("");
        txtTuoiNV.setText("");
        txtGmail.setText("");
        txtLuong.setText("");
        txtDuongDan.setText("");
    }
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try {
            LoadDuLieu();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btnLoadActionPerformed
    public void xoa() throws SQLException {
        KetNoiCSDL();
        String sql = "DeLETE NhanVien WHERE MaNV=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMSNV.getText());
        int ketQua = javax.swing.JOptionPane.showConfirmDialog(this, "ban co muon xoa khong", "xoa nhan Vien", javax.swing.JOptionPane.YES_NO_OPTION);
        if (ketQua == javax.swing.JOptionPane.YES_NO_OPTION) {
            cauLenh.executeUpdate();
        }
        ketNoi.close();

    }

    public boolean timKiem() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMSNV.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtMSNV.getText().equalsIgnoreCase(ketQua.getString(1))) {
                txtTenNV.setText(ketQua.getString(2));
                txtTuoiNV.setText(ketQua.getInt(3) + "");
                txtGmail.setText(ketQua.getString(4));
                txtLuong.setText(ketQua.getInt(5) + "");
                txtDuongDan.setText(ketQua.getString(6));
                LoadHinh();

            }
            return true;
        }
        ketNoi.close();
        return false;
    }
    
 public void ChonHinh() {
        JFileChooser chooser = new JFileChooser("src\\Hinh_anh");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        if (f != null) {
            DuongDan = f.getAbsolutePath(); //Đường dẫn tuyệt đối
            ImageIcon hinhanh = new ImageIcon(new ImageIcon(DuongDan).
                    getImage().getScaledInstance(lblHinhAnh.getWidth(),
                            lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
            
            lblHinhAnh.setIcon(hinhanh);
            txtDuongDan.setText(DuongDan);
        }
    } 
 public void LoadHinh() {
        try {
            KetNoiCSDL();
            String sql = "SELECT Hinh FROM NhanVien where Hinh = ?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setString(1, txtDuongDan.getText());
            ResultSet ketQua = cauLenh.executeQuery();
            if (ketQua.next()) {
                DuongDan = ketQua.getString(1);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(DuongDan).
                        getImage().getScaledInstance(lblHinhAnh.getWidth(),
                                lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
                
                lblHinhAnh.setIcon(imageIcon);
                txtDuongDan.setText(DuongDan);
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (KiemTraTrungMa() == false) {
                them();
                LoadDuLieu();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Trung ma ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            xoa();
            LoadDuLieu();

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        int vitri = tblSinhVien.getSelectedRow();
        txtMSNV.setText(tblSinhVien.getValueAt(vitri, 0).toString());
        txtTenNV.setText(tblSinhVien.getValueAt(vitri, 1).toString());
        txtTuoiNV.setText(tblSinhVien.getValueAt(vitri, 2).toString());
        txtGmail.setText(tblSinhVien.getValueAt(vitri, 3).toString());
        txtLuong.setText(tblSinhVien.getValueAt(vitri, 4).toString());
        txtDuongDan.setText(tblSinhVien.getValueAt(vitri, 5).toString());
        LoadHinh();
        
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            capNhat();
            LoadDuLieu();
            xoa0NhapLieu();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        try {
            if (timKiem() == true) {
                timKiem();
                javax.swing.JOptionPane.showMessageDialog(this, "tim thấy");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Không thấy");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtMSNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMSNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMSNVActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        ChonHinh();
    }//GEN-LAST:event_lblHinhAnhMouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtDuongDan;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMSNV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTuoiNV;
    // End of variables declaration//GEN-END:variables

    
}
