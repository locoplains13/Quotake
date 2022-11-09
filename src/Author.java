import java.util.ArrayList;

public class Author {
    private String quoteAuthor;
    private ArrayList<Quotes> authorQs = new ArrayList<Quotes>();

    public Author(String author){
        quoteAuthor = author;
    }

    public String getAuthor(){
        return quoteAuthor;
    }

    public void setAuthor(String newAuthor){
        this.quoteAuthor = newAuthor;
    }

    public void addQuote(Quotes q){
        authorQs.add(q);
    }

    public void removeQuote(Quotes q){
        authorQs.remove(q);
    }

    public boolean isEmpty(){
        return authorQs.isEmpty();
    }

    public String toString(){
        String statement;
        statement = getAuthor() + " quotes: \n";
        for(int i = 0; i < authorQs.size(); i++){
            statement += authorQs.get(i).toString();
        }
        return statement;
    }
}