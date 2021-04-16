# File-Type-Analyzer
В данном проекте изучаю различные алгоритмы, которые примению для определения типа файла.

## Запуск программы
На данный момент, запуск программы осуществляется осуществляется командой java Main --typeAlgorithm pathToFile "%PatternFileType" "FileType", где:
- typeAlgorithm - алгоритм поиска шаблона (на данный момент реализован Knuth-Morris-Pratt algorithm и Naive(поиск по каждому символу));
- pathToFile - путь до файла;
- %PatternFileType" шаблон который нужно найти;
- тип файла, если шаблон найден.
