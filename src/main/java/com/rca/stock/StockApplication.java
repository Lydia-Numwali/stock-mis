package com.rca.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.rca.stock.repo.*;
import com.rca.stock.models.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository,
                                        CategoryRepository categoryRepository,
                                        OrdersRepository ordersRepository,
                                        ReviewsRepository reviewsRepository,
                                        ProductRepository productRepository,
                                        UserRepository userRepository) {
        return args -> {
            runInteractiveConsole(personRepository, categoryRepository, ordersRepository, reviewsRepository, productRepository, userRepository);
        };
    }

    private void runInteractiveConsole(PersonRepository personRepository,
                                       CategoryRepository categoryRepository,
                                       OrdersRepository ordersRepository,
                                       ReviewsRepository reviewsRepository,
                                       ProductRepository productRepository,
                                       UserRepository userRepository) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            int choice = getValidIntegerInput(scanner);

            switch (choice) {
                case 1:
                    createData(personRepository, categoryRepository, ordersRepository, reviewsRepository, productRepository, userRepository);
                    break;
                case 2:
                    readData(personRepository, categoryRepository, ordersRepository, reviewsRepository, productRepository, userRepository);
                    break;
                case 3:
                    // Implement update functionality if needed
                    System.out.println("Update functionality is not implemented yet.");
                    break;
                case 4:
                    deleteData(personRepository, categoryRepository, ordersRepository, reviewsRepository, productRepository, userRepository);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0); // Terminate the application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getValidIntegerInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
            }
        }
    }

    private void createData(PersonRepository personRepository,
                            CategoryRepository categoryRepository,
                            OrdersRepository ordersRepository,
                            ReviewsRepository reviewsRepository,
                            ProductRepository productRepository,
                            UserRepository userRepository) {
        Person p1 = new Person("John", "MUHIRE", "johnmuhire@gmail.com");
        Person p2 = new Person("Peter", "KALISA", "kalisapeter@gmail.com");
        Contacts contact3 = new Contacts("johdoe@gmail.com", "0781677777");
        Contacts contact2 = new Contacts("singizwa@gmail.com", "4567890987");
        Contacts contact1 = new Contacts("ellapa@gmail.com", "9876543435");
        User user1 = new User("John Doe", contact3);
        User user2 = new User("Pacis Ellapa", contact1);
        User user3 = new User("Hope Singizwa", contact2);
        Category category1 = new Category("Electronics");
        Category category2 = new Category("Accessories");
        Category category3 = new Category("Clothing");
        Product product1 = new Product("Camera", 50000, category2);
        Product product2 = new Product("Book", 70000, category3);
        Product product3 = new Product("Laptop", 5000000, category1);
        Reviews Review1 = new Reviews("Great Product! Highly recommended!", product1, user3);
        Reviews Review2 = new Reviews("High quality product! Highly recommended!", product2, user1);
        Reviews Review3 = new Reviews("Amazing Product! Highly recommended!", product3, user2);
        List<Product> productList1 = Arrays.asList(product1, product2);
        List<Product> productList2 = Arrays.asList(product3, product2);
        List<Product> productList3 = Arrays.asList(product1, product3);
        Orders order1 = new Orders(user1, productList1, LocalDateTime.now());
        Orders order2 = new Orders(user2, productList2, LocalDateTime.now());
        Orders order3 = new Orders(user3, productList3, LocalDateTime.now());
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3));
        reviewsRepository.saveAll(Arrays.asList(Review1, Review2, Review3));
        ordersRepository.saveAll(Arrays.asList(order1, order2, order3));
        personRepository.saveAll(Arrays.asList(p1, p2));
        System.out.println("Data created successfully.");
    }

    private void readData(PersonRepository personRepository,
                          CategoryRepository categoryRepository,
                          OrdersRepository ordersRepository,
                          ReviewsRepository reviewsRepository,
                          ProductRepository productRepository,
                          UserRepository userRepository) {
        System.out.println("Persons:");
        personRepository.findAll().forEach(System.out::println);
        System.out.println("Categories:");
        categoryRepository.findAll().forEach(System.out::println);
        System.out.println("Orders:");
        ordersRepository.findAll().forEach(System.out::println);
        System.out.println("Reviews:");
        reviewsRepository.findAll().forEach(System.out::println);
        System.out.println("Products:");
        productRepository.findAll().forEach(System.out::println);
        System.out.println("Users:");
        userRepository.findAll().forEach(System.out::println);
    }

    private void deleteData(PersonRepository personRepository,
                            CategoryRepository categoryRepository,
                            OrdersRepository ordersRepository,
                            ReviewsRepository reviewsRepository,
                            ProductRepository productRepository,
                            UserRepository userRepository) {
        ordersRepository.deleteAll();
        reviewsRepository.deleteAll();
        productRepository.deleteAll();
        userRepository.deleteAll();
        categoryRepository.deleteAll();
        personRepository.deleteAll();
        System.out.println("All data deleted successfully.");
    }

}
