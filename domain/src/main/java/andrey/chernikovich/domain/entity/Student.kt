package andrey.chernikovich.domain.entity

data class Student(val id: String="",
                   val name: String,
                   val age: Int,
                   val img: String) : DomainEntity {
}