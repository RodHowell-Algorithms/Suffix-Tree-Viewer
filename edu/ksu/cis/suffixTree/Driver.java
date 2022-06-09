// File: Driver.java
// A demo to display suffix trees.

package edu.ksu.cis.suffixTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import edu.ksu.cis.viewer.PatriciaTrie;
import edu.ksu.cis.viewer.TreeFrame;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A demo to display suffix trees.
 */
public class Driver extends JPanel {

  /**
   * The text field in which the input strings will be entered.
   */
  JTextField text = new JTextField(20);

  /**
   * Used for consistency in serialization.
   */

  private static final long serialVersionUID = 1L;
  /** Constructs a new Driver applet.
   */
  public Driver() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      // This shouldn't happen
      e.printStackTrace();
    }
    setLayout(new FlowLayout());
    add(new JLabel("Enter String: "));
    text.addActionListener(new TextEntryListener(this));
    add(text);
  }

  /**
   * Starts the program as an application.
   */
  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setContentPane(new Driver());
    f.addWindowListener(new Terminator());
    f.setTitle("Suffix Trees");
    f.pack();
    f.setVisible(true);
  }

  /**
   * Returns the input string provided by the user.
   */
  public String getInputString() {
    String s = text.getText();
    text.setText("");
    return s;
  }
}

/**
 * The event handler for the text field.
 */
class TextEntryListener implements ActionListener {

  /**
   * The driver applet.
   */
  private Driver theDriver;

  /**
   * Constructs a new TextEntryListener.
   */
  public TextEntryListener(Driver d) {
    theDriver = d;
  }

  /**
   * Handles the event.
   */
  public void actionPerformed(ActionEvent e) {
    String s = theDriver.getInputString();
    PatriciaTrie t = new PatriciaTrie();
    for (int i = 0; i <= s.length(); i++) 
      t = (PatriciaTrie) t.put(s.substring(i));
    JFrame f = new TreeFrame(t, s.length(),
			     new Font("Monospaced", Font.BOLD, 12));
    f.setTitle("Suffix Tree");
    f.setVisible(true);
  }
}

/**
 * The event handler for closing the driver frame.
 */
class Terminator extends WindowAdapter {

  /**
   * Handles the event by terminating the program.
   */
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
}
