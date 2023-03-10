// 점수 시스템(현재 점수 출력하게끔)
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
class   game3 {
    Random rand = new Random();
    Scanner Scan = new Scanner(System.in);
    String nextment;
    int player1length = 999;
    int player1height = 999;
    int player2length = 999;
    int player2height = 999;
    int poisonlength = rand.nextInt(9) + 1;
    int poisonheight = rand.nextInt(9) + 1;
    String[][] box = new String[9][9];
    int playercnt = 0;
    int break1;
    int breakwhile;
    static int player1score = 0;
    static int player2score = 0;

    static int player1gamescore = 0;

    static int player2gamescore = 0;
    static String winner;
    String explainaion = "\n";
    void boxmaking() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                box[i][j] = "\uD83E\uDD5B";
            }
        }
    }

    void start() {
        System.out.print("안녕하세요! 독을 피해 물을 마셔라! 게임에 오신 것을 환영합니다!");
        nextment = Scan.nextLine();
        System.out.println("설명이 필요하시다면 GUI창의 yes을 눌러주세요!");

    }

    void player1select() {
        breakwhile = 0;
        break1 = 0;
        playercnt += 1;
        if (playercnt == 1) {
            nowscoreprint();
            nowbox();
            player1masilmulselect();
            player1false();
            if (breakwhile == 1) {
                return;
            }
            while (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1 || box[player1length-1][player1height-1].equals("\uD83D\uDEAB")) {
                player1notrange();
                nextment = Scan.nextLine();
                nowscoreprint();
                nowbox();
                player1masilmulselect();
            }
        } else {

            nowscoreprint();
            nowbox();
            player1masilmulselect();
            player1false();
            if (breakwhile == 1) {
                return;
            }
            if (break1 == 1) {
                return;
            }
            while (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1 || box[player1length-1][player1height-1].equals("\uD83D\uDEAB")) {
                nextment = Scan.nextLine();
                player1false();
                if (break1 == 1) {
                    return;
                }
                player1notrange();
                nextment = Scan.nextLine();
                nowscoreprint();
                nowbox();
                player1masilmulselect();
            }
        }
        player1true();
        nextment = Scan.nextLine();
        box[player1length-1][player1height-1] = "\uD83D\uDEAB";
        if (playercnt == 5) {
            System.out.println("player1은 독을 마시지 않았네요!");
            nextment = Scan.nextLine();
            System.out.println("player2가 마실 차례에요!");
            nextment = Scan.nextLine();
        }
    }

    void player1true() {
        System.out.println("물을 마셨어요!");
        nextment = Scan.nextLine();
        player1score += 1;
    }

    void player2true() {
        System.out.println("물을 마셨어요!");
        nextment = Scan.nextLine();
        player2score += 1;
    }

    void player1false() {
        if (player1length == poisonlength && player1height == poisonheight) {
            System.out.println("player1이 독을 마셨습니다. ㅠㅠ");
            System.out.println("player2 승!");
            breakwhile = 1;
            player2gamescore += player2score;
            player1score = 0;
            player2score = 0;
            gamescoreprint();
        }
        if (playercnt != 1) {
            if (player1length == 99 && player1height == 99) {
                break1 = 1;
                System.out.println("player1은 독을 마시지 않았네요!");
                nextment = Scan.nextLine();
                System.out.println("player2가 마실 차례에요!");
                nextment = Scan.nextLine();
            }
        }
    }
    void player1notrange() {
        if (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1) {
            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
        } else {
            System.out.println("빈병이에요,, \n다시 입력해주세요.");
        }
    }

    void nowbox() {
        for (int l = 0; l < 9; l++) {
            for (int k = 0; k < 9; k++) {
                System.out.print(box[l][k] + " ");
            }
            System.out.println();
        }
    }

    void player1masilmulselect() {
        System.out.print("player1 마실 물 위치 선택 : ");
        player1length = Scan.nextInt();
        player1height = Scan.nextInt();
    }

    void player2select() {
        breakwhile = 0;
        break1 = 0;
        playercnt += 1;
        if (playercnt == 1) {
            nowscoreprint();
            nowbox();
            player2masilmulselect();
            player2false();
            if (breakwhile == 1) {
                return;
            }
            while (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1 || box[player2length-1][player2height-1].equals("\uD83D\uDEAB")) {
                player2notrange();
                nextment = Scan.nextLine();
                nowscoreprint();
                nowbox();
                player2masilmulselect();
            }
        } else {

            nowscoreprint();
            nowbox();
            player2masilmulselect();
            player2false();
            if (breakwhile == 1) {
                return;
            }
            if (break1 == 1) {
                return;
            }
            while (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1 || box[player2length-1][player2height-1].equals("\uD83D\uDEAB")) {
                nextment = Scan.nextLine();
                player2false();
                if (break1 == 1) {
                    return;
                }
                player2notrange();
                nextment = Scan.nextLine();
                nowscoreprint();
                nowbox();
                player2masilmulselect();
            }
        }
        player2true();
        nextment = Scan.nextLine();
        box[player2length-1][player2height-1] = "\uD83D\uDEAB";
        if (playercnt == 5) {
            System.out.println("player2은 독을 마시지 않았네요!");
            nextment = Scan.nextLine();
            System.out.println("player1이 마실 차례에요!");
            nextment = Scan.nextLine();
        }
    }

    void player2false() {
        if (player2length == poisonlength && player2height == poisonheight) {
            System.out.println("player2이 독을 마셨습니다. ㅠㅠ");
            System.out.println("player1 승!");
            breakwhile = 1;
            player1gamescore += player1score;
            player1score = 0;
            player2score = 0;
            gamescoreprint();
        }
        if (playercnt != 1) {
            if (player2length == 99 && player2height == 99) {
                break1 = 1;
                System.out.println("player2는 독을 마시지 않았네요!");
                nextment = Scan.nextLine();
                System.out.println("player1이 마실 차례에요!");
                nextment = Scan.nextLine();
            }
        }
    }
    void player2notrange() {
        if (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1) {
            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
        } else {
            System.out.println("빈병이에요,, \n다시 입력해주세요.");
        }
    }

    void player2masilmulselect() {
        System.out.print("player2 마실 물 위치 선택 : ");
        player2length = Scan.nextInt();
        player2height = Scan.nextInt();
    }

    void whowin() {
        if (player1score > player2score) {
            System.out.println("player1이 이겼습니다!");
            winner = "사람";
        } else {
            System.out.println("player2가 이겼습니다!");
            winner = "몬스터";
        }
    }

    void gamescoreprint() {
        System.out.println("현재 스코어");
        System.out.println(player1gamescore + " : " + player2gamescore);
    }

    void nowscoreprint() {
        System.out.println("player1이 마신 물 개수 - " + player1score + "잔 ");
        System.out.println("player2가 마신 물 개수 - " + player2score + "잔");
    }
}

class Detail2 extends JFrame {
    Detail2() {
        setTitle("물마시기 게임");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        JLabel l = new JLabel("설명이 필요하십니까?");
        JButton b1 = new JButton("Yes");
        JButton b2 = new JButton("No");
        p.add(l);
        p.add(b1);
        p.add(b2);
        add(p);
        ActionListener l1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                System.out.println();
                System.out.println("사과, 바나나, 오렌지가 그려져 있는 과녁이 랜덤하게 10번 나옵니다.\n플레이어는 과녁에 그려져 있는 그림과 같은 모양의 화살을 발사해야 합니다.\n과녁을 모두 부순 시간을 측정하여 더 빠른 시간 내에 과녁을 모두 부순 플레이어가 승리하게 됩니다.\n플레이어는 enter를 누를 시 화살을 발사할 수 있고 space+enter를 누르면 다음 모양의 화살로 변경할 수 있습니다.");
                System.out.println();
                System.out.println("Enter를 누르면 게임이 시작 됩니다");
            }
        };
        b1.addActionListener(l1);
        setVisible(true);
    }
}

public class Minigame3 {
    public static void mini3main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        Detail2 d = new Detail2();
        game3 a = new game3();
        a.start();
        for (int kkk = 0; kkk < 3; kkk++) {
            String nextment = Scan.nextLine();
            System.out.println("게임 " + (kkk+1) + " 시작합니다.");
            nextment = Scan.nextLine();
            a.boxmaking();
            outwhile : while (true) {
                a.playercnt = 0;
                for (int i = 0; i < 5; i++) {
                    a.player1select();
                    if (a.breakwhile == 1) {
                        break outwhile;
                    }
                    if (a.break1 == 1) {
                        break;
                    }
                }
                a.playercnt = 0;
                for (int i = 0; i < 5; i++) {
                    a.player2select();
                    if (a.breakwhile == 1) {
                        break outwhile;
                    }
                    if (a.break1 == 1) {
                        break;
                    }
                }
            }
            if (kkk == 2) {
                a.whowin();
            }
        }
    }
}