package calabash;

public class Field {
	String[][] field;
	
	Field(){
		this.field = new String[15][15];
	}
	
	public void printField() {
		for(int i = 0; i < 15; i++) {
			System.out.println();
			for(int j = 0; j < 15; j++) {
				System.out.print(field[i][j]);
			}
		}
	}
	
	public void printsingle(int x, int y) {
		System.out.println(field[x][y]);
	}
	
	public void createField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j] = "\t";
			}
		}
	}
	
	public void clearMonster() {
		for(int i = 0; i < 15; i++) {
			for(int j = 8; j < 15; j++) {
				field[i][j] = "\t";
			}
		}
	}
	
	public void updateField(int x, int y, String str) {
		field[x][y] = str;
	}
	
	public static void main(String[] args) {
		Field field = new Field();
		field.createField();
		Formation form = new Formation(field);
		form.longSnakeFormation();
		form.craneFormation();
		field.printField();
		System.out.println();
		form.yokeFormation();
		field.printField();
	}
}
