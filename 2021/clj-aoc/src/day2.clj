(ns day2
  (:require
   [util :as util]
   [fileIO :as fIO]))

(def seed {"forward" 0 "depth" 0 "aim" 0})

(defn handle-horizontal [accum magnitude]
  (let [forward (accum "forward")
        forward' (+ forward magnitude)
        depth (accum "depth")
        aim-adjustment (* magnitude (accum "aim"))
        depth' (+ depth aim-adjustment)]
    (assoc accum "forward" forward' "depth" depth')))

(defn apply-magnitude [accum [direction magnitude]]
  (let [mag (util/parse-int magnitude)]
    (case direction
      "forward" (handle-horizontal accum mag)
      "up" (update accum "aim" - mag)
      "down" (update accum "aim" + mag))))

(defn to-result [a b]
  (* a b))

;; PART - 1
;; depth gets aliased to aim in light of the solution for part 2
(defn part-1 [data]
  (let [{forward "forward"
         aim "aim"} (reduce apply-magnitude seed data)]
    (to-result forward aim)))

;; PART - 2
;; 
(defn part-2 [data]
  (let [{forward "forward"
         depth "depth"} (reduce apply-magnitude seed data)]
    (to-result forward depth)))

(defn run [input-file-path part]
  (let [input (fIO/read-and-split-by-newline input-file-path)
        data (map util/split-string-by-space input)]
    (case part
      1 (part-1 data)
      2 (part-2 data))))