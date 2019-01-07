# Average cell edge length statistics

## Sample invocation

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3measurements.h3.SummaryPerimeterStatsApp"
```

## Summary

This application produces average edge length for cells sampled across the world. Locations
are sampled across a sphere, indexed to an `H3Index`, a random edge of this index is taken,
and the length of this edge is then measured by projecting to Universal Transverse Mercator
(`AUTO:42001` in Geotools) centered on the cell. Measures are in kilometers.

Surprisingly, this application reports the ratio of maximum to minimum edge length as varying
greatly for different resolutions (from 1.1 to 6.5). Edge lengths produced by this application
seem to be slightly longer than those reported in the (H3 Resolution Table)[https://uber.github.io/h3/#/documentation/core-library/resolution-table].
It is not clear why this is the case.

## Sample output

```
iterations=10000 res=0 stats in km: SummaryStatistics:
n: 10000
min: 1197.696327812565
max: 1406.4972938617423
mean: 1301.5621706479199
geometric mean: 1299.5528429345347
variance: 5252.50989133344
sum of squares: 1.6993160687021097E10
standard deviation: 72.47420155706057
sum of logs: 71697.75517305985
ratio of max to min: 1.174335

iterations=10000 res=1 stats in km: SummaryStatistics:
n: 10000
min: 378.07926528269974
max: 532.8188053834147
mean: 490.89995250377945
geometric mean: 489.8935881849291
variance: 936.9858916748043
sum of squares: 2.4191965556129904E9
standard deviation: 30.610225279713383
sum of logs: 61941.88200550979
ratio of max to min: 1.409278

iterations=10000 res=2 stats in km: SummaryStatistics:
n: 10000
min: 140.30815894739848
max: 201.4290051248006
mean: 185.5004802005153
geometric mean: 185.12088920196624
variance: 132.9947582271111
sum of squares: 3.454340961337275E8
standard deviation: 11.532335332755075
sum of logs: 52210.090668152385
ratio of max to min: 1.435619

iterations=10000 res=3 stats in km: SummaryStatistics:
n: 10000
min: 49.28062538971067
max: 76.15118342178695
mean: 70.09282021088855
geometric mean: 69.94514708765843
variance: 19.533306414965494
sum of squares: 4.932534798200205E7
standard deviation: 4.419650033086952
sum of logs: 42477.113218307284
ratio of max to min: 1.545256

iterations=10000 res=4 stats in km: SummaryStatistics:
n: 10000
min: 19.514637902347193
max: 28.776914534210075
mean: 26.51306729419372
geometric mean: 26.4594708571673
variance: 2.691043650142472
sum of squares: 7056335.118922123
standard deviation: 1.6404400781931878
sum of logs: 32756.141606473677
ratio of max to min: 1.474632

iterations=10000 res=5 stats in km: SummaryStatistics:
n: 10000
min: 7.021469593076964
max: 10.876051093142472
mean: 10.027271928487059
geometric mean: 10.006317157466563
variance: 0.3949351920125878
sum of squares: 1009410.7802631779
standard deviation: 0.6284386939173843
sum of logs: 23032.166092923017
ratio of max to min: 1.548971

iterations=10000 res=6 stats in km: SummaryStatistics:
n: 10000
min: 2.7881790879656734
max: 4.111441501287165
mean: 3.7809778933836866
geometric mean: 3.772753367870163
variance: 0.05866852335648762
sum of squares: 143544.56486760324
standard deviation: 0.24221586107537965
sum of logs: 13278.050711992239
ratio of max to min: 1.474597

iterations=10000 res=7 stats in km: SummaryStatistics:
n: 10000
min: 1.0034482778856373
max: 1.5538796601646192
mean: 1.4318220876166055
geometric mean: 1.428907417638163
variance: 0.00788833374855098
sum of squares: 20580.020355019333
standard deviation: 0.08881629213466964
sum of logs: 3569.1010863206243
ratio of max to min: 1.548540

iterations=10000 res=8 stats in km: SummaryStatistics:
n: 10000
min: 0.3972411797200698
max: 0.5873161889029979
mean: 0.5404812038592318
geometric mean: 0.5393201712111257
variance: 0.001183873806153008
sum of squares: 2933.036871438985
standard deviation: 0.0344074673022152
sum of logs: -6174.458747589122
ratio of max to min: 1.478488

iterations=10000 res=9 stats in km: SummaryStatistics:
n: 10000
min: 0.14105733685678185
max: 0.2219880756443219
mean: 0.2044480382271448
geometric mean: 0.2040121475058624
variance: 1.6750238232520972E-4
sum of squares: 419.6648596701499
standard deviation: 0.012942271142469923
sum of logs: -15895.75740313384
ratio of max to min: 1.573744

iterations=10000 res=10 stats in km: SummaryStatistics:
n: 10000
min: 0.057231020702826194
max: 0.08390680521102582
mean: 0.07727709600198995
geometric mean: 0.07711771685955007
variance: 2.3270681732409385E-5
sum of squares: 59.95017921165013
standard deviation: 0.004823969499531416
sum of logs: -25624.22234155039
ratio of max to min: 1.466107

iterations=10000 res=11 stats in km: SummaryStatistics:
n: 10000
min: 0.020329659207323
max: 0.031710143441080536
mean: 0.029201530743128375
geometric mean: 0.029139877996190337
variance: 3.3798026808449173E-6
sum of squares: 8.561088624424404
standard deviation: 0.0018384239665661774
sum of logs: -35356.47665039549
ratio of max to min: 1.559797

iterations=10000 res=12 stats in km: SummaryStatistics:
n: 10000
min: 0.008048538971947277
max: 0.01645063194992777
mean: 0.011047840744386273
geometric mean: 0.01102551389318627
variance: 4.668296259182856E-7
sum of squares: 1.2252156805627736
standard deviation: 6.832493146123789E-4
sum of logs: -45075.43247108643
ratio of max to min: 2.043928

iterations=10000 res=13 stats in km: SummaryStatistics:
n: 10000
min: 0.0034566428317184344
max: 0.02255023600197859
mean: 0.012476441679698018
geometric mean: 0.011084117141273076
variance: 2.8869514938159215E-5
sum of squares: 1.8452822497357035
standard deviation: 0.00537303591446765
sum of logs: -45022.420835355304
ratio of max to min: 6.523739

iterations=10000 res=14 stats in km: SummaryStatistics:
n: 10000
min: 0.001456625294579233
max: 0.008560709567057578
mean: 0.007219322745211527
geometric mean: 0.006900994595423043
variance: 2.6438330820981084E-6
sum of squares: 0.5476218959831793
standard deviation: 0.001625986802559636
sum of logs: -49760.89733502501
ratio of max to min: 5.877084

iterations=10000 res=15 stats in km: SummaryStatistics:
n: 10000
min: 5.860242566693997E-4
max: 0.0032356609268952745
mean: 0.0028877214495545006
geometric mean: 0.0028369197383018973
variance: 1.6773894023939683E-7
sum of squares: 0.08506657336562554
standard deviation: 4.095594465268709E-4
sum of logs: -58650.364146018335
ratio of max to min: 5.521377
```
