package game;

import java.util.ArrayList;
import java.util.List;

public class 길드 {
    public String 길드명;
    private int 최대인원 = 5;
    private List<캐릭터> 캐릭터리스트 = new ArrayList<>();

    public 길드(String 길드명) {
        this.길드명 = 길드명;
    }

    public int 현재인원() { return 캐릭터리스트.size(); }
    public int 최대인원가져오기() { return 최대인원; }

    public boolean 캐릭터가입(캐릭터 c) {
        if (캐릭터리스트.size() >= 최대인원) return false;
        캐릭터리스트.add(c);
        return true;
    }

    public List<캐릭터> 캐릭터리스트가져오기() { return 캐릭터리스트; }
}
