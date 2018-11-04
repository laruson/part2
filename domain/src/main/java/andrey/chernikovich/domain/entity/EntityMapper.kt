package andrey.chernikovich.domain.entity

fun StudentSearch.transformToRequest():String{
    return "name LIKE'$name%'"
}
