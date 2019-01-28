import model.Decorator.AddAllDecorator;
import model.Decorator.Decorator;
import model.Decorator.SearchAllDecorator;
import model.Undergraduate;
import model.User;
import service.LiteratureService;
import service.ServiceFactory;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        UserService userService = ServiceFactory.getUserService();
        LiteratureService literatureService = ServiceFactory.getLiteratureService();
        Decorator user1 = userService.getPriorityUser("12345");
        System.out.println(user1.getId() + user1.getType() + user1.getPriority());

        Decorator user2 = userService.getPriorityUser("12346");
        System.out.println(user2.getId() + user2.getType() + user2.getPriority());

        //System.out.println(user1.borrow(literatureService.getLiterature("000001")));
        System.out.println(user1.searchUser("12346"));
        System.out.println(user2.searchUser("12345"));

        User u = new User();
        u.setId("12347");

        System.out.println(user2.addUser(u));
        System.out.println(user1.addUser(u));

    }
}
