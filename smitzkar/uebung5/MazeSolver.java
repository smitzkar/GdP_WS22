// import javax.security.auth.x500.X500Principal;

// import gdp.stdlib.StdDraw;

public class MazeSolver {

    // Initialise global variable for point A
    // can be moved into solve, if we don't use it recursively
    public static int [] A = {0, 0};

	public static boolean solve(int[][] maze, int row, int col) {
		/*
		Using this for our main solve/move function kind of sucks. Always entering the full maze as a parameter
        is pointless? Then again, does it matter?

        THIS DOESN'T NEED RECURSION!! I think

		*/

        // check if we're already at the end -> if yes, return true
        if (maze[row][col] == 3) return true;

        // Store current position as point, rather pointless -> is same as maze[row][col]
        // this would be easier if we could change solve() parameters...
        int [] B = {row, col};

        // check if we're at the beginning (only needed if we use solve() recursively)
        // if true, we don't have a previous point, but we can define our start as coming "from the right"
        if (maze[row][col] == 2) {
            A[0] = row;
            A[1] = col + 1;            
        }

        // determine current heading from last (A) and current point (B)
        // to figure out the vector needed to move to the left, simply reverse the two (should always have a difference of 1, only)
        int [] vector = {A[0] - B[0], A[1] - B[1]};
        int [] leftVector = {vector[1], vector[2]};
        // combine both into one for final solution!



    

        move(A, B);

        // Idea: move() with 
        // in: pointA, pointB (or A + vector)
        // out: C (or the new B)
            
        
	}

	public static void draw(int[][] maze) {
		/*
		Hier ist Platz für Ihre Lösung zum Anzeigen
		*/

        // NO LONGER WORKS with new idea of how to do solve/move
        // simply store all moves, then remove backtracking, instead?
        // Idea: 
        // at every position run solve(), then move, run solve, move, etc.
        // -> this effectively looks into current path and sees if it can solve from there
        //    as soon as it can no longer solve, it knows that it's a dead end
        //    -> move one step back and try another heading
        // swap the path points in maze to 2
        // then simply draw the maze and colour accordingly
	}
	

    public static int[] move(int[] A, int[] B) {
        // pass by reference going to be an issue?

        // 1. calculate current trajectory as vector, transform into moveLeft
        // 2. check point to the left  (could also check here if we're already at end, but messy)
        //      while 0 or outside of maze (n-1 < left < 0): 
        //          rotate vector and call move() with old B, new A (or vector) (make sure to only do this 3 times, otherwise spinning forever)
        //          rotations++ (how to keep track of this without overwriting on recursion?)
        
        //          if rotations == 3 
        //              -> how to not only exit this function, but also let solve know that there's no valid move?
        //      return B + vector
    }








}
