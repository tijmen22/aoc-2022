(ns aoc.day-4
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn- int-in-range? [[start end] val]
  (and (int? val) (<= start val) (<= val end)))

(defn- overlap? [[e-1 e-2]]
  (some true?
        (concat
         (map #(int-in-range? e-2 %) e-1)
         (map #(int-in-range? e-1 %) e-2))))

(comment
  (with-open [rdr (io/reader "resources/day_4/input.csv")]
    (->>
     (reduce conj [] (line-seq rdr))
     (mapcat #(str/split % #","))
     (mapcat #(str/split % #"-"))
     (map #(Integer/parseInt %))
     (partition 2)
     (partition 2)
     (filter overlap?)
     (count)))

  )
