import java.util.*;
class maingame {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    String[][] a = new String[10][10];
    int x1=0,y1=0;
    int x2=9, y2=9;
    String nextment = "\n";
    int playerheart = 100;
    int playerscore;
    int monsterscore;
    int minigamecnt;
    String direction1 = "";
    String direction2 = "";
    String maljajang;
    int cnt;
    void boardmaking() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = "\uD83D\uDFE3"; // 일반칸
            }
        }
        a[0][0] = "\u2B55"; // 플레이어 말
        a[9][9] = "\uD83D\uDC79"; // 몬스터
        for (int i = 0; i < 10; i++) {
            int k = rand.nextInt(9)+1;
            int l = rand.nextInt(9)+1;
            while(!a[k][l].equals("\uD83D\uDFE3")) {
                k = rand.nextInt(9) + 1;
                l = rand.nextInt(9) + 1;
            }
            a[k][l] = "\uD83D\uDEAB"; // 금지칸
        }
        for (int i = 0; i < 3; i++) {
            int k = rand.nextInt(9) + 1;
            int l = rand.nextInt(9) + 1;
            while(!a[k][l].equals("\uD83D\uDFE3")) {
                k = rand.nextInt(9) + 1;
                l = rand.nextInt(9) + 1;
            }
            a[k][l] = "\u2764"; // 하트칸
        }
        for (int i = 0; i < 3; i++) {
            int k = rand.nextInt(9) + 1;
            int l = rand.nextInt(9) + 1;
            while(!a[k][l].equals("\uD83D\uDFE3")) {
                k = rand.nextInt(9) + 1;
                l = rand.nextInt(9) + 1;
            }
            a[k][l] = "\uD83D\uDCB2"; // 미니게임칸 유니코드 추가해야함
        }
    }
    void start() {
        System.out.print("안녕하세요! 탈출구 찾기! 게임에 오신 것을 환영합니다!");
        nextment = in.nextLine();
        // 설명 gui 추가
    }
    void banmaking() {
        System.out.println("몬스터측 플레이어는 원하는 3곳에 벽을 쌓을 수 있습니다.");
        System.out.println("단 미니게임칸이나 체력칸, 플레이어 시작 지점을 완전히 막는 행위는 금지됩니다.");
        nextment = in.nextLine();
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 10; k++) {
                for (int l = 0; l < 10; l++) {
                    System.out.print(a[k][l]);
                }
                System.out.println();
            }
            System.out.print("벽을 쌓을 곳을 선택해주세요 : ");
            int k = in.nextInt();
            int l = in.nextInt();
            while(k - 1 > 10 || k - 1 < 0 || l - 1 > 10 || l - 1 < 0 || (!a[k-1][l-1].equals("\uD83D\uDFE3"))) {
                System.out.println("벽을 쌓을 수 없습니다. 다시 선택해주세요");
                nextment = in.nextLine();
                nextment = in.nextLine();
                for (int q = 0; q < 10; q++) {
                    for (int w = 0; w < 10; w++) {
                        System.out.print(a[q][w]);
                    }
                    System.out.println();
                }
                System.out.print("벽을 쌓을 곳을 선택해주세요 : ");
                k = in.nextInt();
                l = in.nextInt();
            }
            a[k-1][l-1] = "\uD83D\uDEAB"; // 금지칸
        }
    }

    void nowboard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    void heartplus() {
        System.out.println("하트를 먹어서 체력 30 증가");
        playerheart += 30;
        if (playerheart > 100) {
            playerheart = 100;
        }
        System.out.println("현제 플레이어 체력 : " + playerheart);
        a[x1][y1] = "\uD83D\uDFE3";
        whatplusminus1();
        a[x1][y1] = "\u2B55";
    }

    void minigamestart() {;
        minigamecnt ++;
        if(minigamecnt == 1) {
            Minigame1.mini1main(null);
            a[x1][y1] = "\uD83D\uDFE3";
            whatplusminus1();
            a[x1][y1] = "\u2B55";
            if (FinalComparewith.winner.equals("사람")) {
                playerscore += 1;
                playerheart += 15;
            } else {
                monsterscore += 1;
                playerheart -= 30;
                heartzero();
            }
        }else if(minigamecnt == 2) {
            MiniGame2.minigame2(null);
            a[x1][y1] = "\uD83D\uDFE3";
            whatplusminus1();
            a[x1][y1] = "\u2B55";
            if (Arrow.winner.equals("사람")) {
                playerscore += 1;
                playerheart += 15;
            } else {
                monsterscore += 1;
                playerheart -= 30;
                heartzero();
            }
        }else if(minigamecnt == 3) {
            Minigame3.mini3main(null);
            minigamecnt = 0;
            a[x1][y1] = "\uD83D\uDFE3";
            whatplusminus1();
            a[x1][y1] = "\u2B55";
            if (game3.winner.equals("사람")) {
                playerscore += 1;
                playerheart += 15;
            } else {
                monsterscore += 1;
                playerheart -= 30;
                heartzero();
            }
        }
        heartzero();
        System.out.println("게임 스코어 " + playerscore + " : " + monsterscore);
        if (minigamecnt == 3) {
            System.out.println("모든 미니게임을 플래이 하였어요!");
            if (playerscore > monsterscore) {
                System.out.println("몬스터가 이겼네요....");
            } else {
                System.out.println("용사가 이겼어요!!!");
            }
            System.exit(0);
        }
    }

    void peoplemonstermeeting() {
        playerheart -= 10;
        a[x1][y1] = "\uD83D\uDC79";
        x2 = x1;
        y2 = y1;
        whatplusminus1();
        a[x1][y1] = "\u2B55";
        System.out.println("몬스터와 마주쳐 용사의 체력이 10 감소했어요...");
        System.out.println("남은 체력 : " + playerheart);
        heartzero();
    }

    void monsterpeoplemeeting() {
        playerheart -= 10;
        a[x2][y2] = "\u2B55";
        x1 = x2;
        y1 = y2;
        whatplusminus2();
        a[x2][y2] = "\uD83D\uDC79";
        System.out.println("몬스터와 마주쳐 용사의 체력이 10 감소했어요...");
        System.out.println("남은 체력 : " + playerheart);
        heartzero();
    }

    void whatplusminus1() {
        if (direction1.equals("동")) {
            y1++;
        } else if (direction1.equals("서")) {
            y1--;
        } else if (direction1.equals("남")) {
            x1++;
        } else if (direction1.equals("북")) {
            x1--;
        }
    }

    void whatplusminus2() {
        if (direction2.equals("동")) {
            y2++;
        } else if (direction2.equals("서")) {
            y2--;
        } else if (direction2.equals("남")) {
            x2++;
        } else if (direction2.equals("북")) {
            x2--;
        }
    }

    void heartzero() {
        if (playerheart <= 0) {
            System.out.println("용사의 체력이 다 닳았어요....");
            System.out.println("몬스터 승리!");
            System.exit(0);
        }
    }

    void movingheartminus() {
        playerheart -= 3;
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("용사의 체력이 " + playerheart + "남았어요.");
        heartzero();
    }


    void peopleplayermoving() {
        int minigamecnt = 0;
        Dice2 d = new Dice2();
        d.DiceNum();
        int cnt = d.ran;
        while (true){
            if (cnt == 0) {
                break;
            }
            nowboard();
            System.out.println("용사 플레이어 한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
            System.out.print("방향 입력 : ");
            direction1 = in.next();
            if(direction1.equals("동")) {
                if(y1 == 9) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x1][y1+1].equals("\uD83D\uDEAB")) { // 금지
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                    System.out.println("금지 구역이에요!");
                }else if (a[x1][y1+1].equals("\u2764")) {
                    heartplus();
                    cnt -= 1;
                    movingheartminus();
                } else if (a[x1][y1+1].equals("\uD83D\uDC79")) {
                    peoplemonstermeeting();
                    cnt -= 1;
                    movingheartminus();
                } else if(a[x1][y1+1].equals("\uD83D\uDCB2")){
                    minigamestart();
                    cnt -= 1;
                    movingheartminus();
                }
                else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    y1++;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                    movingheartminus();
                }
            } else if(direction1.equals("서")){
                if(y1 == 0) {
                    System.out.println("갈 곳이 없어요!");
                }else if(a[x1][y1-1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                }else if (a[x1][y1-1].equals("\u2764")) {
                    heartplus();
                    cnt -= 1;
                    movingheartminus();
                } else if (a[x1][y1+1].equals("\uD83D\uDC79")) {
                    peoplemonstermeeting();
                    cnt -= 1;
                    movingheartminus();
                } else if(a[x1][y1-1].equals("\uD83D\uDCB2")){
                    minigamestart();
                    cnt -= 1;
                    movingheartminus();
                }else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    y1--;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                    movingheartminus();
                }
            } else if(direction1.equals("남")) {
                if(x1 == 9) {
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x1+1][y1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                } else if (a[x1+1][y1].equals("\u2764")) {
                    heartplus();
                    cnt -= 1;
                    movingheartminus();
                } else if (a[x1+1][y1].equals("\uD83D\uDC79")) {
                    peoplemonstermeeting();
                    cnt -= 1;
                    movingheartminus();
                } else if(a[x1+1][y1].equals("\uD83D\uDCB2")){
                    minigamestart();
                    cnt -= 1;
                    movingheartminus();
                }else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    x1++;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                    movingheartminus();
                }
            }else if(direction1.equals("북")) {
                if(x1 == 0) {
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x1-1][y1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                } else if (a[x1-1][y1].equals("\u2764")) {
                    heartplus();
                    cnt -= 1;
                    movingheartminus();
                } else if (a[x1-1][y1].equals("\uD83D\uDC79")) {
                    peoplemonstermeeting();
                    cnt -= 1;
                    movingheartminus();
                } else if(a[x1-1][y1].equals("\uD83D\uDCB2")){
                    minigamestart();
                    cnt -= 1;
                    movingheartminus();
                } else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    x1--;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                    movingheartminus();
                }
            }else {
                System.out.println("정확한 방향을 다시 입력해주세요.");
                nowboard();
                System.out.print("방향입력 : ");
                direction1 = in.next();
            }
        }
    }
    void monsterplayermoving() {
        Dice2 d = new Dice2();
        d.DiceNum();
        int cnt = d.ran;
        while (true) {
            if (cnt == 0) {
                break;
            }
            nowboard();
            System.out.println("몬스터 플레이어 한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
            System.out.print("방향 입력 : ");
            direction2 = in.next();
            if(direction2.equals("동")) {
                if(y2 == 9) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x2][y2+1].equals("\uD83D\uDEAB") || a[x2][y2+1].equals("\u2764") || a[x2][y2+1].equals("\uD83D\uDCB2")) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                    System.out.println("금지 구역이에요!");
                } else if (a[x2][y2+1].equals("\u2B55")) {
                    monsterpeoplemeeting();
                    cnt -= 1;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    y2++;
                    a[x2][y2] = "\uD83D\uDC79";
                    cnt -= 1;
                }
            } else if(direction2.equals("서")){
                if(y2 == 0) {
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x2][y2-1].equals("\uD83D\uDEAB") || a[x2][y2-1].equals("\u2764") || a[x2][y2-1].equals("\uD83D\uDCB2")) {
                    System.out.println("금지 구역이에요!");
                } else if (a[x2][y2-1].equals("\u2B55")) {
                    monsterpeoplemeeting();
                    cnt -= 1;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    y2--;
                    a[x2][y2] = "\uD83D\uDC79";
                    cnt -= 1;
                }
            } else if(direction2.equals("남")) {
                if(x2 == 9) {
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x2+1][y2].equals("\uD83D\uDEAB") || a[x2+1][y2].equals("\u2764") || a[x2+1][y2].equals("\uD83D\uDCB2")) {
                    System.out.println("금지 구역이에요!");
                } else if (a[x2+1][y2].equals("\u2B55")) {
                    monsterpeoplemeeting();
                    cnt -= 1;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    x2++;
                    a[x2][y2] = "\uD83D\uDC79";
                    cnt -= 1;
                }
            }else if(direction2.equals("북")) {
                if(x2 == 0) {
                    System.out.println("갈 곳이 없어요!");
                } else if(a[x2-1][y2].equals("\uD83D\uDEAB") || a[x2-1][y2].equals("\u2764") || a[x2-1][y2].equals("\uD83D\uDCB2")) {
                    System.out.println("금지 구역이에요!");
                } else if (a[x2-1][y2].equals("\u2B55")) {
                    monsterpeoplemeeting();
                    cnt -= 1;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    x2--;
                    a[x2][y2] = "\uD83D\uDC79";
                    cnt -= 1;
                }
            }else {
                System.out.println("정확한 방향을 다시 입력해주세요.");
                nowboard();
                System.out.print("방향입력 : ");
                direction2 = in.next();
            }
        }
    }
}
public class practice2 {
    public static void main(String[] args) {
        maingame a = new maingame();
        a.boardmaking();
        a.start();
        a.banmaking();
        while(true) {
            a.peopleplayermoving();
            a.monsterplayermoving();
        }
    }
}
class Dice2 {
    int ran;
    void DiceNum() {
        ran = (int) ((Math.random() * 6) + 1);
        if (ran == 1) {
            System.out.println("\u2680");
            System.out.println("1입니다");
        }
        if (ran == 2) {
            System.out.println("\u2681");
            System.out.println("2입니다");
        }
        if (ran == 3) {
            System.out.println("\u2682");
            System.out.println("3입니다");
        }
        if (ran == 4) {
            System.out.println("\u2683");
            System.out.println("4입니다");
        }
        if (ran == 5) {
            System.out.println("\u2684");
            System.out.println("5입니다");
        }
        if (ran == 6) {
            System.out.println("\u2685");
            System.out.println("6입니다");
        }
    }
}