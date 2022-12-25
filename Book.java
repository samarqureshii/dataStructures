/*
* This program stores relevant information regarding each Book object in the LinkedLists structure, with the
*appropriate modifier and accessor methods
*Name: Samar Qureshi
*Date: Dec 25/2021
Course: ICS4U
*/

package com.company.dataStructure;

public class Book { 
    private String bookTitle;
    private int yearPublished;

    public Book(){
        //constructor with general intial information regarding the Book, such as title and year published
        yearPublished = 0;
        bookTitle = "";
    }

    public Book(int y, String t){ //allows instance vars to be set immediately
        //over loaded constructor with general intial information regarding the Book, such as title and year published
        yearPublished = y;
        bookTitle = t;
    }

    /*
    * Modifier method that sets the title of the book
    *Pre: nothing
    *Post: new book title
    */
    public void setTitle(String newTitle){
        bookTitle = newTitle;
    }

    /*
    * Acessor method that returns the title of the book
    */
    public String getTitle(){
        return bookTitle;
    }

    /*
    * Modifier method that sets the year of publication for the given book
    *Pre: nothing
    *Post: new book year of publication
    */
    public void setYear(int newYear){
        yearPublished = newYear;
    }

    /*
    * Acessor method that returns the year of publication of the given book
    */
    public int getYear(){
        return yearPublished;
    }

    /*
    *toString method that displays info for a book
    *Pre: nothing
    *Post: Displays information of a given book, such as title and year published
    */
    public String toString(){
        return "\n\nBook title: " + bookTitle + "\nYear of publication: " + yearPublished;
    }
    
    /*
    * Determines if two Book objects are equal to one another 
    *Pre: nothing
    *Post: returns boolean based on relation of the book
    */
    public boolean equals(Book book1){
        if(bookTitle.equals(book1.getTitle()) && yearPublished == book1.getYear()){
            return true;
        }
        
        return false;

    }
    
}
