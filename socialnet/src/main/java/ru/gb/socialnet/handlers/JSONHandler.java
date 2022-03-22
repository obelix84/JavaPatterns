package ru.gb.socialnet.handlers;

import org.json.JSONArray;

public abstract class JSONHandler {
        protected JSONHandler next;

        public JSONHandler setNext(JSONHandler jh) {
            this.next = jh;
            return jh;
        }

        protected void handleNext(JSONArray ja) {
            if (next != null) {
                next.handle(ja);
            }
        }

        abstract void handle(JSONArray ja);
}
