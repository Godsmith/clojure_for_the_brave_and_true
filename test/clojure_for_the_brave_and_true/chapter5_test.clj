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

(deftest update-in-test
  (testing "update-in"
    (is (= (update-in {:values {:a 1 :b 2 :c 3}} [:values :a] - 1
                      ) {:values {:a 0 :b 2 :c 3}}))))

(deftest my-update-in-test
  (testing "my-update-in"
    (is (= (my-update-in {:values {:a 1 :b 2 :c 3}} [:values :a] - 1
                      ) {:values {:a 0 :b 2 :c 3}}))))
