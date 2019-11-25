package clean_code.continuidade_vertical;

import java.util.ArrayList;
import java.util.List;

public class ReporterConfig {
    private String m_className;
    private List<Property> m_properties = new ArrayList<>();

    public void addProperty(Property property){
        m_properties.add(property);
    }

}
