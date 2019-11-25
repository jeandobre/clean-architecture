package clean_code.continuidade_vertical;

import java.util.ArrayList;
import java.util.List;

public class ReporterConfigRuim {

    /**
     * The class name of the reporter listener
     */
    private String m_className;

    /**
     * The properties of the reporter listener
     */
    private List<Property> m_properties = new ArrayList<>();

    public void addProperty(Property property){
        m_properties.add(property);
    }
}
