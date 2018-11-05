import java.util.ArrayList;

public class Camp {
    private ArrayList<Unit>list;
    private Unit leader;
    Camp(Unit leader)
    {
        this.leader = leader;
        list = new ArrayList<>();
    }
    Camp(Unit leader, Unit[] unit,int num)
    {
        this.leader = leader;
        list = new ArrayList<>();
        for(int i = 0;i<num;i++)
            list.add(unit[i]);
    }
    public void add_unit(Unit unit)
    {
        list.add(unit);
    }
    public ArrayList<Unit> getList()
    {
        return list;
    }
    public Unit getLeader()
    {
        return leader;
    }
}
