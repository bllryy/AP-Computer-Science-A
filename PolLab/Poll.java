import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Poll {
   public static void main(String[] args) {
      JFrame pollFrame = new JFrame("Poll");
      PollWindow pw = new PollWindow();

      pollFrame.add(pw);
      pollFrame.setSize(900, 900);
      pollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pollFrame.setVisible(true);
   }
}

class PollWindow extends JPanel implements ActionListener {

   JButton button1, button2, button3, button4;
   int count1, count2, count3, count4;

   public PollWindow() {
      setBackground(Color.YELLOW);

      button1 = new JButton("Chocolate");
      button1.setToolTipText("Dont vote for Chocolate");
      button1.addActionListener(this);

      button2 = new JButton("Vanilla");
      button2.setToolTipText("Dont vote for Vanilla");
      button2.addActionListener(this);

      button3 = new JButton("Mint");
      button3.setToolTipText("Dont vote for Mint");
      button3.addActionListener(this);

      button4 = new JButton("Strawberry");
      button4.setToolTipText("Vote for Strawberry");
      button4.addActionListener(this);

      add(button1);
      add(button2);
      add(button3);
      add(button4);
   }

   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();

      if (source == button1)
         count1++;
      else if (source == button2)
         count2++;
      else if (source == button3)
         count3++;
      else if (source == button4)
         count4++;

      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      int xStep = getWidth() / 8;

      // vote counts
      int y = 575;
      g.setColor(Color.BLACK);
      g.drawString("" + count1, 1 * xStep, y);
      g.drawString("" + count2, 3 * xStep, y);
      g.drawString("" + count3, 5 * xStep, y);
      g.drawString("" + count4, 7 * xStep, y);

      // legend
      y = 580;
      g.setColor(Color.PINK);
      g.fillRect(1 * xStep, y, 10, 10);

      g.setColor(Color.BLUE);
      g.fillRect(3 * xStep, y, 10, 10);

      g.setColor(Color.WHITE);
      g.fillRect(5 * xStep, y, 10, 10);

      g.setColor(Color.GREEN);
      g.fillRect(7 * xStep, y, 10, 10);

      int total = count1 + count2 + count3 + count4;
      if (total == 0)
         return;

      int size = 4 * xStep;
      int x = 4 * xStep - size / 2;
      y = 70;

      g.setColor(Color.LIGHT_GRAY);
      g.fillOval(x, y, size, size);

      int from = -90;
      int degrees;

      degrees = -countToDegrees(count1, total);
      g.setColor(Color.PINK);
      g.fillArc(x, y, size, size, from, degrees);
      from += degrees;

      degrees = -countToDegrees(count2, total);
      g.setColor(Color.BLUE);
      g.fillArc(x, y, size, size, from, degrees);
      from += degrees;

      degrees = -countToDegrees(count3, total);
      g.setColor(Color.WHITE);
      g.fillArc(x, y, size, size, from, degrees);
      from += degrees;

      degrees = -countToDegrees(count4, total);
      g.setColor(Color.GREEN);
      g.fillArc(x, y, size, size, from, degrees);
   }

   /**
    * Converts a vote count into degrees for the pie chart
    */
   private int countToDegrees(int count, int total) {
      return (int) ((double) count / total * 360);
   }
}
