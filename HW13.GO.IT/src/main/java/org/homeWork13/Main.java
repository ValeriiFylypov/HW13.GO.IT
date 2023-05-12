package org.homeWork13;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.homeWork13.utils.HTTPMethodsPractice.*;

//@Data

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        System.out.println("\n   Task 1:  \n");
        System.out.println(createUser());
        System.out.println("  --------updated USER---------------------  ");
        System.out.println(updateUser(6));
        System.out.println("  -----------------delete USER--------------  ");
        System.out.println(deleteUser(3));
        System.out.println("  -------------------list of USERS-----  ");
        System.out.println(getAllUsers());
        System.out.println("  ----------------USER by id-----------------------  ");
        System.out.println(getUserById(7));
        System.out.println("  -----------------get USER by UserName----------------------  ");
        System.out.println(getUserByUserName("Kamren"));
        System.out.println("  ---------------------------------------  ");

        System.out.println("\n   Task 2:  \n");

        createJsonWithAllCommentsFromLastPostByUserId(2);
        System.out.println("  ---------------------------------------  ");


        System.out.println("\n   Task 3:  \n");
        System.out.println(getOpenTodos(7));

    }
}