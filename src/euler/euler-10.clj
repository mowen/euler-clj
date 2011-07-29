(ns euler.core
  (:use euler.util))

(defn euler-10 []
  "Find the sum of all the primes below two million."
  (sum (primes-below 2000000)))