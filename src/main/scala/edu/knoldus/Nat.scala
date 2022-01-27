package edu.knoldus
trait Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat

  def +(that: Nat): Nat

  def -(that: Nat): Nat

}

trait Sign {
  def isPositive: Boolean

  def negate: Sign
}

object Positive  extends Sign {
  override def isPositive: Boolean = true

  override def negate: Sign = Negative
}

object Negative  extends Sign {
  override def isPositive: Boolean = false

  override def negate: Sign = Positive
}