package joao.faria.uolhostbackend.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class NicknameService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    private List<String> avengersNicknameList = new ArrayList<>();

    private List<String> justiceLeagueList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadJsonData() {
        try {
            String nicknameResponse = restTemplate.getForObject(environment.getProperty("avengers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(nicknameResponse);

            ArrayNode avengers = (ArrayNode) jsonNode.get("vingadores");

            for (JsonNode item: avengers) {
                this.avengersNicknameList.add(item.get("codinome").asText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(environment.getProperty("justice.league"));

            NodeList nicknameList = document.getElementsByTagName("codinome");

            for (int i = 0; i < nicknameList.getLength(); i++) {
                Element nicknameElement = (Element) nicknameList.item(i);
                String nickname = nicknameElement.getTextContent();
                this.justiceLeagueList.add(nickname);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
