package thienvcPc04086_ASM_HC;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QuanLi extends javax.swing.JFrame implements Runnable {

    DefaultTableModel model;
    Connection ketNoi;

    public QuanLi() {
        initComponents();
        tenCot();
        txtThanhtien.setEditable(false);

    }

    public void tenCot() {
        model = new DefaultTableModel();
        model.addColumn("ID Đồ Uống");
        model.addColumn("Số Lượng");
        model.addColumn("Món ");
        model.addColumn("Thành Tiền");
        model.addColumn("Số bàn");
        tblHienThi.setModel(model);
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

    public void LoadDuLieu() throws SQLException {
        KetNoiCSDL();
        model.setRowCount(0); //xoá dữ liệu của bảng
        String sql = "SELECT * FROM QuanLi";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            String MaKH = ketQua.getString(1);
            String TenKH = ketQua.getString(2);
            String ComBo = ketQua.getString(3);
            int ThanhTien = ketQua.getInt(4);
            int SoDt = ketQua.getInt(5);
            model.addRow(new Object[]{MaKH, TenKH, ComBo, ThanhTien, SoDt});
        }
        ketNoi.close();
    }

    public void them() throws SQLException {
        KetNoiCSDL();
        String sql = "INSERT INTO QuanLi VALUES(?,?,?,?,?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMakh.getText());
        cauLenh.setString(2, txtTenkh.getText());
        cauLenh.setString(3, cboCombo.getSelectedItem().toString());
        cauLenh.setInt(4, Integer.parseInt(txtThanhtien.getText()));
        cauLenh.setInt(5, Integer.parseInt(txtSoDienThoai.getText()));
        cauLenh.executeUpdate();
        ketNoi.close();
    }

    public boolean KiemTraTrungMa() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT MaKH FROM QuanLi WHERE MaKH=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMakh.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtMakh.getText().equalsIgnoreCase(ketQua.getString(1))) {
                return true;
            }
        }
        ketNoi.close();
        return false;
    }

    public void xoa() throws SQLException {
        KetNoiCSDL();
        String sql = "DeLETE QuanLi WHERE MaKH=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMakh.getText());
        int ketQua = javax.swing.JOptionPane.showConfirmDialog(this, "ban co muon xoa khong", "xoa khách hàng", javax.swing.JOptionPane.YES_NO_OPTION);
        if (ketQua == javax.swing.JOptionPane.YES_NO_OPTION) {
            cauLenh.executeUpdate();
        }
        ketNoi.close();

    }

    public void capNhat() throws SQLException {
        int viTri = tblHienThi.getSelectedRow();
        if (viTri >= 0) {
            KetNoiCSDL();
            String sql = "UPDATE QuanLi set TenKH=?, ComBo=?,ThanhTien=? ,SoDt=? WHERE MaKH  = ?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setString(1, txtTenkh.getText());
            cauLenh.setString(2, (cboCombo.getSelectedItem().toString()));
            cauLenh.setInt(3, Integer.parseInt(txtThanhtien.getText()));
            cauLenh.setInt(4, Integer.parseInt(txtSoDienThoai.getText()));
            cauLenh.setString(5, txtMakh.getText());
            cauLenh.executeUpdate();
            ketNoi.close();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Chua chon");
        }

    }

    public void xoa0NhapLieu() {
        txtMakh.setText("");
        txtTenkh.setText("");
        cboCombo.setSelectedItem(0);
        txtThanhtien.setText("");
        txtSoDienThoai.setText("");
    }

    public boolean timKiem() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT * FROM QuanLi WHERE MaKH=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMakh.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtMakh.getText().equalsIgnoreCase(ketQua.getString(1))) {
                txtTenkh.setText(ketQua.getString(2));
                cboCombo.setSelectedItem(ketQua.getString(3));
                txtThanhtien.setText(ketQua.getInt(4) + "");
                txtSoDienThoai.setText(ketQua.getInt(5) + "");

            }
            return true;
        }
        ketNoi.close();
        return false;
    }

    public void tinhThanhTien() {
        if (txtTenkh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ chóng số lượng");
        } else if (txtGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ chóng đơn giá");
        } else {
            int soLuong = Integer.parseInt(txtTenkh.getText());
            float donGia = Float.parseFloat(txtGia.getText());
            int thanhTien = (int) (soLuong * donGia);
            txtThanhtien.setText(String.valueOf(thanhTien));
            txtThanhtien.setHorizontalAlignment(JTextField.RIGHT);
            txtThanhtien.setBackground(Color.yellow);
            txtThanhtien.setForeground(Color.red);
            txtThanhtien.setFont(new Font("TaHoMa", Font.BOLD, 15));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenkh = new javax.swing.JTextField();
        txtMakh = new javax.swing.JTextField();
        txtThanhtien = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHienThi = new javax.swing.JTable();
        cboCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnThoa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        btnCong = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản Lý Quán coffee");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 324, 56));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Số Lượng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 141, 38));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mã Thức Uống");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 36));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên Thức Uống");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 237, 119, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Giá");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 92, 33));

        txtTenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenkhActionPerformed(evt);
            }
        });
        txtTenkh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenkhKeyReleased(evt);
            }
        });
        getContentPane().add(txtTenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 140, -1));

        txtMakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMakhActionPerformed(evt);
            }
        });
        getContentPane().add(txtMakh, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 410, -1));
        getContentPane().add(txtThanhtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 410, -1));

        btnThem.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        btnSua.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        btnXoa.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/Delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, -1, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/5d6eea69216fc703baa30fe760deb138.png"))); // NOI18N
        jButton5.setText("Tìm Kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        tblHienThi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHienThi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 720, 199));

        cboCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coffee", "Cam Ép", " " }));
        cboCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComboActionPerformed(evt);
            }
        });
        getContentPane().add(cboCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 410, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Bàn");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 70, 30));

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });
        getContentPane().add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 410, 30));

        btnLuu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/refresh.png"))); // NOI18N
        btnLuu.setText("Load");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 120, 40));

        btnThoa.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnThoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/Exit.png"))); // NOI18N
        btnThoa.setText("Thoát");
        btnThoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 150, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton2.setText("Quản lí Nhân Viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Xem Thông Tin Nhân Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, -1));

        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });
        getContentPane().add(btnTru, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });
        getContentPane().add(btnCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Thành tiền");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 92, 33));
        getContentPane().add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 170, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh_anh/anhNenban.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHienThiMouseClicked
        int vitri = tblHienThi.getSelectedRow();
        txtMakh.setText(tblHienThi.getValueAt(vitri, 0).toString());
        txtTenkh.setText(tblHienThi.getValueAt(vitri, 1).toString());
        cboCombo.setToolTipText(tblHienThi.getValueAt(vitri, 2).toString());
        txtThanhtien.setText(tblHienThi.getValueAt(vitri, 3).toString());
        txtSoDienThoai.setText(tblHienThi.getValueAt(vitri, 4).toString());
    }//GEN-LAST:event_tblHienThiMouseClicked

    private void txtMakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMakhActionPerformed

    }//GEN-LAST:event_txtMakhActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            xoa();
            LoadDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            capNhat();
            LoadDuLieu();
            xoa0NhapLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed

    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            LoadDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void txtTenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenkhActionPerformed

    }//GEN-LAST:event_txtTenkhActionPerformed

    private void btnThoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoaActionPerformed
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

    }//GEN-LAST:event_btnThoaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Main().setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ThongTinNhanVien().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTenkhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenkhKeyReleased
        if (!txtGia.getText().equals("") && !txtGia.getText().equals("")) {

            tinhThanhTien();
        }
    }//GEN-LAST:event_txtTenkhKeyReleased

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed

        if (txtTenkh.getText().equals("") && txtGia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng");

        } else {
            int soLuong = Integer.parseInt(txtTenkh.getText());
            soLuong = soLuong + 1;
            txtTenkh.setText(soLuong + "");
            tinhThanhTien();
            btnTru.setEnabled(true);
        }

    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        int soLuong = Integer.parseInt(txtTenkh.getText());
        soLuong = soLuong - 1;

        tinhThanhTien();
        if (soLuong > 0) {
            txtTenkh.setText(soLuong + "");
            tinhThanhTien();
            btnTru.setEnabled(true);
        }
        if (soLuong <= 0) {
            txtTenkh.setText(soLuong + "");
            tinhThanhTien();
            btnTru.setEnabled(false);
        }
    }//GEN-LAST:event_btnTruActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QuanLi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoa;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHienThi;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtThanhtien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
