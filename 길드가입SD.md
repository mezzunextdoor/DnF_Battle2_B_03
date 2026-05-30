sequenceDiagram
    autonumber
    actor Player as "플레이어"
    participant UI as "<<boundary>>:Join_Guild_UI"
    participant ctrl as "<<control>>:전투"
    participant p as ":플레이어"
    participant g as ":길드"

    Player->>UI: 길드가입(플레이어id, 길드명)
    UI->>ctrl: 길드가입(플레이어id:String, 길드명:String):boolean
    ctrl->>p: 플레이어체크(id:String):boolean

    alt [id == hero]
        p-->>ctrl: return true
        ctrl->>g: 현재인원():int
        g-->>ctrl: return memberCount

        alt [memberCount < 5]
            ctrl->>p: 캐릭터가져오기():캐릭터
            p-->>ctrl: return c
            ctrl->>+g: 캐릭터가입(c:캐릭터):boolean
            g->>g: 캐릭터리스트.add(c)
            g-->>-ctrl: return true
            ctrl-->>UI: return true (길드 가입 성공)
            UI-->>Player: 길드 가입 성공
        else [memberCount >= 5]
            ctrl-->>UI: return false (정원 초과)
            UI-->>Player: 정원 초과
        end
    else [id != hero]
        p-->>ctrl: return false
        ctrl-->>UI: return false (로그인 실패)
        UI-->>Player: 로그인 실패
    end
