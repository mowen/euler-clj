(ns euler.test.util
  (:use [euler.util])
  (:use [clojure.test]))

(deftest test-inclusive-factors
  (is (= [1 3] (inclusive-factors 3)))
  (is (= [1 2 3 6] (inclusive-factors 6)))
  (is (= [1 2 5 10] (inclusive-factors 10)))
  (is (= [1 3 5 15] (inclusive-factors 15)))
  (is (= [1 3 7 21] (inclusive-factors 21)))
  (is (= [1 2 4 7 14 28] (inclusive-factors 28))))

(deftest test-nth-triangle-number
  (is (= 6 (nth-triangle-number 3)))
  (is (= 28 (nth-triangle-number 7))))

(deftest test-exp-primes
  (is (= {2 1} (exp-primes 2)))
  (is (= {3 1} (exp-primes 3)))
  (is (= {2 2} (exp-primes 4)))
  (is (= {2 1 5 1} (exp-primes 10)))
  (is (= {2 2 7 1} (exp-primes 28)))
  (is (= {2 3 3 2} (exp-primes 72))))

(deftest test-binary-search
  (is (= nil (binary-search [] 5)))
  (is (= 2 (binary-search [1 3 5 7 10 15 18] #(compare % 5) 0 7)))
  (is (= 3 (binary-search [1 3 5 10 15 18] #(compare % 10))))
  (is (= 4 (binary-search [1 3 5 10 15 18] #(compare (* 2 %) 30)))))
