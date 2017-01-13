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
; (mapset inc [1 1 2 2]) ; => #{2 3}
(defn mapset [f s]
  (apply hash-set (map f s)))

; 5. Create a function that’s similar to symmetrize-body-parts except that it has to
; work with weird space aliens with radial symmetry. Instead of two eyes, arms, legs,
; and so on, they have five.


; 6. Create a function that generalizes symmetrize-body-parts and the function you
; created in Exercise 5. The new function should take a collection of body parts and
; the number of matching body parts to add. If you’re completely new to Lisp languages
; and functional programming, it probably won’t be obvious later.
