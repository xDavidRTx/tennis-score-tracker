package com.xdavidrtx.scoretracker

case class Player (val name: String, var score: Int = 0){
  def winBall(): Unit = score+=1
}
