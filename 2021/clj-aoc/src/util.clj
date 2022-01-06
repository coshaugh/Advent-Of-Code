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

;; still unsure if theres some other better way to achieve this
(defn map-to-columns [fcn data]
  (apply map (fn [& args] fcn args) data))

(defn get-nth-column [data idx]
  (map #(nth %1 idx nil) data))