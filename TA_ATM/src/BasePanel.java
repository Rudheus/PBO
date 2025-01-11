import javax.swing.*;
import java.awt.*;

abstract class BasePanel extends JPanel {
    protected MyFrame frame;

    public BasePanel(MyFrame frame) {
        this.frame = frame;
    }
    public abstract void updateLanguage();
    protected void switchToPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.add(newPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
