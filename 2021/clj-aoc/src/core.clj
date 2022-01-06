(ns core
  ;; (:gen-class)
  (:require
   [util :as util]
   [day1]
   [day2]
   [day3]))

(defn displayResults [rslt]
  (println rslt))

(defn -main [& args]
  "I run the show, and print the results"
  (let [day (util/parse-int (first args))
        part (util/parse-int (second args))]
    (case day
      1 (displayResults (day1/run "../inputs/01.txt" part))
      2 (displayResults (day2/run "../inputs/02.txt" part))
      3 (displayResults (day3/run "../inputs/03.txt" part)))))