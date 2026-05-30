package game;

public class Attack_Monster_UI {
    private 전투 전투;
    private String 플레이어id;

    public Attack_Monster_UI(전투 전투, String 플레이어id) {
        this.전투 = 전투;
        this.플레이어id = 플레이어id;
    }

    public void 실행() {
        System.out.println(전투.몬스터공격(플레이어id));
    }
}
