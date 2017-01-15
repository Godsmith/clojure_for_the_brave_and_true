(ns clojure-for-the-brave-and-true.chapter5-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter5 :refer :all]))


(deftest my-comp-test
  (testing "my-comp"
    (is (= ((my-comp inc) 1) 2) "single function")
    (is (= ((my-comp inc inc +) 1 2) 5) "multiple functions")))

(deftest attr-test
  (testing "attr"
    (is (= ((attr :intelligence) {:attributes {:intelligence 10}}) 10))))

(deftest my-assoc-in-test
  (testing "my-assoc-in"
    (is (= (my-assoc-in {} [:a :b :c] "friend") {:a {:b {:c "friend"}}}))))
