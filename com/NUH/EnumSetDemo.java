import java.util.EnumSet;
import java.util.Iterator;

enum FontConstant{
	Plain,Bold,Italilc,Hellp
}

public class EnumSetDemo {
	
	public static void main(String[] args) {
		
		FontConstant fc = FontConstant.valueOf("sss");
		
		
	}
	

	public static void showEnumSet(EnumSet<FontConstant> enumSet){
		for(Iterator<FontConstant> it = enumSet.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
}
