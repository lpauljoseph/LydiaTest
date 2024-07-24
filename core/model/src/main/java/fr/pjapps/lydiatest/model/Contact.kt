package fr.pjapps.lydiatest.model

data class Contact(
    val uuid: String,
    val gender: String,
    val title: String,
    val first: String,
    val last: String,
    val phone: String,
    val cell: String,
    val email: String,
    val image: String,
    val thumbnail: String,
    val bigPicture:String,
) {
    companion object {
        val DEFAULT = Contact(
            uuid = "",
            gender = "",
            title = "",
            first = "",
            last = "",
            phone = "",
            cell = "",
            email = "",
            image = "",
            thumbnail = "",
            bigPicture = ""
        )
    }
}

