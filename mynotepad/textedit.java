package mynotepad;

import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultHighlighter;

public class textedit extends javax.swing.JFrame {

    String filename;
    Clipboard clipb = getToolkit().getSystemClipboard();

    /**
     * Creates new form textedit
     */
    public textedit() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        newmenu = new javax.swing.JMenuItem();
        openmenu = new javax.swing.JMenuItem();
        savemenu = new javax.swing.JMenuItem();
        saveasmenu = new javax.swing.JMenuItem();
        exitmenu = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        copymenu = new javax.swing.JMenuItem();
        cutmenu = new javax.swing.JMenuItem();
        pastemenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        file.setText("File");
        file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileActionPerformed(evt);
            }
        });

        newmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newmenu.setText("New");
        newmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newmenuActionPerformed(evt);
            }
        });
        file.add(newmenu);

        openmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openmenu.setText("Open");
        openmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openmenuActionPerformed(evt);
            }
        });
        file.add(openmenu);

        savemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        savemenu.setText("Save");
        savemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savemenuActionPerformed(evt);
            }
        });
        file.add(savemenu);

        saveasmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveasmenu.setText("SaveAs");
        saveasmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveasmenuActionPerformed(evt);
            }
        });
        file.add(saveasmenu);

        exitmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitmenu.setText("Exit");
        exitmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitmenuActionPerformed(evt);
            }
        });
        file.add(exitmenu);

        jMenuBar1.add(file);

        edit.setText("Edit");

        copymenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copymenu.setText("Copy");
        copymenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copymenuActionPerformed(evt);
            }
        });
        edit.add(copymenu);

        cutmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutmenu.setText("Cut");
        cutmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutmenuActionPerformed(evt);
            }
        });
        edit.add(cutmenu);

        pastemenu.setText("Paste");
        pastemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastemenuActionPerformed(evt);
            }
        });
        edit.add(pastemenu);

        jMenuBar1.add(edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openmenuActionPerformed
        // TODO add your handling code here:
        FileDialog filedialog = new FileDialog(textedit.this, "open file", FileDialog.LOAD);
        filedialog.setVisible(true);
        if (filedialog.getFile() != null) {
            filename = filedialog.getDirectory() + filedialog.getFile();
            setTitle(filename);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                textArea.setText(sb.toString());
            }
            reader.close();
        } catch (IOException e) {

            System.out.println("File Not Found");
        }
    }//GEN-LAST:event_openmenuActionPerformed

    private void savemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savemenuActionPerformed
        // TODO add your handling code here:
        FileDialog filedialog = new FileDialog(textedit.this, "save File", FileDialog.SAVE);
        filedialog.setVisible(true);

        if (filedialog.getFile() != null) {
            filename = filedialog.getDirectory() + filedialog.getFile();
            setTitle(filename);

            try {
                FileWriter filewriter = new FileWriter(filename);
                filewriter.write(textArea.getText());
                setTitle(filename);
                filewriter.close();
            } catch (Exception e) {
                System.out.println("File is not Found ");
            }
    }//GEN-LAST:event_savemenuActionPerformed
    }
    private void fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileActionPerformed
        // TODO add your handling code here:#

    }//GEN-LAST:event_fileActionPerformed

    private void newmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newmenuActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
        setTitle(filename);
    }//GEN-LAST:event_newmenuActionPerformed

    private void exitmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitmenuActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitmenuActionPerformed

    private void copymenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copymenuActionPerformed
        // TODO add your handling code here:
        String copytext = textArea.getSelectedText();
        StringSelection CopySelection = new StringSelection(copytext);
        clipb.setContents(CopySelection, CopySelection);
    }//GEN-LAST:event_copymenuActionPerformed

    private void cutmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutmenuActionPerformed
        // TODO add your handling code here:
        String cutst = textArea.getSelectedText();
        StringSelection CutSelection = new StringSelection(cutst);
        clipb.setContents(CutSelection, CutSelection);
        textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
    }//GEN-LAST:event_cutmenuActionPerformed

    private void pastemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastemenuActionPerformed
        // TODO add your handling code here:

        try {
            Transferable pasteText = clipb.getContents(textedit.this);
            String jo = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(jo, textArea.getSelectionStart(), textArea.getSelectionEnd());
        } catch (Exception e) {
            System.out.println("DID NOT FIND IT");
        }
    }//GEN-LAST:event_pastemenuActionPerformed

    private void saveasmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveasmenuActionPerformed
        // TODO add your handling code here:
   
              FileDialog filedialog = new FileDialog(textedit.this, "save as File", FileDialog.SAVE);
        filedialog.setVisible(true);

        if (filedialog.getFile() != null) {
            filename = filedialog.getDirectory() + filedialog.getFile();
            setTitle(filename);

            try {
                FileWriter filewriter = new FileWriter(filename);
                filewriter.write(textArea.getText());
                setTitle(filename);
                filewriter.close();
            } catch (Exception e) {
                System.out.println("File is not Found ");
            }
    }//GEN-LAST:event_saveasmenuActionPerformed

    }
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
            java.util.logging.Logger.getLogger(textedit.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(textedit.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(textedit.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(textedit.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new textedit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copymenu;
    private javax.swing.JMenuItem cutmenu;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exitmenu;
    private javax.swing.JMenu file;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newmenu;
    private javax.swing.JMenuItem openmenu;
    private javax.swing.JMenuItem pastemenu;
    private javax.swing.JMenuItem saveasmenu;
    private javax.swing.JMenuItem savemenu;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    private void save(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
