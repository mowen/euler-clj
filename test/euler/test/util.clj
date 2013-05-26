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
  ;;(is (= {1 0, 2 1} (prime-factors-in-exponent-notation 2)))
  ;;(is (= {1 0, 2 0, 3 1} (prime-factors-in-exponent-notation 3)))
  (is (= {1 0, 2 2, 3 0} (prime-factors-in-exponent-notation 4)))
  (is (= {1 0, 2 1, 3 0, 5 1, 7 0} (prime-factors-in-exponent-notation 10)))
  (is (= {1 0, 2 2, 3 0, 5 0, 7 1, 11 0, 13 0, 17 0, 19 0, 23 0} (prime-factors-in-exponent-notation 28)))
  (is (let [actual (prime-factors-in-exponent-notation 72)]
        (and (= (actual 2) 3)
             (= (actual 3) 2)))))

(deftest test-number-of-divisors
  (is (= 6 (number-of-divisors 28)))
  (is (= 4 (number-of-divisors 14)))
  (is (= 6 (number-of-divisors 2452))))

(deftest test-binary-search
  (is (= nil (binary-search [] 5)))
  (is (= 2 (binary-search [1 3 5 7 10 15 18] #(compare % 5) 0 7)))
  (is (= 3 (binary-search [1 3 5 10 15 18] #(compare % 10))))
  (is (= 4 (binary-search [1 3 5 10 15 18] #(compare (* 2 %) 30)))))
