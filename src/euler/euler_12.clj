(ns euler.euler-12
  (:use euler.util))

(defn compare-num-factors? [n target]
  "Is the nth triangle number the first one with 500 factors?"
  (let [nth (nth-triangle-number n)
        nth-minus-1 (nth-triangle-number (dec n))
        divisors-for-n (number-of-divisors nth)
        divisors-for-n-minus-1 (number-of-divisors nth-minus-1)]
    (prn nth " divisors: " divisors-for-n)
    (prn nth-minus-1 " divisors: " divisors-for-n-minus-1)
    (cond
     (and (> divisors-for-n target) (<= divisors-for-n-minus-1 target)) 0
     (> divisors-for-n target) 1
     :else -1)))

(defn euler-12 [start end]
  (for [n (range start (inc end))]
    (let [num-of-factors (factors-for-nth-triangle-number n)]
      (if (> num-of-factors 500)
        (nth-triangle-number n)))))
