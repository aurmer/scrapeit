(ns scrapeit.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [reitit.ring :as ring]))

(def app
  (ring/ring-handler
    (ring/router
      [["/" {:get (fn [req]
                    {:status 200
                     :body "Hello World!"})}]])
    (ring/routes
      (ring/redirect-trailing-slash-handler)
      (ring/create-default-handler
        {:not-found (constantly {:status 404 :body "not found"})}))))

(defn -main [& args]
  (println "Started!")
  (jetty/run-jetty app {:join? false :port 3000}))

;R5YZRfABbWY
