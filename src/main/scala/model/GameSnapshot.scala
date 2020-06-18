package model

import utils.BoardGame.Board
import utils.Pair

trait GameSnapshot {

  def getVariant: GameVariant.Val

  def getPlayerToMove: Player.Value

  def getWinner: Player.Value

  def getBoard: Board

  /**
    * Returns the coordinates of the last move.
    *
    * @return
    *         from coordinate - to coordinate
    */
  def getLastMove: Option[(Pair[Int], Pair[Int])]

  def getNumberCapturedBlacks: Int

  def getNumberCapturedWhites: Int
}

object GameSnapshot {

  def apply(variant: GameVariant.Val, playerToMove: Player.Value, winner: Player.Value, board: Board, lastMove: Option[(Pair[Int],Pair[Int])], numberCapturedBlacks: Int, numberCapturedWhites: Int): GameSnapshot =
    GameSnapshotImpl(variant, playerToMove, winner, board, lastMove, numberCapturedBlacks, numberCapturedWhites)

  case class GameSnapshotImpl(variant: GameVariant.Val, playerToMove: Player.Value, winner: Player.Value, board: Board, lastMove: Option[(Pair[Int],Pair[Int])], numberCapturedBlacks: Int, numberCapturedWhites: Int) extends GameSnapshot {

    override def getVariant: GameVariant.Val = variant

    override def getPlayerToMove: Player.Value = playerToMove

    override def getWinner: Player.Value = winner

    override def getBoard: Board = board

    override def getLastMove: Option[(Pair[Int], Pair[Int])] = lastMove

    override def getNumberCapturedBlacks: Int = numberCapturedBlacks

    override def getNumberCapturedWhites: Int = numberCapturedWhites
  }
}