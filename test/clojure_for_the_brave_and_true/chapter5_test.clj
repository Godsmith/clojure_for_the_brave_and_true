(ns clojure-for-the-brave-and-true.chapter5-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter5 :refer :all]))


(deftest my-comp-test
  (testing "my-comp"
    (is (= ((my-comp inc) 1) 2) "single function")
    (is (= ((my-comp inc inc +) 1 2) 5) "multiple functions")))
