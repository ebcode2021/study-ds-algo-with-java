import java.io.*;
import java.util.*;

/**
 * [조건]
 * 1. minecraft -> 1 x 1 x 1 크기 블록
 * 2. 모든 땅의 높이를 동일하게 만드는 작업(땅 고르기) 필요
 * 3. 세로 N, 가로 M 크기의 집터
 * 4. 집터의 맨 왼쪽 위 (0,0)
 * 5. 작업 시작 할 때, 인벤토리에는 B개의 블럭이 있음
 * 6. 땅 높이는 256블록 초과 X. 음수 X
 * 
 * [할 수 있는 작업의 종류]
 * 1. 좌표(i,j)의 가장 위에 있는 블록 제거 후 인벤토리 저장 -> 2s
 * 2. 인벤토리 꺼내서 좌표 (i,j) 의 가장 위에 두기 -> 1s
 * 
 * [원하는 것]
 * -> **작업에 걸리는 최소 시간**, 땅의 높이
 */
class Main {

	private static int assertBlockCnt(int[][] maps, int avgHeight, int remain) {
		int N = maps.length;
		int M = maps[0].length;

		int addBlockCnt = 0;
		int deleteBlockCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] == avgHeight)
					continue;
				else if (maps[i][j] < avgHeight) {
					addBlockCnt += avgHeight - maps[i][j];
				} else {
					deleteBlockCnt += maps[i][j] - avgHeight;
				}
			} 
		}

		if (deleteBlockCnt + remain < addBlockCnt) {
			return -1;
		}
		return (2 * deleteBlockCnt + addBlockCnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 세로(N), 가로(M)
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 땅의 크기
		int[][] maps = new int[N][M];
		// 인벤토리 보유(B)
		int B = Integer.parseInt(st.nextToken());

		// 맵 초기화
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		int resultTime = assertBlockCnt(maps, 256, B);
		int resultHeight = 256;

		for (int height = 255; height >= 0; height--) {
			int time = assertBlockCnt(maps, height, B);
			
			if (time == -1) {
				continue;
			}

			if (resultTime == -1 || time < resultTime) {
				resultTime = time;
				resultHeight = height;
			} else if (time == resultTime) {
				resultHeight = resultHeight > height ? resultHeight : height;
			}
		}
		System.out.println(resultTime + " " + resultHeight);
	}
}