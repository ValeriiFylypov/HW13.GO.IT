package org.homeWork13.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.homeWork13.tamplates.post.*;
import org.homeWork13.tamplates.todo.Todo;
import org.homeWork13.tamplates.users.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class HTTPMethodsPractice {
    private static final String URL = "https://jsonplaceholder.typicode.com";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json; charset=UTF-8";
    private static Geo newGeo = new Geo("49.130086", "9.216551");
    private static Address newAddress = new Address("Friedhofstrasse", "666", "Heilbro", "72314", newGeo);
    private static Company newCompany = new Company("Profitable company", "Proactive didactic contingency",
            "harness real-time e-commerz");
    private static User newUser = new User(20, "Valera", "Valerka", "fylypoovalerii@punkt.com", newAddress,
            "+4904477000000", "morgen.de", newCompany);


    // Task 1
    public static User createUser() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users"))
                .header(CONTENT_TYPE, JSON)
                .POST(HttpRequest.BodyPublishers
                        .ofString(GSON.toJson(newUser))).build();
        return getResponse(request);
    }

    public static User updateUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .PUT(HttpRequest.BodyPublishers
                        .ofString(GSON.toJson(newUser))).build();
        return getResponse(request);
    }

    public static int deleteUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON).DELETE().build();
        return getStatusCode(request);
    }

    private static int getStatusCode(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    private static User getResponse(HttpRequest request) throws IOException, InterruptedException {
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static Collection<User> getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        Type collectionType = new TypeToken<Collection<User>>() {
        }.getType();
        return GSON.fromJson(response.body(), collectionType);
    }

    public static User getUserById(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static List<User> getUserByUserName(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users?username=" + userName))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        Type listType = new TypeToken<List<User>>() {}.getType();
        return GSON.fromJson(response.body(), listType);
    }

    // Task 2

    public static void createJsonWithAllCommentsFromLastPostByUserId(int userId) throws IOException, InterruptedException {
        int postId = getIdOfTheLastUserPost(userId);
        String fileName = String.format("user-%s-post-%s-comments.json", userId, postId);
        createJsonWithName(fileName, getAllCommentForPost(postId));
    }

    private static List<Comment> getAllCommentForPost(int postId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/posts/" + postId + "/comments"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        Comment[] result = GSON.fromJson(response.body(), Comment[].class);
        return Arrays.asList(result);
    }

    private static int getIdOfTheLastUserPost(int userId) throws IOException, InterruptedException {
        Post[] result = getAllUsersPost(userId);
        return Arrays.stream(result)
                .map(Post::getId)
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    private static Post[] getAllUsersPost(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId + "/posts"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), Post[].class);
    }

    private static void createJsonWithName(String fileName, List items) throws IOException, InterruptedException {
        String jsonFilePath = "src/main/" + fileName;
        createJsonFile(jsonFilePath, items);
        System.out.println("File is successfully created. Please check this out---> Path: " + jsonFilePath);
    }

    private static void createJsonFile(String jsonFilePath, List items) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(items);
        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    // Task 3

    public static Collection<Todo> getOpenTodos(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId + "/todos?completed=false"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), new TypeToken<Collection<Todo>>(){}.getType());
    }

}

