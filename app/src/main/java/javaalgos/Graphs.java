package javaalgos;

import java.util.*;


public class Graphs {

    public static class Graph {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        public void addEdge(Integer from, int to) {
            if (adj.containsKey(from)) {
                adj.get(from).add(to);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(to);
                adj.put(from, l);
            }
        }

        public List<Integer> neighbors(int n) {
            if (adj.containsKey(n)) {
                return adj.get(n);
            } else {
                return Collections.EMPTY_LIST;
            }
        }

        public Set<Integer> dfs(int n) {
            Set<Integer> seen = new HashSet<>();
            dfsI(n, seen);
            return seen;
        }

        public Set<Integer> bfs(int n) {
            Set<Integer> seen = new HashSet<>();
            bfsI(n, seen);
            return seen;
        }

        public int connectedComps() {
            Set<Integer> vs = adj.keySet();
            Set<Integer> seen = new HashSet<>();
            int cc = 0;
            for (Integer n : vs) {
                if (!seen.contains(n)) {
                    cc++;
                    dfsI(n, seen);
                }
            }
            return cc;
        }


        private void bfsI(int n, Set<Integer> seen) {
            Queue<Integer> q = new LinkedList<>();
            Map<Integer, Integer> distance = new HashMap<>();
            q.offer(n);
            distance.put(n, 0);
            seen.add(n);
            while (q.peek() != null) {
                int s = q.poll();
                for (int g : this.neighbors(s)) {
                    if (seen.contains(g)) {
                        continue;
                    }
                    seen.add(g);
                    distance.put(g, distance.get(s) + 1);
                    q.offer(g);
                }
            }
            System.out.println(distance);
        }

        private void dfsR(int n, Set<Integer> seen) {
            seen.add(n);
            for (int g : this.neighbors(n)) {
                if (!seen.contains(g)) {
                    dfsR(g, seen);
                }
            }
        }

        private void dfsI(int n, Set<Integer> seen) {
            seen.add(n);
            Stack<Integer> tv = new Stack<>();
            tv.push(n);
            while (!tv.isEmpty()) {
                int g = tv.pop();
                for (int x : this.neighbors(g)) {
                    if (!seen.contains(x)) {
                        seen.add(x);
                        tv.push(x);
                    }
                }
            }
        }



        public boolean isBipartite(int[][] g) {
            int[] colors = new int[g.length];
            for (int i = 0; i < g.length; i++) {
                if (colors[i] != 0) {
                    continue;
                }
                colors[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int s = q.poll();
                    for (int x : g[s]) {
                        if (colors[x] == colors[s]) {
                            return false;
                        }
                        if (colors[x] == 0) {
                            colors[x] = -colors[s];
                            q.offer(x);
                        }
                    }
                }
            }
            return true;
        }

       public int articulationPoints(int[][] g) {
            int[] low = new int[g.length];
            int[] disc = new int[g.length];
            int[] parent = new int[g.length];
            int[] ap = new int[g.length];
            Arrays.fill(parent, -1);
            int time = 0;
            for (int i = 0; i < g.length; i++) {
                if (disc[i] == 0) {
                    articulationPointsI(g, low, disc, parent, ap, i, time);
                }
            }
            return Arrays.stream(ap).sum();
        }

        private void articulationPointsI(int[][] g, int[] low, int[] disc, int[] parent, int[] ap, int n, int time) {
            time++;
            disc[n] = time;
            low[n] = time;
            int children = 0;
            for (int x : g[n]) {
                if (disc[x] == 0) {
                    children++;
                    parent[x] = n;
                    articulationPointsI(g, low, disc, parent, ap, x, time);
                    low[n] = Math.min(low[n], low[x]);
                    if (parent[n] == -1 && children > 1) {
                        ap[n] = 1;
                    }
                    if (parent[n] != -1 && low[x] >= disc[n]) {
                        ap[n] = 1;
                    }
                } else if (x != parent[n]) {
                    low[n] = Math.min(low[n], disc[x]);
                }
            }
        }

        public int bridges(int[][] g) {
            int[] low = new int[g.length];
            int[] disc = new int[g.length];
            int[] parent = new int[g.length];
            int[] ap = new int[g.length];
            Arrays.fill(parent, -1);
            int time = 0;
            for (int i = 0; i < g.length; i++) {
                if (disc[i] == 0) {
                    bridgesI(g, low, disc, parent, ap, i, time);
                }
            }
            return Arrays.stream(ap).sum();
        }

        private void bridgesI(int[][] g, int[] low, int[] disc, int[] parent, int[] ap, int i, int time) {
            time++;
            disc[i] = time;
            low[i] = time;
            for (int x : g[i]) {
                if (disc[x] == 0) {
                    parent[x] = i;
                    bridgesI(g, low, disc, parent, ap, x, time);
                    low[i] = Math.min(low[i], low[x]);
                    if (low[x] > disc[i]) {
                        ap[i] = 1;
                    }
                } else if (x != parent[i]) {
                    low[i] = Math.min(low[i], disc[x]);
                }
            }
        }

        public int[] topologicalSort(int[][] g) {
            int[] in = new int[g.length];
            for (int i = 0; i < g.length; i++) {
                for (int x : g[i]) {
                    in[x]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < g.length; i++) {
                if (in[i] == 0) {
                    q.offer(i);
                }
            }
            int[] res = new int[g.length];
            int i = 0;
            while (!q.isEmpty()) {
                int s = q.poll();
                res[i++] = s;
                for (int x : g[s]) {
                    in[x]--;
                    if (in[x] == 0) {
                        q.offer(x);
                    }
                }
            }
            return res;
        }

        public int[] shortestPath(int[][] g, int s) {
            int[] res = new int[g.length];
            Arrays.fill(res, Integer.MAX_VALUE);
            res[s] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(s);
            while (!q.isEmpty()) {
                int n = q.poll();
                for (int x : g[n]) {
                    if (res[x] > res[n] + 1) {
                        res[x] = res[n] + 1;
                        q.offer(x);
                    }
                }
            }
            return res;
        }

        public int maximumBipartiteMatching(int[][] g) {
            int[] match = new int[g.length];
            Arrays.fill(match, -1);
            int res = 0;
            for (int i = 0; i < g.length; i++) {
                if (match[i] == -1) {
                    res += maximumBipartiteMatchingI(g, match, i);
                }
            }
            return res;
        }

        private int maximumBipartiteMatchingI(int[][] g, int[] match, int i) {
            for (int x : g[i]) {
                if (match[x] == -1) {
                    match[x] = i;
                    return 1;
                }
            }
            for (int x : g[i]) {
                if (maximumBipartiteMatchingI(g, match, match[x]) == 1) {
                    match[x] = i;
                    return 1;
                }
            }
            return 0;
        }

        public int[] minCostMaxFlow(int[][] g, int s, int t) {
            int[] res = new int[2];
            int[][] f = new int[g.length][g.length];
            int[] cost = new int[g.length];
            while (true) {
                int[] p = new int[g.length];
                Arrays.fill(p, -1);
                p[s] = s;
                Queue<Integer> q = new LinkedList<>();
                q.offer(s);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    for (int x : g[n]) {
                        if (p[x] == -1 && f[n][x] < 1) {
                            p[x] = n;
                            q.offer(x);
                        }
                    }
                }
                if (p[t] == -1) {
                    break;
                }
                int cf = Integer.MAX_VALUE;
                for (int i = t; i != s; i = p[i]) {
                    cf = Math.min(cf, 1 - f[p[i]][i]);
                }
                for (int i = t; i != s; i = p[i]) {
                    f[p[i]][i] += cf;
                    f[i][p[i]] -= cf;
                }
                res[1] += cf;
                for (int i = t; i != s; i = p[i]) {
                    cost[t] += cf;
                    cost[p[i]] -= cf;
                }
            }
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g.length; j++) {
                    if (f[i][j] == 1) {
                        res[0] += cost[j];
                    }
                }
            }
            return res;
        }

        public int[] minCostMaxFlow(int[][] g, int[] cost, int s, int t) {
            int[] res = new int[2];
            int[][] f = new int[g.length][g.length];
            while (true) {
                int[] p = new int[g.length];
                Arrays.fill(p, -1);
                p[s] = s;
                Queue<Integer> q = new LinkedList<>();
                q.offer(s);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    for (int x : g[n]) {
                        if (p[x] == -1 && f[n][x] < 1) {
                            p[x] = n;
                            q.offer(x);
                        }
                    }
                }
                if (p[t] == -1) {
                    break;
                }
                int cf = Integer.MAX_VALUE;
                for (int i = t; i != s; i = p[i]) {
                    cf = Math.min(cf, 1 - f[p[i]][i]);
                }
                for (int i = t; i != s; i = p[i]) {
                    f[p[i]][i] += cf;
                    f[i][p[i]] -= cf;
                }
                res[1] += cf;
                for (int i = t; i != s; i = p[i]) {
                    res[0] += cf * cost[i];
                }
            }
            return res;
        }

        public int[] minCostMaxFlow(int[][] g, int[] cost, int[] cap, int s, int t) {
            int[] res = new int[2];
            int[][] f = new int[g.length][g.length];
            while (true) {
                int[] p = new int[g.length];
                Arrays.fill(p, -1);
                p[s] = s;
                Queue<Integer> q = new LinkedList<>();
                q.offer(s);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    for (int x : g[n]) {
                        if (p[x] == -1 && f[n][x] < cap[n]) {
                            p[x] = n;
                            q.offer(x);
                        }
                    }
                }
                if (p[t] == -1) {
                    break;
                }
                int cf = Integer.MAX_VALUE;
                for (int i = t; i != s; i = p[i]) {
                    cf = Math.min(cf, cap[p[i]] - f[p[i]][i]);
                }
                for (int i = t; i != s; i = p[i]) {
                    f[p[i]][i] += cf;
                    f[i][p[i]] -= cf;
                }
                res[1] += cf;
                for (int i = t; i != s; i = p[i]) {
                    res[0] += cf * cost[i];
                }
            }
            return res;
        }

        public int[] minCostMaxFlow(int[][] g, int[] cost, int[] cap, int s, int t, int maxf) {
            int[] res = new int[2];
            int[][] f = new int[g.length][g.length];
            while (true) {
                int[] p = new int[g.length];
                Arrays.fill(p, -1);
                p[s] = s;
                Queue<Integer> q = new LinkedList<>();
                q.offer(s);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    for (int x : g[n]) {
                        if (p[x] == -1 && f[n][x] < cap[n]) {
                            p[x] = n;
                            q.offer(x);
                        }
                    }
                }
                if (p[t] == -1) {
                    break;
                }
                int cf = Integer.MAX_VALUE;
                for (int i = t; i != s; i = p[i]) {
                    cf = Math.min(cf, cap[p[i]] - f[p[i]][i]);
                }
                cf = Math.min(cf, maxf - res[1]);
                for (int i = t; i != s; i = p[i]) {
                    f[p[i]][i] += cf;
                    f[i][p[i]] -= cf;
                }
                res[1] += cf;
                for (int i = t; i != s; i = p[i]) {
                    res[0] += cf * cost[i];
                }
                if (res[1] == maxf) {
                    break;
                }
            }
            return res;
        }

        public int[] minCostMaxFlow(int[][] g, int[] cost, int[] cap, int s, int t, int maxf, int[] minf) {
            int[] res = new int[2];
            int[][] f = new int[g.length][g.length];
            while (true) {
                int[] p = new int[g.length];
                Arrays.fill(p, -1);
                p[s] = s;
                Queue<Integer> q = new LinkedList<>();
                q.offer(s);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    for (int x : g[n]) {
                        if (p[x] == -1 && f[n][x] < cap[n]) {
                            p[x] = n;
                            q.offer(x);
                        }
                    }
                }
                if (p[t] == -1) {
                    break;
                }
                int cf = Integer.MAX_VALUE;
                for (int i = t; i != s; i = p[i]) {
                    cf = Math.min(cf, cap[p[i]] - f[p[i]][i]);
                }
                cf = Math.min(cf, maxf - res[1]);
                for (int i = t; i != s; i = p[i]) {
                    f[p[i]][i] += cf;
                    f[i][p[i]] -= cf;
                }
                res[1] += cf;
                for (int i = t; i != s; i = p[i]) {
                    res[0] += cf * cost[i];
                }
                if (res[1] == maxf) {
                    break;
                }
            }
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g.length; j++) {
                    if (f[i][j] == 1) {
                        minf[i]++;
                    }
                }
            }
            return res;
        }

    }

}