(ns aoc.day-4
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn- enclosed? [[e-1 e-2]]
  (or (and
       (<= (first e-2) (first e-1))
       (>= (second e-2) (second e-1)))
      (and
       (<= (first e-1) (first e-2))
       (>= (second e-1) (second e-2)))))

(comment
  (with-open [rdr (io/reader "resources/day_4/input.csv")]
    (->>
     (reduce conj [] (line-seq rdr))
     (mapcat #(str/split % #","))
     (mapcat #(str/split % #"-"))
     (map #(Integer/parseInt %))
     (partition 2)
     (partition 2)
     (filter enclosed?)
     (count))))
