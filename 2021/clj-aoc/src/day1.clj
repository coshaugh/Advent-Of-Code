(ns day1
  (:require
   [util :as util]
   [fileIO :as fIO]))

;; inserts specified number of nil's at front of a sequence
(defn get-nil-padded-seq [data offset]
  (apply conj data (repeat offset nil)))

;; creates a list of windows of specified size(offset) for a given sequence
(defn generate-windows [data offset]
  (->> (range offset)
       (reverse)
       (map (partial get-nil-padded-seq data))
       (apply map vector)))

;; return true if all elements not nil, otherwise false.
;; todo: not sure if theres a better way to do this..?
(defn all-not-nil [data]
  (every? some? data))

;; PART - 1
;; How many measurements are larger than the previous measurement?
(defn part-1 [data]
  (->> (generate-windows data 2)
       (filter all-not-nil)
       (filter #(< (first %1) (second %1)))
       (count)))

;; PART - 2
;; Count the number of times the sum of measurements in this sliding window(size 3) increases from the previous sum.
(defn part-2 [data]
  (->> (generate-windows data 3)
       (filter all-not-nil)
       (map (partial reduce +))
       (part-1)))

(defn run [input-file-path part]
  (let [input (fIO/read-and-split-by-newline input-file-path)
        data (map util/parse-int input)]
    (case part
      1 (part-1 data)
      2 (part-2 data))))