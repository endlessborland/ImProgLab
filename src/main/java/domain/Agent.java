package domain;

public class Agent {
    Status status;
    double chanceToBuy;
    double realChanceToBuy;
    int productLifespan;
    int remainingLifespan;
    double incChance;

    public Agent(double chanceToBuy, int productLifespan, double incChance) {
        this.chanceToBuy = chanceToBuy;
        this.productLifespan = productLifespan;
        this.incChance = incChance;
        this.realChanceToBuy = chanceToBuy;
    }


    public void incChance() {
        this.realChanceToBuy += incChance;
    }

    public boolean run() {
        if (this.status == Status.BUYER) {
            if (Randomizer.rand.nextDouble() <= this.realChanceToBuy) {
                this.status = Status.CONSUMER;
                remainingLifespan = productLifespan;
                return true;
            }
        } else {
            if (remainingLifespan > 0)
                remainingLifespan--;
            else {
                this.status = Status.BUYER;
                this.realChanceToBuy = this.chanceToBuy;
            }
        }
        return false;
    }
}
