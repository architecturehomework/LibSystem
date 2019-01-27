import model.Literature;
import model.Undergraduate;
import model.User;
import service.LiteratureService;
import service.ServiceFactory;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        UserService userService = ServiceFactory.getUserService();
        LiteratureService literatureService = ServiceFactory.getLiteratureService();
        User user = userService.getUser("161250078");
        Undergraduate undergraduate = new Undergraduate(user);
        Literature literature = literatureService.getLiterature("000001");
        System.out.println(undergraduate.borrow(literature));

    }
}
