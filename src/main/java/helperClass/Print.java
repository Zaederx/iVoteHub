package helperClass;

public class Print {
	String [] messages;
	static String m = "At method:";
	public Print() {
		messages = new String[10];
		messages[0] = "At view:";
	}
	
	public Print(String[] messages) {
		this.messages = messages;
	}
	
	public static void p(String s) {
		System.out.println(m+s);
	}
}
