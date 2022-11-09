import java.time.LocalDate;

public class Quotes {
    private String savedQuote;
    private LocalDate dateAdded = LocalDate.now();
    private String auth;

    public Quotes(String quote, String quoteAuthor){
        savedQuote = quote;
        dateAdded = LocalDate.now();
        auth = quoteAuthor;
    }

    public String getQuote(){
        return savedQuote;
    }

    public LocalDate getDate(){
        return dateAdded;
    }

    public String getAuth(){
        return auth;
    }

    public void setQuote(String newQuote){
        this.savedQuote = newQuote;
    }

    public String toString(){
        String statement;

        statement = "\"" + getQuote() + "\"" + "- " + getAuth() + ", added on " + getDate();

        return statement;
    }
}