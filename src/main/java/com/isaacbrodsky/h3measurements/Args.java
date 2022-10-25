package com.isaacbrodsky.h3measurements;

import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = "-random-sphere", description = "Random based on sphere")
    public boolean randomSphere = false;
  }