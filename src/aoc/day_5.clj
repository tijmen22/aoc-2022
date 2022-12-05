(ns aoc.day-5
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def ^:private POSITIONS (range 1 34 4))

(def ^:private TEST-INSTRUCTIONS
  [[1 2 1]
   [3 1 3]
   [2 2 1]
   [1 1 2]])

(def ^:private TEST-CRATES
  [["N" "Z"]
   ["D" "C" "M"]
   ["P"]])

(defn- parse-crates [lines]
  (mapv (fn [pos] (remove str/blank? (map #(subs % pos (inc pos)) lines))) POSITIONS))

(defn- parse-instructions [lines]
  (->>
   (map #(re-find #"move (\d+) from (\d+) to (\d+)" %) lines)
   (mapcat rest)
   (map #(Integer/parseInt %))
   (partition 3)))

(defn- move [crates [qty from to]]
  (let [[moving remainder] (split-at qty (get crates (dec from)))]
    (->
     (assoc crates (dec from) remainder)
     (assoc (dec to) (concat moving (get crates (dec to)))))))

(comment
  (reduce move TEST-CRATES TEST-INSTRUCTIONS)

  (with-open [rdr (io/reader "resources/day_5/input.csv")]
    (let [lines (reduce conj [] (line-seq rdr))
          crates (parse-crates (take 8 lines))
          instructions (parse-instructions (drop 10 lines))]

      (->>
       (reduce move crates instructions)
       (map first)
       (str/join))))

  )

