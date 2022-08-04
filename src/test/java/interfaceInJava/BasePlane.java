package interfaceInJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePlane {

    private static List<Plane> planes;

    public static List<Plane> getPlanesList() {
        if (planes == null) {
            Random random = new Random();

            planes = new ArrayList<>(16);

            for (int i = 0; i < 15; i++) {
                planes.add(new Plane(getRandomString(), random.nextInt(3000), random.nextInt(1000), random.nextInt(100000)));
            }
        }
        return planes;
    }

    private static String getRandomString() {
        Random random = new Random();
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = random.nextInt(15);
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
