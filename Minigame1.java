import java.util.*;
class Reset extends Game{
    void card1() {
        for (int i = 0; i < 6; i++) {
            player1cardlist.add(i);
        }
    }
    void card2() {
        for (int i = 0; i < 6; i++) {
            player2cardlist.add(i);
        }
    }

}
class CardSelect extends Game{
    int count1 = 0;
    int count2 = 0;
    void player1cardselect() {
        for (int i = 0; i < player1cardlist.size(); i++) {
            System.out.printf("%2d", player1cardlist.get(i));
        }
        System.out.println();
        System.out.print("player1님, 카드를 한 장 골라주세요: ");
        temp1 = in.nextInt();
        while(count1 != player1cardlist.size()){
            count1 = 0;
            for (int i = 0; i < player1cardlist.size(); i++) {
                if(player1cardlist.get(i) != temp1) {
                    count1 ++;
                }
            }
            if(count1 == player1cardlist.size()) {
                System.out.println("범위를 벗어났습니다. 다시 숫자를 입력해주세요. ");
                temp1 = in.nextInt();
            }
            else {
                count1 = 0;
                break;
            }
            count1 = 0;
        }
        System.out.println("\n\n\n\n\n\n\n");
        player1cardlist.remove(player1cardlist.indexOf(temp1));
    }
    void player2cardselect() {
        for (int i = 0; i < player2cardlist.size(); i++) {
            System.out.printf("%2d", player2cardlist.get(i));
        }
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        System.out.println();
        System.out.print("player2님, 카드를 한 장 골라주세요: ");
        temp2 = in.nextInt();
        while(count2 != player1cardlist.size()){
            count2 = 0;
            for (int i = 0; i < player2cardlist.size(); i++) {
                if(player2cardlist.get(i) != temp2) {
                    count2 ++;
                }
            }
            if(count2 == player2cardlist.size()) {
                System.out.println("범위를 벗어났습니다. 다시 숫자를 입력해주세요. ");
                temp2 = in.nextInt();
            }
            else {
                count2 = 0;
                break;
            }
            count2 = 0;
        }
        System.out.println("\n");
        player2cardlist.remove(player2cardlist.indexOf(temp2));
    }
}
class Comparewith extends Game{
    void comparewith() {
        if(Integer.compare(temp1, temp2) == 1) {
            if((temp1 == 2 && temp2 == 0) || (temp1 == 5 && temp2 == 2) ) {
                System.out.println("player2가 승리하였습니다.\n\n");
                player2score += temp1 + temp2;
            }
            else {
                System.out.println("player1이 승리하였습니다.\n\n");
                player1score += temp1 + temp2;
            }
        }
        else if(Integer.compare(temp1, temp2) == -1) {
            if((temp1 == 0 && temp2 == 2) || (temp1 == 2 && temp2 == 5) ) {
                System.out.println("player1가 승리하였습니다.\n\n");
                player1score += temp1 + temp2;
            }
            else {
                System.out.println("player2가 승리하였습니다.\n\n");
                player2score += temp1 + temp2;
            }
        }
        else {
            System.out.println("무승부 입니다.\n\n");
            player1score += temp1;
            player2score += temp2;
        }
    }
}
class FinalComparewith extends Game{
    int cnt = 0;

    void FinalComparewith(){
        System.out.println("player1의 최종점수: " + player1score);
        System.out.println("player2의 최종점수: " + player2score);
        if(player1score < player2score) {
            System.out.println("player2가 최종 승리!");
            winner = "몬스터";
        }
        else if(player1score > player2score) {
            System.out.println("player1이 최종 승리!");
            winner = "사람";
        }
        else {
            System.out.println("무승부 입니다. 게임을 재개합니다.");
            cnt = 0;
        }
    }
}
class Game{
    Scanner in = new Scanner(System.in);
    static int player1score = 0;
    static int player2score = 0;
    static int temp1 = 0;
    static int temp2 = 0;
    static String winner;
    static ArrayList<Integer> player1cardlist = new ArrayList<>();
    static ArrayList<Integer> player2cardlist = new ArrayList<>();
    void gameexplanation() {
        System.out.println("어서오세요! 숫자 심리게임 시작합니다!");
        System.out.println("게임 설명을 보시겠습니까? y / n");
        String s = in.next();
        if(s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
            System.out.println("양 플레이어 모두 0, 1, 2, 3, 4, 5의 카드를 가집니다.\n매 라운드마다 양 플레이어는 카드를 내는데, 상대방보다 큰 숫자를 낸 플레이어가 이기게 됩니다.");
            System.out.println("단, 0은 2를 이기고 2는 5를 이깁니다.");
            System.out.println("3판이 진행되고, 자신이 낸 숫자와 상대방이 낸 숫자의 합을 점수로 얻게되며 총점이 높은 플레이어가 최종 승리합니다.\n");
            System.out.println("그럼 게임을 시작합니다! Game Start!\n");
        }
        else if(s.equalsIgnoreCase("n") || s.equalsIgnoreCase("no")) {
            System.out.println("게임을 바로 시작합니다!\n");
        }
    }
}
public class Minigame1 {
    public static void mini1main(String[] args) {
        Game g = new Game();
        Reset r = new Reset();
        Comparewith c = new Comparewith();
        FinalComparewith fc = new FinalComparewith();
        CardSelect cs = new CardSelect();
        g.gameexplanation();
        r.card1();
        r.card2();
        while(fc.cnt<3) {
            cs.player1cardselect();
            cs.player2cardselect();
            c.comparewith();
            fc.cnt ++;
            if(fc.cnt == 3) {
                fc.FinalComparewith();
            }
        }
    }
}