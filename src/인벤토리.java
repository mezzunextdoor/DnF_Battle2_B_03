package game;

import java.util.ArrayList;
import java.util.List;

public class 인벤토리 {
    private int 최대용량 = 10;
    private List<아이템> 아이템리스트 = new ArrayList<>();

    public boolean 아이템추가(String 아이템명, String 아이템타입, int 아이템가치) {
        if (아이템리스트.size() >= 최대용량) return false;
        아이템 새아이템 = new 아이템(아이템명, 아이템타입, 아이템가치);
        아이템리스트.add(새아이템);
        return true;
    }

    public int 현재크기() { return 아이템리스트.size(); }
    public int 최대용량가져오기() { return 최대용량; }
    public List<아이템> 아이템리스트가져오기() { return 아이템리스트; }
}
