;   This file is part of Wendy.
;
;   Wendy is free software: you can redistribute it and/or modify
;   it under the terms of the GNU General Public License as published by
;   the Free Software Foundation, either version 3 of the License, or
;   (at your option) any later version.
;
;   Wendy is distributed in the hope that it will be useful,
;   but WITHOUT ANY WARRANTY; without even the implied warranty of
;   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
;   GNU General Public License for more details.
;
;   You should have received a copy of the GNU General Public License
;   along with Wendy. If not, see <http://www.gnu.org/licenses/>.

(ns wendy.utils
  (:import java.net.URLEncoder))

(defn map-to-query-str
  [m]
  (->> m
       (filter #(some? (second %)))
       (map (fn [[param value]]
              (let [param-name    (name param)
                    value-encoded (str (URLEncoder/encode value))]
                (str param-name "=" value-encoded) )))
       (clojure.string/join "&")
       (#(if (not-empty %) (str "?" %) ""))))
