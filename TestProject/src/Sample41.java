import java.util.regex.*;

public class Sample41 {

	public static void main(String[] args) {
		String s = "JavaSE,JavaEE,JavaME,JavaDB";
		Pattern p = Pattern.compile("Java.");
		Matcher m = p.matcher(s);
		while (m.find()) {
			//m.group() Returns the input subsequence matched by the previous match.
			System.out.print(m.group() + " ");
		}
	}

}
