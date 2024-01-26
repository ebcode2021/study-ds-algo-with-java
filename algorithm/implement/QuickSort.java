package algorithm.implement;

public class QuickSort {

	public int partition(int[] array, int low, int high) {
		// Pivot을 선택(맨 오른쪽 선택)
		int pivot = array[high];

		// Pivot을 기준으로 작은 값들을 왼쪽으로 이동
		int left = low;
		for (int right = low; right < high; right++) {
			if (array[right] < pivot) {
				swap(array, left, right);
				left++;
			}
		}

		// Pivot의 최종 위치를 설정
		swap(array, left, high);

		return left;
	}

	public int[] quickSort(int[] array, int low, int high) {
		if (low < high) {
			// 배열을 분할하고 각 부분을 정렬
			int pivot = partition(array, low, high);
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
		return array;
	}

	// 배열에서 두 요소의 위치를 교환하는 메서드
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}