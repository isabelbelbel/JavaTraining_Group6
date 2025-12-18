package project.librarySystem;


public class Library{
   // can contain up to 5 books	
	
	private Book[] books;
	private int bookCount = 0;
	private Loan[] loans;
	private int loanCount = 0;
	
	public Library (int counter) {
		
		this.books = new Book[counter];
		this.loans = new Loan[counter];
		
	}
	public void addBook(Book newBook) {
		
		if (bookCount < books.length) {
			books[bookCount] = newBook;
			bookCount++;
			
			//System.out.println(newBook.getTitle() + " by " + newBook.getAuthor()+ " added to library.");
		}else {
			
			//System.out.println("Library is full! Sorry :(");
		}
	}

	public void getAllBooks() {
		
		if (bookCount > 0) {
			System.out.println("===============================================");
			System.out.println("DISPLAY ALL BOOKS:");

			for (int x = 0; x < books.length; x++) {

				System.out.println(books[x].getId() + " | "
						+ books[x].getTitle() + " | "
						+ books[x].getAuthor() + " | "
						+ (books[x].getIsAvailable() ? "AVAILABLE" : "BORROWED")
						);	
			}
		}else {
			System.out.println("===============================================");
			System.out.println("Library is empty! Sorry :(");

		}
	};
	public void getAvailableBooks() {
		
		int availableBooks = 0;
		if (bookCount > 0) {
			System.out.println("===============================================");
			System.out.println("DISPLAY AVAILABLE BOOKS:");

			for (int x = 0; x < books.length; x++) {
				
				if (books[x].getIsAvailable()) {
					System.out.println(books[x].getId() + " | "
							+ books[x].getTitle() + " | "
							+ books[x].getAuthor());	
					availableBooks++;
				}
				
			}
			if (availableBooks == 0){
				System.out.println("===============================================");
				System.out.println("No books available! Sorry :(");
			}
		}else {
			System.out.println("===============================================");
			System.out.println("Library is empty! Sorry :(");

		}
		
		
	};
	public void getBorrowedBooks(String borrower) {
		
		int borrowedBooks = 0;
		if (bookCount > 0) {
			System.out.println("===============================================");
			System.out.println("DISPLAY BORROWED BOOKS:");

			for (int x = 0; x < books.length; x++) {
				
				if (!books[x].getIsAvailable()) {
					System.out.println(books[x].getId() + " | "
							+ books[x].getTitle() + " | "
							+ borrower);	
					borrowedBooks++;
				}
			}
			if (borrowedBooks == 0){
				System.out.println("===============================================");
				System.out.println("No borrowed books.");
			}
			
		}else {
			System.out.println("===============================================");
			System.out.println("Library is empty! Sorry :(");

		}
		
	};
	public void borrowBook(Integer id, String borrower) {
		
		//check if book is available
		//set isAvailable to false
		//log book title to loan array via bookID
		//log username to loan array
	};
	public void returnBook() {
		
		//check if loanId is on the loan array
		//via loanId get bookId then via bookId set status of is Available to TRUE
		//remove from Loan Array via loanID
	};
	

}
