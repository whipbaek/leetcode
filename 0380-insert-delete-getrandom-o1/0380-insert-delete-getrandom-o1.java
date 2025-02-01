import java.util.*;


class RandomizedSet {

    public Map<Integer, Integer> map;
    public int[] arr = new int[20001];
    public int lastIdx;

    public RandomizedSet() {
        map = new HashMap<>();
        lastIdx = -1;
    }
    // 요소가 없으면 true, 있으면 false
    public boolean insert(int val) {

        // if map has key, return false
        if(map.containsKey(val)){
            return false;
        }

        // if not, add val
        lastIdx++;
        map.put(val, lastIdx);
        arr[lastIdx] = val;

        return true;
    }

    // 요소가 있으면 true, 아니면 false
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        map.put(arr[lastIdx], map.get(val)); // 마지막 값의 인덱스를 새롭게 갱신한다.
        arr[map.get(val)] = arr[lastIdx]; // 실제로 위치도 갱신해준다.
        map.remove(val); // 그리고 기존 값은 map 에서 삭제해준다.
        lastIdx--;

        return true;
    }
    
    public int getRandom() {
        return arr[new Random().nextInt(lastIdx+1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */