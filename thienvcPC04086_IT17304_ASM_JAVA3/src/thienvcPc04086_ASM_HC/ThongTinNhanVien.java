
package thienvcPc04086_ASM_HC;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


public class ThongTinNhanVien extends javax.swing.JFrame {
DefaultTableModel model;
    Connection ketNoi;
    String DuongDan = null;
    private String Duongdan;
    
    public ThongTinNhanVien() {
        initComponents();
        txtTenNV.setEditable(false);
        txtTuoiNV.setEditable(false);
        txtGMAIL.setEditable(false);
        txtLuong.setEditable(false);
        
    }
    public void KetNoiCSDL () throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName = IT17304";
            String user = "sa";
            String pass = "phuc123";
            ketNoi = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public boolean timKiem() throws SQLException{
        KetNoiCSDL();
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1,txtMaNV.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while(ketQua.next()==true)
        {
            if(txtMaNV.getText().equalsIgnoreCase(ketQua.getString(1))){
                txtTenNV.setText(ketQua.getString(2));
                txtTuoiNV.setText(ketQua.getInt(3)+"");
                txtGMAIL.setText(ketQua.getString(4));
               txtLuong.setText(ketQua.getInt(5)+"");
               txtDuongDan.setText(ketQua.getString(6));
               LoadHinh();
               
               
            }
                return true;
        }
        ketNoi.close();
        return false;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLaythongTin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtTuoiNV = new javax.swing.JTextField();
        txtGMAIL = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblHinhAnh = new javax.swing.JLabel();
        txtDuongDan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Nhập Bàn");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 178, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Quản Lý Bàn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 14, 218, -1));

        btnLaythongTin.setFont(new java.awt.Font("Segoe UI Light", 1, 15)); // NOI18N
        btnLaythongTin.setText("lấy thông tin");
        btnLaythongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaythongTinActionPerformed(evt);
            }
        });
        getContentPane().add(btnLaythongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel4.setText("Tên nhân viên");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 155, -1, -1));
        getContentPane().add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 155, 188, -1));
        getContentPane().add(txtTuoiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 223, 188, -1));
        getContentPane().add(txtGMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 289, 188, -1));
        getContentPane().add(txtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 357, 188, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel8.setText("Tuổi nhân viên");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 227, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel9.setText("gmail nhân viên");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 293, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel10.setText("Lương nhân viên");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 361, -1, -1));

        jToggleButton1.setText("Đăng xuất");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 526, -1, -1));

        lblHinhAnh.setOpaque(true);
        getContentPane().add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 180, 180));
        getContentPane().add(txtDuongDan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 180, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhNen.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 890, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaythongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaythongTinActionPerformed
    try {
            if(timKiem()==true){
                timKiem();
                javax.swing.JOptionPane.showMessageDialog(this, " Đây là thông tin của bạn");
            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "Không có thông tin");
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLaythongTinActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
     int choice = javax.swing.JOptionPane.showConfirmDialog(this, "Ban co muon thoat không");
        if(choice == javax.swing.JOptionPane.YES_NO_OPTION) {   
            if(choice == javax.swing.JOptionPane.YES_OPTION){
                new DangNhap().setVisible(true);
                this.dispose();
            }else {
                this.dispose();
            }
        }else {
            
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaythongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTextField txtDuongDan;
    private javax.swing.JTextField txtGMAIL;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTuoiNV;
    // End of variables declaration//GEN-END:variables
}
