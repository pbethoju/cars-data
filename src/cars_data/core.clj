(ns cars-data.core
  (:require [cars-data.data :as cdata]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main [& args]
  (cdata/setup-db db-url))

                                                                           ,