# Average cell area statistics

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3.SummaryAreaStatsApp"
```

This application produces average area for cells sampled across the world.

Mean area mostly agrees with the official H3 Resolution Table.

Maximum cell size for a resolution is about twice the minimum cell size for that resolution.

Measures are in square kilometers. The map projection used is Universal Transverse Mercator centered on each cell.

```
final iterations=10000 res=0 stats in km2: SummaryStatistics:
n: 10000
min: 2556412.4657580336
max: 5042893.391997592
mean: 4336186.904321027
geometric mean: 4299502.972997633
variance: 2.6838314848426172E11
sum of squares: 1.90708731793736064E17
standard deviation: 518057.0899855167
sum of logs: 152740.0998630805
ratio of max to min: 1.972645

final iterations=10000 res=1 stats in km2: SummaryStatistics:
n: 10000
min: 327154.7929048971
max: 735436.7025415347
mean: 626239.4717110745
geometric mean: 621685.1524827026
variance: 5.1424102762440405E9
sum of squares: 3.973177719641802E15
standard deviation: 71710.60086377774
sum of logs: 133401.8905784695
ratio of max to min: 2.247978

final iterations=10000 res=2 stats in km2: SummaryStatistics:
n: 10000
min: 44733.44936501878
max: 105378.43812056628
mean: 89516.05897622957
geometric mean: 88863.96268239159
variance: 1.0683421044637266E8
sum of squares: 8.119948341661062E13
standard deviation: 10336.063585639005
sum of logs: 113948.6197016576
ratio of max to min: 2.355697

final iterations=10000 res=3 stats in km2: SummaryStatistics:
n: 10000
min: 7703.570072528557
max: 15060.540369260403
mean: 12814.31517639034
geometric mean: 12722.931254164001
variance: 2146124.321088695
sum of squares: 1.6635258314852488E12
standard deviation: 1464.9656381938435
sum of logs: 94511.61254855603
ratio of max to min: 1.955008

final iterations=10000 res=4 stats in km2: SummaryStatistics:
n: 10000
min: 1088.7366068704885
max: 2151.2296977029387
mean: 1829.0803665372596
geometric mean: 1815.632606917118
variance: 44993.368573062704
sum of squares: 3.3905238564883114E10
standard deviation: 212.11640335688963
sum of logs: 75041.89229727675
ratio of max to min: 1.975895

final iterations=10000 res=5 stats in km2: SummaryStatistics:
n: 10000
min: 153.66674420087807
max: 307.3852449363559
mean: 261.26935416278684
geometric mean: 259.4026326368984
variance: 897.0119726679234
sum of squares: 6.915859769611048E8
standard deviation: 29.950158140950165
sum of logs: 55583.814207780226
ratio of max to min: 2.000337

final iterations=10000 res=6 stats in km2: SummaryStatistics:
n: 10000
min: 22.408350689833966
max: 43.89502306555793
mean: 37.35558220492802
geometric mean: 37.09863162322366
variance: 17.673527714095464
sum of squares: 1.4131112822304573E7
standard deviation: 4.203989499760372
sum of logs: 36135.80085462117
ratio of max to min: 1.958869

final iterations=10000 res=7 stats in km2: SummaryStatistics:
n: 10000
min: 3.164202201571684
max: 6.271430959630527
mean: 5.3216108435605065
geometric mean: 5.283073132482873
variance: 0.37636869228162284
sum of squares: 286958.7302571313
standard deviation: 0.6134889504152645
sum of logs: 16645.079610700628
ratio of max to min: 1.981994

final iterations=10000 res=8 stats in km2: SummaryStatistics:
n: 10000
min: 0.44844875360974107
max: 0.8961427224091808
mean: 0.7619661728558202
geometric mean: 0.7566054923455348
variance: 0.007504347051660312
sum of squares: 5880.960451935022
standard deviation: 0.08662763445725799
sum of logs: -2789.133075635416
ratio of max to min: 1.998317

final iterations=10000 res=9 stats in km2: SummaryStatistics:
n: 10000
min: 0.06480618770915567
max: 0.12802618963517215
mean: 0.1088482755797914
geometric mean: 0.10806515312552792
variance: 1.5686895761550344E-4
sum of squares: 120.04800367413876
standard deviation: 0.01252473383411813
sum of logs: -22250.209640711066
ratio of max to min: 1.975524

final iterations=10000 res=10 stats in km2: SummaryStatistics:
n: 10000
min: 0.009147076434253802
max: 0.018287214628592417
mean: 0.015511812231785356
geometric mean: 0.015397121603919027
variance: 3.259574632812054E-6
sum of squares: 2.438755673895146
standard deviation: 0.0018054292101359315
sum of logs: -41735.74695868613
ratio of max to min: 1.999241

final iterations=10000 res=11 stats in km2: SummaryStatistics:
n: 10000
min: 0.001311689307175414
max: 0.0026123639555300877
mean: 0.002216274361775926
geometric mean: 0.0022001825395480336
variance: 6.550829010663908E-8
sum of squares: 0.049773737859429255
standard deviation: 2.5594587339247937E-4
sum of logs: -61192.149495380625
ratio of max to min: 1.991603

final iterations=10000 res=12 stats in km2: SummaryStatistics:
n: 10000
min: 1.87369028369826E-4
max: 3.731879161162272E-4
mean: 3.168691368909841E-4
geometric mean: 3.145507770418222E-4
variance: 1.3494509681455803E-9
sum of squares: 0.0010175536593708628
standard deviation: 3.673487400475984E-5
sum of logs: -80643.6504162281
ratio of max to min: 1.991727

final iterations=10000 res=13 stats in km2: SummaryStatistics:
n: 10000
min: 2.678516484357113E-5
max: 5.3306290557523755E-5
mean: 4.526138257233608E-5
geometric mean: 4.492746554543425E-5
variance: 2.7726388734196736E-11
sum of squares: 2.076316368454691E-5
standard deviation: 5.265585317340964E-6
sum of logs: -100104.61245433094
ratio of max to min: 1.990142

final iterations=10000 res=14 stats in km2: SummaryStatistics:
n: 10000
min: 3.8275597101907655E-6
max: 7.616429750473061E-6
mean: 6.477451579778524E-6
geometric mean: 6.430399384799785E-6
variance: 5.601189083345633E-13
sum of squares: 4.251744186481892E-7
standard deviation: 7.484109221106833E-7
sum of logs: -119544.73908922078
ratio of max to min: 1.989892

final iterations=10000 res=15 stats in km2: SummaryStatistics:
n: 10000
min: 5.418084239682702E-7
max: 1.0878836083817775E-6
mean: 9.241254010115873E-7
geometric mean: 9.173046898775368E-7
variance: 1.1564897501856491E-14
sum of squares: 8.655714978069341E-9
standard deviation: 1.0754021341738397E-7
sum of logs: -139018.2615174624
ratio of max to min: 2.007875
```

## Possible limitations

1. Incorrect sampling using spherical point picking.
2. Incorrect choice of projection for measuring area.
3. Ambiguous definition of "average" in the H3 Resolution Table.
4. Limited number of samples (n=10000) per resolution.
