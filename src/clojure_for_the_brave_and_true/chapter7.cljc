(ns clojure-for-the-brave-and-true.chapter7)

;; 1. Use the list function, quoting and read-string to create a list that, 
;; when evaluated, prints your first name and your favorite sci-fi movie.
(def my-list-1 (read-string "(println \"Filip\" \"2001\")"))
(def my-list-2 '(println "Filip" "2001"))
(def my-list-3 (list println "Filip" "2001"))

;; 2. Create an infix function that takes a list like (1 + 3 * 4 - 5) and 
;; transforms it into the lists that Clojure needs in order to correctly 
;; evaluate the expression using operator precedence rules.
(def operators-precedence-2 ['+ '-])
(def operators-precedence-1 ['* '/])

(defmacro infix
  [list]
  (-> list
      combine-multiply-divide
      apply-infix-operators))

(defn apply-infix-operators 
  [list] 
  (loop [[first-term operator second-term & rest] list]
  (if 
    (nil? operator) 
      first-term
      (recur (conj rest ((eval operator) first-term second-term))))))


(defn combine-multiply-divide
  [list]
  (loop [skipped []
         [first-term operator second-term & rest :as all] list]
    (if ( nil? operator)
      (concat skipped all)
      (if (.contains operators-precedence-1 operator)
        (recur skipped (conj rest ((eval operator) first-term second-term)))
        ;; Step forward in the list
        (recur (conj skipped first-term operator) (conj rest second-term))))))
