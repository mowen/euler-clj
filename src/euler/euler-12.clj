(ns euler.core
  (:use euler.util))

(defn euler-12 []
  (loop [n 1]
    (let [triangle-number (nth-triangle-number n)
          factors (inclusive-factors triangle-number)]
      (if (> (count factors) 500)
        triangle-number
        (recur (inc n))))))