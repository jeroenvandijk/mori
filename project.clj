(defproject mori "0.5.0-SNAPSHOT"
  :description "Persistent Data Structures for JavaScript"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.946" :classifier "aot"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :clean-targets ["dev" "release" "target"]
  
  :cljsbuild
  {:builds
    [;; mori
     {:source-paths ["src"],
      :id "dev",
      :compiler
      {:output-to      "dev/mori.dev.js",
       :output-dir     "dev/"
       :optimizations  :simple
       :cache-analysis true
       :output-wrapper false
       :pretty-print   true}}

     {:source-paths ["src"],
      :id "release"
      :compiler
      {:optimizations  :simple
       :output-dir     "release"
       :output-wrapper false
       :pretty-print   false
       :verbose        true
       :modules
       {:cljs-base {:entries #{cljs.core mori cljs.js}
                    :output-to "release/build/mori.base.js"}
        #_:mutable   #_{:entries #{mori.mutable}
                    :output-to "release/build/mori.mutable.js"}
        #_:extra     #_{:entries #{clojure.data cljs.reader clojure.set mori.extra}
                    :output-to "release/build/mori.extra.js"}}}}]})
