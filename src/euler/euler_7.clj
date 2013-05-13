(ns euler.core
  (:require euler.util))

(defn e7 []
  "Find the 10001st prime number."
  (nth (prime-seq) 10000))
