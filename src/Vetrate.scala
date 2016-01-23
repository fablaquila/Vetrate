
import scala.collection.mutable.ArrayBuffer

/**
 * Punto di entrata nel programma
 */
object Vetrate {

  def loadTiles( filename: String ): ArrayBuffer[Tile] = {

    // Lista di pezzi
    var tiles = new ArrayBuffer[Tile](0)

    // carica file CSV
    var numLines = 0
    val file = io.Source.fromFile(filename)
    for( line <- file.getLines() ) {
      numLines += 1

      // slata la prima linea
      if( numLines > 1 ) {

        // estrai larghezza, altezza, quantità
        val tileInfo = line.split(',')
        val width    = tileInfo(0).toDouble
        val height   = tileInfo(1).toDouble
        val quantity = tileInfo(2).toInt

        // costruisci il numero corretto di pezzi con le dimensioni richieste
        for ( q <- 1 to quantity ) {
          tiles += new Tile( width, height )
        }
      }
    }

    return tiles
  }

  def main( args: Array[String] ) {

    // leggi il CSV e metti tutti i pezzi in un array
    val path = new java.io.File( "." ).getCanonicalPath
    var tiles = loadTiles( path + "/vetri_fablab.csv")

    // verifica che ci sia tutto
    println( "Caricate " + tiles.length + " tessere." )
    for( t <- tiles ){
      println( s"\t ${t.width}, ${t.height}" )
    }

  }

}