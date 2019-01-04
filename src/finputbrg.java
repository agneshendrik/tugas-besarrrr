import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class finputbrg extends javax.swing.JFrame {
    
    public Connection con;
    public DefaultTableModel tabel;
    public ResultSet rs;
    public Statement st;

    /**
     * Creates new form finputbrg
     */
    public finputbrg() {
        initComponents();
        setLocationRelativeTo(this);
        //koneksi();
        String[] judul={"kode barang", "nama barang", "jumlah stok","harga"};
        tabel = new DefaultTableModel(judul,0);
        jTable1.setModel(tabel);
        tampil ();
        RefreshTabel();
        
        
                
    }
    
    public void RefreshTabel(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root", "");
               DefaultTableModel model = new DefaultTableModel(new String[]{"kode_barang", "nama_barang", "jumlah_stok", "harga"}, 0);

               String sql = "SELECT * FROM tpos";


               PreparedStatement pst = con.prepareStatement(sql);
               ResultSet rs = pst.executeQuery();

               while(rs.next())
               {
                   String d = rs.getString("kode_barang");
                   String e = rs.getString("nama_barang");
                   String f = rs.getString("jumlah_stok");
                   String g = rs.getString("harga");
                   model.addRow(new Object[]{d, e, f, g});
                   //JTable jTable1 = new JTable();
                   jTable1.setModel(model);
               }
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
    }
    
    public void KosongkanField(){
            txtkodebarang.setText("");
            txtnamabarang.setText("");
            txtjumlahstok.setText("");
            txthargabrg.setText("");
    }
    
    public void tampil(){
        koneksi classKoneksi  = new koneksi();
        try {
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM tpos");
            int no = 1;
            while(rs.next()){
                String[] row = {Integer.toString(no), rs.getString(2),rs.getString(3), rs.getString(4)};
                tabel.addRow(row);
                jTable1.setModel(tabel);
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        txtkodebarang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtjumlahstok = new javax.swing.JTextField();
        txthargabrg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel1.setText("KODE BARANG");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel2.setText("NAMA BARANG");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel3.setText("JUMLAH STOK");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel4.setText("HARGA BARANG");

        btnsave.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        btnsave.setText("save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        btnedit.setText("edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        btnhapus.setText("hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "KODE", "NAMA", "JUMLAH", "HARGA"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnkeluar.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        btnkeluar.setText("exit");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtjumlahstok)
                                .addGap(93, 93, 93))
                            .addComponent(txthargabrg, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhapus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnkeluar)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtjumlahstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txthargabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnedit)
                    .addComponent(btnhapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnkeluar)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
                   fmain menu = new fmain();
                   menu.setVisible(true);
                   this.setVisible(false);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root", "");
            
            String sql = "Insert into tpos( kode_barang, nama_barang, jumlah_stok, harga) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);   
            pst=con.prepareStatement(sql);
           
            pst.setString(1, txtkodebarang.getText());
            pst.setString(2, txtnamabarang.getText());
            pst.setString(3, txtjumlahstok.getText());
            pst.setString(4, txthargabrg.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "tersimpan!");
//            DefaultTableModel model = (DefaultTableModel) 
//            jTable1.getModel();
//            model.addRow(new Object[]{ txtkodebarang.getText(), txtnamabarang.getText(), txtjumlahstok.getText(),txthargabrg.getText()});
            RefreshTabel();
            KosongkanField();
        } 
        catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root", "");
            
            String sql = "Update tpos set nama_barang = ?, jumlah_stok=?, harga=? WHERE kode_barang=?";
            PreparedStatement pst = con.prepareStatement(sql);   
            pst=con.prepareStatement(sql);
           
            pst.setString(4, txtkodebarang.getText());
            pst.setString(1, txtnamabarang.getText());
            pst.setString(2, txtjumlahstok.getText());
            pst.setString(3, txthargabrg.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "tersimpan!");
//            DefaultTableModel model = (DefaultTableModel) 
//            jTable1.getModel();
//            model.addRow(new Object[]{ txtkodebarang.getText(), txtnamabarang.getText(), txtjumlahstok.getText(),txthargabrg.getText()});
            RefreshTabel();
            KosongkanField();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }       
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
           
                try {
                     int baris = jTable1.getSelectedRow();
                    if (baris != -1) {
                     String kode = jTable1.getValueAt(baris, 0).toString();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root", "");
                    String SQL = "DELETE FROM tpos WHERE kode_barang='"+kode+"'"; 
                    PreparedStatement pst = con.prepareStatement(SQL);   
                     pst=con.prepareStatement(SQL);
                      pst.execute();
                      JOptionPane.showMessageDialog(null, "terhapus");
                      RefreshTabel();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            
    
    }//GEN-LAST:event_btnhapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
       int selectedRow = jTable1.getSelectedRow();
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       txtkodebarang.setText(model.getValueAt(selectedRow, 0).toString());
       txtnamabarang.setText(model.getValueAt(selectedRow, 1).toString());
       txtjumlahstok.setText(model.getValueAt(selectedRow, 2).toString());
       txthargabrg.setText(model.getValueAt(selectedRow, 3).toString());
    
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(finputbrg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(finputbrg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(finputbrg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(finputbrg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new finputbrg().setVisible(true);
                
                
            }
        });
        
        
        
                     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txthargabrg;
    private javax.swing.JTextField txtjumlahstok;
    private javax.swing.JTextField txtkodebarang;
    private javax.swing.JTextField txtnamabarang;
    // End of variables declaration//GEN-END:variables

    
}