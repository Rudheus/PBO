import javax.swing.*;
import java.awt.*;

class TransactionPanel extends BasePanel {
    private JLabel transactionLabel;
    private JButton withdrawButton;
    private JButton depositButton;
    // Menggunakan BasePanel untuk konsistensi
    public TransactionPanel(MyFrame frame) {
        super(frame); // Panggil konstruktor BasePanel
        initializeComponents();
    }

    protected void initializeComponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);

        // Label judul untuk transaksi
        JLabel transactionLabel = new JLabel("PILIH JUMLAH UANG YANG INGIN DITARIK:", SwingConstants.CENTER);
        transactionLabel.setForeground(Color.yellow);
        transactionLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Panel untuk tombol transaksi
        JPanel transactionButtonPanel = new JPanel(new GridBagLayout());
        transactionButtonPanel.setBackground(Color.blue);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tombol-tombol transaksi
        JButton withdraw100 = createTransactionButton("Rp 100.000", frame, "Anda telah menarik Rp 100.000");
        JButton withdraw500 = createTransactionButton("Rp 500.000", frame, "Anda telah menarik Rp 500.000");
        JButton withdraw1000 = createTransactionButton("Rp 1.000.000", frame, "Anda telah menarik Rp 1.000.000");

        // Tambahkan tombol ke panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        transactionButtonPanel.add(withdraw100, gbc);
        gbc.gridy++;
        transactionButtonPanel.add(withdraw500, gbc);
        gbc.gridy++;
        transactionButtonPanel.add(withdraw1000, gbc);

        // Tambahkan label dan tombol ke panel utama
        this.add(transactionLabel, BorderLayout.NORTH);
        this.add(transactionButtonPanel, BorderLayout.CENTER);
    }

    @Override
    public void updateLanguage() {
        Language language = frame.getCurrentLanguage().equals("English")
                ? new EnglishLanguage()
                : new IndonesianLanguage();
    }
    private JButton createTransactionButton(String text, MyFrame frame, String message) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.addActionListener(e -> showMessage(frame, message));
        return button;
    }

    private String getTransactionLabelText() {
        return frame.getCurrentLanguage().equals("English")
                ? "SELECT AMOUNT TO WITHDRAW:"
                : "PILIH JUMLAH UANG YANG INGIN DITARIK:";
    }

    private String getWithdrawText(int amount) {
        return frame.getCurrentLanguage().equals("English")
                ? "Rp " + amount + ".000"
                : "Rp " + amount + ".000";
    }

    private String getWithdrawMessage(int amount) {
        return frame.getCurrentLanguage().equals("English")
                ? "You have withdrawn Rp " + amount + ".000"
                : "Anda telah menarik Rp " + amount + ".000";
    }

    private void showMessage(MyFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}

