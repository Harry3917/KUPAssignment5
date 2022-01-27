# Classes And Objects Assignment

Class Int can in principle also be implemented using just objects and classes, without reference to a built-in type of integers. To see how we consider a slightly simpler problem, namely how to implement a type Nat of natural (i.e. non-negative) numbers. Here is the definition of an abstract class Nat:



``` bash
trait Nat {
def isZero: Boolean
def predecessor: Nat
def successor: Nat
def +(that: Nat): Nat
def -(that: Nat): Nat

}
```

To implement the operations of class Nat, we define a sub-object Zero and a subclass Succ (for successor). Each number N is represented as N applications of the Succ constructor to Zero:


new Succ( ... new Succ(Zero) ... )
-------------------------------------------------------
                N times



The implementation of the Zero object is straightforward:



``` bash
object Zero extends Nat {
def isZero: Boolean = true
def predecessor: Nat = error("negative number")
def successor: Nat = new Succ(Zero)
def +(that: Nat): Nat = that
def -(that: Nat): Nat = if (that.isZero) Zero else error("negative number")
}
```


The implementation of the predecessor and subtraction functions on Zero throws an Error exception, which aborts the program with the given error message. Here is the implementation of the successor class:
``` bash
class Succ(x: Nat) extends Nat {
def isZero: Boolean = false
def predecessor: Nat = x
def successor: Nat = new Succ(this)
def +(that: Nat): Nat = x + that.successor
def -(that: Nat): Nat = if (that.isZero) this else x - that.predecessor
}
```



Note the implementation of method successor. To create the successor of a number, we need to pass the object itself as an argument to the Succ constructor. The object itself is referenced by the reserved name this.


The implementations of + and - each contain a recursive call with the constructor argument as a receiver. The recursion will terminate once the receiver is the Zero object (which is guaranteed to happen eventually because of the way numbers are formed).


Write an implementation Integer of integer numbers.


The implementation should support all operations of class Nat while adding two methods:


def isPositive: Boolean
def negate: Integer

The first method should return true if the number is positive. The second method should negate the number. Do not use any of Scala’s standard numeric classes in your implementation. (Hint: There are two possible ways to implement Integer. One can either make use of the existing implementation of Nat, representing an integer as a  natural number and a sign. Or one can generalize the given implementation of Nat to  Integer, using the three subclasses Zero for 0, Succ for positive numbers, and Pred for negative numbers.)
