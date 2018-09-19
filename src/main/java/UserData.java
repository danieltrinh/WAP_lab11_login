import java.util.ArrayList;
import java.util.List;

public class UserData {
    public static List<User> users = new ArrayList<>();
    static {
                users.add(new User("Daniel", "123"));
                users.add(new User("Leo", "321"));
            };
}
