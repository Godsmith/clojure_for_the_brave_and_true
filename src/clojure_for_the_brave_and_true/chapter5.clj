(ns clojure-for-the-brave-and-true.chapter5)


; 1. You used (comp :intelligence :attributes) to create a function that returns a character’s intelligence.
; Create a new function, attr , that you can call like (attr :intelligence) and that does the same thing.
(defn attr
  [attribute]
  (fn [char] ((comp attribute :attributes) char)))
; 2. Implement the comp function.
(defn my-comp
  "Returns a function that takes a number of arguments, and then
  1. takes the last function and applies it to the arguments to get a result.
  2. takes that result (%1) and the next thing in the list (%2) and runs them
  through the function #(%2 %1), i.e. apply the next function in the list on
  the result and store THAT result.
  3. Take the next function in the list and do the same thing until there are
  no functions left in the list. Then, return the result."
  [& functions]
  (fn
    [& args]
    (reduce #(%2 %1) (apply (last functions) args) (rest (reverse functions))))
  )
; 3. Implement the assoc-in function. Hint: use the assoc function and define its parameters as [m [k & ks] v] .
(defn my-assoc-in
  ""
  ([m [k & ks] v]
   (if ks
     (let [new-value (my-assoc-in (get m k) ks v)]
       (assoc m k new-value))
     (assoc m k v)))
  )
; 4. Look up and use the update-in function.
; 5. Implement update-in .
