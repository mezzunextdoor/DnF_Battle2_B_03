package game;

import java.util.ArrayList;
import java.util.List;


public class 전투 {
    private 플레이어 플레이어;
    private List<길드> 길드목록 = new ArrayList<>();

    public void 캐릭터생성(String 플레이어id, String 캐릭터명, String 직업, int 레벨) {
        플레이어 p = new 플레이어(플레이어id);
        if (!p.플레이어체크(플레이어id)) {
            System.out.println("[오류] 유효하지 않은 플레이어 ID: " + 플레이어id);
            return;
        }
        캐릭터 새캐릭터;
        if ("전사".equals(직업)) {
            새캐릭터 = new 전사(캐릭터명, 레벨);
        } else if ("마법사".equals(직업)) {
            새캐릭터 = new 마법사(캐릭터명, 레벨);
        } else {
            System.out.println("[오류] 알 수 없는 직업: " + 직업);
            return;
        }
        p.캐릭터설정(새캐릭터);
        this.플레이어 = p;
        System.out.println("캐릭터 생성 완료: " + 캐릭터명 + " [" + 직업 + "] Lv." + 레벨
                + " | HP:" + 새캐릭터.hp + " | 공격력:" + 새캐릭터.공격력);
    }

    public String 몬스터공격(String 플레이어id) {
        if (플레이어 == null || !플레이어.플레이어체크(플레이어id))
            return "[오류] 유효하지 않은 플레이어 ID";
        캐릭터 c = 플레이어.캐릭터가져오기();
        if (c == null) return "[오류] 캐릭터가 없습니다";
        double 데미지 = c.스킬발동();
        String 등급;
        if (데미지 >= 200) 등급 = "S급";
        else if (데미지 >= 100) 등급 = "A급";
        else 등급 = "B급";
        return "데미지: " + 데미지 + " → " + 등급 + " 공격";
    }

    public boolean 아이템획득(String 플레이어id, String 아이템명, String 아이템타입, int 아이템가치) {
        if (플레이어 == null || !플레이어.플레이어체크(플레이어id)) return false;
        캐릭터 c = 플레이어.캐릭터가져오기();
        if (c == null) return false;
        return c.아이템추가(아이템명, 아이템타입, 아이템가치);
    }

    public boolean 길드가입(String 플레이어id, String 길드명) {
        if (플레이어 == null || !플레이어.플레이어체크(플레이어id)) return false;
        길드 대상길드 = 길드찾기(길드명);
        if (대상길드 == null) return false;
        if (대상길드.현재인원() >= 5) return false;
        캐릭터 c = 플레이어.캐릭터가져오기();
        return 대상길드.캐릭터가입(c);
    }

    public void 길드등록(길드 g) { 길드목록.add(g); }

    private 길드 길드찾기(String 이름) {
        for (길드 g : 길드목록) {
            if (g.길드명.equals(이름)) return g;
        }
        return null;
    }

    public 플레이어 플레이어가져오기() { return 플레이어; }
    public List<길드> 길드목록가져오기() { return 길드목록; }
}
