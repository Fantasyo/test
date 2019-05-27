package cn.com.colibri.itsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("cn.com.colibri.itsystem.dao")
public class ItSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItSystemApplication.class, args);
    }

}
