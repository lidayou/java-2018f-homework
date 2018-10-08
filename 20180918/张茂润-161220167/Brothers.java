class Baby{
    int number;
    Brothers.Color color;
    int place;
    Baby(){
        number = 0;
        color = Brothers.Color.RED;
        place = 0;
    }
}

 class Queue{
    public Baby[] members;
    public void randomQueue(){
        boolean[] place = new boolean[7];
        for(int i = 0; i < 7; i++)
            place[i] = false;

        members = new Baby[7];
        for(int i = 0; i < 7; i++)
            members[i] = new Baby();

        for(int i = 0; i < 7; i++) {
            int randomNumber = (int) (1 + Math.random() * (7 - 1)); //from 1 to 7
            while (place[randomNumber - 1]) {
                randomNumber = (randomNumber + 1) % 8;
                if (randomNumber == 0)
                    randomNumber = 1;
            }
            members[randomNumber - 1].place = randomNumber;
            members[randomNumber - 1].number = i;
            switch (i) {
                case 0:
                    members[randomNumber - 1].color = Brothers.Color.RED;
                    break;
                case 1:
                    members[randomNumber - 1].color = Brothers.Color.ORANGE;
                    break;
                case 2:
                    members[randomNumber - 1].color = Brothers.Color.YELLOW;
                    break;
                case 3:
                    members[randomNumber - 1].color = Brothers.Color.GREEN;
                    break;
                case 4:
                    members[randomNumber - 1].color = Brothers.Color.WATHET;
                    break;
                case 5:
                    members[randomNumber - 1].color = Brothers.Color.BLUE;
                    break;
                case 6:
                    members[randomNumber - 1].color = Brothers.Color.PURPLE;
                    break;
                default:
                    break;
            }
            place[randomNumber - 1] = true;
        }
    }

    void bubbleSort(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7 - i - 1; j++){
                if(members[j].color.ordinal() > members[j+1].color.ordinal()){
                    Baby tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;
                    int place = members[j].place;
                    members[j].place = members[j+1].place;
                    members[j+1].place = place;
                    System.out.println("Brother " + members[j].color + " from " + members[j+1].place + " to " + members[j].place);
                    System.out.println("Brother " + members[j+1].color + " from " + members[j].place + " to " + members[j+1].place);

                }
            }
        }
        show();
    }
    void show(){
        for(int i = 0; i < 7; i++){
            System.out.println("Brother " + members[i].color + " is at seat No." + members[i].place);
        }
    }

    void insertSort()
    {
        for(int i = 1; i < 7; i++){
            Brothers.Color color = members[i].color;
            Baby tmp = members[i];
            int j;
            for(j = i-1; j >=0; j--){
                if((int)members[j].color.ordinal() > (int)color.ordinal()){
                    int n = j + 2;
                    System.out.println("Brother " + members[j].color + " from " + members[j].place + " to " + n);
                    members[j].place = j + 2;
                    members[j+1] = members[j];
                }
                else
                    break;
            }
            if(j + 1 != i) {
                int n = j + 2;
                System.out.println("Brother " + tmp.color + " from " + tmp.place + " to " + n);
            }
            tmp.place = j + 2;
            members[j+1] = tmp;
        }
        for(int i = 0; i < 7; i++){
            System.out.println("Brother " + members[i].color + " is at seat No." + members[i].place);
        }
    }
}

public class Brothers {
    public enum Color {
        RED, ORANGE, YELLOW, GREEN, WATHET, BLUE, PURPLE
    }

    public static void main(String[] args){
        Queue q ;
        q = new Queue();
        System.out.println("Problem 1:");
        q.randomQueue();
        System.out.println("After random queuing:");
        q.show();
        System.out.println("After bubble-sorting:");
        q.bubbleSort();

        System.out.println("Problem 2:");
        q.randomQueue();
        System.out.println("After random queuing:");
        q.show();
        System.out.println("After insert-sorting:");
        q.insertSort();
        return ;
    }
}
