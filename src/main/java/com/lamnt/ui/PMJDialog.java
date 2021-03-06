/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.ui;

import com.lamnt.dao.CHITIETPMDAO;
import com.lamnt.entity.CHITIETPM;
import com.lamnt.util.Auth;
import com.lamnt.util.MsgBox;
import com.lamnt.util.XImage;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class PMJDialog extends javax.swing.JDialog {
    CHITIETPMDAO dao = new CHITIETPMDAO();
    int row = -1;
    /**
     * Creates new form PMJDialog
     */
    public PMJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    
    void init(){
        getContentPane().setBackground(Color.white);// sử dụng màu để làm nền background
        setIconImage(XImage.getAppIcon());// sử dụng lớp tiện ích XImage để đọc và chọn file ảnh
        setLocationRelativeTo(null);// dùng câu lệnh để đưa form ra giữa màn hình
        fillTable();// đổ dữ liệu vào bảng
        this.updateStatus();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMaPM = new javax.swing.JLabel();
        txtMaPM = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        lblSL = new javax.swing.JLabel();
        lblTT = new javax.swing.JLabel();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextArea();
        txtMaSach = new javax.swing.JTextField();
        lblMaSach = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPM = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ CHI TIẾT PHIẾU MƯỢN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("QUẢN LÝ CTPHIẾU MƯỢN");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập Nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblMaPM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaPM.setText("Mã PM:");

        txtMaPM.setNextFocusableComponent(txtMaSach);
        txtMaPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPMActionPerformed(evt);
            }
        });

        txtSL.setNextFocusableComponent(txtGhiChu);

        cboTrangThai.setMaximumRowCount(3);
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã trả", "Đang trả", "Chưa trả" }));
        cboTrangThai.setNextFocusableComponent(txtSL);
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        lblSL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSL.setText("Số lượng:");

        lblTT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTT.setText("Trạng thái:");

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);

        txtMaSach.setNextFocusableComponent(cboTrangThai);

        lblMaSach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaSach.setText("Mã sách:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMaSach)
                    .addComponent(lblMaPM)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTT)
                        .addComponent(lblSL, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblGhiChu, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMaPM, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txtSL)
                    .addComponent(txtMaSach))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaPM)
                    .addComponent(txtMaPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSach)
                    .addComponent(lblMaSach))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTT))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSL))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblGhiChu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tblPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PM", "Mã Sách", "Trạng Thái", "Số Lượng", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPMMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPM);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnthem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/Add.png"))); // NOI18N
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/Upload.png"))); // NOI18N
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/Delete.png"))); // NOI18N
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/Refresh.png"))); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa)
                    .addComponent(btnMoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/first.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/prev.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lamnt/icons/last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void txtMaPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPMActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
           if (isValidated(true)) {// kiểm tra nhập liệu 
            Insert();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
            if (isValidated(false)) {// kiểm tra nhập liệu 
                Update();
            }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        this.Delete();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        this.First();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        this.Prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        this.Next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        this.Last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblPMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPMMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblPM.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblPMMousePressed

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
            java.util.logging.Logger.getLogger(PMJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PMJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PMJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PMJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PMJDialog dialog = new PMJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblMaPM;
    private javax.swing.JLabel lblMaSach;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblTT;
    private javax.swing.JTable tblPM;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaPM;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSL;
    // End of variables declaration//GEN-END:variables
    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        try {
            List<CHITIETPM> list = dao.selectAll();// sử dụng câu lệnh đổ dữ liệu vào bảng
            for (CHITIETPM pm : list) {
                Object[] row = {
                    pm.getMaPM(),
                    pm.getMaSach(),
                    pm.getTrangThai(),
                    pm.getSoLuong(),
                    pm.getGhiChu()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }
    void edit(){//khi chọn từng phiếu mượn
         int mapm = (Integer) tblPM.getValueAt(this.row, 0);
        CHITIETPM pm = dao.selectById(mapm);
        this.setForm(pm);
        this.updateStatus();
    }
    void setForm(CHITIETPM pm) {//lấy 1 pm có sẵn trên form
        txtMaPM.setText(String.valueOf(pm.getMaPM()));
        txtMaSach.setText(String.valueOf(pm.getMaSach()));
        cboTrangThai.setSelectedItem(pm.getTrangThai());
        txtSL.setText(String.valueOf(pm.getSoLuong()));
        txtGhiChu.setText(pm.getGhiChu());
    }
    CHITIETPM getForm() {
        CHITIETPM pm = new CHITIETPM();
        pm.setMaPM(Integer.valueOf(txtMaPM.getText()));
        pm.setMaSach(Integer.valueOf(txtMaSach.getText()));
        pm.setTrangThai(String.valueOf(cboTrangThai.getSelectedItem()));
        pm.setSoLuong(Integer.valueOf(txtSL.getText()));
        pm.setGhiChu(txtGhiChu.getText());
        return pm;
    }
    void updateStatus(){
        boolean edit = this.row >=0;// người ta đang chọn hàng ở đâu đó (true là chọn, false là không chọn)
        boolean first = this.row == 0;// đang ở bảng ghi đầu tiên
        boolean last = this.row == tblPM.getRowCount() - 1;// đang ở vị trí cuối cùng
        txtMaPM.setEditable(!edit);
        //Trạng Thái Form
        //Khi insert thì không update và delete
        btnthem.setEnabled(!edit);// nếu giá trị edit là false thì mới cho sửa
        btnsua.setEnabled(edit);// nếu giá trị edit là false thì mới nỗi button lên cho ta chọn
        btnxoa.setEnabled(edit);// nếu giá trị edit là true sẽ bật Enabled lên (có nghĩa là mờ nút đi),(có nghĩa là trên form có thông tin)
        //Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);// nếu như giá trị edit là true và ko phải hàng đầu tiên thì nó sẽ ẩn
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);// nếu như giá trị edit là true và ko phải hàng cuối cùng thì nó sẽ ẩn
        btnLast.setEnabled(edit && !last);
    }
    void clearForm() {// xóa trắng tất cả các dòng
        CHITIETPM pm = new CHITIETPM();
        this.setForm(pm);
        this.row = -1;
        this.updateStatus();
    }
    void Insert(){
        try{
        CHITIETPM pm = getForm();
        dao.insert(pm);
        this.fillTable();
        this.clearForm();
        MsgBox.alert(this, "Thêm mới thành công !");
        }catch(Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Thêm mới thất bại !");
        }
    }
    void Delete(){
        CHITIETPM pm = getForm();
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa phiếu mượn !");
        } else {
            MsgBox.confirm(this, "Bạn thật sự muốn xóa khóa học này ? ");
            int mapm = Integer.parseInt(txtMaPM.getText());
            try {
                pm.setMaPM(Integer.parseInt(txtMaPM.getText()));
                dao.delete(mapm);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công !");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại !");
            }
        }
    }
    void Update(){
        try{
            CHITIETPM pm = getForm();
            dao.update(pm);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this,"Cập Nhật Thành Công");
        }catch(Exception e){
            System.out.println(e);
            MsgBox.alert(this,"Cập Nhật Thất Bại");
        }
    }
    void First(){
        this.row = 0;
        this.edit();
    }
    void Next(){
         if (this.row < tblPM.getRowCount() - 1);
        this.row++;
        this.edit();
    }
    void Last(){
        this.row = tblPM.getRowCount() - 1;
        this.edit();
    }
    void Prev(){
         if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }
    boolean isValidated(boolean chk){
        CHITIETPM s = this.getForm();
        if(Double.parseDouble(txtSL.getText()) <= 0){
                MsgBox.alert(this, "Số Lượng Phải Nhập Số Dương!");
                txtSL.requestFocus();
                 return false;
        }
           return true;
    }
}
