package model.Reader;

public class ReaderFactory {

    public static Reader getReaderFactory(String filePath) {
        String[] strings = filePath.split("/");
        String fileName = strings[strings.length - 1];
        String format = fileName.split("\\.")[1];
        switch (format) {
            case "txt":
                return new TxtReader();
            case "doc":
                return new DocReder();
            case "docx":
                return new DocxReader();
            case "pdf":
                return new PDFReader();
            case "ppt":
                return new PPTReader();
            case "pptx":
                return new PPTXReader();
            case "xls":
                return new XlsReader();
            case "xlsx":
                return new XlsxReader();
            default:
                System.out.println("未知的文件格式");
                return null;
        }
    }
}
