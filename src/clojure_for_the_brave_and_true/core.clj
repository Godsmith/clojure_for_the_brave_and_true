(ns clojure-for-the-brave-and-true.core
  (:gen-class)
  (:require
    [clojure-for-the-brave-and-true.chapter4 :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(println (validate {:key1 "val1" :key2 "val2"} {:key1 "val3" :key2 "val4"}))
  (println (to-csv '({:name "value" :glitter-index 0},
                      {:name "name2" :glitter-index 3})))
  )

