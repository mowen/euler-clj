(ns euler.core
  (:use euler.util))

(defn fibonacci []
  (let [fib-step (fn [[a b]] [b (+ a b)])]
    (map first (iterate fib-step [1 2]))))

(defn euler-2 []
  (let [limit 4000000]
    (sum (filter even? (take-while #(< % limit) (fibonacci))))))