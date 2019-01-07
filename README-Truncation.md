# Index truncation error

## Sample invocation

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3measurements.h3.TruncationRatioApp"
```

## Summary

This application measures the ratio of area error when truncating from a finer H3
resolution to a coarser one. The error is introduced by the use aperture 7 hexagon
subdivision, where 7 finer hexagonal cells are approximately contained by a coarser
cell.

The ratio of error is measured by randomly sampling locations on the sphere, indexing
to a fine resolution, and truncating the precision of the fine `H3Index`. The truncated
`H3Index` is compared to the same location indexed at the coarser resolution (which is
not affected by shape error). If the two indexes are the same, the point is considered
`in`, as shown in the sample output below (otherwise it is considered `out`). The ratio
of `out` points to all points sampled is taken as the shape error introduced by aperture 7.

Sample output is shown below. When truncating indexes to a coarser resolution, about 7.2%
~ 6.2% of the area is in error.

## Sample output

```
iterations=1000000 res=15 truncated=14 in=928646 out=71354: 0.928646 percent contained
iterations=1000000 res=15 truncated=13 in=938535 out=61465: 0.938535 percent contained
iterations=1000000 res=15 truncated=12 in=934096 out=65904: 0.934096 percent contained
iterations=1000000 res=15 truncated=11 in=934659 out=65341: 0.934659 percent contained
iterations=1000000 res=15 truncated=10 in=934453 out=65547: 0.934453 percent contained
iterations=1000000 res=15 truncated=9 in=934481 out=65519: 0.934481 percent contained
iterations=1000000 res=15 truncated=8 in=934757 out=65243: 0.934757 percent contained
iterations=1000000 res=15 truncated=7 in=934481 out=65519: 0.934481 percent contained
iterations=1000000 res=15 truncated=6 in=934532 out=65468: 0.934532 percent contained
iterations=1000000 res=15 truncated=5 in=934713 out=65287: 0.934713 percent contained
iterations=1000000 res=15 truncated=4 in=934984 out=65016: 0.934984 percent contained
iterations=1000000 res=15 truncated=3 in=935223 out=64777: 0.935223 percent contained
iterations=1000000 res=15 truncated=2 in=934695 out=65305: 0.934695 percent contained
iterations=1000000 res=15 truncated=1 in=935078 out=64922: 0.935078 percent contained
iterations=1000000 res=15 truncated=0 in=930000 out=70000: 0.930000 percent contained
iterations=1000000 res=14 truncated=13 in=928612 out=71388: 0.928612 percent contained
iterations=1000000 res=14 truncated=12 in=938602 out=61398: 0.938602 percent contained
iterations=1000000 res=14 truncated=11 in=934507 out=65493: 0.934507 percent contained
iterations=1000000 res=14 truncated=10 in=934994 out=65006: 0.934994 percent contained
iterations=1000000 res=14 truncated=9 in=935202 out=64798: 0.935202 percent contained
iterations=1000000 res=14 truncated=8 in=934810 out=65190: 0.934810 percent contained
iterations=1000000 res=14 truncated=7 in=934926 out=65074: 0.934926 percent contained
iterations=1000000 res=14 truncated=6 in=934770 out=65230: 0.934770 percent contained
iterations=1000000 res=14 truncated=5 in=934860 out=65140: 0.934860 percent contained
iterations=1000000 res=14 truncated=4 in=935059 out=64941: 0.935059 percent contained
iterations=1000000 res=14 truncated=3 in=934584 out=65416: 0.934584 percent contained
iterations=1000000 res=14 truncated=2 in=935259 out=64741: 0.935259 percent contained
iterations=1000000 res=14 truncated=1 in=934960 out=65040: 0.934960 percent contained
iterations=1000000 res=14 truncated=0 in=930090 out=69910: 0.930090 percent contained
iterations=1000000 res=13 truncated=12 in=928704 out=71296: 0.928704 percent contained
iterations=1000000 res=13 truncated=11 in=938896 out=61104: 0.938896 percent contained
iterations=1000000 res=13 truncated=10 in=934162 out=65838: 0.934162 percent contained
iterations=1000000 res=13 truncated=9 in=935150 out=64850: 0.935150 percent contained
iterations=1000000 res=13 truncated=8 in=934982 out=65018: 0.934982 percent contained
iterations=1000000 res=13 truncated=7 in=935214 out=64786: 0.935214 percent contained
iterations=1000000 res=13 truncated=6 in=934658 out=65342: 0.934658 percent contained
iterations=1000000 res=13 truncated=5 in=934938 out=65062: 0.934938 percent contained
iterations=1000000 res=13 truncated=4 in=934604 out=65396: 0.934604 percent contained
iterations=1000000 res=13 truncated=3 in=935253 out=64747: 0.935253 percent contained
iterations=1000000 res=13 truncated=2 in=935168 out=64832: 0.935168 percent contained
iterations=1000000 res=13 truncated=1 in=934676 out=65324: 0.934676 percent contained
iterations=1000000 res=13 truncated=0 in=930018 out=69982: 0.930018 percent contained
iterations=1000000 res=12 truncated=11 in=928656 out=71344: 0.928656 percent contained
iterations=1000000 res=12 truncated=10 in=938452 out=61548: 0.938452 percent contained
iterations=1000000 res=12 truncated=9 in=934658 out=65342: 0.934658 percent contained
iterations=1000000 res=12 truncated=8 in=934983 out=65017: 0.934983 percent contained
iterations=1000000 res=12 truncated=7 in=934485 out=65515: 0.934485 percent contained
iterations=1000000 res=12 truncated=6 in=934734 out=65266: 0.934734 percent contained
iterations=1000000 res=12 truncated=5 in=935170 out=64830: 0.935170 percent contained
iterations=1000000 res=12 truncated=4 in=934936 out=65064: 0.934936 percent contained
iterations=1000000 res=12 truncated=3 in=934871 out=65129: 0.934871 percent contained
iterations=1000000 res=12 truncated=2 in=934922 out=65078: 0.934922 percent contained
iterations=1000000 res=12 truncated=1 in=935255 out=64745: 0.935255 percent contained
iterations=1000000 res=12 truncated=0 in=930483 out=69517: 0.930483 percent contained
iterations=1000000 res=11 truncated=10 in=928690 out=71310: 0.928690 percent contained
iterations=1000000 res=11 truncated=9 in=938606 out=61394: 0.938606 percent contained
iterations=1000000 res=11 truncated=8 in=934168 out=65832: 0.934168 percent contained
iterations=1000000 res=11 truncated=7 in=935016 out=64984: 0.935016 percent contained
iterations=1000000 res=11 truncated=6 in=934806 out=65194: 0.934806 percent contained
iterations=1000000 res=11 truncated=5 in=934922 out=65078: 0.934922 percent contained
iterations=1000000 res=11 truncated=4 in=935075 out=64925: 0.935075 percent contained
iterations=1000000 res=11 truncated=3 in=935322 out=64678: 0.935322 percent contained
iterations=1000000 res=11 truncated=2 in=935225 out=64775: 0.935225 percent contained
iterations=1000000 res=11 truncated=1 in=935197 out=64803: 0.935197 percent contained
iterations=1000000 res=11 truncated=0 in=930092 out=69908: 0.930092 percent contained
iterations=1000000 res=10 truncated=9 in=928621 out=71379: 0.928621 percent contained
iterations=1000000 res=10 truncated=8 in=938640 out=61360: 0.938640 percent contained
iterations=1000000 res=10 truncated=7 in=934698 out=65302: 0.934698 percent contained
iterations=1000000 res=10 truncated=6 in=934995 out=65005: 0.934995 percent contained
iterations=1000000 res=10 truncated=5 in=934553 out=65447: 0.934553 percent contained
iterations=1000000 res=10 truncated=4 in=934718 out=65282: 0.934718 percent contained
iterations=1000000 res=10 truncated=3 in=934833 out=65167: 0.934833 percent contained
iterations=1000000 res=10 truncated=2 in=934968 out=65032: 0.934968 percent contained
iterations=1000000 res=10 truncated=1 in=935507 out=64493: 0.935507 percent contained
iterations=1000000 res=10 truncated=0 in=929651 out=70349: 0.929651 percent contained
iterations=1000000 res=9 truncated=8 in=928373 out=71627: 0.928373 percent contained
iterations=1000000 res=9 truncated=7 in=938928 out=61072: 0.938928 percent contained
iterations=1000000 res=9 truncated=6 in=934440 out=65560: 0.934440 percent contained
iterations=1000000 res=9 truncated=5 in=934973 out=65027: 0.934973 percent contained
iterations=1000000 res=9 truncated=4 in=934834 out=65166: 0.934834 percent contained
iterations=1000000 res=9 truncated=3 in=934895 out=65105: 0.934895 percent contained
iterations=1000000 res=9 truncated=2 in=935556 out=64444: 0.935556 percent contained
iterations=1000000 res=9 truncated=1 in=935045 out=64955: 0.935045 percent contained
iterations=1000000 res=9 truncated=0 in=930278 out=69722: 0.930278 percent contained
iterations=1000000 res=8 truncated=7 in=928450 out=71550: 0.928450 percent contained
iterations=1000000 res=8 truncated=6 in=938690 out=61310: 0.938690 percent contained
iterations=1000000 res=8 truncated=5 in=934085 out=65915: 0.934085 percent contained
iterations=1000000 res=8 truncated=4 in=935041 out=64959: 0.935041 percent contained
iterations=1000000 res=8 truncated=3 in=935224 out=64776: 0.935224 percent contained
iterations=1000000 res=8 truncated=2 in=935194 out=64806: 0.935194 percent contained
iterations=1000000 res=8 truncated=1 in=935208 out=64792: 0.935208 percent contained
iterations=1000000 res=8 truncated=0 in=930190 out=69810: 0.930190 percent contained
iterations=1000000 res=7 truncated=6 in=928820 out=71180: 0.928820 percent contained
iterations=1000000 res=7 truncated=5 in=938296 out=61704: 0.938296 percent contained
iterations=1000000 res=7 truncated=4 in=934838 out=65162: 0.934838 percent contained
iterations=1000000 res=7 truncated=3 in=934483 out=65517: 0.934483 percent contained
iterations=1000000 res=7 truncated=2 in=935034 out=64966: 0.935034 percent contained
iterations=1000000 res=7 truncated=1 in=935219 out=64781: 0.935219 percent contained
iterations=1000000 res=7 truncated=0 in=930286 out=69714: 0.930286 percent contained
iterations=1000000 res=6 truncated=5 in=928757 out=71243: 0.928757 percent contained
iterations=1000000 res=6 truncated=4 in=938476 out=61524: 0.938476 percent contained
iterations=1000000 res=6 truncated=3 in=934763 out=65237: 0.934763 percent contained
iterations=1000000 res=6 truncated=2 in=935512 out=64488: 0.935512 percent contained
iterations=1000000 res=6 truncated=1 in=934873 out=65127: 0.934873 percent contained
iterations=1000000 res=6 truncated=0 in=929983 out=70017: 0.929983 percent contained
iterations=1000000 res=5 truncated=4 in=928557 out=71443: 0.928557 percent contained
iterations=1000000 res=5 truncated=3 in=938832 out=61168: 0.938832 percent contained
iterations=1000000 res=5 truncated=2 in=934487 out=65513: 0.934487 percent contained
iterations=1000000 res=5 truncated=1 in=935199 out=64801: 0.935199 percent contained
iterations=1000000 res=5 truncated=0 in=930078 out=69922: 0.930078 percent contained
iterations=1000000 res=4 truncated=3 in=928872 out=71128: 0.928872 percent contained
iterations=1000000 res=4 truncated=2 in=939029 out=60971: 0.939029 percent contained
iterations=1000000 res=4 truncated=1 in=934432 out=65568: 0.934432 percent contained
iterations=1000000 res=4 truncated=0 in=930135 out=69865: 0.930135 percent contained
iterations=1000000 res=3 truncated=2 in=928957 out=71043: 0.928957 percent contained
iterations=1000000 res=3 truncated=1 in=939112 out=60888: 0.939112 percent contained
iterations=1000000 res=3 truncated=0 in=929612 out=70388: 0.929612 percent contained
iterations=1000000 res=2 truncated=1 in=928872 out=71128: 0.928872 percent contained
iterations=1000000 res=2 truncated=0 in=934252 out=65748: 0.934252 percent contained
iterations=1000000 res=1 truncated=0 in=923930 out=76070: 0.923930 percent contained
```
