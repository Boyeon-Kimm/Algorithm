package algoTest;
import java.util.Scanner;

public class 전기버스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt(); // 한 번 충전으로 이동 가능한 정류장의 수
			int N = sc.nextInt(); // 종점
			int M = sc.nextInt(); // 충전기 설치된 정류장의 수
			int[] station = new int[M];
			// 충전기 설치된 정류장 배열에 입력
			for(int i = 0; i < M; i++) {
				station[i] = sc.nextInt();
			}
			// 배터리 잔량
			int battery = K + 1;
			// 몇번 충전했는지 구할 변수
			int charge = 0;
			int j = 0;
			// 종점에 도착할때까지 배터리 1씩 감소
			for(int i = 0; i <= N; i++) {
				battery -= 1;
				
				// 배터리가 음수가 되면 break, 0 출력
				if(battery < 0) {
					charge = 0;
					break;
				}
				
				// 버스가 충전소가 있는 정류장에 도착했을 때
				// 그 다음 충전소까지의 거리보다 배터리가 더 적게 남아있다면
				// 충전시키고, 충전횟수 증가
				if(station[j] == i) {
					if(j + 1 < M) {
						if(battery < station[j + 1] - station[j]) {
							battery += K;
							charge++;
						}
						j++;
					} else if(j == M - 1) {
						if(battery < K) {
							battery += K;
							charge++;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, charge);
		}
	}
}
