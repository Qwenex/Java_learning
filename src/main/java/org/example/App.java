package org.example;

import org.example.repository.EquationSolvedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class App {
    public static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    SqlDataSourceScriptDatabaseInitializer scriptInitDB
            (DataSource dataSource, SqlInitializationProperties properties, EquationSolvedRepository equationSolvedRepository) {
        return new SqlDataSourceScriptDatabaseInitializer(dataSource, properties) {
            @Override
            public boolean initializeDatabase() {
                if (equationSolvedRepository.count() == 0L) {
                    return super.initializeDatabase();
                }
                return false;
            }
        };
    }
}