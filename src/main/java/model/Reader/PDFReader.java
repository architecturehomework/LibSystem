package model.Reader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        File input = new File(filePath);
        PDDocument pd = PDDocument.load(input);
        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(pd);
    }
}
