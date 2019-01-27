package model.Reader;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class PPTXReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        String resultString = null;
        StringBuilder sb = new StringBuilder();
        FileInputStream in = new FileInputStream(filePath);
        try {
            XMLSlideShow xmlSlideShow = new XMLSlideShow(in);
            List<XSLFSlide> slides = xmlSlideShow.getSlides();
            for(XSLFSlide slide:slides){
                CTSlide rawSlide = slide.getXmlObject();
                CTGroupShape gs = rawSlide.getCSld().getSpTree();
                CTShape[] shapes = gs.getSpArray();
                for(CTShape shape:shapes){
                    CTTextBody tb = shape.getTxBody();
                    if(null==tb){
                        continue;
                    }
                    CTTextParagraph[] paras = tb.getPArray();
                    for(CTTextParagraph textParagraph:paras){
                        CTRegularTextRun[] textRuns = textParagraph.getRArray();
                        for(CTRegularTextRun textRun:textRuns){
                            sb.append(textRun.getT());
                        }
                    }
                }
            }
            resultString = sb.toString();
            xmlSlideShow.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;

    }
}
