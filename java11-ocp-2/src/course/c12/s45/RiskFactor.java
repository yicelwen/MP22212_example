package course.c12.s45;

import java.lang.annotation.Repeatable;

@Repeatable(RiskFactors.class)
public @interface RiskFactor {
	String desc();

	int level() default 1;
}
