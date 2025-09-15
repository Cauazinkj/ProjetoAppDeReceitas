package com.cauapaula.receitas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class RecipesApplication implements CommandLineRunner {

    private final DataSource dataSource;

    public RecipesApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Iniciando verificação de conexão com o banco...");

        try (Connection conn = dataSource.getConnection()) {
            System.out.println("Conexão com banco funcionando! URL: " + conn.getMetaData().getURL());

            // Consulta genérica de versão do PostgreSQL
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT version()");
                if (rs.next()) {
                    System.out.println("Versão do PostgreSQL: " + rs.getString(1));
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao conectar no banco: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Verificação de conexão concluída.");
    }
}
