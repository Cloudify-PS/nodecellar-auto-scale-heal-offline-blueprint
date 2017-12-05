(where* (is-service-name-contained {%for s in service%} "{{s}}" {%endfor%})
  (let [downstream (autohealing/downstream* index check-restraints-and-process)]
    (where* expired?
            (fn [event]
              ((with {:diagnose "{{constants.HEART_BEAT_FAILURE}}"
                      :state EVENT-TRIGGERING-STATE}
                     downstream)
               event)))))
