package vn.edu.hust.soict.project.ops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"vn.edu.hust.soict.project.core"})
@ComponentScan(basePackages = {"vn.edu.hust.soict.project.adapter"})
public class OpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpsApplication.class, args);
    }

}
