/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpodfeed;

import java.io.*;

/**
 *
 * @author beardo
 */
public class NPFConvertFeedDialog extends javax.swing.JDialog {
    
    javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
    NPFFeedFileFilter fileFilter = new NPFFeedFileFilter();
    NPFDialog feedback = new NPFDialog(NPFMainFrame.frame, true);

    /**
     * Creates new form NPFConvertFeedDialog
     */
    public NPFConvertFeedDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        chooser.setFileFilter(fileFilter);
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
        convertFeedField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        proceedButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Convert Feed");

        jLabel1.setText("Choose feed to convert:");

        convertFeedField.setColumns(20);

        browseButton.setText("...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        proceedButton.setText("Proceed");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });
        jPanel1.add(proceedButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(convertFeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(convertFeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        int returnType = 0;
        File feedFile;
        String path = "";
        
        returnType = chooser.showOpenDialog(this);
        
        if (returnType == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        
        feedFile = chooser.getSelectedFile();
        convertFeedField.setText(feedFile.getPath());
    }//GEN-LAST:event_browseButtonActionPerformed

    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        try {
            File feedFile = new File(convertFeedField.getText());
            File path = feedFile.getParentFile();
            File tempFile = File.createTempFile("npf", "npftemp", path);
            
            BufferedReader feedReader = new BufferedReader(new FileReader(feedFile));
            BufferedWriter feedWriter = new BufferedWriter(new FileWriter(tempFile));
            
            String input = "";
            boolean converted = false;
            
            if (feedFile.getName().endsWith(".xml") != true) {
                String fileName = feedFile.getPath();
                fileName += ".xml";
                feedFile = new File(fileName);
            }
            
            input = feedReader.readLine();
            feedWriter.write(input + "\n");
            input = feedReader.readLine();
            feedWriter.write(input + "\n");
            input = feedReader.readLine();
            
            if (input.equals(("<!-- npf -->"))) {
                feedback.clear();
                feedback.setText("This feed is already managed by NewPodFeed.");
                feedback.setVisible(true);
                tempFile.delete();
                return;
            }
            
            feedWriter.write("<!-- npf -->\n");
            feedWriter.write(input + "\n");
            
            while(true) {
                input = feedReader.readLine();
                
                if (input == null) {
                    break;
                }
                
                if (converted == false && input.contains("<item>")) {
                    feedWriter.write("<!-- item insert point -->\n");
                    feedWriter.write("\n");
                    converted = true;
                }
                
                feedWriter.write(input);
                feedWriter.write("\n");
            }
            
            feedWriter.flush();
            feedWriter.close();
            feedReader.close();
            
            feedFile.delete();
            tempFile.renameTo(feedFile);
            
            feedback.clear();
            feedback.setText("Converting feed complete.");
            feedback.setVisible(true);
            setVisible(false);
        }
        catch(Exception e) {
            feedback.clear();
            feedback.append("There has been an error converting the feed.  The error log is:\n\n");
            feedback.append("" + e + "\n\n");
            feedback.append("Report all errors to InsertWebsiteHere");
            feedback.setVisible(true);
        }
            
    }//GEN-LAST:event_proceedButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NPFConvertFeedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NPFConvertFeedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NPFConvertFeedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NPFConvertFeedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                NPFConvertFeedDialog dialog = new NPFConvertFeedDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField convertFeedField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton proceedButton;
    // End of variables declaration//GEN-END:variables
}
