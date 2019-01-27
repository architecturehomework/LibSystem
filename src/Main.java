import model.Decorator.AddAllDecorator;
import model.Decorator.SearchAllDecorator;
import model.Undergraduate;
import model.User;
import service.ServiceFactory;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        UserService userService = ServiceFactory.getUserService();
        User user = userService.getUser("12345");
        System.out.println(user.getId());
        Undergraduate undergraduate = new Undergraduate(user);
        System.out.println(undergraduate.getId());
        AddAllDecorator addAllDecorator = new AddAllDecorator(undergraduate);
        SearchAllDecorator searchAllDecorator = new SearchAllDecorator(addAllDecorator);

        User nu = new User();
        nu.setId("123467");
        System.out.println(searchAllDecorator.addUser(nu));
        System.out.println(searchAllDecorator.searchUser("12346"));

    }
}
