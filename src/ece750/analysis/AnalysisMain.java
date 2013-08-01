package ece750.analysis;

import ece750.analysis.LocalMustAliasAnalysis;
import soot.Body;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Transform;
import soot.jimple.toolkits.pointer.LocalMustNotAliasAnalysis;
//import soot.jimple.toolkits.pointer.LocalMustNotAliasAnalysis;
import soot.toolkits.graph.ExceptionalUnitGraph;
import java.util.Map;

public class AnalysisMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackManager.v().getPack("jtp").add(
				    new Transform("jtp.myTransform", new BodyTransformer() {
					      protected void internalTransform(Body body, String phase, Map options) { // TODO what to do with the map??
					        new LocalMustAliasAnalysis(new ExceptionalUnitGraph(body));
					      }     	
			        }
	    ));	
		  soot.Main.main(args);
	}

}
