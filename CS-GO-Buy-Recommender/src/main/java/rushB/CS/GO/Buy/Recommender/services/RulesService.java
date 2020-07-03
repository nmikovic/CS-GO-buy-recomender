package rushB.CS.GO.Buy.Recommender.services;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.drools.core.io.impl.ReaderResource;
import org.drools.verifier.Verifier;
import org.drools.verifier.builder.VerifierBuilder;
import org.drools.verifier.builder.VerifierBuilderFactory;
import org.kie.api.io.ResourceType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.RulesDTO;
import rushB.CS.GO.Buy.Recommender.exceptions.RulesException;
import rushB.CS.GO.Buy.Recommender.utils.Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class RulesService {
    @Value("${rules.package.path}")
    private String rulesPackagePath;


    public Object createRules(RulesDTO rules) throws RulesException, IOException, MavenInvocationException {
        VerifierBuilder verifierBuilder = VerifierBuilderFactory.newVerifierBuilder();
        Verifier verifier = verifierBuilder.newVerifier();

        StringBuilder builder = new StringBuilder(returnImportsAndGlobals());
        builder.append("\n");
        builder.append(rules.getRules());

        if (!verifyRules(builder.toString(), verifier))
            throw new RulesException("Invalid rules format");

        verifier.dispose();

        String id = UUID.randomUUID().toString();

        FileWriter writer = new FileWriter(String.valueOf(Paths.get(rulesPackagePath, "Rules" + id + ".drl")));
        writer.write(builder.toString());
        writer.close();

        Utilities.mavenCleanAndInstall();
        return "Rules created";
    }

    private boolean verifyRules(String rules, Verifier verifier) {
        verifier.addResourcesToVerify(new ReaderResource(new StringReader(rules)), ResourceType.DRL);

        return verifier.getErrors().size() == 0;
    }

    private String returnImportsAndGlobals() {
        return "package rules;\n" +
                "dialect  \"java\"\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Armament;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.ArmamentType;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Side;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Player;\n" +
                "import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Player;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Rank;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Tactic;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.BuyOptions;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Map;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Round;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.PlayerStatus;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.List;\n" +
                "import java.util.ArrayList;\n" +
                "import rushB.CS.GO.Buy.Recommender.facts.Weapon;\n" +
                "\n" +
                "global HashMap<String, Armament> armaments;";
    }
}
