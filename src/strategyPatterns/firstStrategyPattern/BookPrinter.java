package strategyPatterns.firstStrategyPattern;

public class BookPrinter {
    Book book;

    public BookPrinter() {}

    public BookPrinter(Book book) {
        setBook(book);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void Print() {
        System.out.println("Book {\nname: " + book.name() + "\nauthor: " + book.author() + "\nnumber of page: " + book.pageCount() + "\ndescription: " + book.description() + "\n}");
    }

    public void Print(Book book) {
        setBook(book);
        Print();
    }
}
