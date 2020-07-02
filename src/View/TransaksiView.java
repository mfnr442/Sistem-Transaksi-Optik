package View;

import controller.Controller;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Model.*;

public class TransaksiView extends javax.swing.JFrame {

    private Controller con;
    private ArrayList<Detail_Transaksi> arrTransaksi;
    private Double harga_total;

    public TransaksiView() throws SQLException {
        initComponents();
        this.con = new Controller();
        this.arrTransaksi = new ArrayList<>();
        this.harga_total = 0.0;
        this.showComboBoxKaryawan();
        this.showComboBoxProduk();
        this.showComboBoxPembeli();
        this.showTableTransaksi();
        this.showTableDeal();
        this.showHargaTotal();
    }

    private void showComboBoxKaryawan() throws SQLException {
        DefaultComboBoxModel dcbmKar = new DefaultComboBoxModel();

        for (Karyawan k : this.con.getDataKaryawan()) {
            dcbmKar.addElement(k.getId_karyawan() + "." + k.getNama_karyawan());
        }
        this.Karyawan.setModel(dcbmKar);
    }

    private void showComboBoxProduk() throws SQLException {
        DefaultComboBoxModel dcbmPro = new DefaultComboBoxModel();

        for (Produk p : this.con.getDataProduk()) {
            dcbmPro.addElement(p.getId_produk() + "." + p.getMerk() + "(" + p.getJenis() + ")");
        }
        this.Produk.setModel(dcbmPro);
    }

    private void showComboBoxPembeli() throws SQLException {
        DefaultComboBoxModel dcbmPem = new DefaultComboBoxModel();

        for (Pembeli pe : this.con.getDataPembeli()) {
            dcbmPem.addElement(pe.getNama_pembeli() + "(" + pe.getJenis_kelamin() + ")");
        }
        this.Pembeli.setModel(dcbmPem);
    }

    private void showHargaTotal() {
        this.hargatotal.setText(this.harga_total.toString());
    }

    private void showTableTransaksi() throws SQLException {
        DefaultTableModel dtmTra = new DefaultTableModel(new String[]{
            "Id Transaksi", "No Telp", "Id Karyawan", "Tanggal Pembelian"
        }, 0);
        dtmTra.setRowCount(0);

        for (Transaksi t : this.con.getDataTransaksi()) {
            dtmTra.addRow(new String[]{
                t.getId_transaksi().toString(), t.getPembeli().getNo_telp(),
                t.getKaryawan().getId_karyawan().toString(), t.getTanggal_pembelian().toString()

            });
        }
        this.tableDeal.setModel(dtmTra);
    }

    private void showTableDeal() {
        DefaultTableModel dtmTra = new DefaultTableModel(new String[]{
            "Id Produk", "Merk", "Jumlah Produk"
        }, 0);
        dtmTra.setRowCount(0);

        for (Detail_Transaksi dt : this.arrTransaksi) {
            dtmTra.addRow(new String[]{
                dt.getProduk().getId_produk().toString(), dt.getProduk().getMerk().toString(),
                dt.getJumlah_produk().toString()
            });
        }
        this.tabletransaksi.setModel(dtmTra);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Karyawan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Produk = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Pembeli = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Jumlah = new javax.swing.JTextField();
        Next = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabletransaksi = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        hargatotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDeal = new javax.swing.JTable();
        Deal = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tadetail = new javax.swing.JTextArea();
        detail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi");

        jLabel2.setText("Nama Karyawan :");

        Karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaryawanActionPerformed(evt);
            }
        });

        jLabel3.setText("Produk : ");

        Produk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Nama Pembeli :");

        Pembeli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Jumlah :");

        Jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahActionPerformed(evt);
            }
        });

        Next.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        tabletransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tabletransaksi);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Harga total :");

        tableDeal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tableDeal);

        Deal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Deal.setText("Deal");
        Deal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DealActionPerformed(evt);
            }
        });

        Tadetail.setColumns(20);
        Tadetail.setRows(5);
        jScrollPane3.setViewportView(Tadetail);

        detail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detail.setText("Detail");
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(hargatotal, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Jumlah, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Pembeli, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Produk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Karyawan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Deal)
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detail)
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Produk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Deal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargatotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KaryawanActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        try {
            Detail_Transaksi dt = new Detail_Transaksi();
            dt.setJumlah_produk(Integer.parseInt(Jumlah.getText()));
            dt.setProduk(this.con.getDataProduk().get(Produk.getSelectedIndex()));
            double jum = Integer.parseInt(Jumlah.getText());
            this.harga_total += this.con.getDataProduk().get(Produk.getSelectedIndex()).getHarga_satuan() * jum;
            this.showHargaTotal();
            this.arrTransaksi.add(dt);
            this.showTableDeal();
            this.showTableTransaksi();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiView.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_NextActionPerformed

    private void DealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DealActionPerformed
        Transaksi transaksi = new Transaksi();
        try {
            transaksi.setPembeli(this.con.getDataPembeli().get(this.Pembeli.getSelectedIndex()));
            transaksi.setkaryawan(this.con.getDataKaryawan().get(this.Karyawan.getSelectedIndex()));
            transaksi.setTanggal_pembelian(new Date());
            transaksi.setarrDetail_Transaksi(this.arrTransaksi);
            this.con.insertTransaksi(transaksi);
            this.showTableTransaksi();
//            this.arrTransaksi = new ArrayList<>();
            this.showTableDeal();
            //this.showComboBoxProduk();
        } catch (SQLException err) {
            System.out.println(err);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_DealActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Menu().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabletransaksi.getModel();
        int i = tabletransaksi.getSelectedRow();
        Integer del = Integer.parseInt(model.getValueAt(i, 0).toString());
        try {
            this.con.deleteTransaksi(del);
            this.showTableTransaksi();
        } catch (SQLException ex) {
            Logger.getLogger(FromPembeli.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JumlahActionPerformed

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        try {
            Transaksi t = this.con.getDataTransaksi().get(this.tableDeal.getSelectedRow());
            String teks = "" + "========================Detail Transaksi========================" + "\n"
                    + "Nama Karyawan : " + t.getKaryawan().getNama_karyawan() + "\n"
                    + "Nama Pembeli  : " + t.getPembeli().getNama_pembeli() + "\n"
                    + "Jenis Kelamin : " + t.getPembeli().getJenis_kelamin() + "\n"
                    + "No. Telp      : " + t.getPembeli().getNo_telp() + "\n"
                    + "Tanggal Pembelian : " + new SimpleDateFormat("dd/MM/yyyy").format(
                            t.getTanggal_pembelian()) + "\n";

            ArrayList<Detail_Transaksi> dp = t.getarrDetail_Transaksi();
            for (int i = 0; i < dp.size(); i++) {
                teks += "\n\n" + (i + 1) + ". "
                        + "Merk Produk  : " + dp.get(i).getProduk().getMerk() + "\n"
                        + "Jenis Produk : " + dp.get(i).getProduk().getJenis() + "\n"
                        + "Harga Satuan : " + dp.get(i).getProduk().getHarga_satuan() + "\n"
                        + "Jumlah Beli Produk : " + dp.get(i).getJumlah_produk() + "\n";
            }
            this.Tadetail.setText(teks);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_detailActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TransaksiView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deal;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JComboBox<String> Karyawan;
    private javax.swing.JButton Next;
    private javax.swing.JComboBox<String> Pembeli;
    private javax.swing.JComboBox<String> Produk;
    private javax.swing.JTextArea Tadetail;
    private javax.swing.JButton detail;
    private javax.swing.JTextField hargatotal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableDeal;
    private javax.swing.JTable tabletransaksi;
    // End of variables declaration//GEN-END:variables
}
