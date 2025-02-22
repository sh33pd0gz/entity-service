package com.sh33pd0gz.entity_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EntityServiceApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(EntityServiceApplication.class, args);
  }

  @Autowired JdbcTemplate jdbcTemplate;

  @Override
  public void run(String... strings) throws Exception {
    System.out.println(jdbcTemplate);
  }
}
