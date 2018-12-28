# Index truncation error

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3.TruncationRatioApp"
```

When truncating indexes to the next coarser resolution, about 7.2% of the area is in error.

```
final iterations=10000000 res=15 in=9285933 out=714067: 0.928593
final iterations=10000000 res=14 in=9286233 out=713767: 0.928623
final iterations=10000000 res=13 in=9286145 out=713855: 0.928615
final iterations=10000000 res=12 in=9285095 out=714905: 0.928510
final iterations=10000000 res=11 in=9285620 out=714380: 0.928562
final iterations=10000000 res=10 in=9286749 out=713251: 0.928675
final iterations=10000000 res=9 in=9287145 out=712855: 0.928715
final iterations=10000000 res=8 in=9284618 out=715382: 0.928462
final iterations=10000000 res=7 in=9287314 out=712686: 0.928731
final iterations=10000000 res=6 in=9285718 out=714282: 0.928572
final iterations=10000000 res=5 in=9287933 out=712067: 0.928793
final iterations=10000000 res=4 in=9286511 out=713489: 0.928651
final iterations=10000000 res=3 in=9288609 out=711391: 0.928861
final iterations=10000000 res=2 in=9288135 out=711865: 0.928814
final iterations=10000000 res=1 in=9241681 out=758319: 0.924168
```
