# SudokuValidator

SudokuValidator is a CSV validator to validate a complete sudoku solution saved as a simple CSV (text) file.

## Usage

Can be executed using JVM 11. You need to pass filename (with path if needed) as a parameter.

```bash
java -jar SudokuValidator SudokuValid.csv
```

## Development Notes

This is a simple Sudoku Validator. Since the file is a single 9x9 sudoku file, performance is not considered to be an issue. Written in java, no additional frameworks or libraries were used. In fact, I don't see what was intended to send a junior level code case to a team leader candidate, so not much time was spent on this, nor commited over Git

## License

[GPL](https://www.gnu.org/licenses/gpl-3.0.en.html)