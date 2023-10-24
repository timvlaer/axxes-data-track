docker run --rm \
  --mount 'type=bind,src=/tmp/tst-rocksdb-bla,dst=/tmp/rocksdb' \
  abicky/rocksdb-tools sst_dump --file=/tmp/rocksdb --command=scan

docker run --rm \
  --mount 'type=bind,src=/tmp/tst-rocksdb-bla,dst=/tmp/rocksdb' \
  abicky/rocksdb-tools sst_dump --file=/tmp/rocksdb --command=raw