(ns aoc.day-1.main
  (:require [clojure.java.io :as io]))

(defn- safe-parse-int [str]
  (try (Integer/parseInt str)
       (catch Exception e nil)))

(defn most-calories [lines]
  (->>
   (map safe-parse-int lines)
   (partition-by nil?)
   (map #(remove nil? %))
   (filter seq)
   (map #(apply + %))
   (sort (comp - compare))))

(comment
  ;; Part 1
  (with-open [rdr (io/reader "resources/day_1/input.csv")]
    (->> (most-calories (reduce conj [] (line-seq rdr)))
         (first)))

  ;; Part 2
  (with-open [rdr (io/reader "resources/day_1/input.csv")]
    (->> (most-calories (reduce conj [] (line-seq rdr)))
         (take 3)
         (apply +))))
