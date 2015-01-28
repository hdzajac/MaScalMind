/**
 * Created by Hubert on 2015-01-28.
 */

import java.awt.Color

import swing._


object GUI extends SimpleSwingApplication{


  val inputGridBackground = Color.LIGHT_GRAY

  val inputButton1 = new Button()
  val inputButton2 = new Button()
  val inputButton3 = new Button()
  val inputButton4 = new Button()

  var labelsInputTable =  Array.ofDim[Label](12,4)
  for (i <- 0 to 11){
    for (j <- 0 to 3){
        labelsInputTable(i)(j)= new Label(Integer.toString((i+ 1) * (1 + j))){
          background = inputGridBackground
          foreground = inputGridBackground
        }
    }
  }

  var labelsResultTable = Array.ofDim[Label](2,2)
    for(i <- 0 to 11){
      for(j <- 0 to 3){
        labelsResultTable(i)(j) = new Label(Integer.toString((i+1) * (j+1)))
      }
    }


  val confirmButton = new Button("Confirm")

  val inputPanel = new BoxPanel(Orientation.Vertical){
    contents += inputButton1
    contents += inputButton2
    contents += inputButton3
    contents += inputButton4
  }

  val inputGrid =  new GridPanel(12,2){
    for( i <- 0 to 11){
      for(j <- 0 to 3){
        contents += labelsInputTable(i)(j)
      }
    }
  }

  def getResultGrid (row :Int): GridPanel ={
    val tmpGrid = new GridPanel(2,2) {
      for (i <- 0 to 3) {
        contents += labelsResultTable(row)(i)
      }
    }
    tmpGrid
  }
  val resultGrid = new GridPanel(2,2){
    contents += labelsResultTable(0)(0)
    contents += labelsResultTable(0)(1)
    contents += labelsResultTable(1)(0)
    contents += labelsResultTable(1)(1)
  }

  val gamePanel = new BorderPanel{
      background = inputGridBackground
      add(inputGrid, BorderPanel.Position.Center)
  }

  val ui  = new BorderPanel{
    add(inputPanel, BorderPanel.Position.West)
    add(gamePanel, BorderPanel.Position.Center)
    add(confirmButton, BorderPanel.Position.South)
  }

  override def top = new MainFrame{
    title = "MaScalMind"
    contents = ui
    visible = true
  }


}
