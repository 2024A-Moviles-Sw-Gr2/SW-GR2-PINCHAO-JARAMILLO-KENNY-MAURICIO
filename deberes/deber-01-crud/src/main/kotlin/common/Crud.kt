package common

interface Crud<T, ID> {
    fun create(item: T): T
    fun read(id: ID): T?
    fun readAll(): List<T>
    fun update(id: ID, item: T): Boolean
    fun delete(id: ID): Boolean
}