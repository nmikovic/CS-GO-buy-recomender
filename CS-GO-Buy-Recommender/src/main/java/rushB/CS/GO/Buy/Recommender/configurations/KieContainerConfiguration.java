package rushB.CS.GO.Buy.Recommender.configurations;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rushB.CS.GO.Buy.Recommender.utils.Utilities;

@Configuration
public class KieContainerConfiguration {
    @Bean
    public KieContainer kieContainer() throws MavenInvocationException {
        Utilities.mavenCleanAndInstall();
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks
                .newKieContainer(ks.newReleaseId("rushB", "Rules", "1.0-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(3000);
        return kContainer;
    }
}
