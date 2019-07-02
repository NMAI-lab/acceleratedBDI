package acceleratedBDI.agentBehaviour;

import acceleratedBDI.util.ResourceManager;

import jason.architecture.AgArch;
import jason.asSemantics.*;
import jason.asSyntax.*;

import java.io.*;
import java.util.*;

/**
 * Example of an agent that only uses Jason BDI engine. It runs without all
 * Jason IDE stuff. (see Jason FAQ for more information about this example)
 *
 * The class must extend AgArch class to be used by the Jason engine.
 */
public class SimpleJasonAgent extends AgArch {
	private Queue<String> perceptionList;		// List of perceptions for this agent (from a file)

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

		// Set up the Jason agent
		try {
			Agent ag = new Agent();
			new TransitionSystem(ag, null, null, this);
			InputStream aslFile = ResourceManager.getResourceStream("/asl/" + "test" + ".asl");
			ag.initAg();
			ag.load(aslFile, "ugv");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		// Set up the perception input file
		String testingFilename = "/perceptions/" + "testPercepts" + ".txt";		// File name for the test perceptions
		BufferedReader reader;
		this.perceptionList = new LinkedList<>();

		try {
			String line;
			// Open the file
			reader = ResourceManager.getResourceBufferedReader(testingFilename);
			//reader = new BufferedReader(new FileReader(testingFilename));

			// Load the perceptions
			while ((line = reader.readLine()) != null) {
				this.perceptionList.add(line);
			}

			// Done reading the file
			reader.close();
			System.out.println("Finished going through testing file.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
			while (isRunning() && !this.perceptionList.isEmpty()) {
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
		List<Literal> literalList = new ArrayList<Literal>();

		// Get the current perception
		String nextPercept = this.perceptionList.poll();

		if (nextPercept != null) {
			// Process the perception
			for (String item: nextPercept.split("\\s+")) { //split around any number of whitespace/tabs
				literalList.add(Literal.parseLiteral(item));
			}
		} else {
			// All done
			System.out.println("All perceptions Processed.");
		}

		//Collection<Literal> returnList = super.getPercepts(ag);
		return literalList;
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