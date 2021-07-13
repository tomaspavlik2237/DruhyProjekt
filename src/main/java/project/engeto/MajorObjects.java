package project.engeto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public class MajorObjects
{
    @JsonProperty("last_updated")
    private String lastUpdate;
    private String disclaimer;
    private HashMap<String, State> rates;

    @Override
    public String toString() {
        return "MajorObjects{" +
                "lastUpdate='" + lastUpdate + '\'' + "\n" +
                ", disclaimer='" + disclaimer + '\'' + "\n" +
                ", rates=" +'\''+ rates + '\'' +
                '}';
    }
}
