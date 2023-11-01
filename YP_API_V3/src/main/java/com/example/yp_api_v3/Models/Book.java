package com.example.yp_api_v3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Book", nullable = false)
    private int idBook;
    @Basic
    @Column(name = "Title", nullable = false, length = 100)
    private String title;
    @Basic
    @Column(name = "Image", nullable = false, length = 2147483647)
    private String image;
    @Basic
    @Column(name = "Summary", nullable = false, length = -1)
    private String summary;
    @Basic
    @Column(name = "TXT", nullable = false, length = -1)
    private String txt;
    @Basic
    @Column(name = "Author", nullable = false, length = 100)
    private String author;
    @Basic
    @Column(name = "Year_Of_Publication", nullable = false)
    private Date yearOfPublication;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Book_Similar",
            joinColumns = @JoinColumn(name = "Book", referencedColumnName = "ID_Book"),
            inverseJoinColumns = @JoinColumn(name = "Similar", referencedColumnName = "ID_Book"))
    private List<Book> booksimilar = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Book_Tag",
            joinColumns = @JoinColumn(name = "Book", referencedColumnName = "ID_Book"),
            inverseJoinColumns = @JoinColumn(name = "Tag", referencedColumnName = "ID_Tag"))
    private List<Tag> booktag = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "liked")
    private List<Client> liked;
    @JsonIgnore
    @ManyToMany(mappedBy = "history")
    private List<Client> history;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Book_Genre",
            joinColumns = @JoinColumn(name = "Book", referencedColumnName = "ID_Book"),
            inverseJoinColumns = @JoinColumn(name = "Genre", referencedColumnName = "ID_Genre"))
    private List<Genre> bookgenre;

    public Book() {
    }

    public Book(String title, String image, String summary, String txt, String author, Date yearOfPublication) {
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.txt = txt;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public List<Client> getLiked() {
        return liked;
    }

    public void setLiked(List<Client> liked) {
        this.liked = liked;
    }

    public List<Client> getHistory() {
        return history;
    }

    public void setHistory(List<Client> history) {
        this.history = history;
    }

    public Book(int idBook, String title, String image, String summary, String txt, String author, Date yearOfPublication, List<Book> booksimilar, List<Tag> booktag, List<Genre> bookgenre) {
        this.idBook = idBook;
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.txt = txt;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.booksimilar = booksimilar;
        this.booktag = booktag;
        this.bookgenre = bookgenre;
    }

    public List<Book> getBooksimilar() {
        return booksimilar;
    }

    public void setBooksimilar(List<Book> booksimilar) {
        this.booksimilar = booksimilar;
    }

    public List<Tag> getBooktag() {
        return booktag;
    }

    public void setBooktag(List<Tag> booktag) {
        this.booktag = booktag;
    }

    public List<Genre> getBookgenre() {
        return bookgenre;
    }

    public void setBookgenre(List<Genre> bookgenre) {
        this.bookgenre = bookgenre;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
