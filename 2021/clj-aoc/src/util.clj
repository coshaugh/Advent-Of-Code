(ns util)

(defn parse-int [i]
  (if (integer? i) i (. Integer parseInt i)))
