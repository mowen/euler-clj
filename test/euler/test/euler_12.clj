(ns euler.test.euler-12
  (:use [euler.euler-12])
  (:use [clojure.test]))

(deftest test-factors-for-nth-triangle-number
  (is (= 1 (factors-for-nth-triangle-number 1)))
  (is (= 6 (factors-for-nth-triangle-number 7))))

(deftest test-compare-num-factors?
  (is (= -1 (compare-num-factors? 7))))
