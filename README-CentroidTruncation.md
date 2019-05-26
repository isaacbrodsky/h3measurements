# Index truncation error using centroids

## Sample invocation

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3measurements.h3.CentroidTruncationRatioApp"
```

## Summary

This application measures the ratio of area error when truncating from a finer H3
resolution to a coarser one by reindexing the centroid of the finer index. The error
is introduced by the use aperture 7 hexagon subdivision, where 7 finer hexagonal cells
are approximately contained by a coarser cell. This is different than bit-wise truncation
in both speed and containment characteristics.

The ratio of error is measured by randomly sampling locations on the sphere, indexing
to a fine resolution, obtaining the centroid of that index, and indexing the centroid at
the coarser resolution. The reindexed `H3Index` is compared to the same location indexed
at the coarser resolution (which is not affected by shape error). If the two indexes are
the same, the point is considered `in`, as shown in the sample output below (otherwise it
is considered `out`). The ratio of `out` points to all points sampled is taken as the shape
error introduced by aperture 7.

Sample output is shown below. Area in error ranges from about 7.2% to 0.0% (less than one in
one million sampled points were in error).

## Sample output

```
iterations=1000000 res=15 truncated=14 in=928672 out=71328: 0.928672 percent contained
iterations=1000000 res=15 truncated=13 in=938925 out=61075: 0.938925 percent contained
iterations=1000000 res=15 truncated=12 in=977022 out=22978: 0.977022 percent contained
iterations=1000000 res=15 truncated=11 in=990113 out=9887: 0.990113 percent contained
iterations=1000000 res=15 truncated=10 in=996448 out=3552: 0.996448 percent contained
iterations=1000000 res=15 truncated=9 in=998549 out=1451: 0.998549 percent contained
iterations=1000000 res=15 truncated=8 in=999457 out=543: 0.999457 percent contained
iterations=1000000 res=15 truncated=7 in=999796 out=204: 0.999796 percent contained
iterations=1000000 res=15 truncated=6 in=999932 out=68: 0.999932 percent contained
iterations=1000000 res=15 truncated=5 in=999981 out=19: 0.999981 percent contained
iterations=1000000 res=15 truncated=4 in=999993 out=7: 0.999993 percent contained
iterations=1000000 res=15 truncated=3 in=999997 out=3: 0.999997 percent contained
iterations=1000000 res=15 truncated=2 in=999998 out=2: 0.999998 percent contained
iterations=1000000 res=15 truncated=1 in=1000000 out=0: 1.000000 percent contained
iterations=1000000 res=15 truncated=0 in=1000000 out=0: 1.000000 percent contained
iterations=1000000 res=14 truncated=13 in=928734 out=71266: 0.928734 percent contained
iterations=1000000 res=14 truncated=12 in=939337 out=60663: 0.939337 percent contained
iterations=1000000 res=14 truncated=11 in=977169 out=22831: 0.977169 percent contained
iterations=1000000 res=14 truncated=10 in=990117 out=9883: 0.990117 percent contained
iterations=1000000 res=14 truncated=9 in=996421 out=3579: 0.996421 percent contained
iterations=1000000 res=14 truncated=8 in=998533 out=1467: 0.998533 percent contained
iterations=1000000 res=14 truncated=7 in=999479 out=521: 0.999479 percent contained
iterations=1000000 res=14 truncated=6 in=999822 out=178: 0.999822 percent contained
iterations=1000000 res=14 truncated=5 in=999926 out=74: 0.999926 percent contained
iterations=1000000 res=14 truncated=4 in=999974 out=26: 0.999974 percent contained
iterations=1000000 res=14 truncated=3 in=999996 out=4: 0.999996 percent contained
iterations=1000000 res=14 truncated=2 in=999994 out=6: 0.999994 percent contained
iterations=1000000 res=14 truncated=1 in=999999 out=1: 0.999999 percent contained
iterations=1000000 res=14 truncated=0 in=1000000 out=0: 1.000000 percent contained
iterations=1000000 res=13 truncated=12 in=928679 out=71321: 0.928679 percent contained
iterations=1000000 res=13 truncated=11 in=939001 out=60999: 0.939001 percent contained
iterations=1000000 res=13 truncated=10 in=977054 out=22946: 0.977054 percent contained
iterations=1000000 res=13 truncated=9 in=989977 out=10023: 0.989977 percent contained
iterations=1000000 res=13 truncated=8 in=996539 out=3461: 0.996539 percent contained
iterations=1000000 res=13 truncated=7 in=998523 out=1477: 0.998523 percent contained
iterations=1000000 res=13 truncated=6 in=999499 out=501: 0.999499 percent contained
iterations=1000000 res=13 truncated=5 in=999770 out=230: 0.999770 percent contained
iterations=1000000 res=13 truncated=4 in=999918 out=82: 0.999918 percent contained
iterations=1000000 res=13 truncated=3 in=999973 out=27: 0.999973 percent contained
iterations=1000000 res=13 truncated=2 in=999990 out=10: 0.999990 percent contained
iterations=1000000 res=13 truncated=1 in=999997 out=3: 0.999997 percent contained
iterations=1000000 res=13 truncated=0 in=999999 out=1: 0.999999 percent contained
iterations=1000000 res=12 truncated=11 in=928466 out=71534: 0.928466 percent contained
iterations=1000000 res=12 truncated=10 in=938733 out=61267: 0.938733 percent contained
iterations=1000000 res=12 truncated=9 in=977214 out=22786: 0.977214 percent contained
iterations=1000000 res=12 truncated=8 in=989868 out=10132: 0.989868 percent contained
iterations=1000000 res=12 truncated=7 in=996365 out=3635: 0.996365 percent contained
iterations=1000000 res=12 truncated=6 in=998584 out=1416: 0.998584 percent contained
iterations=1000000 res=12 truncated=5 in=999510 out=490: 0.999510 percent contained
iterations=1000000 res=12 truncated=4 in=999808 out=192: 0.999808 percent contained
iterations=1000000 res=12 truncated=3 in=999937 out=63: 0.999937 percent contained
iterations=1000000 res=12 truncated=2 in=999971 out=29: 0.999971 percent contained
iterations=1000000 res=12 truncated=1 in=999986 out=14: 0.999986 percent contained
iterations=1000000 res=12 truncated=0 in=999997 out=3: 0.999997 percent contained
iterations=1000000 res=11 truncated=10 in=928604 out=71396: 0.928604 percent contained
iterations=1000000 res=11 truncated=9 in=938709 out=61291: 0.938709 percent contained
iterations=1000000 res=11 truncated=8 in=977123 out=22877: 0.977123 percent contained
iterations=1000000 res=11 truncated=7 in=990003 out=9997: 0.990003 percent contained
iterations=1000000 res=11 truncated=6 in=996461 out=3539: 0.996461 percent contained
iterations=1000000 res=11 truncated=5 in=998466 out=1534: 0.998466 percent contained
iterations=1000000 res=11 truncated=4 in=999480 out=520: 0.999480 percent contained
iterations=1000000 res=11 truncated=3 in=999789 out=211: 0.999789 percent contained
iterations=1000000 res=11 truncated=2 in=999929 out=71: 0.999929 percent contained
iterations=1000000 res=11 truncated=1 in=999965 out=35: 0.999965 percent contained
iterations=1000000 res=11 truncated=0 in=999985 out=15: 0.999985 percent contained
iterations=1000000 res=10 truncated=9 in=928362 out=71638: 0.928362 percent contained
iterations=1000000 res=10 truncated=8 in=939002 out=60998: 0.939002 percent contained
iterations=1000000 res=10 truncated=7 in=977041 out=22959: 0.977041 percent contained
iterations=1000000 res=10 truncated=6 in=989907 out=10093: 0.989907 percent contained
iterations=1000000 res=10 truncated=5 in=996454 out=3546: 0.996454 percent contained
iterations=1000000 res=10 truncated=4 in=998491 out=1509: 0.998491 percent contained
iterations=1000000 res=10 truncated=3 in=999482 out=518: 0.999482 percent contained
iterations=1000000 res=10 truncated=2 in=999800 out=200: 0.999800 percent contained
iterations=1000000 res=10 truncated=1 in=999930 out=70: 0.999930 percent contained
iterations=1000000 res=10 truncated=0 in=999951 out=49: 0.999951 percent contained
iterations=1000000 res=9 truncated=8 in=928289 out=71711: 0.928289 percent contained
iterations=1000000 res=9 truncated=7 in=938532 out=61468: 0.938532 percent contained
iterations=1000000 res=9 truncated=6 in=977128 out=22872: 0.977128 percent contained
iterations=1000000 res=9 truncated=5 in=989992 out=10008: 0.989992 percent contained
iterations=1000000 res=9 truncated=4 in=996570 out=3430: 0.996570 percent contained
iterations=1000000 res=9 truncated=3 in=998526 out=1474: 0.998526 percent contained
iterations=1000000 res=9 truncated=2 in=999503 out=497: 0.999503 percent contained
iterations=1000000 res=9 truncated=1 in=999811 out=189: 0.999811 percent contained
iterations=1000000 res=9 truncated=0 in=999913 out=87: 0.999913 percent contained
iterations=1000000 res=8 truncated=7 in=928666 out=71334: 0.928666 percent contained
iterations=1000000 res=8 truncated=6 in=938578 out=61422: 0.938578 percent contained
iterations=1000000 res=8 truncated=5 in=977103 out=22897: 0.977103 percent contained
iterations=1000000 res=8 truncated=4 in=989989 out=10011: 0.989989 percent contained
iterations=1000000 res=8 truncated=3 in=996456 out=3544: 0.996456 percent contained
iterations=1000000 res=8 truncated=2 in=998549 out=1451: 0.998549 percent contained
iterations=1000000 res=8 truncated=1 in=999521 out=479: 0.999521 percent contained
iterations=1000000 res=8 truncated=0 in=999748 out=252: 0.999748 percent contained
iterations=1000000 res=7 truncated=6 in=928263 out=71737: 0.928263 percent contained
iterations=1000000 res=7 truncated=5 in=938774 out=61226: 0.938774 percent contained
iterations=1000000 res=7 truncated=4 in=977249 out=22751: 0.977249 percent contained
iterations=1000000 res=7 truncated=3 in=989988 out=10012: 0.989988 percent contained
iterations=1000000 res=7 truncated=2 in=996375 out=3625: 0.996375 percent contained
iterations=1000000 res=7 truncated=1 in=998535 out=1465: 0.998535 percent contained
iterations=1000000 res=7 truncated=0 in=999432 out=568: 0.999432 percent contained
iterations=1000000 res=6 truncated=5 in=928604 out=71396: 0.928604 percent contained
iterations=1000000 res=6 truncated=4 in=938449 out=61551: 0.938449 percent contained
iterations=1000000 res=6 truncated=3 in=977210 out=22790: 0.977210 percent contained
iterations=1000000 res=6 truncated=2 in=989836 out=10164: 0.989836 percent contained
iterations=1000000 res=6 truncated=1 in=996515 out=3485: 0.996515 percent contained
iterations=1000000 res=6 truncated=0 in=998331 out=1669: 0.998331 percent contained
iterations=1000000 res=5 truncated=4 in=928614 out=71386: 0.928614 percent contained
iterations=1000000 res=5 truncated=3 in=938796 out=61204: 0.938796 percent contained
iterations=1000000 res=5 truncated=2 in=977160 out=22840: 0.977160 percent contained
iterations=1000000 res=5 truncated=1 in=990005 out=9995: 0.990005 percent contained
iterations=1000000 res=5 truncated=0 in=995759 out=4241: 0.995759 percent contained
iterations=1000000 res=4 truncated=3 in=928471 out=71529: 0.928471 percent contained
iterations=1000000 res=4 truncated=2 in=939067 out=60933: 0.939067 percent contained
iterations=1000000 res=4 truncated=1 in=977341 out=22659: 0.977341 percent contained
iterations=1000000 res=4 truncated=0 in=988679 out=11321: 0.988679 percent contained
iterations=1000000 res=3 truncated=2 in=928842 out=71158: 0.928842 percent contained
iterations=1000000 res=3 truncated=1 in=939149 out=60851: 0.939149 percent contained
iterations=1000000 res=3 truncated=0 in=974617 out=25383: 0.974617 percent contained
iterations=1000000 res=2 truncated=1 in=929057 out=70943: 0.929057 percent contained
iterations=1000000 res=2 truncated=0 in=934964 out=65036: 0.934964 percent contained
iterations=1000000 res=1 truncated=0 in=924505 out=75495: 0.924505 percent contained
```
