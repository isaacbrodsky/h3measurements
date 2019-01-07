# Average cell area statistics

## Sample invocation

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3measurements.h3.SummaryAreaStatsApp"
```

## Summary

This application produces average area for cells sampled across the world. Locations
are sampled across a sphere, indexed to an `H3Index`, and the area of this cell is then
measured by projecting to Universal Transverse Mercator (`AUTO:42001` in Geotools) centered
on the cell. Measures are in square kilometers.

Sample output is shown below. Mean area mostly agrees with the official
[H3 Resolution Table](https://uber.github.io/h3/#/documentation/core-library/resolution-table).
Maximum cell size for a resolution is about twice the minimum cell size for that resolution.

## Sample output

```
iterations=10000 res=0 stats in km2: SummaryStatistics:
n: 10000
min: 2556412.4657580345
max: 5042893.391997588
mean: 4341307.915475162
geometric mean: 4306048.8130999515
variance: 2.588518324814851E11
sum of squares: 1.91057803642646912E17
standard deviation: 508774.8347564816
sum of logs: 152755.31292908135
ratio of max to min: 1.972645

iterations=10000 res=1 stats in km2: SummaryStatistics:
n: 10000
min: 327154.7929048969
max: 735436.7025415351
mean: 625665.3778835743
geometric mean: 621015.5166379161
variance: 5.23029108661751E9
sum of squares: 3.9668693313970225E15
standard deviation: 72320.7514245912
sum of logs: 133391.11347137945
ratio of max to min: 2.247978

iterations=10000 res=2 stats in km2: SummaryStatistics:
n: 10000
min: 44833.08056400893
max: 105378.43812056624
mean: 89558.53276445437
geometric mean: 88905.12215696057
variance: 1.0726425989280455E8
sum of squares: 8.12798432438861E13
standard deviation: 10356.846039833003
sum of logs: 113953.2503690587
ratio of max to min: 2.350462

iterations=10000 res=3 stats in km2: SummaryStatistics:
n: 10000
min: 7694.784415732174
max: 15060.540369260225
mean: 12800.371441656249
geometric mean: 12705.674522479576
variance: 2218891.904066164
sum of squares: 1.6606817905924475E12
standard deviation: 1489.5945435138262
sum of logs: 94498.03985449238
ratio of max to min: 1.957240

iterations=10000 res=4 stats in km2: SummaryStatistics:
n: 10000
min: 894.5975739174917
max: 2151.6871539300714
mean: 1830.0122964636137
geometric mean: 1817.1490713153166
variance: 43193.424903487154
sum of squares: 3.392134110769049E10
standard deviation: 207.83027908244543
sum of logs: 75050.24107581947
ratio of max to min: 2.405201

iterations=10000 res=5 stats in km2: SummaryStatistics:
n: 10000
min: 154.84044272061317
max: 307.3095477105777
mean: 261.449713392867
geometric mean: 259.58293277613745
variance: 897.3503514998142
sum of squares: 6.925321324967635E8
standard deviation: 29.955806640780253
sum of logs: 55590.76238354883
ratio of max to min: 1.984685

iterations=10000 res=6 stats in km2: SummaryStatistics:
n: 10000
min: 22.258812836385527
max: 43.90889094319994
mean: 37.41601552814074
geometric mean: 37.15299563536205
variance: 18.094095096846516
sum of squares: 1.4180505036893887E7
standard deviation: 4.253715446153693
sum of logs: 36150.44404127165
ratio of max to min: 1.972652

iterations=10000 res=7 stats in km2: SummaryStatistics:
n: 10000
min: 3.146313521425711
max: 6.273382022215191
mean: 5.334126392659885
geometric mean: 5.294940339315438
variance: 0.3823629747800864
sum of squares: 288352.2911135365
standard deviation: 0.6183550555951544
sum of logs: 16667.51711627369
ratio of max to min: 1.993883

iterations=10000 res=8 stats in km2: SummaryStatistics:
n: 10000
min: 0.45100516617021563
max: 0.8960912768170864
mean: 0.761726147690224
geometric mean: 0.7561946935635817
variance: 0.007730606093172278
sum of squares: 5879.565571075492
standard deviation: 0.08792386532206303
sum of logs: -2794.564047893044
ratio of max to min: 1.986876

iterations=10000 res=9 stats in km2: SummaryStatistics:
n: 10000
min: 0.06527858214998122
max: 0.1279926339968223
mean: 0.10871097934626768
geometric mean: 0.10792344482797375
variance: 1.573543918926073E-4
sum of squares: 119.75415686877987
standard deviation: 0.012544097890745563
sum of logs: -22263.331473921706
ratio of max to min: 1.960714

iterations=10000 res=10 stats in km2: SummaryStatistics:
n: 10000
min: 0.009266082052736968
max: 0.01828888054313378
mean: 0.015530535101387057
geometric mean: 0.015415181387919322
variance: 3.284286659604499E-6
sum of squares: 2.4448147876635318
standard deviation: 0.0018122600971175464
sum of logs: -41724.02450738273
ratio of max to min: 1.973745

iterations=10000 res=11 stats in km2: SummaryStatistics:
n: 10000
min: 0.001312877391267854
max: 0.002612255577248015
mean: 0.002220557380736729
geometric mean: 0.0022048685283908545
variance: 6.409314295515574E-8
sum of squares: 0.04994961814785184
standard deviation: 2.5316623581187863E-4
sum of logs: -61170.87396173465
ratio of max to min: 1.989718

iterations=10000 res=12 stats in km2: SummaryStatistics:
n: 10000
min: 1.8865953961713178E-4
max: 3.732456401407067E-4
mean: 3.175842343064413E-4
geometric mean: 3.1526007533597806E-4
variance: 1.3536042486579703E-9
sum of squares: 0.001022132147682413
standard deviation: 3.679136106014522E-5
sum of logs: -80621.12623801312
ratio of max to min: 1.978409

iterations=10000 res=13 stats in km2: SummaryStatistics:
n: 10000
min: 2.6896479094096367E-5
max: 5.3316408261642764E-5
mean: 4.523796595396981E-5
geometric mean: 4.490609987548227E-5
variance: 2.7628874661113983E-11
sum of squares: 2.074099675426177E-5
standard deviation: 5.256317595152902E-6
sum of logs: -100109.36917755677
ratio of max to min: 1.982282

iterations=10000 res=14 stats in km2: SummaryStatistics:
n: 10000
min: 3.834892132292558E-6
max: 7.617401459781286E-6
mean: 6.464389982954106E-6
geometric mean: 6.41686294619027E-6
variance: 5.630295538138227E-13
sum of squares: 4.235131110257573E-7
standard deviation: 7.503529528254171E-7
sum of logs: -119565.81197349759
ratio of max to min: 1.986340

iterations=10000 res=15 stats in km2: SummaryStatistics:
n: 10000
min: 5.46295056139646E-7
max: 1.0880505547155501E-6
mean: 9.240534076361537E-7
geometric mean: 9.172975716242094E-7
variance: 1.1413961558266136E-14
sum of squares: 8.652875203260989E-9
standard deviation: 1.068361435014674E-7
sum of logs: -139018.33911742482
ratio of max to min: 1.991690
```

## Possible limitations

1. Choice of projection for measuring area.
2. Ambiguous definition of "average" in the H3 Resolution Table.
3. Limited number of samples (n=10000) per resolution.
