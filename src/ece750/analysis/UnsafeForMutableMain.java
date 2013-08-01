package ece750.analysis;

import java.util.Iterator;

import soot.Body;
import soot.SootClass;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.AbstractFlowAnalysis;
import soot.toolkits.scalar.ForwardFlowAnalysis;

public class UnsafeForMutableMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SootClass c = Scene.v().loadClassAndSupport("ClientEscape");
		c.setApplicationClass();
		SootMethod m = c.getMethodByName("main");
		Body b = m.retrieveActiveBody();
		UnitGraph g = new ExceptionalUnitGraph(b);
		UnsafeForMutableAnalysis result = new UnsafeForMutableAnalysis(g);
		/**
		 * Need to finish coding this part.
		 */
		Iterator<Unit> i = g.iterator();
		while(i.hasNext()){
			Unit u = (Unit)i.next();
			for(;;){
				result.mustAlias(l1, s1, l2, s2);
			}
		}
	}

}
