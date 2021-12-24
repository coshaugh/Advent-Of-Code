(ns core
  ;; (:gen-class)
  (:require
   [util :as util]
   [day1]))

(defn displayResults [runFcn]
  (println (runFcn)))

(defn -main [& args]
  "I run the show, and print the results"
  (let [day (util/parse-int (first args))
        part (util/parse-int (second args))]
    (case day
      1 (displayResults (day1/run part)))))