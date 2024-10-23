class Solution {
	public int solution(int[] wallet, int[] bill) {
		int cnt = 0;
		
		int walletMin = wallet[0] < wallet[1] ? wallet[0] : wallet[1];
		int walletMax = wallet[0] > wallet[1] ? wallet[0] : wallet[1];
		int billMin = bill[0] < bill[1] ? bill[0] : bill[1];
		int billMax = bill[0] > bill[1] ? bill[0] : bill[1];
		
		while (!(billMin <= walletMin && billMax <= walletMax)) {
			billMax /= 2;
			if (billMin > billMax) {
				int tmp = billMin;
				billMin = billMax;
				billMax = tmp;
			}
			cnt++;
		}
		
		return cnt;
	}
}