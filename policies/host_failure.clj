(where* (is-service-name-contained {%for s in service%} "{{s}}" {%endfor%})
  #(info "got event in host failure 1: " %)
  (let [downstream (autohealing/downstream* index check-restraints-and-process)]
    (where* expired?
             #(info "got event in host failure 2: " %)
            (fn [event]
              ((with {:diagnose "{{constants.HEART_BEAT_FAILURE}}"
                      :state EVENT-TRIGGERING-STATE}
                     downstream)
               event)))))
