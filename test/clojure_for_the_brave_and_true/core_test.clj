(ns clojure-for-the-brave-and-true.core-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.core :refer :all]
            [clojure-for-the-brave-and-true.chapter3 :refer :all]))

(deftest my-str-test
  (testing "testing string function"
    (is (= (my-str "a" "b") "ab"))))

(deftest misc-test
  (testing "testing string function"
    (is (= (misc) #{1 2 3}))))

(deftest hash-map-experiment-test
  (testing "testing hash-map-experiment"
    (is (= (hash-map-experiment) "value1"))))

(deftest add100-test
  (testing "add100"
    (is (= (add100 32) 132))))

(deftest dec-maker-test (testing "dec-maker-test"
                          (def dec9 (dec-maker 9))
                          (is (= (dec9 10) 1))
                          )
                        )
(deftest mapset-test
  (testing "mapset-test"
    (is (= (mapset inc [1 1 2 2]) #{2 3}))))
