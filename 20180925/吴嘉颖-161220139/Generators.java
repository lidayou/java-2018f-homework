import java.util.*;

interface Generator<T> {
    T next();
}

public class Generators<T> {
    public static <T> Collection<T> fill(Collection<T> clt, Generator<T> gen, int num) {
        for (int i = 0; i < num; i++)
            clt.add(gen.next());
        return clt;
    }
}