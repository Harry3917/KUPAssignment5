package edu.knoldus

object Zero extends Nat {

  def error(string:String)=throw new Exception(string)
  def isZero: Boolean = true

  def predecessor: Nat = error("Negative Number.")

  def successor: Nat = new Succ(Zero)

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if (that.isZero) Zero else error("Negative Number")
}