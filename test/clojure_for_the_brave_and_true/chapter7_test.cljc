(ns clojure-for-the-brave-and-true.chapter7-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter7 :refer :all]))

(deftest infix-test
  (testing "+ only"
    (is (= (infix (1 + 2)) 3)))
  (testing "mix"
    (is (= (infix (1 + 2 * 3 + 4)) 11))))

(deftest apply-infix-operators-test
  (testing "two terms"
    (is (= (apply-infix-operators '(1 + 2)) 3)))
  (testing "three terms"
    (is (= (apply-infix-operators '(1 + 2 + 3)) 6))))

(deftest combine-multiply-divide-test
  (testing "empty"
    (is (= ( combine-multiply-divide []) [])))
  (testing "1 + 1"
    (is (= ( combine-multiply-divide '(1 + 1)) '(1 + 1))))
  (testing "2 * 3"
    (is (= ( combine-multiply-divide '(2 * 3)) '(6))))
  (testing "2 * 3 * 4"
    (is (= ( combine-multiply-divide '(2 * 3 * 4)) '(24))))
  (testing "2 + 3 * 4"
    (is (= ( combine-multiply-divide '(2 + 3 * 4)) '(2 + 12))))
  (testing "2 + 3 * 4"
    (is (= ( combine-multiply-divide '(2 * 3 + 4)) '(6 + 4))))
  (testing "2 + 3 * 4 + 2"
    (is (= ( combine-multiply-divide '(2 + 3 * 4 + 2)) '(2 + 12 + 2))))
  (testing "3 / 3 * 4"
    (is (= ( combine-multiply-divide '(3 / 3 * 4)) '(4)))))

