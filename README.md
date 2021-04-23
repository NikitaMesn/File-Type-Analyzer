# File-Type-Analyzer
В данном проекте изучаю различные алгоритмы и многопоточность.
Программа принимает каталог с файлами и базу данных со списоком шаблонов (подпись для определения типа файла). База данных содержит шаблоны и их приоритет (в случаи нескольких совпадений). База данных обрабатывается в классе SortedDatabase, где сортируется в порядке убывания паттерна. Даллее осуществляется поиск паттерна по порядку, первый найденный паттерн и определяет тип файла.

## Запуск программы
На данный момент, запуск программы осуществляется командой java Main filesDirectory patterns.db, где:

- filesDirectory - папка с файлами;
- patterns.db база данных с с паттернами для определения типа файла,;

