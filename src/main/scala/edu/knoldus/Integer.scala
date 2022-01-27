package edu.knoldus

case class Integer(v: Nat, sign: Sign) extends Nat with Sign {
  override def isZero: Boolean = v.isZero

  override def predecessor: Nat = {
    if (isZero) Integer(v.successor, Negative)
    else if (isPositive) Integer(v.predecessor, sign)
    else Integer(v.predecessor, Negative)
  }

  override def successor: Nat = {
    if (isZero) Integer(v.successor, Positive)
    else if (isPositive) Integer(v.successor, sign)
    else Integer(v.predecessor, Negative)
  }

  override def +(that: Nat): Nat = {
    if (isZero) that
    else if (sign.isPositive) this.predecessor + that.successor
    else this.successor + that.predecessor
  }

  override def -(that: Nat): Nat = {
    if (that.isZero) this
    else that match {
      case Integer(v, s) => this + Integer(v, s.negate)
    }
  }


  def isPositive: Boolean = true

  def negate: Integer = Integer(v, sign.negate)
}