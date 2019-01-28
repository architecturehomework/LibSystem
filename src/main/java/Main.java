import model.Decorator.AddAllDecorator;
import model.Decorator.Decorator;
import model.Decorator.SearchAllDecorator;
import model.Reader.Reader;
import model.Reader.ReaderFactory;
import model.Undergraduate;
import model.User;
import service.LiteratureService;
import service.ServiceFactory;
import service.UserService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Reader reader = ReaderFactory.getReaderFactory("H:/关于作业运行环境的说明.pdf");
        try {
            System.out.println(reader.getText("H:/关于作业运行环境的说明.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
