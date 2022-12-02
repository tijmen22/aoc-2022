(ns aoc.day-2.main
  (:require [clojure.java.io :as io]))

(def ^:private SHAPE-SCORES
  {\A 1 ;; Rock
   \B 2 ;; Paper
   \C 3 ;; Sciccors
   \X 1 ;; Rock
   \Y 2 ;; Paper
   \Z 3 ;; Sciccors
   })

(def ^:private GAME-SCORES
  {"A X" 3
   "A Y" 6
   "A Z" 0
   "B X" 0
   "B Y" 3
   "B Z" 6
   "C X" 6
   "C Y" 0
   "C Z" 3})

(defn- score [[_ _ last :as line]]
  (+ (get SHAPE-SCORES last)
     (get GAME-SCORES line)))

(defn- total-score [lines]
  (->> (map score lines)
       (apply +)))

(comment
  ;; Part 1
  (with-open [rdr (io/reader "resources/day_2/input.csv")]
    (->>
     (reduce conj [] (line-seq rdr))
     (total-score)))

  )
