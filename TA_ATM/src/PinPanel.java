import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
class PinPanel extends BasePanel {
    private JPanel transactionPanel;
    private JLabel pinLabel;
    private JButton submitButton;
    public PinPanel(MyFrame frame, JPanel transactionPanel) {
        super(frame);
        this.transactionPanel = transactionPanel;
        initializeComponents(); // Pastikan method ini dipanggil di sini
    }


    protected void initializeComponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);

        JLabel pinLabel = new JLabel(getPinLabelText(), SwingConstants.CENTER);
        pinLabel.setForeground(Color.yellow);
        pinLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel pinInputPanel = new JPanel();
        pinInputPanel.setLayout(new FlowLayout());
        pinInputPanel.setBackground(Color.blue);

        JPasswordField pinField = new JPasswordField(10);
        JButton pinSubmitButton = new JButton(getSubmitButtonText());

        pinSubmitButton.addActionListener(e -> {
            String pin = new String(pinField.getPassword());
            if (pin.equals("1234")) {
                switchToPanel(transactionPanel);
            } else {
                JOptionPane.showMessageDialog(frame, getErrorMessageText(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        pinInputPanel.add(pinField);
        pinInputPanel.add(pinSubmitButton);

        this.add(pinLabel, BorderLayout.NORTH);
        this.add(pinInputPanel, BorderLayout.CENTER);
    }


    @Override
    public void updateLanguage() {
        Language language = frame.getCurrentLanguage().equals("English")
                ? new EnglishLanguage()
                : new IndonesianLanguage();
    }

    // Metode untuk mendapatkan teks sesuai bahasa
    private String getPinLabelText() {
        return frame.getCurrentLanguage().equals("English") ? "Enter PIN:" : "MASUKKAN PIN:";
    }

    private String getSubmitButtonText() {
        return frame.getCurrentLanguage().equals("English") ? "Submit" : "Kirim";
    }

    private String getErrorMessageText() {
        return frame.getCurrentLanguage().equals("English") ? "Incorrect PIN, please try again!" : "PIN salah, coba lagi!";
    }
}


