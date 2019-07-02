package acceleratedBDI.agentBehaviour;

import acceleratedBDI.util.ResourceManager;

import jason.architecture.AgArch;
import jason.asSemantics.*;
import jason.asSyntax.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;


/**
 * Example of an agent that only uses Jason BDI engine. It runs without all
 * Jason IDE stuff. (see Jason FAQ for more information about this example)
 *
 * The class must extend AgArch class to be used by the Jason engine.
 */
public class SimpleJasonAgent extends AgArch {
	//private static final String broadcastID = "BROADCAST";
	
	//private String name;
	//private SyncAgentState agentState;
	//private boolean running;
	//private static Logger logger = Logger.getLogger(SimpleJasonAgent.class.getName());

	//private double lastPerceptionId;		// ID of the last perception received
	//private boolean firstPerception;	// Flag for noting if any perceptions have ever been received (deal with the first ID issue)
	//private PerceptionHistory perceptHistory;
	private File perceptionLogFile;
	
	// TimeStamp file names
	//private long lastCycleTimeStamp;
	//private File timeStampFile;
	
	public SimpleJasonAgent() {

		// Set parameters for the first perception ID
		//this.lastPerceptionId = 0;

		//this.firstPerception = true;
		//this.perceptHistory = new PerceptionHistory();
		//agentState = modelAgentState;
		//running = false;

		// set up the Jason agent
		try {
			Agent ag = new Agent();
			new TransitionSystem(ag, null, null, this);
			//this.name = id;
			InputStream aslFile = ResourceManager.getResourceStream("/asl/" + "ugv" + ".asl");
			ag.initAg();
			ag.load(aslFile, "ugv");
		} catch (Exception e) {
			//logger.log(Level.SEVERE, "Init error", e);
			System.out.println(e.toString());
		}
		
		// Set up the perception logfile
		//try {
		//	this.perceptionLogFile = ResourceManager.createOutputFile("PerceptionLog_" + this.name + ".log");
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		// Set up the cycle length logfile
		//this.lastCycleTimeStamp = 0;
		//try {
		//	this.timeStampFile = ResourceManager.createOutputFile("AgentTimeStamps_" + this.name + ".log");
		//} catch (Exception e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}

	/**
	 * Run reasoning cycles on the agent
	 */
	public void run(){
		try {
			while (isRunning()) {
				// calls the Jason engine to perform one reasoning cycle
				getTS().reasoningCycle();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	// this method just add some perception for the agent
	@Override
	public List<Literal> perceive() {
		List<Literal> litteralList = new ArrayList<Literal>();
		litteralList.add(Literal.parseLiteral("fact(5)"));

		//Todo: Make this parse lines from a file (or randomly generate perceptions)

		return litteralList;
	}
	
	/**
	 * This method gets the agent actions. This is called back by the agent code
	 */
	@Override
	public void act(ActionExec action) {
		System.out.println(action.toString());

		// Set that the execution was OK and flag it as complete.
		action.setResult(true);
		actionExecuted(action);
	}

}