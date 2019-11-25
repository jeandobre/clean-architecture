package clean_code.espacamento_vertical;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BoldWidgetRuim extends ParentWidget {
    public static final String REGEXP = "'''.+?'''";
    private static final Pattern pattern = Pattern.compile(REGEXP,
            Pattern.MULTILINE + Pattern.DOTALL);
    public BoldWidgetRuim(ParentWidget parent, String text) throws Exception {
        super(parent);
        Matcher match = pattern.matcher(text);
        match.find();}
    public String render() throws Exception{
        StringBuffer html = new StringBuffer("<b>");
        html.append("").append("</b>");
        return html.toString();
    }
}
