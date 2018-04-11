package com.mlasaf.utils

class SimpleStatistics {
  var valueCount : Double = 0.0;
  var valueMin : Double = Double.MaxValue;
  var valueMax : Double = Double.MinValue;
  var valueSum : Double = 0.0;
  var valueSumSq : Double = 0.0;

  def valueStdev : Double = 0.0;
  // (x-xs)^2/N = (x^2/N - 2x*xs/N + xs^2/N)  = SumSq/N - 2Avg*Sum + Avg^2*N
  def valueMean : Double = valueSum / valueCount

  def add(v : Double) : Unit = {
    valueCount = valueCount + 1;
    valueSum = valueSum + v
    valueSumSq = valueSumSq + v*v
    if (valueMin > v) {
      valueMin = v
    }
    if (valueMax < v) {
      valueMax = v
    }
  }
}
