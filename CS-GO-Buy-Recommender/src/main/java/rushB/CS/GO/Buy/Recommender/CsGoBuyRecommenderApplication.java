package rushB.CS.GO.Buy.Recommender;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rushB.CS.GO.Buy.Recommender.services.TestService;

@SpringBootApplication
public class CsGoBuyRecommenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsGoBuyRecommenderApplication.class, args);
    }

    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }
}
