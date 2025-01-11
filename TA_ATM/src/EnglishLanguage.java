public class EnglishLanguage extends Language {
    public EnglishLanguage() {
        // Inisialisasi teks dalam bahasa Inggris

        this.setPinPrompt("ENTER PIN:");
        this.setErrorMessage("Incorrect PIN, try again!");
        this.setTransactionPrompt("Choose a Transaction");
    }
}
