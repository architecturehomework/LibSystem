package model.Reader;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

public class DocxReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(in);
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text = extractor.getText();
        in.close();
        return text;

    }
}
