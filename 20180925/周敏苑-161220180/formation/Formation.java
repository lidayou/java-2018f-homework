package formation;

import creature.CalabashBrother;
import creature.Soldier;

import java.util.ArrayList;
import java.util.List;

public abstract class Formation {
    private String name;

    public abstract void form_C_formation(List<CalabashBrother> a);
    public abstract void form_S_formation(List<Soldier> a);
}
