package acceleratedBDI.environment;

import jason.architecture.AgArch;

import acceleratedBDI.agentBehaviour.SimpleJasonAgent;

public class TestRunner {

    public static void main( String[] args ) {
        System.out.println("Hello world");

        AgArch myAgent = new SimpleJasonAgent();
       myAgent.toString();

       ((SimpleJasonAgent) myAgent).run();

    }
}
