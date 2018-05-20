package helpers;

public class WebLibrary {
	
	public static int cutStingReturnInt(String text, int start, int end) {
		String cutSting = text.substring(start, end);
		int intCutSting = Integer.parseInt(cutSting);
		return intCutSting;
	}
}
