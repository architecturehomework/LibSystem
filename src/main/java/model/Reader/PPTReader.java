package model.Reader;

import org.apache.poi.hslf.extractor.PowerPointExtractor;

import java.io.FileInputStream;
import java.io.IOException;

public class PPTReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        PowerPointExtractor extractor = new PowerPointExtractor(in);
        String content = extractor.getText();
        extractor.close();
        return content;
    }
}
