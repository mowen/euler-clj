(ns euler.core
  (:require euler.util))

(defn euler-3 []
  "What is the largest prime factor of the number 600851475143?"
  (last (prime-factors 600851475143)))