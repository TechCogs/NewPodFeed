/* NewPodFeed podcast RSS feed generation software
 * Copyright (C) 2011 TechCogs
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Main.java
 *
 * Created on March 18, 2007, 11:15 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpodfeed;

/**
 *
 * @author newpodfeed
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NPFMainFrame mainFrame = new NPFMainFrame();
        mainFrame.setVisible(true);
    }
    
}
