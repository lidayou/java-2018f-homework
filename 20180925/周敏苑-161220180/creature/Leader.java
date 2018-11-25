package creature;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class Leader {
    public abstract void support();
    public abstract void check_C_formation(List<CalabashBrother> x,String name);
    public abstract void check_S_formation(List<Soldier> x,String name);
}
