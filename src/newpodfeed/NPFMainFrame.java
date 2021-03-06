/*
 * NPFMainFrame.java
 *
 * Created on March 18, 2007, 11:18 PM
 */

package newpodfeed;

import java.io.*;
import javax.swing.UIManager;

/**
 *
 * @author  newpodfeed
 */
public class NPFMainFrame extends javax.swing.JFrame {
    
    NPFNewFeedDialog newFeed;
    NPFNewItemDialog newItem;
    NPFDialog dialog;

    BufferedReader reader;

    String helpText;
    String aboutText;
    
    static javax.swing.JFrame frame;
    
    /** Creates new form NPFMainFrame */
    public NPFMainFrame() {
        /* Set the look and feel to native */
        String laf = javax.swing.UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(laf);
        }
        catch(Exception e) {
        }
        initComponents();
        newFeed = new NPFNewFeedDialog(this, true);
        newItem = new NPFNewItemDialog(this, true);
        dialog = new NPFDialog(this, true);
        try {
            reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("help.txt")));
            String currentLine = "";
            helpText = "";
            while(true) {
                currentLine = reader.readLine();
                if (currentLine == null) {
                    break;
                }
                helpText += currentLine + "\n";
            }
            reader.close();
        }
        catch(Exception e) {
            System.out.println("Error reading the help file.");
            helpText = "The help file appears to be missing.  Go to http://InsertWebsiteHere for instructions.";
        }
        try {
            reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("license.txt")));
            String currentLine = "";
            aboutText = "";
            while(true) {
                currentLine = reader.readLine();
                if (currentLine == null) {
                    break;
                }
                aboutText += currentLine + "\n";
            }
            reader.close();
        }
        catch(Exception e) {
            System.out.println("Error reading the license file.");
            aboutText = "The license file appears to be missing.";
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newFeedButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        newItemButton = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        convertMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NewPodFeed v1.3.3");
        setMinimumSize(new java.awt.Dimension(300, 78));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        newFeedButton.setText("New Feed");
        newFeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFeedButtonActionPerformed(evt);
            }
        });
        jPanel1.add(newFeedButton);

        getContentPane().add(jPanel1);

        newItemButton.setText("New Episode");
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });
        jPanel2.add(newItemButton);

        getContentPane().add(jPanel2);

        jMenu2.setText("Menu");

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(helpMenuItem);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(aboutMenuItem);

        convertMenuItem.setText("Convert Feed");
        convertMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(convertMenuItem);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        dialog.clear();
        String text = "";
        text += "NewPodFeed v1.3.3";
        text += "\n\n";
        text += "http://InsertWebsiteHere";
        text += "\n\n";
        text += aboutText;
        dialog.setText(text);
        dialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed
        newItem.setVisible(true);
    }//GEN-LAST:event_newItemButtonActionPerformed

    private void newFeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFeedButtonActionPerformed
        newFeed.setVisible(true);
    }//GEN-LAST:event_newFeedButtonActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        dialog.setText(helpText);
        dialog.setVisible(true);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void convertMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertMenuItemActionPerformed
        NPFConvertFeedDialog convertFeed = new NPFConvertFeedDialog(this, true);
        
        convertFeed.setVisible(true);
    }//GEN-LAST:event_convertMenuItemActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NPFMainFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem convertMenuItem;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton newFeedButton;
    private javax.swing.JButton newItemButton;
    // End of variables declaration//GEN-END:variables
    
}
