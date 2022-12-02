(ns aoc.day-2
  (:require [clojure.java.io :as io]))

(def ^:private SHAPE-SCORES
  {\A 1 ;; Rock
   \B 2 ;; Paper
   \C 3 ;; Sciccors
   })

(def ^:private GAME-SCORES
  {\X 0 ;; Lose
   \Y 3 ;; Draw
   \Z 6 ;; Win
   })

(def ^:private GAME-REACTIONS
  {"A X" \C
   "A Y" \A
   "A Z" \B
   "B X" \A
   "B Y" \B
   "B Z" \C
   "C X" \B
   "C Y" \C
   "C Z" \A})

(defn- score [[_ _ last :as line]]
  (+ (get GAME-SCORES last)
     (get SHAPE-SCORES (get GAME-REACTIONS line))))

(defn- total-score [lines]
  (->> (map score lines)
       (apply +)))

(comment
  (with-open [rdr (io/reader "resources/day_2/input.csv")]
    (->>
     (reduce conj [] (line-seq rdr))
     (total-score)))

  )
