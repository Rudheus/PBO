import javax.swing.*;
import java.awt.*;

class LanguagePanel extends BasePanel {
    private Language currentLanguage;
    @Override
    public void updateLanguage() {
        Language language = frame.getCurrentLanguage().equals("English")
                ? new EnglishLanguage()
                : new IndonesianLanguage();

        // Perbarui teks di komponen LanguagePanel
        JLabel languageLabel = (JLabel) this.getComponent(0);
        languageLabel.setText(language.getTitle() + "\n" + language.getChooseLanguageText());
    }

    public LanguagePanel(MyFrame frame, JPanel pinPanel) {
        super(frame);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);

        // Default ke bahasa Inggris
        currentLanguage = new EnglishLanguage();

        JLabel languageLabel = new JLabel("Chose a language", SwingConstants.CENTER);
        languageLabel.setForeground(Color.yellow);
        languageLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.blue);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton englishButton = new JButton("English");
        JButton indonesianButton = new JButton("Bahasa Indonesia");

        englishButton.addActionListener(e -> {
            currentLanguage = new EnglishLanguage(); // Set bahasa Inggris
            frame.setCurrentLanguage("English");
            frame.updateLanguage(); // Perbarui panel aktif
            switchToPanel(pinPanel);
        });

        indonesianButton.addActionListener(e -> {
            currentLanguage = new IndonesianLanguage(); // Set bahasa Indonesia
            frame.setCurrentLanguage("Bahasa Indonesia");
            frame.updateLanguage(); // Perbarui panel aktif
            switchToPanel(pinPanel);
        });

        buttonPanel.add(englishButton, gbc);
        gbc.gridy++;
        buttonPanel.add(indonesianButton, gbc);

        this.add(languageLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
