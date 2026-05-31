package game;

public class 전투 {
    private 플레이어 플레이어;
    private 길드 길드;

    public 전투(길드 길드) {
        this.길드 = 길드;
    }

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

    public String 아이템획득(String 플레이어id, String 아이템명, String 아이템타입, int 아이템가치) {
        if (플레이어 == null || !플레이어.플레이어체크(플레이어id)) return "로그인 실패";
        캐릭터 c = 플레이어.캐릭터가져오기();
        if (c == null) return "캐릭터 없음";
        if (c.아이템추가(아이템명, 아이템타입, 아이템가치)) {
            아이템 추가된아이템 = c.인벤토리.아이템리스트가져오기().get(c.인벤토리.현재크기() - 1);
            return 추가된아이템 + " 획득 성공";
        }
        return "용량 초과";
    }

    public boolean 길드가입(String 플레이어id, String 길드명) {
        if (플레이어 == null || !플레이어.플레이어체크(플레이어id)) return false;
        if (길드.현재인원() >= 길드.최대인원가져오기()) return false;
        캐릭터 c = 플레이어.캐릭터가져오기();
        return 길드.캐릭터가입(c);
    }
}
