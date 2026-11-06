import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/** Use the shipped MyBatis DTD, including resultMap element ordering, offline. */
public final class MapperXmlValidation {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new XMLMapperEntityResolver());
        builder.setErrorHandler(new DefaultHandler() {
            @Override public void error(SAXParseException error) throws SAXParseException { throw error; }
            @Override public void fatalError(SAXParseException error) throws SAXParseException { throw error; }
        });
        int count = 0;
        for (String filename : Files.readAllLines(Paths.get(args[0]))) {
            Path file = Paths.get(filename);
            try {
                builder.parse(file.toFile());
                count++;
            } catch (Exception error) {
                throw new IllegalStateException("Invalid MyBatis mapper: " + file, error);
            }
        }
        System.out.println("mapper_xml_dtd_checks=" + count);
    }
}
