package exercise2_basic2_Java.problem2.library;


import exercise2_basic2_Java.problem2.bookManagement.BookManagerImpl;

public class Main {
    public static void main(String... a){
        BookManagerImpl bookManager = new BookManagerImpl();

        // task 2.d
        //create 2 two author
        //call searchAuthors with different values for search, and output the results.
        bookManager.createAuthor("Nazmos","sakib");
        bookManager.createAuthor("sag","zig");
        bookManager.createAuthor("Jane", "Doe");
        bookManager.createAuthor("Peter", "Miller");

        //search author return List
        bookManager.searchAuthor("zig").forEach((x)->{
            System.out.println(x.toString());
        });


        //search author return List
        bookManager.searchAuthor("e").forEach((x)->{
            System.out.println(x.toString());
        });
        bookManager.searchAuthor("o").forEach((x)->{
            System.out.println(x.toString());
        });


        //task 2.e
        //create some books, search for them, and output the results.
        bookManager.createBook("Distributed Systems", bookManager.searchAuthor("o"));
        bookManager.createBook("Web Applications", bookManager.searchAuthor("e"));

        bookManager.searchBook("Dist").forEach((x)->{
            System.out.println(x.toString());
        });

        bookManager.searchBook("e").forEach((x)->{
            System.out.println(x.toString());
        });

    }

}
