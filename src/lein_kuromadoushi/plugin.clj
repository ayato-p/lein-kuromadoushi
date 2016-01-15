(ns lein-kuromadoushi.plugin
  (:require [clojure.java.io :as io]
            [kuromadoushi.core :as kc]))

(defn add-repl-welcome [project & forms]
  (update-in project [:repl-options :welcome]
             (fn [cur]
               (if cur
                 `(do ~cur ~@forms)
                 `(do ~@forms)))))

(defn render []
  (kc/render (io/resource "kuromadoushi.dat")))

(defn middleware [project]
  (-> project
      (update-in [:dependencies] concat [['lein-kuromadoushi "0.1.0-SNAPSHOT"]])
      (add-repl-welcome `(do
                           (require 'lein-kuromadoushi.plugin)
                           ((ns-resolve 'lein-kuromadoushi.plugin 'render))))))
