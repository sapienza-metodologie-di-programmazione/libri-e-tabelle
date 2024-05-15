# Libri e tabelle 

La tua amica Aurora lavora in una biblioteca, e ha bisogno di una mano per trovare alcune informazioni sui libri della biblioteca. 

Aurora sa che sei un abile programmatore, la puoi aiutare a trovare le informazioni che le servono?

## Test 

- `public static <T extends OccurencesCounter & Csv> T occurencesCounter()`
    - ritorna un'**istanza** di una classe che implementa `OccurencesCounter` e `Csv`
    - `Integer count(String word, String filename)`
        - conta quante volte compare la parola `word` nel file indicato da `filename`
        - il metodo è case **insensitive**, quindi sia `Cane`, `CANe` e `canE` valgono se `word = "cane"` 
    - `void save(String filename)`
        - salve nel file indicato da `filename` una tabella `csv` nel seguente formato

```csv
cane,pesce,anello
12,48,96
```

```java
counter.count('pesce', 'La grande enciclopedia degli oceani.txt') -> 90129
counter.count('anello', 'Il signore degli anelli.txt') -> 1280
counter.save('risultati.txt')
```

```csv
pesce,anello
90129,1280
```

```java
counter.count('JavA', 'Il nuovo java.txt') -> 7897210
counter.save('risultati2.txt')
```
    
```csv
pesce,anello,java
90129,1280,7897210
```
        
- `public static <T extends DistinctWordCounter & Csv> T wordsCounter() `
    - ritorna un'**istanza** di una classe che implementa `DistinctWordCounter` e `Csv`
    - `public Integer count(String filename) `
        - conta quante parole distinte ha file indicato da `filename`
        - il metodo è case **sensitive**, quindi `Cane`, `CANe` e `canE` sono parole diverse
    - `void save(String filename)`
        - salve nel file indicato da `filename` una tabella `csv` nel seguente formato

```csv
Il signore degli anelli.txt,Il nuovo Java.txt
14900,2290
```

```java
counter.count('Il signore degli anelli.txt') -> 14900
counter.save('parole')
```

```csv
Il signore degli anelli.txt
14900
```

```java
counter.count('Il nuovo java.txt') -> 2290
counter.save('risultati2.txt')
```
    
```csv
Il signore degli anelli.txt,Il nuovo Java.txt
14900,2290
```

- `public static <T extends OccurencesCounter & DistinctWordCounter & Csv> T countingCounters()`
    - ritorna un'**istanza** di una classe che implementa `OccurencesCounter`, `DistinctWordCounter` e `Csv`

```java
counter.count('Il signore degli anelli.txt') -> 14900
counter.save('parole')
```

```csv
Il signore degli anelli.txt
14900
```

```java
counter.count('pesce', 'La grande enciclopedia degli oceani.txt') -> 90129
counter.save('risultati.txt')
```

```csv
Il signore degli anelli.txt,pesce
14900,90129
```

> NOTA: `@SuppressWarnings("unchecked")` dovrebbe servire, fidatevi...

<!-- - `public static <T> Invert<T> inverter()` -->
<!--     - ritorna un'**istanza** di una **Classe** che implementa l'interfaccia `Invert<T>` -->
<!---->
<!-- - `public static <T> Max<T> maximizer()`  -->
<!--     - ritorna un'**istanza** di una **Classe** che implementa l'interfaccia `Max<T>` -->
<!---->
<!-- > NOTA: Il `maximizer()` **genera appositamente un errore**: capite cosa va **aggiunto** al metodo `maximizer()` per sistemare l'errore *(non potete levare cose dalla firma di maximizer, le potete solo aggiungere)* -->
