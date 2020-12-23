package com.kushagra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@SecondaryTables({

		@SecondaryTable(name = "author_details", pkJoinColumns = {
				@PrimaryKeyJoinColumn(name = "auth_id", referencedColumnName = "book_id") }),
		@SecondaryTable(name = "publisher_details", pkJoinColumns = {
				@PrimaryKeyJoinColumn(name = "publisher_id", referencedColumnName = "book_id") }) })
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", updatable = false, nullable = false)
	private int bookId;

	@Column(name = "book_title", length = 100)
	private String bookTitle;

	@Column(name = "book_year", length = 40)
	private int bookYear;

	@Column(name = "book_isbn_no", length = 50)
	private int bookIsbnNo;

	@Column(name = "book_available", length = 20)
	private int bookAvailable;

	@Column(table = "author_details", name = "author_name", length = 40)
	private String authorName;

	@Column(table = "publisher_details", name = "publisher_name", length = 40)
	private String publisherName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBookYear() {
		return bookYear;
	}

	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}

	public int getBookIsbnNo() {
		return bookIsbnNo;
	}

	public void setBookIsbnNo(int bookIsbnNo) {
		this.bookIsbnNo = bookIsbnNo;
	}

	public int getBookAvailable() {
		return bookAvailable;
	}

	public void setBookAvailable(int bookAvailable) {
		this.bookAvailable = bookAvailable;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookYear=" + bookYear + ", bookIsbnNo="
				+ bookIsbnNo + ", bookAvailable=" + bookAvailable + ", authorName=" + authorName + ", publisherName="
				+ publisherName + ", getAuthorName()=" + getAuthorName() + ", getPublisherName()=" + getPublisherName()
				+ ", getBookId()=" + getBookId() + ", getBookTitle()=" + getBookTitle() + ", getBookYear()="
				+ getBookYear() + ", getBookIsbnNo()=" + getBookIsbnNo() + ", getBookAvailable()=" + getBookAvailable()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
