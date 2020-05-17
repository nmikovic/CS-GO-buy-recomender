package rushB.CS.GO.Buy.Recommender.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.ArmamentType;
import rushB.CS.GO.Buy.Recommender.facts.Side;
import rushB.CS.GO.Buy.Recommender.facts.Weapon;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Utilities {

    public static ArrayList<Armament> loadArmament(String path) {
        ArrayList<Armament> armaments = new ArrayList<>();
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
                    armaments.add(a);
                } else {
                    Weapon w = new Weapon(record.get(0),
                            Integer.parseInt(record.get(2)),
                            ArmamentType.valueOf(record.get(1).toUpperCase()),
                            Side.valueOf(record.get(4)),
                            Boolean.parseBoolean(record.get(5)),
                            Integer.parseInt(record.get(3)),
                            Boolean.parseBoolean(record.get(6)));
                    armaments.add(w);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return armaments;
    }

}
