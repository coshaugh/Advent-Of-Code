(ns core-test
  (:require [clojure.test :refer :all]
            [core :refer :all]
            [day1 :refer :all]))

(deftest pair-elements-test
  (testing "pair-elements: w/ window size 1"
    (let [input '(1 2 3)
          expected '((nil 1) (1 2) (2 3))
          actual (generate-windows input 2)]
      (is (=  actual expected)))))
