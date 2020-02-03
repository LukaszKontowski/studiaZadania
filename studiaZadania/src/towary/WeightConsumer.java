package towary;

public class WeightConsumer extends Thread {
    public static boolean shouldContinue = false;

    @Override
    public void run() {
        int currentListIndex = 0;
        long totalWeight = 0;
        int currentListSize = 0;
        synchronized (Towar.towary) {
            while (Towar.towary.isEmpty()) {
                try {
                    Towar.towary.notify();
                    Towar.towary.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (Towar.towary.size() > currentListSize || shouldContinue) {
                if (!TowarCreator.isDead) {
                    while (Towar.towary.size() < currentListSize + 100) {
                        try {
                            Towar.towary.notify();
                            Towar.towary.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int i = 0; i < 100; i++) {
                        totalWeight += Towar.towary.get(i + currentListIndex).getWeight();
                    }
                    currentListSize = Towar.towary.size();
                    currentListIndex = currentListSize - 1;
                    System.out.println("policzono wage " + currentListSize + " towarów");
                    shouldContinue = false;
                    Towar.towary.notify();
                    try {
                        Towar.towary.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    while (Towar.towary.size() > currentListSize) {
                        totalWeight += Towar.towary.get(currentListIndex + 1).getWeight();
                        currentListIndex++;
                        currentListSize++;
                    }
                    break;
                }
            }
        }
        System.out.println("policzono wage " + currentListSize + " towarów");
        System.out.println("Sumaryczna waga to " + totalWeight);
    }
}
