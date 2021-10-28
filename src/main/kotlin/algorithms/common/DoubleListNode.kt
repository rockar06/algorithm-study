package algorithms.common

class DoubleListNode<T>(var value: T) {
    var next: DoubleListNode<T>? = null
    var previous: DoubleListNode<T>? = null
}