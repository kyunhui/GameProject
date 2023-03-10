import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Arrow {
    String[] targetlist = { "\uD83C\uDF4E", "\uD83C\uDF4C", "\uD83C\uDF4A" };
    String[] arrowlist = { "\uD83C\uDF4E", "\uD83C\uDF4C", "\uD83C\uDF4A" };
    String arrow;
    int arrowindex;
    String target;
    String arrowchange;
    String explainaion = "\n";
    String nextment;
    Scanner Scan = new Scanner(System.in);
    Random rand = new Random();
    long player1time;
    long player2time;
    static String winner;

    void start() {
        System.out.print("안녕하세요! 같은 모양 화살로 과녁 맞추기! 게임에 오신 것을 환영합니다!");
        nextment = Scan.nextLine();

        System.out.println("게임을 시작합니다!");
        nextment = Scan.nextLine();
    }

    void maincode1() {
        System.out.println("player1부터 시작합니다!");
        try {
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
            System.out.println("시작");
            long start = System.currentTimeMillis();
            play();
            long end = System.currentTimeMillis();
            player1time = end - start;
            System.out.println("player1이 걸린 시간은" + (player1time/1000) + "초" + (player1time%1000) + "입니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void maincode2() {
        nextment = Scan.nextLine();
        System.out.println("player2 시작합니다!");
        try {
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
            System.out.println("시작");
            long start = System.currentTimeMillis();
            play();
            long end = System.currentTimeMillis();
            player2time = end - start;
            System.out.println("player2가 걸린 시간은" + (player2time/1000) + "초" + (player2time%1000) + "입니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println();
        if (player2time > player1time) {
            System.out.println("player1이 이겼습니다.");
            winner = "사람";
        } else if (player2time < player1time) {
            System.out.println("player2가 이겼습니다.");
            winner = "몬스터";
        }
    }

    void play() {
        for (int i = 0; i < 10; i++) {
            int a = rand.nextInt(3);
            target = targetlist[a];
            for (int j = 0; j < 10; j++) {
                System.out.println();
            }
            System.out.println("  " + target + "\n");
            arrowindex = 0;
            arrow = arrowlist[arrowindex];
            for (int m = 0; m < 8; m++) {
                System.out.println();
            }
            System.out.print(" (•‿•)⎠⎞");
            System.out.println(arrow);
            while (true) {
                arrowchange = Scan.nextLine();
                if (arrowchange.equals("")) {
                    try {
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.print("⎛⎝(•‿•) ");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.print(" (•‿•)⎠⎞");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.println();
                        System.out.print("⎛⎝(•‿•) ");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.print(" (•‿•)⎠⎞");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.print("⎛⎝(•‿•) ");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.print(" (•‿•)⎠⎞");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println();
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.print("⎛⎝(•‿•) ");
                        System.out.println(arrow);
                        Thread.sleep(500);

                        System.out.println();
                        System.out.println();
                        System.out.println("  " + target);
                        System.out.println("   ↑");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.print(" (•‿•)⎠⎞");
                        System.out.println(arrow);
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    if (arrow.equals(target)) {
                        try {
                            System.out.println("       ○○○○○○           ○○○         ○○○       ○○○○○○    ");
                            System.out.println("     ○        ○       ○     ○     ○     ○     ○     ○   ");
                            System.out.println("    ○                ○       ○   ○       ○    ○      ○  ");
                            System.out.println("    ○      ○○○○○     ○       ○   ○       ○    ○      ○  ");
                            System.out.println("    ○          ○     ○       ○   ○       ○    ○      ○  ");
                            System.out.println("     ○        ○       ○     ○     ○     ○     ○     ○   ");
                            System.out.println("       ○○○○○○           ○○○         ○○○       ○○○○○○    ");
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        break;
                    } else {
                        System.out.println("    ○○○○○○○○          ○○○         ○○○○○○      ");
                        System.out.println("    ○       ○        ○   ○        ○     ○     ");
                        System.out.println("    ○       ○       ○     ○       ○      ○    ");
                        System.out.println("    ○○○○○○○○○      ○○○○○○○○○      ○      ○    ");
                        System.out.println("    ○       ○     ○         ○     ○      ○    ");
                        System.out.println("    ○       ○    ○           ○    ○     ○     ");
                        System.out.println("    ○○○○○○○○    ○             ○   ○○○○○○      ");
                        System.out.println();
                        System.out.println("잘못 발사했어요");
                    }
                } else if (arrowchange.equals(" ")) {
                    arrowindex += 1;
                    if (arrowindex == 3) {
                        arrowindex = 0;
                    }
                    arrow = arrowlist[arrowindex];
                    for (int j = 0; j < 10; j++) {
                        System.out.println();
                    }
                    System.out.println("  " + target);
                    for (int m = 0; m < 8; m++) {
                        System.out.println();
                    }
                    System.out.print(" (•‿•)⎠⎞");
                    System.out.println(arrow);

                }
            }
        }
    }
}

class Detail extends JFrame {
    Detail() {
        setTitle("화살 게임");
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
                System.out.println(
                        "사과, 바나나, 오렌지가 그려져 있는 과녁이 랜덤하게 10번 나옵니다.\n플레이어는 과녁에 그려져 있는 그림과 같은 모양의 화살을 발사해야 합니다.\n과녁을 모두 부순 시간을 측정하여 더 빠른 시간 내에 과녁을 모두 부순 플레이어가 승리하게 됩니다.\n플레이어는 enter를 누를 시 화살을 발사할 수 있고 space+enter를 누르면 다음 모양의 화살로 변경할 수 있습니다.");
                System.out.println();
                System.out.println("Enter를 누르면 게임이 시작 됩니다");
            }
        };
        ActionListener l2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Enter를 누르면 게임이 시작 됩니다");
            }
        };
        b1.addActionListener(l1);
        b2.addActionListener(l2);
        setVisible(true);
    }
}

public class MiniGame2 {
    public static void minigame2(String[] args) {
        Arrow game = new Arrow();
        Detail d = new Detail();
        game.start();
        game.maincode1();
        game.maincode2();
    }
}