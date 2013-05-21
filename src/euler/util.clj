(ns euler.util)

(defn divisible? [x, divisor]
  (zero? (rem x divisor)))

(defn factors-seq [x rang]
  (for [i rang :when (divisible? x i)]
    i))

(defn factors [x]
  (cond
   (and (not (= x 2)) (even? x))
   (cons 2 (factors-seq x (range 3 (+ 1 (/ x 2)))))
   (and (not (= x 3)) (divisible? x 3))
   (cons 3 (factors-seq x (range 4 (+ 2 (Math/sqrt x)))))
   :else (factors-seq x (range 3 (+ 1 (Math/sqrt x))))))

(defn inclusive-factors [x]
  "All factors of the number including itself and 1."
  (for [i (range 1 (inc x)) :when (divisible? x i)]
    i))

(defn no-factors? [x]
  (not-any? #(zero? (rem x %))
            (factors x)))

(defn prime? [x]
  (cond
   (or (= x 2) (= x 3))
   true
   (or (< x 2) (even? x))
   false
   :else (no-factors? x)))

(defn prime-factors [x]
  (filter prime? (factors x)))

(defn prime-seq []
  (filter prime? (iterate inc 1)))

(defn nth-prime [n]
  (last (take n (prime-seq))))

(defn primes-below [n]
  (take-while #(< % n) (prime-seq)))

(defn divisors
  "Return a sequence of the prime factors (divisors) of a number."
  ([n] (divisors n (prime-factors n) []))
  ([n prime-factors divisors]
     (let [next-prime (first prime-factors)]
       (cond
        (= 1 next-prime) (recur n (rest prime-factors) divisors)
        (zero? (mod n next-prime)) (recur (/ n next-prime) prime-factors (conj divisors next-prime))
        (not (zero? (mod n next-prime))) (recur (/ n next-prime) (rest prime-factors) divisors)
        (> next-prime n) divisors))))

(defn nth-triangle-number [n]
  (reduce + (range 1 (inc n))))

(defn exp [x n]
  (loop [total 1
         counter n]
    (if (= counter 0)
      total
      (recur (* x total) (dec counter)))))

(defn square [n]
  (exp n 2))

(defn product [seq]
  (reduce * seq))

(defn sum [seq]
  (reduce + seq))

(defn binary-search
  "Use a binary search to find the first instance that satisfies f in seq."
  ([seq f] (binary-search seq f 0 (count seq)))
  ([seq f min] (binary-search seq f min (count seq)))
  ([seq f min max]
     (cond
      (or (< max min) (empty? seq)) nil
      :else (let [midpoint (+ min (quot (- max min) 2))
                  result (f (nth seq midpoint))]
              (cond
               (> result 0) (recur seq f min (dec midpoint))
               (< result 0) (recur seq f (inc midpoint) max)
               :else midpoint)))))
