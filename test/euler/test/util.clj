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
