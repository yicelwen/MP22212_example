package course.c12.s23;

@Exercise(startHour = 5, hoursPerDay = 3)
class Cheetah {
}

@Exercise(hoursPerDay = 0)
class Sleep {
}

@Exercise(hoursPerDay = 7, startHour = "8") // 編譯失敗
class ZooEmployee {
}
