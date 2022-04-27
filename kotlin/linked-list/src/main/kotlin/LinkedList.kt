class Deque<T> {

    private data class Node<T>(val value: T, var next: Node<T>?, var prev: Node<T>?)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun push(value: T) {
        val newNode = Node(value, head, tail)
        println("push $value")
        if (tail == null) {
            tail = newNode
            head = newNode
        }
        newNode.prev = tail
        tail?.next = newNode
        tail = newNode
    }

    fun pop(): T? {
        val result = tail?.value
        println("pop $result")
        tail = tail?.prev

        return result
    }

    fun unshift(value: T) {
        val newNode = Node(value, head, tail)
        println("unshift $value")
        if (head == null) {
            head = newNode
            tail = newNode
        }
        head?.prev = newNode
        newNode.next = head
        head = newNode
    }

    fun shift(): T? {
        val result = head?.value
        println("shift $result")
        head = head?.next
println("${head?.value}")
        return result
    }
}
