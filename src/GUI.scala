/**
 * Created by Hubert on 2015-01-28.
 */

import swing._


object GUI extends SimpleSwingApplication{

  val inputButton1 = new Button()
  val inputButton2 = new Button()
  val inputButton3 = new Button()
  val inputButton4 = new Button()

  var labelsInputTable =  Array.ofDim[Label](12,4)
  for (i <- 0 to 11){
    for (j <- 0 to 3){
        labelsInputTable(i)(j)= new Label()
    }
  }

  var labelsResultTable = Array.ofDim[Label](2,2)
    labelsResultTable(1)(1) = new Label()
    labelsResultTable(0)(0) = new Label()
    labelsResultTable(1)(0) = new Label()
    labelsResultTable(0)(1) = new Label()


  val confirmButton = new Button("Confirm")

  val resultPanel = new GridPanel(2,2){
    contents += labelsResultTable(1)(1)
    contents += labelsResultTable(0)(1)
    contents += labelsResultTable(0)(0)
    contents += labelsResultTable(1)(0)
  }

  val inputPanel = new BoxPanel(Orientation.Vertical){
    contents += inputButton1
    contents += inputButton2
    contents += inputButton3
    contents += inputButton4
  }

  val gamePanel = new GridPanel(12,2){
      for( i <- 0 to 11){
        for(j <- 0 to 3){
          contents += labelsInputTable(i)(j)
        }
      }
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
