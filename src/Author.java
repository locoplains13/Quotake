import java.util.ArrayList;

public class Author {
    private String quoteAuthor;
    private ArrayList<String> authorQs;

    public Author(String author){
        quoteAuthor = author;
    }

    public String getAuthor(){
        return quoteAuthor;
    }

    public void setAuthor(String newAuthor){
        this.quoteAuthor = newAuthor;
    }

    public void addQuote(String q){
        authorQs.add(q);
    }

}