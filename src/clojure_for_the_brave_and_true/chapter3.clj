(ns clojure-for-the-brave-and-true.chapter3)

;1. Use the str , vector , list , hash-map , and hash-set functions.
(defn my-str
  [& args]
  (apply str args)
  )
(defn misc
  [& args]
  (do
    (vector 1 2 3)                                          ; [1 2 3]
    (list 1 2 3)                                            ; '(1 2 3)
    (hash-map 1 2 3 4 5 6)                                  ; {1 2, 3 4, 5 6}
    (hash-set 1 2 3)
    )
  )
(defn hash-map-experiment
  []
  (def h {:key1 "value1" :key2 "value2"})
  (:key1 h))                                                ; equal to (get h :key1)

; 2. Write a function that takes a number and adds 100 to it.
(defn add100 [a] (+ a 100))

; 3. Write a function, dec-maker , that works exactly like the function inc-maker
; except with subtraction: (def dec9 (dec-maker 9)) (dec9 10) ; => 1
(defn dec-maker [dec-by]
  #(- % dec-by))

; 4. Write a function, mapset , that works like map except the return value is a set:
