package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book classic = new Book("Мастер и Маргарита", 700);
        Book programmer = new Book("Clean Code", 1000);
        Book fantastic = new Book("Пикник на обочине", 200);
        Book nursery = new Book("Красная шапочка", 50);
        Book[] books = {classic, programmer, fantastic, nursery};
         for (int i = 0; i < books.length; i++) {
          Book book = books[i];
            System.out.println("Имя книги: "
                    + book.getName()
                    + ", количество страниц: "
                    + book.getPage());
        }
        Book temp = books[0];
        books[0] = books[2];
        books[2] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Имя книги: "
                    + book.getName() + ", количество страниц: " + book.getPage());
        }

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.equals("Clean Code")) {
                System.out.println("Имя книги: " + book.getName()
                        + ", количество страниц: " + book.getPage());
            }
        }
    }
}
