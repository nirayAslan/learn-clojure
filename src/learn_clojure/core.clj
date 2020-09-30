(ns learn-clojure.core
  (:require [patika.core :refer [resource get-routes]]
            [ring.adapter.jetty :refer [run-jetty]]
            ;; Middlewares
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.cookies :refer [wrap-cookies]]
            [ring.middleware.gzip :refer [wrap-gzip]]
            [compojure.core :as c]
            [compojure.route :as r]))

;GET HTTP metoduna ve “/” path’ine sahip, geriye HTML döndüren bir servis
(resource home
          :get ["/"]
          :content-type :html
          :handle-ok (fn [ctx] "<html>
                                <body>
                                Merhaba Clojure!
                                <ul>
                                <li><a href=\"/users\">Users</a></li>
                                <li><a href=\"/print-request\">Pretty Print Request</a></li>
                                </ul>
                                </body>
                                </html>"))

;GET HTTP metoduna ve “/users” path’ine sahip, geriye kullanıcıları JSON formatında döndüren bir servis
(resource users
          :get ["/users"]
          :content-type :json
          :handle-ok (fn [ctx] [{:name "Niray" :age 24}
                                {:name "Aslan" :age 22}]))

;GET HTTP metoduna ve “/print-request” path’ine sahip, geriye Request (Hash-Map veri türünde) bilgisini PLAIN/TEXT formatında döndüren bir servis
(resource print-request
          :get ["/print-request"]
          :content-type :text
          :handle-ok (fn [ctx] (with-out-str (clojure.pprint/pprint ctx))))

(c/defroutes not-found (r/not-found "404!"))

;tüm routeların olduğu değişken
(def handler (get-routes {:resource-ns-path "learn-clojure."
                          :not-found-route  'learn-clojure.core/not-found}))

(defn -main
  [& args]
  (run-jetty handler {:port 3000}))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
