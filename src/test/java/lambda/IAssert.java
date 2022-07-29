package lambda;

@FunctionalInterface
public interface IAssert {

    boolean assertEquals(String var0, String var1);

    static IAssert assertI() {
        return (str0, str1) -> str1.equals(str0);
    }
}
