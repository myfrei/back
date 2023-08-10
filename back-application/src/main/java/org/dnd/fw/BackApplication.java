package org.dnd.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "org.dnd")
public class BackApplication {
    public static void main(String[] args) { SpringApplication.run(BackApplication.class, args);
    }
}
