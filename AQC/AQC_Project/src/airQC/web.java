package airQC;
import java.awt.Dimension;
import java.awt.Font;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class web {
    public static void main(String[] args) throws BadLocationException, MalformedURLException {
        JTextPane jtp = new JTextPane();
       
        UIManager.put("OptionPane.minimumSize",new Dimension(500,500)); 
        JLabel label = new JLabel("index of cities");
        label.setFont(new Font("Arial",3,16));
        Object[] options = {"Go back",
    			"Next City",};
    	int n = JOptionPane.showOptionDialog(jtp,label,"Searching Result...",1,1,null,options,options[1]);
    	if (n == 0){
    		
    	}
    }

}
