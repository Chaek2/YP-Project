package com.example.yp.Controllers;


import com.example.yp.Models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatusCode;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Server {
    static String http_request = "http://localhost:456/api/";
    static private ObjectMapper objectMapper = new ObjectMapper();
    static private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public Object GetAll(TABLE table) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(http_request + table.toString()))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (table) {
                case client -> {
                    List<Client> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case tag -> {
                    List<Tag> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case book -> {
                    List<Book> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case role -> {
                    List<Role> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case genre -> {
                    List<Genre> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case liked -> {
                    List<Liked> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case booktag -> {
                    List<BookTag> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case history -> {
                    List<History> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case bookgenre -> {
                    List<BookGenre> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case booksimilar -> {
                    List<BookSimilar> classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Object GetByID(TABLE table, int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(http_request + table.toString() + "/" + String.valueOf(id)))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (table) {
                case client -> {
                    Client classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case tag -> {
                    Tag classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case book -> {
                    Book classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case role -> {
                    Role classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case genre -> {
                    Genre classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case liked -> {
                    Liked classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case booktag -> {
                    BookTag classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case history -> {
                    History classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case bookgenre -> {
                    BookGenre classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
                case booksimilar -> {
                    BookSimilar classes = objectMapper.readValue(response.body(), new TypeReference<>() {
                    });
                    return classes;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Client GetByUsername(String username) {
        List<Client> clients = (List<Client>) GetAll(TABLE.client);
        for (Client cli: clients) {
            if(cli.getUsername().equals(username)){
                return cli;
            }
        }
        return null;
    }
    public int Post(TABLE table, ArrayList arrayList) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(http_request + table.toString()))
                .POST(HttpRequest.BodyPublishers.ofString(JsonConvertorPost(table,arrayList,0)))
                .build();
        int complite = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
        System.out.println(complite);
        return complite;
    }
    public int Put(TABLE table, ArrayList arrayList) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(http_request + table.toString()))
                .PUT(HttpRequest.BodyPublishers.ofString(JsonConvertorPost(table,arrayList,1)))
                .build();
        int complite = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
        System.out.println(complite);
        return complite;
    }
    public int Delete(TABLE table, int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(http_request + table.toString()+"?id="+String.valueOf(id)))
                .DELETE()
                .build();
        int complite = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
        System.out.println(complite);
        return complite;
    }
    private String JsonConvertorPost(TABLE table, ArrayList arrayList, int metod){

        String json = "{ ";
        switch (table) {
            case client -> {
                if (metod == 1){
                    json+= "\"idClient\":"+arrayList.get(4)+", ";
                }
                //role, username, password
                json+=  "\"role\":{" +
                        "\"idRole\":"+arrayList.get(0)+", " +
                        "\"title\":\""+arrayList.get(1)+"\""+
                        "}," +
                        "\"username\":\""+arrayList.get(2)+"\", " +
                        "\"password\":\""+arrayList.get(3)+"\"";
            }
            case tag -> {
                if (metod == 1){
                    json+= "\"idTag\":"+arrayList.get(1)+", ";
                }
                //title
                json+=  "\"title\":\""+arrayList.get(0)+"\"";
            }
            case book -> {
                if (metod == 1){
                    json+= "\"idBook\":"+arrayList.get(6)+", ";
                }
                //title, image, summary, txt, author, yearOfPublication
                json+=  "\"title\":\""+arrayList.get(0)+"\",\n" +
                        "\"image\":\""+arrayList.get(1)+"\",\n" +
                        "\"summary\":\""+arrayList.get(2)+"\",\n" +
                        "\"txt\":\""+arrayList.get(3)+"\",\n" +
                        "\"author\":\""+arrayList.get(4)+"\",\n" +
                        "\"yearOfPublication\":\""+arrayList.get(5)+"\"";
            }
            case role -> {
                if (metod == 1){
                    json+= "\"idRole\":"+arrayList.get(1)+", ";
                }
                //title
                json+=  "\"title\":\""+arrayList.get(0)+"\"";
            }
            case genre -> {
                if (metod == 1){
                    json+= "\"idGenre\":"+arrayList.get(1)+", ";
                }
                //title
                json+=  "\"title\":\""+arrayList.get(0)+"\"";
            }
            case liked -> {
                if (metod == 1){
                    json+= "\"idLiked\":"+arrayList.get(2)+", ";
                }
                //book, client
                json+=  "\"book\":"+arrayList.get(0)+",\n" +
                        "\"client\":"+arrayList.get(1);
            }
            case booktag -> {
                if (metod == 1){
                    json+= "\"idBookTag\":"+arrayList.get(2)+", ";
                }
                //book, tag
                json+=  "\"book\":"+arrayList.get(0)+",\n" +
                        "\"tag\":"+arrayList.get(1);
            }
            case history -> {
                if (metod == 1){
                    json+= "\"idHistory\":"+arrayList.get(2)+", ";
                }
                //book, client
                json+=  "\"book\":"+arrayList.get(0)+",\n" +
                        "\"client\":"+arrayList.get(1);
            }
            case bookgenre -> {
                if (metod == 1){
                    json+= "\"idBookGenre\":"+arrayList.get(2)+", ";
                }
                //book, genre
                json+=  "\"book\":"+arrayList.get(0)+",\n" +
                        "\"genre\":"+arrayList.get(1);
            }
            case booksimilar -> {
                if (metod == 1){
                    json+= "\"idBookSimilar\":"+arrayList.get(2)+", ";
                }
                //book, similar
                json+=  "\"book\":"+arrayList.get(0)+",\n" +
                        "\"similar\":"+arrayList.get(1);
            }
        }
        json +=" }";
        System.out.println(json);
        return json;
    }
}
