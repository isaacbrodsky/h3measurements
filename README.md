# H3 Measurements

[![Build Status](https://travis-ci.com/isaacbrodsky/h3measurements.svg?branch=master)](https://travis-ci.com/isaacbrodsky/h3measurements)

This repository contains code for measuring different aspects of the [H3](https://github.com/uber/h3) hexagonal
hierarchical geospatial indexing system. Some things this repository measures includes average cell
area, the effect of aperture 7 on cell precision truncation, and so on.

Build with `mvn package`. Each application is described on its own README page, listed below, with sample
invocation, explanation, and sample output.

There are applications for describing randomly sampled cells:

* [Average area statistics](./README-SummaryAreaStats.md)
* [Truncation statistics](./README-Truncation.md)
* [Centroid truncation statistics](./README-CentroidTruncation.md)
* [Perimeter statistics](./README-SummaryPerimeterStats.md)

There is also an application which measure user specified cells:

* [Area statistics](./README-AreaStats.md)

There are also tests for some comparable systems:

* [S2 average area statistics](./README-S2SummaryAreaStats.md)

## License

[Apache 2.0](./LICENSE)
