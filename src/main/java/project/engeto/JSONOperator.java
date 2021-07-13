package project.engeto;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSONOperator
{
    private static final String CONNECTION_ADDRESS = "https://euvatrates.com/rates.json";

    private String jsonFile;

    public JSONOperator()
    {
        this.jsonFile = "";
    }

    public String getJsonFile()
    {
        return jsonFile;
    }

    public MajorObjects acquireJsonFile()
    {
        MajorObjects majorObjects = new MajorObjects();

        try
        {
            URL url = new URL(CONNECTION_ADDRESS);
            URLConnection connection = url.openConnection();
            connection.connect();

            ObjectMapper objectMapper = new ObjectMapper();

            majorObjects = objectMapper.readValue(url, MajorObjects.class);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return majorObjects;
    }

    public List<String> getMaxThreeValues(MajorObjects majorObjects)
    {
        List<String> listOfMaxRate = majorObjects.getRates().entrySet().stream().sorted(Map.Entry.<String, State>comparingByValue().reversed()).
                limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

        return listOfMaxRate;
    }

    public List<String> getMinThreeValues(MajorObjects majorObjects)
    {
        List<String> listOfMinrate = majorObjects.getRates().entrySet().stream().sorted(Map.Entry.<String, State>comparingByValue()).limit(3).
                map(Map.Entry::getKey).collect(Collectors.toList());

        return listOfMinrate;
    }

    public Float getStateRate(MajorObjects majorObjects, String shortcut)
    {
        return majorObjects.getRates().get(shortcut).getStandardRate();
    }
}
