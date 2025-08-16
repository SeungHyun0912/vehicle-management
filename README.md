# vehicle-management
Path Management service of Vehicles like AMR, AGV, OHT etc..


># Index
1. Description
2. Memo

>## Description

### Path Types
1. 직선 (Line)
    - 시작점/종료점 (간단).
    - <img width="304" height="101" alt="image" src="https://github.com/user-attachments/assets/b0137b5a-a45d-43c8-a071-0d4ec9d0f784" />
    

2. 원호 / 원(Circular arc)
    - 중심, 반지름, 시작각/종료각. 곡률(κ)=1/R (상수).
    - <img width="350" height="95" alt="image" src="https://github.com/user-attachments/assets/ef7861d4-bd15-49b4-b864-0bb58edb5534" />


3. 베지어(Bézier) / 스플라인 (Cubic Bézier, B‑spline, Catmull‑Rom)
    - 컨트롤 포인트로 매끄러운 궤적 생성. 구현/저장 쉽고 편집성 우수.
    - <img width="458" height="125" alt="image" src="https://github.com/user-attachments/assets/bb4af9df-d970-4ba7-bd90-d1565bb7ef32" />

5. 클로소이드(Clothoid, Euler spiral)
    - 곡률이 선형으로 변함(κ(s) = κ0 + k’·s). 차량/로봇의 조향이 자연스러워 도로·선형설계에 적합.
    - <img width="753" height="208" alt="image" src="https://github.com/user-attachments/assets/a4b03a63-2e74-4a34-bbcf-7baf91999eaa" />

7. 다항/폴리노미얼(Quintic, Cubic polynomial path)
    - 시작/끝 위치·속도·가속도를 맞출 때 쓰임.
    - <img width="192" height="103" alt="image" src="https://github.com/user-attachments/assets/c0ae03a8-f441-469f-b32d-248e9f1c5f1f" />


