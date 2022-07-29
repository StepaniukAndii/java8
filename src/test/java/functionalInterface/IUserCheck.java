package functionalInterface;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface IUserCheck {

    boolean checkConditions(User user);

    static List<User> getConditions(List<User> users, IUserCheck conditions) {
        List<User> filtrationUsers = new ArrayList<>();
        for (User user : users) {
            if (conditions.checkConditions(user)) {
                filtrationUsers.add(user);
            }
        }
        return filtrationUsers;
    }
}
