package rushB.CS.GO.Buy.Recommender.services;

import org.apache.commons.io.FileUtils;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.drools.core.io.impl.ReaderResource;
import org.drools.verifier.Verifier;
import org.drools.verifier.builder.VerifierBuilder;
import org.drools.verifier.builder.VerifierBuilderFactory;
import org.kie.api.io.ResourceType;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.RulesDTO;
import rushB.CS.GO.Buy.Recommender.exceptions.RulesException;
import rushB.CS.GO.Buy.Recommender.utils.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public ArrayList<String> getFactClasses() {
        Reflections reflections = new Reflections("rushB.CS.GO.Buy.Recommender.facts", new SubTypesScanner(false));

        ArrayList<String> types = (ArrayList<String>) reflections.getSubTypesOf(Object.class).stream()
                .map(c -> c.getName().replace("rushB.CS.GO.Buy.Recommender.facts.", "")).collect(Collectors.toList());
        types.addAll(reflections.getSubTypesOf(Enum.class).stream()
                .map(e -> e.getName().replace("rushB.CS.GO.Buy.Recommender.facts.", "")).collect(Collectors.toList()));

        return types;
    }

    public String getFactContent(String name) throws IOException {
        File f = new File("../CS-GO-Buy-Recommender/src/main/java/rushB/CS/GO/Buy/Recommender/facts/" + name + ".java");

        return FileUtils.readFileToString(f, StandardCharsets.UTF_8);
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
                "import rushB.CS.GO.Buy.Recommender.facts.*;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.List;\n" +
                "\n" +
                "global HashMap<String, Armament> armaments;";
    }
}
