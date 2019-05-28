package cn.com.colibri.itsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.colibri.itsystem.dao")
public class ItSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItSystemApplication.class, args);
    }

}
