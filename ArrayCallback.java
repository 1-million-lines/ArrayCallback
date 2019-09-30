public class ArrayCallback {
	public static void forEach(int[] arr, IntConsumer consumer) {
		for (int i : arr) {
			consumer.run(i);
		}
	}

	public static void filter(int[] arr, IntToInt mapper) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = mapper.run(arr[i]);
		}
	}

	public static void main(final String... args) {
		int[] numbers = {1, 2, 3, 4, 5};

		forEach(numbers, new IntConsumer() {
			@Override
			public void run(int x) {
				System.out.println(x);
			}
		});

		filter(numbers, new IntToInt() {
			@Override
			public int run(int x) {
				return x * x;
			}
		});

		forEach(numbers, new IntConsumer() {
			@Override
			public void run(int x) {
				System.out.println(x);
			}
		});
	}

}

interface IntConsumer {
	void run(int x);
}

interface IntToInt {
	int run(int x);
}

