package game;

public class 플레이어 {
    private String 플레이어id;
    private 캐릭터 캐릭터;

    public 플레이어(String 플레이어id) {
        this.플레이어id = 플레이어id;
    }

    public boolean 플레이어체크(String id) {
        return "hero".equals(id);
    }

    public void 캐릭터설정(캐릭터 c) { this.캐릭터 = c; }
    public 캐릭터 캐릭터가져오기() { return 캐릭터; }
    public String 아이디가져오기() { return 플레이어id; }
}
