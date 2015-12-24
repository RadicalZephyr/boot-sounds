(set-env!
 :resource-paths #{"sounds"})

(require '[boot.core :refer [*warnings* with-pre-wrap]]
         '[boot.git :refer [last-commit]])

(def +version+ "1.0.0")

(task-options!
 speak {:theme "radz_sounds"}
 push {:repo           "deploy"
       :ensure-branch  "master"
       :ensure-clean   true
       :ensure-tag     (last-commit)
       :ensure-version +version+}
 pom {:project 'radicalzephyr/boot-sounds
      :version +version+
      :description "RadicalZephyr's sounds for use by `boot speak'"
      :url "https://github.com/radicalzephyr/boot-sounds"
      :scm {:url "https://github.com/radicalzephyr/boot-sounds"}
      :license {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask do-warn []
  (with-pre-wrap fileset
    (warn "Warning!\n")
    (swap! *warnings* inc)
    fileset))

(deftask do-fail []
  (with-pre-wrap fileset
    (fail "Failed build\n")))
