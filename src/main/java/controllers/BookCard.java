package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Book;

public class BookCard {

    // importing fields from the fxml view
    @FXML
    private ImageView bookImage;
    @FXML
    private Label bookTitle, bookAuthor;

    // populating the book card
    public void setBookCard(Book book, Image image) {
        bookImage.setImage(image);
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
    }

    // populating the book card (if image isn't available)
    public void setBookCard(Book book) {
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
    }
}
