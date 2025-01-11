import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();


        // Membuat panel-panel
        TransactionPanel transactionPanel = new TransactionPanel(myFrame);
        PinPanel pinPanel = new PinPanel(myFrame, transactionPanel);
        LanguagePanel languagePanel = new LanguagePanel(myFrame, pinPanel);

        // Menampilkan panel awal
        myFrame.add(languagePanel, BorderLayout.CENTER);

    }
}