package javaalgos;

import java.util.*;

public class Intervals {
    public static class Interval {
        int s;
        int e;

        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public String toString() {
            return this.s + " .. " + this.e;
        }
    }

    public static class IntervalVal {
        Intervals.Interval iv;
        int v;
    }

    public static class IntervalTreeNode {
        int c;
        List byLow;
        List<Integer> byHigh;
        Map<Integer, Intervals.Interval> lowMap;
        Map<Integer, Intervals.Interval> highMap;

        Intervals.IntervalTree left;
        Intervals.IntervalTree right;

        public IntervalTreeNode(int c, List<Integer> byLow, List<Integer> byHigh, Map<Integer, Intervals.Interval> lowMap, Map<Integer, Intervals.Interval> highMap, Intervals.IntervalTree left, Intervals.IntervalTree right) {
            this.c = c;
            this.byLow = byLow;
            this.byHigh = byHigh;
            this.lowMap = lowMap;
            this.highMap = highMap;

            this.left = left;
            this.right = right;

        }
    }

    public static class IntervalTree {
        IntervalTreeNode r;

        public IntervalTree(List<Intervals.Interval> intervals) {
            if (intervals == null || intervals.isEmpty()) {
                this.r = null;
            } else {
                int center = intervals.get(intervals.size() / 2).s;
                Map<Integer, Intervals.Interval> lowMap = new HashMap<>();
                Map<Integer, Intervals.Interval> highMap = new HashMap<>();
                List<Intervals.Interval> left = new ArrayList<>();
                List<Intervals.Interval> right = new ArrayList<>();
                List<Intervals.Interval> centers = new ArrayList<>();
                List<Integer> byLow = new ArrayList<>();
                List<Integer> byHigh = new ArrayList<>();
                for (int i = 0; i < intervals.size(); i++) {
                    if (intervals.get(i).e <= center) {
                        left.add(intervals.get(i));
                    } else if (center < intervals.get(i).s) {
                        right.add(intervals.get(i));
                    } else {
                        lowMap.put(intervals.get(i).s, intervals.get(i));
                        highMap.put(intervals.get(i).e, intervals.get(i));
                        byLow.add(intervals.get(i).s);
                        byHigh.add(intervals.get(i).e);

                    }

                    Collections.sort(byLow);
                    Collections.sort(byHigh);
                    this.r = new Intervals.IntervalTreeNode(center, byLow, byHigh, lowMap, highMap, new Intervals.IntervalTree(left), new Intervals.IntervalTree(right));
                }

            }

        }

        public List<Intervals.Interval> findIntervals(int s) {
            if (this.r == null) {
                return new ArrayList<>();
            }
            List<Intervals.Interval> retVal;
            int j;
            if (s < this.r.c) {
                retVal = this.r.left.findIntervals(s);
                j = Collections.binarySearch(this.r.byLow, s);
                if (j < 0) {
                    j = ~j;
                    for (int i = 0; i < j; i++) {
                        retVal.add(this.r.lowMap.get(this.r.byLow.get(i)));
                    }
                }

            } else {
                retVal = this.r.right.findIntervals(s);
                j = Collections.binarySearch(this.r.byHigh, s);
                if (j < 0) {
                    j = ~j;
                    for (int i = j; i < this.r.byHigh.size(); i++) {
                        retVal.add(this.r.highMap.get(this.r.byHigh.get(i)));
                    }
                }
            }
            return retVal;
        }
    }

    public static class IV implements Comparable<IV> {
        int v;
        boolean isStart;

        public IV(int v, boolean isStart) {
            this.v = v;
            this.isStart = isStart;
        }

        public int compareTo(IV other) {
            if (this.v == other.v) {
                if (this.isStart == other.isStart) {
                    return 0;
                }
                return this.isStart ? 1 : -1;
            }
            return this.v > other.v ? 1 : -1;
        }
    }

    public static List<Intervals.Interval> union(Set<Intervals.Interval> ivs) {
        List<Intervals.Interval> l = new ArrayList<>();
        List<IV> a = new ArrayList<>();
        for (Intervals.Interval i : ivs) {
            a.add(new Intervals.IV(i.s, true));
            a.add(new Intervals.IV(i.e, false));
        }
        int last = -1;
        Stack<Integer> s = new Stack<Integer>();
        Collections.sort(a);
        for (Intervals.IV t : a) {
            if (t.isStart) {
                if (s.isEmpty()) {
                    last = t.v;
                }
                s.push(t.v);

            } else {
                s.pop();
                if (s.isEmpty()) {
                    l.add(new Intervals.Interval(last, t.v));
                }

            }
        }
        System.out.println(l);
        return l;
    }

    public static List<Integer> intervalCover(List<Intervals.Interval> s) {
        List<Integer> l = new ArrayList<>();
        Collections.sort(s, new Comparator<Intervals.Interval>() {
            public int compare(Intervals.Interval one, Intervals.Interval other) {
                if (one.e == other.e) {
                    return 0;
                }
                return one.e > other.e ? 1 : -1;
            }
        });
        for (Intervals.Interval i : s) {
            if (l.isEmpty() || l.get(l.size() - 1) < i.s) {
                l.add(i.e);
            }
        }
        System.out.println(l);
        return l;
    }


}