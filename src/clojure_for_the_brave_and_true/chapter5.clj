(ns clojure-for-the-brave-and-true.chapter5)

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
