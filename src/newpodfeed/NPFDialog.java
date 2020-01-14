/*
 * NPFDialog.java
 *
 * Created on April 7, 2007, 12:13 AM
 */

package newpodfeed;

/**
 *
 * @author  newpodfeed
 */
public class NPFDialog extends javax.swing.JDialog {
    
    /** Creates new form NPFDialog */
    public NPFDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        area.setColumns(50);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setRows(20);
        area.setWrapStyleWord(true);
        jScrollPane1.setViewportView(area);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        button.setText("Okay");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        jPanel2.add(button);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonActionPerformed
    
    
    public void setText(String s) {
        area.setText(s);
        try {
            area.setCaretPosition(0);
        }
        catch(Exception e){
        }
    }

    public void clear() {
        area.setText("");
    }

    public void append(String s) {
        area.append(s);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NPFDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
