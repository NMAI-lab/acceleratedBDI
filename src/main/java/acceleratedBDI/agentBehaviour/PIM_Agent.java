package acceleratedBDI.agentBehaviour;

import jason.asSemantics.Agent;
import jason.asSemantics.Intention;

import java.util.Queue;

public class PIM_Agent extends Agent {

    @Override
    public Intention selectIntention(Queue<Intention> intentions) {
        System.out.println("I'm in the intention selection function!");

        return super.selectIntention(intentions);
    }


}
