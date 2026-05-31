sequenceDiagram
    autonumber
    actor Player as "플레이어"
    participant ctrl as "<<control>>:전투"
    participant p as "<<domain>>:플레이어"
    participant c as ":캐릭터"
    participant inv as ":인벤토리"
    participant item as ":아이템"

    Player->>ctrl: 아이템획득(id:String, 아이템명:String, 아이템타입:String, 아이템가치:int)
    ctrl->>p: 플레이어체크(id:String):boolean

    alt [id == hero]
        p-->>ctrl: return true
        ctrl->>p: 캐릭터가져오기():캐릭터
        p-->>ctrl: return c
        ctrl->>c: 아이템추가(아이템명:String, 아이템타입:String, 아이템가치:int):boolean
        c->>inv: 아이템추가(아이템명:String, 아이템타입:String, 아이템가치:int):boolean

        alt [현재크기 < 10]
            inv->>+item: new 아이템(아이템명:String, 아이템타입:String, 아이템가치:int)
            note right of item: Composition 발생<br/>인벤토리가 아이템 객체를 직접 생성
            alt [아이템가치 >= 1000]
                item->>item: 아이템등급 = 전설
            else [아이템가치 >= 500]
                item->>item: 아이템등급 = 희귀
            else [아이템가치 < 500]
                item->>item: 아이템등급 = 일반
            end
            item-->>-inv: 생성 및 등급 설정 완료
            inv->>inv: 아이템리스트.add(새아이템)
            inv-->>c: return true
            c-->>ctrl: return true
            ctrl-->>Player: 아이템 획득 성공
        else [현재크기 >= 10]
            inv-->>c: return false
            c-->>ctrl: return false
            ctrl-->>Player: 용량 초과
        end
    else [id != hero]
        p-->>ctrl: return false
        ctrl-->>Player: 로그인 실패
    end
