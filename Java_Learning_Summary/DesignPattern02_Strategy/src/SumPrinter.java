
public class SumPrinter {
	
	void print(SumStrategy strategy, int N) {
		System.out.printf("This Sum of 1 - %d : ", N );
		System.out.println(strategy.get(N));
	}
}
