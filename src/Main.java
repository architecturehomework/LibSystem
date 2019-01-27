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
        User user = userService.getUser("12345");
        System.out.println(user.getId());
        Undergraduate undergraduate = new Undergraduate(user);
        System.out.println(undergraduate.getId());
        Literature literature = literatureService.getLiterature("000001");
        System.out.println(undergraduate.returnBook(literature));

    }
}
