# Average cell area statistics for S2

## Sample invocation

```
mvn exec:java -Dexec.mainClass="com.isaacbrodsky.h3measurements.s2.S2SummaryAreaStatsApp"
```

## Summary

This application produces average area for S2 cells sampled across the world. Locations
are sampled across a sphere, indexed to an `S2CellId`, and the area of this cell is then
measured by projecting to Universal Transverse Mercator (`AUTO:42001` in Geotools) centered
on the cell. Measures are in square kilometers.

This application is intended to be comparable to the (average cell area statistics for H3)[./README-SummaryAreaStats.md].

It seems to be consistent with the comment about the quadratic projection in (Geometry on the Sphere: Google's S2 Library)[https://docs.google.com/presentation/d/1Hl4KapfAENAOf4gv-pSngKwvS_jwNVHRPZTTDzXXn6Q/view#slide=id.i34] (maximum ratio of about 2.1).

## Sample output

```
final iterations=10000 level=0 stats in km2: SummaryStatistics:
n: 10000
min: 4.261413284807859E7
max: 8.406788121860726E7
mean: 6.18113637184704E7
geometric mean: 5.837186344512258E7
variance: 4.273062354445844E14
sum of squares: 4.247908189557706E19
standard deviation: 2.0671386877628323E7
sum of logs: 178823.44541376963
ratio of max to min: 1.972770

final iterations=10000 level=1 stats in km2: SummaryStatistics:
n: 10000
min: 2.115902970726042E7
max: 2.1384543038680784E7
mean: 2.1281708959553074E7
geometric mean: 2.1281412377521828E7
variance: 1.261686962455252E10
sum of squares: 4.5292375184715566E18
standard deviation: 112324.83974861715
sum of logs: 168733.44591359398
ratio of max to min: 1.010658

final iterations=10000 level=2 stats in km2: SummaryStatistics:
n: 10000
min: 4906243.572088953
max: 6070366.512996412
mean: 5455271.366534189
geometric mean: 5434073.654119299
variance: 2.3559675272951746E11
sum of squares: 2.9995558875585421E17
standard deviation: 485383.0989327064
sum of logs: 155081.99623186342
ratio of max to min: 1.237274

final iterations=10000 level=3 stats in km2: SummaryStatistics:
n: 10000
min: 1053704.021615499
max: 1656857.8889353701
mean: 1372259.869457796
geometric mean: 1360855.4484962113
variance: 2.990889762012035E10
sum of squares: 1.9130030560545884E16
standard deviation: 172941.89087702363
sum of logs: 141236.24066217936
ratio of max to min: 1.572413

final iterations=10000 level=4 stats in km2: SummaryStatistics:
n: 10000
min: 230870.01146357047
max: 416205.19167240744
mean: 344432.3567676818
geometric mean: 341076.09348999045
variance: 2.1869294721290803E9
sum of squares: 1.2082035916772182E15
standard deviation: 46764.61773744206
sum of logs: 127398.60879436316
ratio of max to min: 1.802769

final iterations=10000 level=5 stats in km2: SummaryStatistics:
n: 10000
min: 53544.39034368282
max: 104905.42648337747
mean: 85997.02460198055
geometric mean: 85111.99191515613
variance: 1.4384688556570166E8
sum of squares: 7.539320741270655E13
standard deviation: 11993.618535108646
sum of logs: 113517.23220205551
ratio of max to min: 1.959223

final iterations=10000 level=6 stats in km2: SummaryStatistics:
n: 10000
min: 12882.313059974995
max: 26269.643832320857
mean: 21483.2652408
geometric mean: 21259.791014274906
variance: 9057218.280955443
sum of squares: 4.705869979656935E12
standard deviation: 3009.521271058811
sum of logs: 99645.72821851147
ratio of max to min: 2.039202

final iterations=10000 level=7 stats in km2: SummaryStatistics:
n: 10000
min: 3183.30490324601
max: 6568.714598318766
mean: 5348.872997604658
geometric mean: 5292.282246098708
variance: 572992.5619765805
sum of squares: 2.918337760722444E11
standard deviation: 756.9627216558162
sum of logs: 85740.04858298386
ratio of max to min: 2.063489

final iterations=10000 level=8 stats in km2: SummaryStatistics:
n: 10000
min: 788.115191026094
max: 1642.2048066204093
mean: 1342.4393917248244
geometric mean: 1328.4449691419597
variance: 35462.198642052004
sum of squares: 1.837602172876697E10
standard deviation: 188.31409570728368
sum of logs: 71917.64341038896
ratio of max to min: 2.083712

final iterations=10000 level=9 stats in km2: SummaryStatistics:
n: 10000
min: 196.13261119775015
max: 410.57411614724924
mean: 335.33775187987476
geometric mean: 331.7497498718106
variance: 2270.020064478336
sum of squares: 1.1472120089832063E9
standard deviation: 47.64472756222178
sum of logs: 58043.80919246127
ratio of max to min: 2.093350

final iterations=10000 level=10 stats in km2: SummaryStatistics:
n: 10000
min: 49.47804285792203
max: 102.64182469483947
mean: 83.72967325337825
geometric mean: 82.84872241431145
variance: 139.24451238976442
sum of squares: 7.149888771055977E7
standard deviation: 11.800191201407053
sum of logs: 44170.163232867046
ratio of max to min: 2.074492

final iterations=10000 level=11 stats in km2: SummaryStatistics:
n: 10000
min: 12.49731716716916
max: 25.660909072247833
mean: 20.911574238861117
geometric mean: 20.69607008369355
variance: 8.55465550167194
sum of squares: 4458477.37183521
standard deviation: 2.924834269094907
sum of logs: 30299.43831218038
ratio of max to min: 2.053313

final iterations=10000 level=12 stats in km2: SummaryStatistics:
n: 10000
min: 3.1351650608944786
max: 6.414889949577735
mean: 5.226995008876376
geometric mean: 5.171561868691686
variance: 0.547566179927859
sum of squares: 278689.8824612835
standard deviation: 0.7399771482470652
sum of logs: 16431.74745158086
ratio of max to min: 2.046109

final iterations=10000 level=13 stats in km2: SummaryStatistics:
n: 10000
min: 0.7652932177935892
max: 1.6038117219420975
mean: 1.3104278892531265
geometric mean: 1.2969371043301188
variance: 0.03339600890767045
sum of squares: 17506.139222391863
standard deviation: 0.18274574935595753
sum of logs: 2600.0541096658403
ratio of max to min: 2.095683

final iterations=10000 level=14 stats in km2: SummaryStatistics:
n: 10000
min: 0.1918560512210903
max: 0.40091286927727593
mean: 0.3277036012032186
geometric mean: 0.32430879558999426
variance: 0.002102662340131251
sum of squares: 1094.9210231545653
standard deviation: 0.04585479626092837
sum of logs: -11260.59144266705
ratio of max to min: 2.089655

final iterations=10000 level=15 stats in km2: SummaryStatistics:
n: 10000
min: 0.04799420544761492
max: 0.1002355969175301
mean: 0.08190938246563063
geometric mean: 0.08106033129304702
variance: 1.316080490109692E-4
sum of squares: 68.40741824107042
standard deviation: 0.011472055134585485
sum of logs: -25125.61570780124
ratio of max to min: 2.088494

final iterations=10000 level=16 stats in km2: SummaryStatistics:
n: 10000
min: 0.012122477329648516
max: 0.025059242627959097
mean: 0.02043875722666129
geometric mean: 0.020229124575119987
variance: 8.104763174455364E-6
sum of squares: 4.258467496685401
standard deviation: 0.0028468865756217554
sum of logs: -39006.3190233644
ratio of max to min: 2.067172

final iterations=10000 level=17 stats in km2: SummaryStatistics:
n: 10000
min: 0.003108356302392246
max: 0.0062647001577943425
mean: 0.005113521077732717
geometric mean: 0.005060861461376932
variance: 5.097092773163982E-7
sum of squares: 0.26657756118805487
standard deviation: 7.139392672464501E-4
sum of logs: -52862.18560889549
ratio of max to min: 2.015438

final iterations=10000 level=18 stats in km2: SummaryStatistics:
n: 10000
min: 7.538600701242393E-4
max: 0.00156621977897243
mean: 0.0012805406563457305
geometric mean: 0.0012671426297524088
variance: 3.232239153911205E-8
sum of squares: 0.016721035318543315
standard deviation: 1.797842916917717E-4
sum of logs: -66709.9081116729
ratio of max to min: 2.077600

final iterations=10000 level=19 stats in km2: SummaryStatistics:
n: 10000
min: 1.8875537951480045E-4
max: 3.9155737626819846E-4
mean: 3.1931616653058185E-4
geometric mean: 3.160119032215132E-4
variance: 1.9937550058998777E-9
sum of squares: 0.0010395636983818477
standard deviation: 4.4651483804011234E-5
sum of logs: -80597.30676664288
ratio of max to min: 2.074417

final iterations=10000 level=20 stats in km2: SummaryStatistics:
n: 10000
min: 4.797564706735461E-5
max: 9.788519130105551E-5
mean: 7.980872499898684E-5
geometric mean: 7.897677035631549E-5
variance: 1.2572320613667542E-10
sum of squares: 6.495143219779991E-5
standard deviation: 1.1212636003040294E-5
sum of logs: -94463.5679485988
ratio of max to min: 2.040310

final iterations=10000 level=21 stats in km2: SummaryStatistics:
n: 10000
min: 1.19582430893021E-5
max: 2.4470617997501576E-5
mean: 1.995980192127336E-5
geometric mean: 1.9746922451489156E-5
variance: 8.025724576142635E-12
sum of squares: 4.064186147401531E-6
standard deviation: 2.832970980462496E-6
sum of logs: -108325.12904000212
ratio of max to min: 2.046339

final iterations=10000 level=22 stats in km2: SummaryStatistics:
n: 10000
min: 2.9541883942584836E-6
max: 6.117731488426546E-6
mean: 4.999268974338874E-6
geometric mean: 4.947729463957829E-6
variance: 4.863386079757275E-13
sum of squares: 2.547898025190212E-7
standard deviation: 6.973798161516632E-7
sum of logs: -122165.8178076595
ratio of max to min: 2.070867

final iterations=10000 level=23 stats in km2: SummaryStatistics:
n: 10000
min: 7.386252493297868E-7
max: 1.5294027800060972E-6
mean: 1.2495534255425278E-6
geometric mean: 1.2365303691284181E-6
variance: 3.0715202787232816E-14
sum of squares: 1.592095894552011E-8
standard deviation: 1.752575327546089E-7
sum of logs: -136032.01189729798
ratio of max to min: 2.070607

final iterations=10000 level=24 stats in km2: SummaryStatistics:
n: 10000
min: 1.8401362794693786E-7
max: 3.8237972017083114E-7
mean: 3.122632711987289E-7
geometric mean: 3.091277176133327E-7
variance: 1.854852352117583E-15
sum of squares: 9.936301740661427E-10
standard deviation: 4.3067996843568E-8
sum of logs: -149895.11319834675
ratio of max to min: 2.077997

final iterations=10000 level=25 stats in km2: SummaryStatistics:
n: 10000
min: 4.579304823925932E-8
max: 9.558923455153105E-8
mean: 7.784003432932214E-8
geometric mean: 7.702436710643977E-8
variance: 1.2028322698127605E-16
sum of squares: 6.179342143048581E-11
standard deviation: 1.0967371015027988E-8
sum of logs: -163791.44009226555
ratio of max to min: 2.087418

final iterations=10000 level=26 stats in km2: SummaryStatistics:
n: 10000
min: 1.1589874065326539E-8
max: 2.3898487489214387E-8
mean: 1.9549502485812014E-8
geometric mean: 1.9346749959104046E-8
variance: 7.499760023009886E-18
sum of squares: 3.896820574897806E-12
standard deviation: 2.7385689735717607E-9
sum of logs: -177607.41392347426
ratio of max to min: 2.062014

final iterations=10000 level=27 stats in km2: SummaryStatistics:
n: 10000
min: 2.8406796153645627E-9
max: 5.974625588074642E-9
mean: 4.8746782708144324E-9
geometric mean: 4.824063596447015E-9
variance: 4.6634855831235E-19
sum of squares: 2.4228790167407186E-13
standard deviation: 6.828971798977867E-10
sum of logs: -191496.49194265346
ratio of max to min: 2.103238

final iterations=10000 level=28 stats in km2: SummaryStatistics:
n: 10000
min: 7.158890667179812E-10
max: 1.4936223049958055E-9
mean: 1.2189857168853708E-9
geometric mean: 1.2063034551597193E-9
variance: 2.920040784295929E-20
sum of squares: 1.515123665772717E-14
standard deviation: 1.7088126826237943E-10
sum of logs: -205357.05149098922
ratio of max to min: 2.086388

final iterations=10000 level=29 stats in km2: SummaryStatistics:
n: 10000
min: 1.7931442416776983E-10
max: 3.73390407257513E-10
mean: 3.047666854166747E-10
geometric mean: 3.015470556806377E-10
variance: 1.8496235002208704E-21
sum of squares: 9.47321710777374E-16
standard deviation: 4.3007249391478997E-11
sum of logs: -219220.95040030015
ratio of max to min: 2.082322

final iterations=10000 level=30 stats in km2: SummaryStatistics:
n: 10000
min: 4.555870150493851E-11
max: 9.335036721854576E-11
mean: 7.614116076449056E-11
geometric mean: 7.534867770337319E-11
variance: 1.142354813585042E-22
sum of squares: 5.91170042037439E-17
standard deviation: 1.0688099988234775E-11
sum of logs: -233088.94739737653
ratio of max to min: 2.049013
```
