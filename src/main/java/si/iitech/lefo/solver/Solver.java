package si.iitech.lefo.solver;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Solver {

	public int solveProblem(String problem) {
		Expression e = new ExpressionBuilder(problem).build();
		return (int)e.evaluate();		
	}
}
