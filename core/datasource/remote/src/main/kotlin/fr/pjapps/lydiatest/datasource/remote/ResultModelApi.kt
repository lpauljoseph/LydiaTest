package fr.pjapps.lydiatest.datasource.remote

data class ResultModelApi(
    val results : List<ContactModelApi>
)

data class ContactModelApi(
    val gender: String,
    val name: Name,
    val phone: String,
    val cell: String,
    val email: String,
    val registered: Registered,
    val location: Location,
    val picture: Picture,
    val login : Login,
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates,
)

data class Coordinates(
    val latitude: String,
    val longitude: String,
)

data class Street(
    val number: Int,
    val name: String
)

data class Registered(
    val date: String,
    val age: Int
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

data class Login(
    val uuid:String,
)
