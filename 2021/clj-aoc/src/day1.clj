(ns day1
  (:require
   [util :as util]
   [fileIO :as fIO]))

;; swap for http request maybe idk..?
(def input-file-path "../inputs/01.txt")

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

;; compare 2 element sequence. return true if second item larger.
;; todo: not sure if theres a cleaner way since just destructuring 2 items to compare..?
(defn bigger-than-previous? [[a b]]
  (< a b))

;; PART - 1
;; How many measurements are larger than the previous measurement?
(defn part-1 [data]
  (->> (generate-windows data 2)
       (filter all-not-nil)
       (filter bigger-than-previous?)
       (count)))

;; PART - 2
;; Count the number of times the sum of measurements in this sliding window(size 3) increases from the previous sum.
(defn part-2 [data]
  (->> (generate-windows data 3)
       (filter all-not-nil)
       (map (partial reduce +))
       (part-1)))

(defn run [part]
  (let [input (fIO/read-and-split-by-newline input-file-path)
        data (util/parse-int-seq input)]
    (case part
      1 (part-1 data)
      2 (part-2 data))))