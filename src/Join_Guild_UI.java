package game;

public class Join_Guild_UI {
    private 전투 전투;
    private String 플레이어id;
    private String 길드명;

    public Join_Guild_UI(전투 전투, String 플레이어id, String 길드명) {
        this.전투 = 전투;
        this.플레이어id = 플레이어id;
        this.길드명 = 길드명;
    }

    public void 실행() {
        boolean 결과 = 전투.길드가입(플레이어id, 길드명);
        if (결과) System.out.println("길드 가입 성공");
        else System.out.println("길드 가입 실패");
    }
}
