(ns aoc.day-6)

(comment

  (let [stream (slurp  "resources/day_6/input.csv")]
    (loop [i 0]
      (if (= (count (set (subs stream i (+ i 14)))) 14)
        (+ i 14)
        (recur (inc i)))))


  )
