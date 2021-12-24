(ns fileIO)

; reads input from file path
(defn read-input [path]
    (slurp path))
  
(defn split-by-newline [data]
    (clojure.string/split-lines data))

(defn read-and-split-by-newline [path]
    (split-by-newline (read-input path)))