package xml;

import org.springframework.context.annotation.Bean;

public class DevelopConfig {
    @Bean

    public Developer getDeveloper(){
        Developer developer = new Developer();
        developer.setId(1);
        developer.setName("Hai");
        developer.setMajor("Ok");

        return developer;
    }
}
