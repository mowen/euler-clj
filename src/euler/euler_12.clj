(ns euler.euler-12
  (:use euler.util))

(defn factors-for-nth-triangle-number [n]
  (count (inclusive-factors (nth-triangle-number n))))

(defn triangle-num-factors [start end]
  (map #(vector % (factors-for-nth-triangle-number %)) (range start (inc end))))

(defn euler-12 [start end]
  (for [n (range start (inc end))]
    (let [num-of-factors (factors-for-nth-triangle-number n)]
      (if (> num-of-factors 500)
        (nth-triangle-number n)))))
