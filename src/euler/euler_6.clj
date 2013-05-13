(ns euler.core
  (:use euler.util))

(defn e6
  [limit]
  "Find the difference between the sum of the squares of the first one hundred
  natural numbers and the square of the sum."
  (let [nums (range 1 (inc limit))
	sum-of-squares (sum (map square nums))
	square-of-sum (square (sum nums))]
    (- square-of-sum sum-of-squares)))