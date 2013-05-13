(ns euler.core)

(defn evenly-divisible? 
  "Is N evenly-divisible by all of the numbers in SEQ?"
  [n seq]
  (loop [s seq]
    (cond 
     (empty? s) true
     (not (zero? (mod n (first s)))) false)
    (recur (rest s))))

(defn euler-5
  "What is the smallest number that is evenly divisible by all of the numbers
  from 1 to 20?"
  [limit]
  (let [nums (range 1 (+ 1 limit))]
    (loop [n 20]
      (if (evenly-divisible? n nums)
	n
	(recur (inc n))))))