(defproject lein-kuromadoushi "0.1.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"}
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo/"
                                      :username [:gpg :env]
                                      :password [:gpg :env]}]
                        ["releases" {:url "https://clojars.org/repo/"
                                     :creds :gpg}]]
  :dependencies [[kuromadoushi "0.1.2"]]
  :eval-in-leiningen true)
