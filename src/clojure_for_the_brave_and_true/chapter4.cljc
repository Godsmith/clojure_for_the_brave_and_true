(ns clojure-for-the-brave-and-true.chapter4)

(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\r\n")))

(defn mapify
  "Return a seq of maps like {:name 'Edward Cullen' :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
         {}
         (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn vampires [] (glitter-filter 3 (mapify (parse (slurp filename)))))


;1. Turn the result of your glitter filter into a list of names.
(defn vampire-names [] (map :name (vampires)))

;2. Write a function, append , which will append a new suspect to
; your list of suspects.
(defn append
  [name glitter-index]
  (conj (vampires) {:name name :glitter-index glitter-index} ))
;3. Write a function, validate , which will check that :name and
; :glitter-index are present when you append . The validate
; function should accept two arguments: a map of keywords to
; validating functions, similar to conversions , and the record
; to be validated.
(defn validate
  [map_with_keys record]
  (every? #(not (nil? %)) (map #(get record %) (keys map_with_keys))))
;Write a function that will take your list of maps and convert
; it back to a CSV string. You’ll need to use the
; clojure.string/join function.
(defn to-csv [hashmap]
  (clojure.string/join "\r\n" (map #(clojure.string/join "," %) (map vals hashmap))))