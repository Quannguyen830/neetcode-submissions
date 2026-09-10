class TimeMap {
    static class MapInstance {
        String value;
        int timestamp;

        MapInstance(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<MapInstance>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        MapInstance inner = new MapInstance(value, timestamp);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(inner);
    }

    public String get(String key, int timestamp) {
        if (map.get(key) == null)
            return "";
        String res = "";

        List<MapInstance> mapi = map.get(key);
        int l = 0, r = mapi.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (mapi.get(m).timestamp <= timestamp) {
                res = mapi.get(m).value;
                l = m + 1;
            } else
                r = m - 1;
        }

        return res;
    }
}
