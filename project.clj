(defproject learn-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  ;bağımlılıklar eklendi
  ;ring:HTTP sağlayan Jetty Adaptörü
  ;patika:Routing ve Restful için kütüphane
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.0"]
                 [patika "0.1.10"]
                 [amalloy/ring-gzip-middleware "0.1.4"]


                 ;      [prismatic/schema "1.1.9"]
                 ;[metosin/compojure-api "2.0.0-alpha26"]
                 ;[ring/ring-jetty-adapter "1.6.3"]

                 ; Database
                 ;[toucan "1.1.9"]
                 ;[org.postgresql/postgresql "42.2.4"]

                 ; Password Hashing
                 ;[buddy/buddy-hashers "1.3.0"]
                 ]
  :main ^:skip-aot learn-clojure.core
  :repl-options {:init-ns learn-clojure.core})
