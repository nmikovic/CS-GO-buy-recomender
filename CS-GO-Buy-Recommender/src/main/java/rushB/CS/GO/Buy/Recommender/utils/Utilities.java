package rushB.CS.GO.Buy.Recommender.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.maven.shared.invoker.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.ArmamentType;
import rushB.CS.GO.Buy.Recommender.facts.Side;
import rushB.CS.GO.Buy.Recommender.facts.Weapon;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class Utilities {
    @Bean
    public HashMap<String, Armament> armaments() {
        return this.loadArmament("../CS-GO-Buy-Recommender/src/main/resources/data/armament.csv");
    }


    private HashMap<String, Armament> loadArmament(String path) {
        HashMap<String, Armament> armaments = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
            CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();// skips header
            Iterable<CSVRecord> records = format.parse(reader);

            for (CSVRecord record : records) {
                // NAME,TYPE,PRICE,KILL BONUS,SIDE,SCOPE,HS
                if ((ArmamentType.GRENADE.toString().equals(record.get(1).toUpperCase())) ||
                        ArmamentType.EQUIPMENT.toString().equals(record.get(1).toUpperCase())) {
                    Armament a = new Armament(record.get(0),
                            Integer.parseInt(record.get(2)),
                            ArmamentType.valueOf(record.get(1).toUpperCase()),
                            Side.valueOf(record.get(4))
                    );
                    armaments.put(a.getName(), a);
                } else {
                    Weapon w = new Weapon(record.get(0),
                            Integer.parseInt(record.get(2)),
                            ArmamentType.valueOf(record.get(1).toUpperCase()),
                            Side.valueOf(record.get(4)),
                            Boolean.parseBoolean(record.get(5)),
                            Integer.parseInt(record.get(3)),
                            Boolean.parseBoolean(record.get(6)));
                    armaments.put(w.getName(), w);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return armaments;
    }

    public static void mavenCleanAndInstall() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("../Rules/pom.xml"));
        request.setGoals(Arrays.asList("clean", "install"));

        Invoker invoker = new DefaultInvoker();
        invoker.execute(request);
    }

}
