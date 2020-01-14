/*
 * NPFFileFilter.java
 *
 * Created on May 12, 2007, 6:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpodfeed;

import java.io.*;

/**
 *
 * @author newpodfeed
 */
public class NPFFileFilter extends javax.swing.filechooser.FileFilter {
    
    /** Creates a new instance of NPFFileFilter */
    public NPFFileFilter() {
    }
    
    public boolean accept(File f) {
        if (f.isDirectory() || f.getName().endsWith(".npf")) {
            return true;
        }
        return false;
    }
    
    public String getDescription() {
        return "NewPodFeed Template Files";
    }
    
}
