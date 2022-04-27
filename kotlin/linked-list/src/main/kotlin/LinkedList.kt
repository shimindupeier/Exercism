class Deque<T> {

    private data class Node<T>(val value: T, val next: Node<T>? = null, var prev: Node<T>? = null)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    //private var size: Int = 0

    fun push(value: T) {
        head = Node(value, head)
        if (tail == null) {
            tail = head?.next
            //tail?.prev = head
        }
        println("head $head")
    }

    fun pop(): T? {
        val result = head?.value
        head = head?.next
        println(result)
        return result
    }

    fun unshift(value: T) {
        tail = Node(value, tail)
        if (head == null) {
            head = tail?.next
        }
    }

    fun shift(): T? {
        val result = head?.value
        head?.prev = null
        println("shift $result")
        return result
    }
}
