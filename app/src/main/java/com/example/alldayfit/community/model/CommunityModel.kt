package com.example.alldayfit.community.model

data class CommunityModel(
    val userId: String,
    val title: String,
    val post: String,
    val date: String,
)

object PracticeData {
    val list: List<CommunityModel>
        get() = _list
    private val _list = arrayListOf(
        CommunityModel(
            userId = "Temporary UI",
            title = "1111111", post = "1111111111", "2023.11.03"
        ), CommunityModel(
            userId = "Temporary UI",
            title = "2222", post = "122222", "2023.11.03"
        ), CommunityModel(
            userId = "Temporary UI",
            title = "1113331", post = "13333", "2023.11.03"
        ), CommunityModel(
            userId = "Temporary UI",
            title = "111444411", post = "14444", "2023.11.03"
        ),CommunityModel(
            userId = "Temporary UI",
            title = "1115555", post = "155555", "2023.11.03"
        ),CommunityModel(
            userId = "Temporary UI",
            title = "111666661", post = "16666", "2023.11.03"
        ),CommunityModel(
            userId = "Temporary UI",
            title = "11177777777", post = "177777", "2023.11.03"
        ),)
}
