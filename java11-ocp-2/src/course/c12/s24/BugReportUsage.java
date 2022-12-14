package course.c12.s24;

@BugReport(
	assignedTo = "Jim", 
	ref = @Reference(id = "3352627"), 
	repeatable = false, 
	reportedBy = { "Bill", "Jill" }, 
	status = Status.CONFIRMED, 
	testCase = MyTestCase.class)
public class BugReportUsage {

}

class MyTestCase {
}