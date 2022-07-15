/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;

import Information.book;
import Validation.inputValidation;

/**
 *
 * @author admin
 */
public class menuFunction {
    public static ArrayList<book> books = new ArrayList<>();
    public static file file = new file();

    public static void addBook() {
        book listBook = new book();
        System.out.println("Enter code: ");
        listBook.setCode(inputValidation.string());
        if (getTittlebookbycode(listBook.getCode()) == null) {
            System.out.println("Enter title: ");
            listBook.setTitle(inputValidation.string());
        } else {
            System.out.println("Book Title " + getTittlebookbycode(listBook.getCode()));
            listBook.setTitle(getTittlebookbycode(listBook.getCode()));
        }
        System.out.println("Enter quantity: ");
        listBook.setQua(inputValidation.Int());
        System.out.println("Enter price: ");
        listBook.setPrice(inputValidation.Int());
        books.add(listBook);
    }

    public static book searchbycode(String Code) {
        for (book listBook : books) {
            if (listBook.getCode().equals(Code)) {
                return listBook;
            }
        }
        return null;
    }

    public static void showBook() {
        int index = 0;
        for (book listBook : books) {
            System.out.println("[" + index + "] " + listBook.toString());
            index++;
        }
    }

    public static void addmanyBook() {
        System.out.println("Enter number of book you want to add: ");
        int number = inputValidation.Int();
        for (int i = 0; i < number; i++) {
            System.out.println("Book " + (i + 1) + ": ");
            addBook();
        }
    }

    public static String getTittlebookbycode(String Code) {
        for (book book : books) {
            if (book.getCode() == Code) {
                return book.getTitle();
            }
        }
        return null;
    }

    // update quantity of books
    public static void updateBook() {
        System.out.println("Enter code of book you want to update: ");
        String code = inputValidation.string();
        book listBook = searchbycode(code);
        if (listBook != null) {
            System.out.println("Enter new quantity: ");
            listBook.setQua(inputValidation.Int());
        } else {
            System.out.println("Book not found");
        }
    }

    // Find the (first) max price value.
    public static double maxPrice() {
        double max = 0;
        for (book listBook : books) {
            if (listBook.getPrice() > max) {
                max = listBook.getPrice();
            }
        }
        return max;
    }

    // Sort the list ascendingly by code
    public static void sortByCode() {
        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(i).getCode().compareTo(books.get(j).getCode()) > 0) {
                    book temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
    }
    // sort the list ascendingly by quantity
    public static void sortByQua() {
        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(i).getQua() > books.get(j).getQua()) {
                    book temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
    }
    //sort the list ascendingly by title
    public static void sortByTitle() {
        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {
                if (books.get(i).getTitle().compareTo(books.get(j).getTitle()) > 0) {
                    book temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
    }

    // remove book by code
    public static void removeBook() {
        System.out.println("Enter code of book you want to remove: ");
        String code = inputValidation.string();
        book listBook = searchbycode(code);
        if (listBook != null) {
            books.remove(listBook);
        } else {
            System.out.println("Book not found");
        }
    }

    // load data from file
    public static void loadData() {
        books.clear();
        String data = file.readFile("src\\Book.txt");
        String[] listBook = data.split("\n");
        for (String listBook1 : listBook) {
            String[] listBook2 = listBook1.split("|");
            book listBook3 = new book();
            listBook3.setCode(listBook2[0]);
            listBook3.setTitle(listBook2[2]);
            listBook3.setQua(Integer.parseInt(listBook2[4]));
            listBook3.setPrice(Integer.parseInt(listBook2[6]));
            books.add(listBook3);
        }
    }

    // save data to file
    public static void saveData() {
        String data = "";
        for (book listBook : books) {
            data += listBook.toString() + "\n";
        }
        file.writeFile("src\\Book.txt", data);
    }


    public static void Test() {
        // load data from file Book.txt and display
        loadData();
        showBook();
        // Sort by title and display
        sortByTitle();
        showBook();
        // sort by quantity and display
        sortByQua();
        showBook();
        // change max price to 99 and display
        books.get(0).setPrice(99);
        showBook();
        
    }

    public static void changeMaxPrice(int i) {
        double maxPrice = books.get(0).getPrice();
        book bookPos = books.get(0);

        for (book listBook : books) {
            if (listBook.getPrice() > maxPrice) {
                maxPrice = listBook.getPrice();
                bookPos = listBook;
            }
        }

        bookPos.setPrice(i);

    }
}
