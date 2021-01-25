package JdiHomework.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import JdiHomework.main.entities.MetalsAndColorsDataset;
import JdiHomework.main.entities.User;
import JdiHomework.main.utils.CredentialsManager;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static User ROMAN = new User().set(
            u -> {
                u.fullName = "Roman Iovlev";
                u.userName = CredentialsManager.getLogin(u.fullName);
                u.password = CredentialsManager.getPassword(u.fullName);
            });

    @DataProvider(name = "datasets")
    public Object[] parseDatasets() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/test/resources/JdiHomework/JDI_ex8_metalsColorsDataSet.json");

        List<MetalsAndColorsDataset> list = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(file);
            rootNode.iterator().forEachRemaining(jNode -> {
                try {
                    list.add(objectMapper.treeToValue(jNode, MetalsAndColorsDataset.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
            return list.toArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
