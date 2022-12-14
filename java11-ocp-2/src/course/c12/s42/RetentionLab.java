package course.c12.s42;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@interface Anno1 {
}

@Retention(RetentionPolicy.CLASS)
@interface Anno2 {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Anno3 {
}
