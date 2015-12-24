(set-env!
 :resource-paths "sounds")

(def +version+ "1.0.0")

(task-options!
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
