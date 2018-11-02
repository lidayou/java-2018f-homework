import beings.CalabashBrother;
import beings.Creature;

import java.util.*;
public class CalabashGroup{
    public CalabashGroup(){
        group = new ArrayList<CalabashBrother>();
        for(int i = 0; i < 7; i++){
            group.add(new CalabashBrother(i));
        }
    }
    public Creature[] getFormationCreatrue(){
        int size = group.size();
        return (Creature[])group.toArray(new CalabashBrother[size]);
    }
    public void shuffle(){
        Collections.shuffle(group);
    }
    public void sort(){
        Collections.sort(group, new CalabashCompare());
    }
    public void print(){
        for(int i = 0; i < group.size(); i++){
            System.out.print(group.get(i).getName()+' ');
        }
        System.out.print("\n");
    }
    private ArrayList<CalabashBrother> group;
}
class CalabashCompare implements Comparator<CalabashBrother>{
    @Override
    public int compare(CalabashBrother a, CalabashBrother b){
        return a.getRank()-b.getRank();
    }
}



