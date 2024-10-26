/**
    t초 연속으로 붕대 감는 데 성공 -> y만큼 체력 증가 (최대 체력 넘으면 안됨)
    - 붕대 감기 중 공격 당하면 기술 취소 
    - 공격 당하는 순간에는 체력 회복 x
    - 붕대 감기 사용 후에는 연속 성공 시간 0으로 초기화
    - bandage는 [시전 시간, 초당 회복량, 추가 회복량] 형태의 길이가 3인 정수 배열
    - 최대 체력 health
    - attacks[i]는 [공격 시간, 피해량] << 공격 시간은 오름 차순으로 정렬
    - return 해야하는 것 -> 마지막 체력(만약 공격 받고 체력 0이하면 -1 리턴)
*/

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        
        int techTime = bandage[0];
        int heel = bandage[1];
        int addHeel = bandage[2];
        
        int currentTime = 0;
        int time = 1;
        for (int[] attack : attacks) {
            while (currentTime < attack[0]) {
                if (time != techTime) {
                    health = health + heel < maxHealth ? health + heel : maxHealth;
                    time++;
                } else {
                    health = health + heel + addHeel < maxHealth ? health + heel + addHeel : maxHealth;
                    time = 1;
                }
                currentTime++;
            }        
            time = 1;
            health -= attack[1];
            if (health <= 0) {
                return -1;
            }
            currentTime++;
        }
        return health;
    }
}