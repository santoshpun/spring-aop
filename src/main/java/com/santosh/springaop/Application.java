package com.santosh.springaop;

import com.santosh.springaop.manager.LoginManager;
import com.santosh.springaop.manager.ShapeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ShapeManager shapeManager;
    @Autowired
    private LoginManager loginManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //shapeManager.perform();

       // loginManager.setParameters("santosh","pass");
        loginManager.validate();
       // loginManager.doLogin();
    }
}
