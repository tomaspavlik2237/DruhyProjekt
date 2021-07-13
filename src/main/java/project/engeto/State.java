package project.engeto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class State implements Comparable<State> {
    @JsonProperty("_comment")
    private String comment;
    @JsonAlias({"iso_duplicate_of", "iso_duplicate"})
    private String isoDuplicateOf;
    private String country;
    @JsonProperty("standard_rate")
    private Float standardRate;
    @JsonProperty("reduced_rate")
    private Float reducedRate;
    @JsonProperty("reduced_rate_alt")
    private Float reducedRateAlt;
    @JsonProperty("super_reduced_rate")
    private Float superReducedRate;
    @JsonProperty("parking_rate")
    private Float parkingRate;

    public void setStandardRate(String standardRate) {
        if(!standardRate.contains("false")) this.standardRate = Float.parseFloat(standardRate);
    }

    public void setReducedRate(String reducedRate) {
        if(!reducedRate.contains("false")) this.reducedRate = Float.parseFloat(reducedRate);
    }

    public void setReducedRateAlt(String reducedRateAlt) {
        if(!reducedRateAlt.contains("false")) this.reducedRateAlt = Float.parseFloat(reducedRateAlt);
    }

    public void setSuperReducedRate(String superReducedRate) {
        if(!superReducedRate.contains("false")) this.superReducedRate = Float.parseFloat(superReducedRate);
    }

    public void setParkingRate(String parkingRate) {
        if(!parkingRate.contains("false")) this.parkingRate = Float.parseFloat(parkingRate);
    }

    @Override
    public String toString() {
        return "State{" +
                "comment='" + comment + '\'' +
                ", isoDuplicateOf='" + isoDuplicateOf + '\'' +
                ", country='" + country + '\'' +
                ", standardRate=" + standardRate +
                ", reducedRate=" + reducedRate +
                ", reducedRateAlt=" + reducedRateAlt +
                ", superReducedRate=" + superReducedRate +
                ", parkingRate=" + parkingRate +
                '}' + "\n";
    }

    @Override
    public int compareTo(State state) {
        return standardRate.compareTo(state.standardRate);
    }
}
