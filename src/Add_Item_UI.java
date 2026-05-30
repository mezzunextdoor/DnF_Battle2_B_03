package game;

public class Add_Item_UI {
    private 전투 전투;
    private String 플레이어id;
    private String 아이템명;
    private String 아이템타입;
    private int 아이템가치;

    public Add_Item_UI(전투 전투, String 플레이어id, String 아이템명, String 아이템타입, int 아이템가치) {
        this.전투 = 전투;
        this.플레이어id = 플레이어id;
        this.아이템명 = 아이템명;
        this.아이템타입 = 아이템타입;
        this.아이템가치 = 아이템가치;
    }

    public void 실행() {
        boolean 결과 = 전투.아이템획득(플레이어id, 아이템명, 아이템타입, 아이템가치);
        if (결과) System.out.println("아이템 획득 성공");
        else System.out.println("아이템 획득 실패");
    }
}
