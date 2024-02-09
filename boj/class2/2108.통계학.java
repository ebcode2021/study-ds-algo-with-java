import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] datas = new int[N];
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			datas[i] = num;
			sum += num;
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		Arrays.sort(datas);
		
		int maxFrequency = Collections.max(frequencyMap.values());
		List<Integer> freqencyList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() == maxFrequency) {
				freqencyList.add(entry.getKey());
			}
		}
		Collections.sort(freqencyList);

		System.out.println(Math.round((double)sum / N));
		System.out.println(datas[N / 2]);
		System.out.println(freqencyList.size() > 1 ? freqencyList.get(1) : freqencyList.get(0));
		System.out.println(datas[N - 1] - datas[0]);
	}
}

// 최빈값 구하는 다른 방법
//for(int i = 0; i < N - 1; i++) {
//	if(arr[i] == arr[i + 1]) {
//		count++;
//	}else {
//		count = 0;
//	}
	
//	if(max < count) {
//		max = count;
//		mod = arr[i];
//		check = true;
//	}else if(max == count && check == true) {
//		mod = arr[i];
//		check = false;
//	}
//}