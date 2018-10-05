package wcr;

public class HomeWork2 {

    public static void main(String[] args) {
        new HomeWork2().sort();
    }

    public void sort() {
        sortByAge();
        sortByColor();
    }

    //Sort Calabash Brothers by bubble-sort Algorithm
    private void sortByAge() {
        CalabashBrother[] huluwa = {
                new CalabashBrother(0),
                new CalabashBrother(4),
                new CalabashBrother(6),
                new CalabashBrother(2),
                new CalabashBrother(1),
                new CalabashBrother(3),
                new CalabashBrother(5),
        };

        for (int i = 0; i < huluwa.length - 1; ++i) {
            for (int j = 0; j < huluwa.length - 1 - i; ++j) {
                if (huluwa[j].compareAge(huluwa[j + 1]) > 0) {
                    huluwa[j].displayMov(j, j + 1);
                    huluwa[j + 1].displayMov(j + 1, j);
                    CalabashBrother temp = huluwa[j];
                    huluwa[j] = huluwa[j + 1];
                    huluwa[j + 1] = temp;
                }
            }
        }

        for (CalabashBrother it : huluwa) {
            it.printAge();
        }
        System.out.print('\n');
    }

    //Sort Calabash Brothers by quick-sort Algorithm
    private void sortByColor(){
        CalabashBrother[] huluwa = {
                new CalabashBrother(0),
                new CalabashBrother(4),
                new CalabashBrother(6),
                new CalabashBrother(2),
                new CalabashBrother(1),
                new CalabashBrother(3),
                new CalabashBrother(5),
        };

        quickSort(huluwa, 0, huluwa.length - 1);

        for (CalabashBrother it : huluwa) {
            it.printCol();
        }
        System.out.print('\n');
    }

    //Execute a recursion process
    private void quickSort(CalabashBrother[] huluwa, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int mid = start;
        for (int i = start + 1; i <= end; ++i) {
            if (huluwa[i].compareCol(huluwa[pivot]) < 0) {
                mid++;
                if (mid == i) continue;
                huluwa[i].displayMov(i, mid);
                huluwa[mid].displayMov(mid, i);
                CalabashBrother temp = huluwa[mid];
                huluwa[mid] = huluwa[i];
                huluwa[i] = temp;
            }
        }

        if (mid != pivot) {
            huluwa[pivot].displayMov(pivot, mid);
            huluwa[mid].displayMov(mid, pivot);
            CalabashBrother temp = huluwa[mid];
            huluwa[mid] = huluwa[pivot];
            huluwa[pivot] = temp;
        }

        quickSort(huluwa, start, mid - 1);
        quickSort(huluwa, mid + 1, end);
    }
}
