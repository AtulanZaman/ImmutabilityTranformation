package ece750.analysis;
import soot.Context;
import soot.EscapeAnalysis;
import soot.jimple.AnyNewExpr;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.BackwardFlowAnalysis;;


public class UnsafeForMutableAnalysis extends BackwardFlowAnalysis implements EscapeAnalysis{

	public UnsafeForMutableAnalysis(DirectedGraph graph) {
		super(graph);
		doAnalysis();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks if the any of the element isEcape(). If yes,
	 * Add it to the HashMap
	 */
	@Override
	protected void flowThrough(Object arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void copy(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object entryInitialFlow() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Since this is a "May-Analysis" a union of the inputs is taken
	 */
	@Override
	protected void merge(Object arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object newInitialFlow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mayEscapeMethod(AnyNewExpr arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayEscapeMethod(Context arg0, AnyNewExpr arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayEscapeThread(AnyNewExpr arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayEscapeThread(Context arg0, AnyNewExpr arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
