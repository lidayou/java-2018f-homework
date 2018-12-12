package world;

/**	
 *	主宰世界的动向，然而是个甩手掌柜
 *
 *	@author Mirror
 *	
 *	@see CharWindow
 *	@see GUIWindow
 */
public final class Main {
	
	public static void main(String[] args) {
		CharWindow cWin = new CharWindow();
		new GUIWindow(cWin);
	}
}
