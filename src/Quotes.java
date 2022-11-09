public class Quotes {
    private String savedQuote;

    public Quotes(String quote){
        savedQuote = quote;
    }

    public String getQuote(){
        return savedQuote;
    }

    public void setQuote(String newQuote){
        this.savedQuote = newQuote;
    }

}