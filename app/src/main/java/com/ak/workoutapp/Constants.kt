package com.ak.workoutapp

import java.util.ArrayList

class Constants {
    companion object{

        fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        val jumpingJack = ExerciseModel(1,"JumpingJack",R.drawable.jumping_jack,false,false)
            exerciseList.add(jumpingJack)

        val wallSit = ExerciseModel(2,"Wall Sit",R.drawable.wall_sit,false,false)
            exerciseList.add(wallSit)

            val pushUp = ExerciseModel(2,"Push UP",R.drawable.push_up,false,false)
            exerciseList.add(pushUp)

            val abdominalCrunch = ExerciseModel(4,"Abodominal Crunch",R.drawable.abdominal_crunch,false,false)
            exerciseList.add(abdominalCrunch)

            val stepUpOnChair = ExerciseModel(5,"Step Up On Chair",R.drawable.step_up_on_chair,false,false)
            exerciseList.add(stepUpOnChair)

            val squat = ExerciseModel(6,"JumpingJack",R.drawable.squat,false,false)
            exerciseList.add(squat)

            val benchPres = ExerciseModel(7,"Bench Pres",R.drawable.bench_pres,false,false)
            exerciseList.add(benchPres)

            val inclinePres = ExerciseModel(8,"Incline Pres",R.drawable.incline_pres,false,false)
            exerciseList.add(inclinePres)

            return  exerciseList
    }
    }

}