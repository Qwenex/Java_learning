package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import org.example.mappingTest.PersonIn;
import org.example.mappingTest.PersonMapper;
import org.example.mappingTest.PersonOut;
import org.example.parsingTest.Book;
import org.example.serializationTest.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1. Mapping
        logger.info("Задание 1. Mapping (mapStruct)");

        PersonOut personOut = new PersonOut("Иван", "Иванов", "Иванович",
                LocalDate.of(2000, 1, 1));
        logger.info("PersonOUT: {}", personOut);

        PersonIn personIn = PersonMapper.INSTANCE.toPersonIn(personOut);
        logger.info("PersonIN: {}", personIn);

        // Задание 2. Parsing
        logger.info("2.1 Data Binding Parsing:");

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Book> books = mapper.readValue(new File(PropertyConfig.getProperty("jsonRoot.properties", "booksList")),
                    mapper.getTypeFactory().constructCollectionType(List.class, Book.class));

            logger.info(books.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("2.2 Tree model Parsing:");

        try {
            JsonNode rootNode = mapper.readTree(new File(PropertyConfig.getProperty("jsonRoot.properties", "booksList")));

            for (JsonNode bookNode : rootNode) {
                String title = bookNode.get("title").asText();
                String author = bookNode.get("author").asText();
                Integer year = bookNode.get("year").asInt();
                logger.info("Тайтл: {}, Автор: {}, Год: {}", title, author, year);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("2.3 JsonPath Parsing:");

        try {
            String jsonPath = new String(Files.readAllBytes(new File(PropertyConfig.getProperty("jsonRoot.properties", "booksList")).toPath()));

            List<String> titles = JsonPath.read(jsonPath, "$[*].title");
            List<String> authors = JsonPath.read(jsonPath, "$[*].author");
            List<String> genre = JsonPath.read(jsonPath, "$[*].genre");
            Set<String> uniqueGenres = new HashSet<>(genre);
            Set<String> uniqueAuthors = new HashSet<>(authors);
            logger.info("\nВсе названия книг:{} \nВсе уникальные авторы:{} \nВсе уникальные жанры: {}", titles, uniqueAuthors, uniqueGenres);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("2.4 Stream API Parsing");

        JsonFactory factory = new JsonFactory();
        List<Book> books = new ArrayList<>();

        try (JsonParser parser = factory.createParser(new File(PropertyConfig.getProperty("jsonRoot.properties", "booksList")))) {

            Book currentBook = null;
            String currentField = null;

            while (parser.nextToken() != null) {
                JsonToken token = parser.currentToken();

                if (token == JsonToken.START_OBJECT) {
                    currentBook = new Book();

                } else if (token == JsonToken.END_OBJECT) {
                    books.add(currentBook);
                    currentBook = null;

                } else if (token == JsonToken.FIELD_NAME) {
                    currentField = parser.getCurrentName();

                } else if (currentBook != null) {

                    switch (currentField) {
                        case "title":
                            currentBook.setTitle(parser.getValueAsString());
                            break;
                        case "author":
                            currentBook.setAuthor(parser.getValueAsString());
                            break;
                        case "year":
                            currentBook.setYear(parser.getIntValue());
                            break;
                        case "genre":
                            currentBook.setGenre(parser.getValueAsString());
                            break;
                        case "price":
                            currentBook.setPrice(parser.getDoubleValue());
                            break;
                    }
                }
            }

            logger.info("Количество книг: {}, {}", books.size(), books);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Задание 3. Object serialization
        logger.info("Задание 3 Object serialization ");

        User user981378 = new User(981378, "The_Werewolf_13", "Adm1nPa55w0rd", LocalDate.of(2016, 6, 23), true);
        logger.info("Исходный объект до сериализации: {}", user981378);

        // Сериализация объекта в файл
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/user.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(user981378);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Десериализация объекта из файла
        try (FileInputStream fis = new FileInputStream("src/main/resources/user.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            User restoredUser = (User) ois.readObject();
            logger.info("Востановленный объект после десериализации: {}", restoredUser);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}