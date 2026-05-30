package game;

public abstract class 캐릭터 {
    public String 캐릭터명;
    public int 레벨;
    public double hp;
    public double 공격력;
    public 인벤토리 인벤토리;

    public 캐릭터(String 캐릭터명, int 레벨) {
        this.캐릭터명 = 캐릭터명;
        this.레벨 = 레벨;
        this.인벤토리 = new 인벤토리();
    }

    public abstract double 스킬발동();

    public boolean 아이템추가(String 아이템명, String 아이템타입, int 아이템가치) {
        return 인벤토리.아이템추가(아이템명, 아이템타입, 아이템가치);
    }
}
