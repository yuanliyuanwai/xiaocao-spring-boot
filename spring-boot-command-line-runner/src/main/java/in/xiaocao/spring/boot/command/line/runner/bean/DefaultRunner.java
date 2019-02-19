package in.xiaocao.spring.boot.command.line.runner.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner start to initialize ...");
    }
}