import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Library {
    private ArrayList<Book> fullCatalog;
    /*
     * Arraylist is the best collection type in this instance because it keeps the
     * order data is inserted, which allows books to easily be listed in the order
     * they were added to the catalog. ArrayList works better than a HashMap because
     * only one class is needed per each entry, as opposed to checkoutHistory.
     * ArrayList works better than a HashSet because dublicates can be stored in the
     * entire catalog as opposed to the availability.
     */
    private HashMap<String, Book> fastLookup;
    /*
     * HashMap is the best collection type in this instance because it allows isbns
     * to be mapped to books allowing for the fastest average-time lookup when an
     * isbn is used to search for a book. HashMap works better than an ArrayList or
     * a HashSet because it allows the isbn to map to a specific book.
     */
    private HashSet<Book> availableBooks;
    /*
     * HashSet is the best collection type in this instance because it prevents
     * dublicates and allows fast checks to find the availability of a book. HashSet
     * works better than an ArrayList because it stores duplicates as the same and a
     * book is either available or not so no duplicates are necessary. HashSet works
     * better than HashMap because only one peice of data is necessary, the book's
     * availibity is determined by whether it's in the HashSet or not.
     */
    private HashMap<Borrower, LinkedList<Book>> checkoutHistory;
    /*
     * HashMap is the best collection type in this instance because it associates a
     * borrower with their checkout history. HashMap provides the most efficient
     * access to a borrower's list of borrowed books. HashMap works better than
     * HashSet and ArrayList because it can associate a key to a value, just like in
     * fastLookup.
     */
    /*
     * LinkedList is the best collection type in this instance because it preserves
     * the order the books were checked out just like an ArrayList. LinkedList works
     * better than ArrayList because the borrower's checkout history is naturally
     * ordered and often added to, which LinkedList efficiently supports.
     */

    // Constructor
    public Library() {
        fullCatalog = new ArrayList<>();
        fastLookup = new HashMap<>();
        availableBooks = new HashSet<>();
        checkoutHistory = new HashMap<>();
    }
    
    // Getters
    public ArrayList<Book> getFullCatalog() {
        return fullCatalog;
    }

    public HashMap<String, Book> getFastLookup() {
        return fastLookup;
    }

    public HashSet<Book> getAvailableBooks() {
        return availableBooks;
    }

    public HashMap<Borrower, LinkedList<Book>> getCheckoutHistory() {
        return checkoutHistory;
    }

    // Regular Instance methods

    /**
     * Adds a book to the collections if the book isn't null or already in the
     * catalog
     * 
     * @param book the Book to be added
     */
    public void addBook(Book book) {
        // Check if book is null
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }

        // Check if the Library already has the book
        String isbn = book.getIsbn();
        if (fastLookup.containsKey(book.getIsbn())) {
            System.out.println("Book with ISBN " + isbn + " is already in the catalog");
            return;
        }

        // Add to all structures
        fullCatalog.add(book);
        fastLookup.put(isbn, book);
        availableBooks.add(book);

    }

    /**
     * Finds a book by it's isbn if the book is in the catalog
     * 
     * @param isbn The isbn of the book to be found
     * @return The book if it is found, null if not
     */
    public Book findByIsbn(String isbn) {
        // isbn being null or blank is guarded against in the Book class
        return fastLookup.get(isbn);
    }

    /**
     * Checks by isbn if a book is available to be checked out
     * 
     * @param isbn The isbn of the book to be checked
     * @return True if the book is in availableBooks, false if not
     */
    public boolean isAvailable(String isbn) {
        Book book = findByIsbn(isbn);
        return book != null && availableBooks.contains(book);
    }

    /**
     * Adds a borrower into the checkoutHistory HashMap
     * 
     * @param b The borrower to be added
     */
    public void registerBorrower(Borrower b) {
        if (b == null) {
            throw new IllegalArgumentException("Borrower must not be null");
        }
        if (checkoutHistory.containsKey(b)) {
            System.out.println(b + " has already been registered");
            return;
        }
        checkoutHistory.put(b, new LinkedList<Book>());
    }

    /**
     * Finds a borrower by a provided borrowerId
     * 
     * @param borrowerId The id of the borrower to be found
     * @return The borrower if it exists, null if not
     */
    public Borrower findBorrowerById(String borrowerId) {
        if (borrowerId == null || borrowerId.trim().isEmpty()) {
            return null;
        }
        for (Borrower b : checkoutHistory.keySet()) {
            if (borrowerId.equals(b.getId())) {
                return b;
            }
        }
        return null;
    }

    /**
     * Checks a specified book by isbn out to a specified borrower by id if the book
     * is available
     * 
     * @param borrowerId The id of the borrower to borrow the book
     * @param isbn       The isbn of the book to be borrowed
     * @return True if the book is sucessfully borrowed, false if the book is not
     *         available
     */
    public boolean checkout(String borrowerId, String isbn) {
        // Find the borrower and book
        Borrower borrower = findBorrowerById(borrowerId);
        Book book = findByIsbn(isbn);

        // Guard against null borrowers or books
        if (borrower == null || book == null) {
            throw new IllegalArgumentException("Borrower and/or book must not be null");
        }

        // Check if the book is available
        if (!availableBooks.contains(book))
            return false;

        // Checkout
        LinkedList<Book> books = checkoutHistory.get(borrower);
        books.addLast(book);
        availableBooks.remove(book);
        return true;
    }

    /**
     * Checks a book back into the available books HashSet if the isbn is valid and
     * the book is currently checked out
     * 
     * @param isbn The isbn of the Book to be checked in
     * @return True if the book was checked out, false if it was available
     */
    public boolean checkin(String isbn) {
        // Find the book using the isbn
        Book book = findByIsbn(isbn);

        // Guard against null books
        if (book == null) {
            throw new IllegalArgumentException(isbn + " is not a known isbn in the catalog");
        }

        // Checkin
        // returns true if book was checked out
        // returns false if the book was already available
        return availableBooks.add(book);
    }

    /**
     * Finds the books a borrower specified by their Id has checked out
     * 
     * @param borrowerId The id of the borrower to find
     * @return The books the specified borrower has checked out
     */
    public LinkedList<Book> getBorrowerBooks(String borrowerId) {
        // Find the borrower by the id
        Borrower borrower = findBorrowerById(borrowerId);

        // If the borrower is not registered an empty copy is returned
        if (borrower == null) {
            return new LinkedList<>();
        }

        // Find the borrowers checkout history
        LinkedList<Book> history = checkoutHistory.get(borrower);

        // If their checkout history is null, return an empty list
        if (history == null) {
            return new LinkedList<>();
        }
        // return a copy of their checkout history
        return new LinkedList<>(history);
    }
}
