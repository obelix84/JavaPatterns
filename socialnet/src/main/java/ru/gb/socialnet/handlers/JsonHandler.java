package ru.gb.socialnet.handlers;

import org.json.JSONArray;

public abstract class JsonHandler {
        protected JsonHandler next;

        public JsonHandler setNext(JsonHandler jh) {
            this.next = jh;
            return jh;
        }

        protected void handleNext(JSONArray ja) {
            if (next != null) {
                next.handle(ja);
            }
        }

        public abstract void handle(JSONArray ja);
}
