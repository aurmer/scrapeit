(ns scrapeit.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [reitit.ring :as ring]))

(def app
  (ring/ring-handler
    (ring/router
      [["/" {:get (fn [req]
                    {:status 200
                     :body "Hello World!"})}]])))

(defn -main [& args]
  (println "Started!")
  (jetty/run-jetty app {:join? false :port 3000}))

;R5YZRfABbWY
