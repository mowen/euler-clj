(ns euler.test.euler-12
  (:use [euler.euler-12])
  (:use [clojure.test]))

(deftest test-compare-num-factors?
  (is (= -1 (compare-num-factors? 7 500))))
