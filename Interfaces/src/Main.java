import com.shuvamnandi.interfaces.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Shuvam", 0, 10);
        List savedValues = player.write();
        System.out.println("Saved values: " + savedValues);
        player.setHitPoints(20);
        player.setWeapon("Stormbringer");
        System.out.println("Player state: " + player.toString());
        player.read(savedValues);
        System.out.println("Player state: " + player.toString());
    }
}
