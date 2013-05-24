(ns euler.euler-12
  (:use euler.util))

(defn factors-for-nth-triangle-number [n]
  (number-of-divisors (nth-triangle-number n)))

(defn triangle-num-factors [start end]
  (map #(vector % (factors-for-nth-triangle-number %)) (range start (inc end))))

(defn compare-num-factors? [n]
  "Is the nth triangle number the first one with 500 factors?"
  (let [factors-for-n (factors-for-nth-triangle-number n)
        factors-for-n-minus-1 (factors-for-nth-triangle-number (dec n))]
    (cond
     (and (> factors-for-n 500) (<= factors-for-n-minus-1 500)) 0
     (> factors-for-n 500) 1
     :else -1)))

(defn euler-12 [start end]
  (for [n (range start (inc end))]
    (let [num-of-factors (factors-for-nth-triangle-number n)]
      (if (> num-of-factors 500)
        (nth-triangle-number n)))))
