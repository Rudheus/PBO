import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {
    private String currentLanguage;

    public MyFrame() {
        this.setTitle("ATM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ImageIcon img = new ImageIcon(getClass().getResource("/atm.jpg"));
        this.setIconImage(img.getImage());
        this.getContentPane().setBackground(Color.blue);

        // Atur bahasa default
        this.currentLanguage = "English";

        this.revalidate();
        this.repaint();
    }
    public void updateLanguage() {
        Component currentPanel = this.getContentPane().getComponent(0);
        if (currentPanel instanceof BasePanel) {
            ((BasePanel) currentPanel).updateLanguage();
        }
    }



    public void setCurrentLanguage(String language) {
        this.currentLanguage = language;
    }

    public String getCurrentLanguage() {
        return currentLanguage ;
    }

}
