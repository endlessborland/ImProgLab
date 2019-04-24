package domain;

public class Simulation {
    int productLifespan;
    double chanceToBuy;
    double incChance;
    int agentAmount;
    int iterations;
    int bought;
    Agent agents[];

    public int getBought() {
        return bought;
    }

    public Simulation(int productLifespan, double chanceToBuy, double incChance, int agentAmount, int iterations) {
        this.productLifespan = productLifespan;
        this.chanceToBuy = chanceToBuy;
        this.incChance = incChance;
        this.agentAmount = agentAmount;
        this.iterations = iterations;
        this.bought = 0;
        agents = new Agent[agentAmount];
        for (int i = 0; i < agentAmount; i++)
            agents[i] = new Agent(chanceToBuy, productLifespan, incChance);
    }

    public void run() {
        for (int i = 0; i < iterations; i++)
            for (int j = 0; j < agentAmount; j++)
                runAgent(agents[j]);
    }

    private void runAgent(Agent agent) {
        if (bought > 0)
        {
            agent.incChance();
            bought--;
        }
        if (agent.run())
            bought++;
    }
}
