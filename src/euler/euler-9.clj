(ns euler.core
  (:use euler.util))

(defn is-pythagoran-triplet? [[a b c]]
  (= (+ (square a) (square b)) (square c)))

(defn possible-solutions [c]
  "Possible solutions for the given value of c."
  (loop [b (- 1000 c 1)
         solutions []]
    (let [a (- 1000 b c)]
      (if (< a b)
        (recur (dec b) (conj solutions [a b c]))
        solutions))))

(defn euler-9 []
  (let [all-possible-solutions (mapcat possible-solutions (range 335 998))
        solution (first (filter is-pythagoran-triplet? all-possible-solutions))]
    (product solution)))
  