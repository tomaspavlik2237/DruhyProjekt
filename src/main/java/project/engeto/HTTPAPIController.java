package project.engeto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTTPAPIController
{
    JSONOperator jsonOperator = new JSONOperator();
    MajorObjects majorObjects = jsonOperator.acquireJsonFile();


    @GetMapping("/api/states/getState/{stateShortcut}")
    public State getStateByShortcut(@PathVariable String stateShortcut)
    {
        return majorObjects.getRates().get(stateShortcut);
    }

    @GetMapping("/api/states/getRate/{stateShortcut}")
    public Float getStateRateByShortcut(@PathVariable String stateShortcut)
    {
        return majorObjects.getRates().get(stateShortcut).getStandardRate();
    }

    @GetMapping("/api/states/getMaxRate")
    public List<String> getMaxRate()
    {
        return jsonOperator.getMaxThreeValues(majorObjects);
    }

    @GetMapping("/api/states/getMinRate")
    public List<String> getMinRate()
    {
        return jsonOperator.getMinThreeValues(majorObjects);
    }
}
