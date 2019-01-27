package model.Reader;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocReder extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(new File(filePath));
        HWPFDocument doc = new HWPFDocument(fis);
        Range rang = doc.getRange();
        sb.append(rang.text());
        fis.close();
        return sb.toString();
    }
}
