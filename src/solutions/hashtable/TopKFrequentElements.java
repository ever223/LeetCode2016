package solutions.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-03 22:38.
 * @DESCRIPTION:
 */
public class TopKFrequentElements {
    class Element {
        private int value;
        private int count;
        public Element(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> topK = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(Integer i : nums) {
            Integer cnt = count.get(i);
            if (cnt == null) {
                count.put(i, 1);
            } else {
                count.replace(i, cnt + 1);
            }
        }
        int len = count.keySet().size();
        Element[] elements = new Element[len + 1];
        int i = 1;
        for(Integer value : count.keySet()) {
            elements[i ++] = new Element(value, count.get(value));
        }

        heap(elements);

        for(i = 0; i < k; i ++) {
            topK.add(elements[len - i].value);
        }

        return topK;
    }
    private void heap(Element[] elements) {
        int heapSize = elements.length - 1;
        build(elements, heapSize);
        for (int i = elements.length - 1; i > 1; i--) {
            swap(elements, 1, i);
            heapSize --;
            adjust(elements, 1, heapSize);
        }

    }
    private void swap(Element[] elements, int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
    private void build(Element[] elements, int len) {
        for(int i = len / 2; i > 0; i --) {
            adjust(elements, i, len);
        }
    }
    public void adjust(Element[] elements, int index, int len) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int largest = index;
        if (left <= len && elements[left].count > elements[largest].count) {
            largest = left;
        }
        if (right <= len && elements[right].count > elements[largest].count) {
            largest = right;
        }
        if (largest != index) {
            swap(elements, largest, index);
            adjust(elements, largest, len);
        }
    }
}
