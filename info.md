Dati aggiuntivi
=====

* Spessore del legno tra i vetri: 2.5 cm
* Dimensione totale finestre: ??? x ???

Algoritmo di ottimizzazione
=====

Algoritmo genetico

Possibili codifiche del genotipo e mutazioni
-----

Stringa a lunghezza fissa in cui ogni gene è una tripla: <id, o, p, a>, dove:

* "id" è l'identificativo del vetro (univoco per ogni vetro, vetri con la stessa
  dimensione hanno id diversi)
* "o" è l'orientamento (orizzontale o verticale)
* "p" è la posizione del vetro rispetto al vetro precedente (sopra, sotto,
  destra o sinitra). Per il primo vetro indica da dove partire (rispettivamente:
  sul bordo alto, sul bordo basso, sul bordo destro, sul bordo sinistro)
* "a" è l'allineamento rispetto al vetro precedente (centri sulla stessa linea,
  il centro di questo vetro a destra del centro del vetro precedente o il centro
  di questo vetro a sinistra del vetro precedente - destra e sinistra diventano
  in alto o in basso per vetri posizionati uno di fianco all'altro). Per il
  primo vetro indica se si parte rispettivamente al centro, a destra/alto o a
  sinistra/basso del bordo

La stringa contiene tutti i vetri (per questo è a lunghezza fissa). Le mutazioni
possono essere di due tipi:

* mutazione di un gene (cambio di "o", "p" o "a", id è sempre fisso)
* scambio di posizione tra due geni

Mapping genotipo-fenotipo
-----

La decodifica parte dal primo vetro e cerca di posizionare quelli successivi nel
genotipo nella posizione specificata in modo che non si sovrappongano mai con
altri vetri già presenti. Ad esempio:

~~~~~
+---+  +----+
| B |  |    |
|   |  |    |
+---+  | C  |
+-----+|    |
|     |+----+
|  A  |
|     |
+-----+
~~~~~

Il vetro A viene posizionato per primo, poi B va sopra ad A allineato a sinistra
e C a destra di B allineato sopra. Siccome non si può posizionare C adiacente a
B perché coprirebbe A, si sposta a destra finché non si sovrappone a nessun
altro vetro. Se un vetro non può essere posizionato, viene saltato e si prova
con il successivo. Se si arriva alla fine della lista si riprovano in ordine
quelli che non è stato possibile posizionare in precedenza, fermandosi quando
nessun vetro può essere utilizzato.

Calcolo della fitness
-----

La fitness potrebbe essere semplicemente l'area non occupata da vetri. Per
calcolarla si potrebbe procedere in due modi, che dipendono da come modelliamo
il risultato della decodifica (vedi sopra)

* Se il risultato della decodifica contiene la posizione x,y di ogni vetrata,
  allora bisogna trovare un algoritmo per estrarre le parti non coperte (una
  specie di differenza tra aree)
* Se invece usiamo una matrice, in cui ad esempio 1 indice la presenza di un
  vetro, 2 della cornice e 0 il vuoto, possiamo semplicemente contare gli 0. In
  questo caso si avrebbe una sorta di immagine della vetrata, in cui la
  dimensione di ogni pixel deve essere tale che ogni vetro contiene un numero
  intero di pixel (bisogna guardare i dati, ma credo che 0.5 cm dovrebbe
  andare). Il problema potrebbe essere che forse vengono fuori matrici
  abbastanza grandi...
