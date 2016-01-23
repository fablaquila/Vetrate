
/**
 * Punto di entrata nel programma
 */
object Vetrate {

  def loadTiles( filename: String ): Array[Tile] = {

    // Lista di pezzi
    var tiles = new Array[Tile](3)

    // carica file CSV
    val file = io.Source.fromFile(filename)
    for( i <- file.getLines() ) {
      println( i )
    }

    return tiles
  }

  def main( args: Array[String] ) {
    var tiles = loadTiles("/home/piero/Desktop/progetti/Vetrate/src/vetri_fablab.csv")
    println( tiles )
  }

}