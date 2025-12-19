package project.librarySystem;

public class Loan {
    private static int loanCounter = 1; // auto-increment for loan IDs

    private int loanId;  
    private Book book;    
    private String user;  

    public Loan(Book book, String user) {
        this.loanId = loanCounter++; 
        this.book = book;
        this.user = user;
        book.setIsAvailable(false); 
    }

    public int getLoanId() { 
    	return loanId; 
    }
    
    public Book getBook() { 
    	return book; 
    }
    public String getUser() { 
    	return user; 
    }
  
}
