package com.example.alldayfit.database.data

data class User(
    val userId: String,
    val email: String,
    val name: String,
    val nickname: String
)

data class InformationId(
    val inputDate: String, // yyyy.MM.dd 형식의 날짜 문자열
    val height: Int,
    val weight: Int
)

data class PhysicalInformation(
    val userId: String,
    val informationId: InformationId
)

data class LogId(
    val totalTime: Int,
    val exerciseDate: String // yyyy.MM.dd 형식의 날짜 문자열
)

data class ExerciseLog(
    val userId: String,
    val logId: LogId
)

data class MealLogId(
    val breakfast: Meal,
    val lunch: Meal,
    val dinner: Meal,
    val snack: Meal,
    val mealDate: String // yyyy.MM.dd 형식의 날짜 문자열
)

data class Meal(
    val foodText: List<String>,
    val foodImage: String
)

data class DietLog(
    val userId: String,
    val mealLogId: MealLogId
)
