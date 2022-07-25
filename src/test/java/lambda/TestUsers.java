package lambda;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUsers {

    @Test
    public void checkFiltrationBySex() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.isSex();
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertTrue(user.isSex());
        }
    }

    @Test
    public void checkFiltrationByAge() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(12, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getAge() == 12;
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getAge(), 12);
        }
    }

    @Test
    public void checkFiltrationByName() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getName().equals("Andrii");
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getName(), "Andrii");
        }
    }

    @Test
    public void checkFiltrationByWeight() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getWeight() == 45;
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getWeight(), 45);
        }
    }

    @Test
    public void checkFiltrationBySpeciality() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getSpeciality().equals("QA");
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getSpeciality(), "QA");
        }
    }

    @Test
    public void checkFiltrationBySexAndAge() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.isSex() && user.getAge() < 100;
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertTrue(user.isSex());
            Assert.assertTrue(user.getAge() < 100);
        }
    }

    @Test
    public void checkFiltrationByAgeAndName() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(12, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getAge() == 12 && user.getName().equals("Andrii");
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getAge(), 12);
            Assert.assertEquals(user.getName(), "Andrii");
        }
    }

    @Test
    public void checkFiltrationByNameAndWeight() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getName().equals("Andrii") && user.getWeight() >= 1;
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getName(), "Andrii");
            Assert.assertTrue(user.getWeight() >= 1);
        }
    }

    @Test
    public void checkFiltrationByWeightAndSpeciality() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.getWeight() == 45 && user.getSpeciality().equals("QA");
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        for (User user : actualResult) {
            Assert.assertEquals(user.getWeight(), 45);
            Assert.assertEquals(user.getSpeciality(), "QA");
        }
    }

    @Test
    public void checkFiltrationByAll() {

        List<User> users = new ArrayList<>(getUsersList());
        users.add(new User(24, "Andrii", 45, true, "QA"));

        List<User> actualResult = IUserCheck.getConditions(users,
                new IUserCheck() {
                    @Override
                    public boolean checkConditions(User user) {
                        return user.isSex() && user.getSpeciality().equals("QA") &&
                                user.getAge() == 24 && user.getWeight() == 45 && user.getName().equals("Andrii");
                    }
                }
        );

        Assert.assertNotNull(actualResult);
        Assert.assertEquals(actualResult.size(), 1);
    }

    private String getRandomString() {
        Random random = new Random();
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = random.nextInt(15);
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private List<User> getUsersList() {
        Random random = new Random();

        List<User> users = new ArrayList<>(16);

        for (int i = 0; i < 15; i++) {
            users.add(new User(random.nextInt(90), getRandomString(), random.nextInt(100), random.nextBoolean(), getRandomString()));
        }

        return users;
    }
}
