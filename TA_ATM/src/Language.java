public abstract class Language {
    private String title;
    private String chooseLanguageText;
    private String pinPrompt;
    private String errorMessage;
    private String transactionPrompt;


    // Getter dan Setter untuk setiap atribut
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChooseLanguageText() {
        return chooseLanguageText;
    }

    public void setChooseLanguageText(String chooseLanguageText) {
        this.chooseLanguageText = chooseLanguageText;
    }

    public String getPinPrompt() {
        return pinPrompt;
    }

    public void setPinPrompt(String pinPrompt) {
        this.pinPrompt = pinPrompt;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTransactionPrompt() {
        return transactionPrompt;
    }

    public void setTransactionPrompt(String transactionPrompt) {
        this.transactionPrompt = transactionPrompt;
    }

}
