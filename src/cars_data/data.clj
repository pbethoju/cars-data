(ns cars-data.data
  (:require [datomic-schema.schema :as schema]
             [datomic-schema.part :as part]))

(defonce db-url "datomic:mem://testdb")

(defn dbparts []
  [(part "app")])

(defn dbschema []
  [(schema make
           (fields
             [id :string :indexed]
             [name :string :indexed]
             [model :ref :many]))

   (schema model
           (fields
             [name :string]
             [id :string :indexed]))])

(defn setup-db [url]
  (d/create-database url)
  (d/transact
    (d/connect url)
    (concat
      (s/generate-parts d/tempid (dbparts))
      (s/generate-schema d/tempid (dbschema)))))
