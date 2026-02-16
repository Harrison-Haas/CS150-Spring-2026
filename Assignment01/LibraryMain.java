public class LibraryMain {
    public static void main(String[] args){
        
        Book book1 = new Book("001", "Book1", "Alice");
        Book book2 = new Book("002", "Book2", "Bob");
        Book book3 = new Book("003", "Book3", "Charlie");
        Borrower Dave = new Borrower("001", "Dave");
        Borrower Eve = new Borrower("002", "Eve");
        Borrower Mallory = new Borrower("003", "Mallory");
    
        Library library = new Library();
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.print("getFullCatalog: ");
        System.out.println(library.getFullCatalog());
        System.out.println();
        
        System.out.print("findByIsbn(\"002\"): ");
        System.out.println(library.findByIsbn("002"));
        System.out.println();

        System.out.print("isAvailable(\"002\"): ");
        System.out.println(library.isAvailable("002"));
        System.out.println();

        library.registerBorrower(Dave);
        library.registerBorrower(Eve);
        library.registerBorrower(Mallory);

        System.out.print("getCheckoutHistory(): ");
        System.out.println(library.getCheckoutHistory());
        System.out.println();

        System.out.print("checkout(\"001\", \"002\"): ");
        System.out.println(library.checkout("001","002"));
        System.out.println();

        System.out.print("getCheckoutHistory(): ");
        System.out.println(library.getCheckoutHistory());
        System.out.println();

        System.out.print("checkin(\"002\"): ");
        System.out.println(library.checkin("002"));
        System.out.println();

        System.out.print("getCheckoutHistory(): ");
        System.out.println(library.getCheckoutHistory());
        System.out.println();

        System.out.print("getBorrowerBooks(\"001\"): ");
        System.out.println(library.getBorrowerBooks("001"));
        System.out.println();


    }  

}
