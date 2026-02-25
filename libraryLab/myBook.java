public class myBook
{
	private String title;
	private String author;
	private String isbn;
	private boolean isCheckedOut;

	public myBook()
	{
		this.title = "";
		this.author = "";
		this.isbn = "";
		this.isCheckedOut = false;
	}

	public myBook(String title, String author, String isbn)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isCheckedOut = false;
	}

//	public myBook(myBook otherBook)
//	{
//		this.title = otherBook.title;
//		this.author = otherBook.author;
//		this.isbn = otherBook.isbn;
//		this.isCheckedOut = otherBook.isCheckedOut;
//	}

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

//	public String getIsbn()
//	{
//		return isbn;
//	}

	public boolean getIsCheckedOut()
	{
		return isCheckedOut;
	}

//	public void setTitle(String title)
//	{
//		this.title = title;
//	}
//
//	public void setAuthor(String author)
//	{
//		this.author = author;
//	}
//
//	public void setIsbn(String isbn)
//	{
//		this.isbn = isbn;
//	}

	public void setIsCheckedOut(boolean isCheckedOut)
	{
		this.isCheckedOut = isCheckedOut;
	}

	@Override
	public String toString()
	{
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + isbn + ", checkedOut=" + isCheckedOut + "]";
	}
}
