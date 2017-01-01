package controllers;

import Models.Model;

/**
 * Created by QuanLA on 12/18/2016.
 */
public interface Body {
    Model getModel();
    void onContact(Body other);
}
