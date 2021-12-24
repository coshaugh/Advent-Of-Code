(ns util)

(defn parse-int [i]
  (if (integer? i) i (. Integer parseInt i)))

(defn parse-int-seq [seq]
  (map parse-int seq))