package game;

public class Main {
    public static void main(String[] args) {
        전투 전투 = new 전투();
        전투.길드등록(new 길드("A길드"));

        Create_Character_UI 캐릭터UI = new Create_Character_UI(전투, "hero", "홍길동", "전사", 10);
        Attack_Monster_UI   공격UI   = new Attack_Monster_UI(전투, "hero");
        Add_Item_UI         아이템UI  = new Add_Item_UI(전투, "hero", "불꽃검", "무기", 1200);
        Join_Guild_UI       길드UI    = new Join_Guild_UI(전투, "hero", "A길드");

        System.out.println("=== 캐릭터 생성 ===");
        캐릭터UI.실행();

        System.out.println("\n=== 몬스터 공격 ===");
        공격UI.실행();

        System.out.println("\n=== 아이템 획득 ===");
        아이템UI.실행();

        System.out.println("\n=== 길드 가입 ===");
        길드UI.실행();
    }
}
