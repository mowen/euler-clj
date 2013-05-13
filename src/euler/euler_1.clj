(ns euler.core
  (:use euler.util))

(defn euler-1 [limit]
  (sum (filter #(or (zero? (mod % 3))
                    (zero? (mod % 5)))
               (take (- limit 1) (iterate inc 1)))))
