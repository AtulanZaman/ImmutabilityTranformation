package ece750.analysis;

import java.util.Map;

import soot.Body;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Transform;
import soot.toolkits.graph.ExceptionalUnitGraph;

public class GuaranteedDefsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackManager.v().getPack("jtp").add(
			    new Transform("jtp.myTransform", new BodyTransformer() {
				      protected void internalTransform(Body body, String phase, Map options) { // TODO what to do with the map??
				        new GuaranteedDefs(new ExceptionalUnitGraph(body));
				      }     	
		        }
    ));	
	  soot.Main.main(args);
	}

}


