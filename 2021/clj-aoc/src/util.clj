(ns util)
(require '[clojure.string :as str])

(defn parse-int [i]
  (if (integer? i) i (. Integer parseInt i)))

(defn split-string-by-space [input]
  (str/split input #" "))

(defn split-string-by-char [input]
  (str/split input #""))

(defn binary-seq-to-decimal [x]
  (Long/parseLong (str/join x) 2))

(defn map-to-columns [fcn data]
    (apply map (partial package-args-into-list fcn) data))

(defn package-args-into-list [f & args]
  (f args))

(defn get-nth-column [data idx]
  (map #(nth %1 idx nil) data))