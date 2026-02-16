public class Book {

    private String isbn;
    private String title;
    private String author;
   
    public Book(String isbn, String title, String author) {
        this.isbn = requireNotBlank(isbn, "isbn");
        this.title = requireNotBlank(title, "title");
        this.author = requireNotBlank(author, "author");
    }

    private static String requireNotBlank(String value, String fieldName){
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be null, empty, or whitespace");
        }
        return value;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString(){
        String output = "\"" + title + "\" ";
        output+= "by " + author + " ";
        output += "(isbn: " + isbn + ")";
        return output;
    }

    public boolean equals(Object o){
       // If the object is this book return true
       if (this == o) return true;
       // If the object is null return false
       if (o == null) return false;
       // If the object isn't a book, return false
       if(getClass() != o.getClass()) return false;
       // make the object into a book and check if it has the same isbn as this book, return the result
       Book other = (Book) o;
       return this.isbn.equals(other.isbn);
    }

    public int hashCode(){
        return isbn.hashCode();
    }

}
