package game;

public class Create_Character_UI {
    private 전투 전투;
    private String 플레이어id;
    private String 캐릭터명;
    private String 직업;
    private int 레벨;

    public Create_Character_UI(전투 전투, String 플레이어id, String 캐릭터명, String 직업, int 레벨) {
        this.전투 = 전투;
        this.플레이어id = 플레이어id;
        this.캐릭터명 = 캐릭터명;
        this.직업 = 직업;
        this.레벨 = 레벨;
    }

    public void 실행() {
        전투.캐릭터생성(플레이어id, 캐릭터명, 직업, 레벨);
    }
}
