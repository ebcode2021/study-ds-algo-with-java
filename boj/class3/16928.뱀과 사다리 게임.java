import java.io.*;
import java.util.*;

/**
 * [문제 이해]
 * - 맵은 10x10 크기
 * - 플레이어가 i번째 칸. 주사위가 n번. i+n 번 칸으로 이동
 * - 만약 100번 칸을 넘어가면 이동 X
 * - 도착한 칸이 사다리면, 사다리를 타고 위로 올라가기.
 * - 뱀이 있는 칸이면, 뱀을 따라서 내려가기
 * - 사다리는 위로. 뱀은 아래로.
 * - 최소 주사위 횟수
 * 
 */
class Main {

	static int[] ladder = new int[101];
	static int[] snake = new int[101];
	static boolean[] board = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ladderCnt = Integer.parseInt(st.nextToken());
		int snakeCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < ladderCnt + snakeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			if (i < ladderCnt) {
				ladder[front] = back;
			} else {
				snake[front] = back;
			}
		}

		// 출발 지점 큐에 삽입
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;

			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				for (int j = 1; j < 7; j++) {
					int current = now + j;
					
					if (current > 100) {
						continue;
					}
					if (ladder[current] > 0) {
						current = ladder[current];
					} else if (snake[current] > 0) {
						current = snake[current];
					}
					if (board[current] == true) {
						continue;
					}

					if (current == 100) {
						System.out.println(cnt);
						br.close();
						return;
					}
					board[current] = true;
					queue.add(current);
				}
			}
		}
	}
}