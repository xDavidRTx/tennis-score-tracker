package com.xdavidrtx.scoretracker

case class TennisGame (player1: Player, player2: Player){

  def score: String = (regularPoints,  getLeader) match {
    case (true, _) => s"${getScoreString(player1.score)}, ${getScoreString(player2.score)}"
    case (_, None) => "deuce"
    case (false, Some(leader)) => if(isTheWinner) s"${leader.name} won" else s"advantage ${leader.name}"
  }

  private def regularPoints : Boolean = player1.score <= 3 && player2.score <= 3 && player1.score + player2.score < 6

  private def getLeader: Option[(Player)] = player1.score - player2.score match {
    case 1 | 2 => Some(player1)
    case -1 | -2 => Some(player2)
    case _ => None
  }

  private def isTheWinner: Boolean = Math.abs(player1.score - player2.score) >= 2
  private def getScoreString(score : Int):String = List("love", "fifteen", "thirty", "forty").lift(score).getOrElse("Undefined")
}
