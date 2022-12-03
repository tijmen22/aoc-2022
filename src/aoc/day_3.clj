(ns aoc.day-3
  (:require [clojure.java.io :as io]
            [clojure.set :as set]))

(def ^:private ITEMS
  (->>
   (into [] "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
   (map-indexed (fn [i x] [x (inc i)]))
   (into {})))

;; ITEMS =>
;; {/a 1
;;  /b 2
;;  /c 3...}

(defn- items [lines]
  (->>
   (map #(into [] %) lines)
   (map #(split-at (/ (count %) 2) %))))

(defn- common-items [compartments]
  (->>
   (map set compartments)
   (apply set/intersection)))

(comment
  (with-open [rdr (io/reader "resources/day_3/input.csv")]
    (->>
     (reduce conj [] (line-seq rdr))
     (items)
     (map common-items)
     (map first)
     (map #(get ITEMS %))
     (apply +)))

  )

