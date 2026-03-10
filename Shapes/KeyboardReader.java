import java.util.Scanner;

public class KeyboardReader
{
    private Scanner scanner;

    public KeyboardReader()
    {
        scanner = new Scanner(System.in);
    }

    public void pause()
    {
        System.out.println("Enter to continue");
        scanner.nextLine();
    }

    public void close()
    {
        scanner.close();
    }
}
