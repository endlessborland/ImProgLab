public class WorldRunner {

    public static int consumers = 0;

    public synchronized static void increaseConsumers() {
        consumers++;
    }

}
