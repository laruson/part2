package andrey.chernikovich.data.entity

import andrey.chernikovich.domain.entity.Student

fun StudentResponse.transformToDomain(): Student {
    return Student(id = id, name = name, age = age, img = img)
}

fun Student.transformToRequest(): StudentRequest {
    return StudentRequest(name = name,age = age, img = img)
}