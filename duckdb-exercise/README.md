# DuckDB Exercise

https://shell.duckdb.org/


* `.files add` BEATS.csv
* `.files add` ECG.csv
* `create table beats as select *, to_timestamp(time) as ts from read_csv_auto("BEATS.csv");`
* calculate median HR for the total data set
* calculate median, min and max HR for every 30 seconds window
* create table from ECG file and join the beats into it
  * give ECG amplitude of every beat

