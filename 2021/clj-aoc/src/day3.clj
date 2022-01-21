(ns day3
  (:require
   [util :as util]
   [fileIO :as fIO]))

;; turns string binary digit into frequency
;; 1 => +1
;; 0 => -1
(defn accumulate-frequency [accum x]
  (+ accum (if (= x "1") 1 -1)))

(defn collapse-column [column]
  (reduce accumulate-frequency 0 column))

(defn collapse-columns [columns]
  (map collapse-column columns))

(defn get-most-common [freq]
  (if (< freq 0) "0" "1"))

(defn get-least-common [freq]
  (if (< freq 0) "1" "0"))

(defn get-rating [target-fcn data idx]
  (let [nth-bits (util/get-nth-column data idx)
        freq (collapse-column nth-bits)
        target-bin (target-fcn freq)
        filtered-data (filter #(= target-bin (nth %1 idx)) data)]
    (if (or (every? nil? nth-bits) (empty? filtered-data))
      (first data)
      (get-rating target-fcn filtered-data (inc idx)))))

;; PART - 1
;; calculate power consumption by multiplying gamma and epsilon ratings
;; data is a list of list of strings
(defn part-1 [data]
  (let [column-data (util/transpose data)
        collapsed-by-column (collapse-columns column-data)
        gamma-bin (map get-most-common collapsed-by-column)
        epsilon-bin (map get-least-common collapsed-by-column)]
    (apply * (map util/binary-seq-to-decimal [gamma-bin epsilon-bin]))))

;; PART - 2
;; calculate life support rating by multiplying oxygen generator and co2 scrubber ratings
;; for a given list of numbers, find the frequency
(defn part-2 [data]
  (let [oxygen-gen-rating (get-rating get-most-common data 0)
        co2-scrub-rating (get-rating get-least-common data 0)]
    (apply * (map util/binary-seq-to-decimal [oxygen-gen-rating co2-scrub-rating]))))

(defn run [input-file-path part]
  (let [input (fIO/read-and-split-by-newline input-file-path)
        data (map util/split-string-by-char input)]
    (case part
      1 (part-1 data)
      2 (part-2 data))))