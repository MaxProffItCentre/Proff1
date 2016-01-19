package action10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("abs");
		list.add("jlsa");
		list.add("dgfk");
		list.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.equals("abs");
			}
		});
		list.removeIf(t -> t.equals("jlsa"));
		System.out.println(list);
	}
}
