package lambda;

@FunctionalInterface
public interface IBMI {

    double getBMI(double weight, String name, double growth);

    static IBMI bmi() {
        return (weight, name, growth) -> {
            System.out.println("Name is " + name);
            return (weight / growth * growth);
        };
    }
}
