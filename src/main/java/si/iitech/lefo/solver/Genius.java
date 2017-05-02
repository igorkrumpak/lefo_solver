package si.iitech.lefo.solver;

public class Genius {
	
	Reader reader = new Reader();
	Solver solver = new Solver();
	Typer typer = new Typer();	

	public Genius() {
		reader = new Reader();
		solver = new Solver();
		typer = new Typer();	
	}

	public void start() {
		String currentProblem = null;
		while(true) {
			String newProblem = reader.readProblem();
			if(currentProblem == null || !newProblem.contentEquals(currentProblem)) {
				currentProblem = newProblem;
				if(!currentProblem.isEmpty()) {
					int solution = solver.solveProblem(currentProblem);
					typer.typeSolutionAndPressOK(solution);
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
