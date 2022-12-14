package course.c12.s53;

import java.util.List;

/**
 * Design and plan stuff.
 * 
 * @deprecated Use EnhancedPlanner instead.
 */
@Deprecated(since = "1.8", forRemoval = true)
public class Planner {

	public int getTaskQty(List<String> tasks) {
		return tasks.size();
	}

}
