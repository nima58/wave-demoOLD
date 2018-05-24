package com.example.wavedemo.controller;

import java.util.List;
import java.util.Map;

public interface ControllerApi<ControllerType> {
    public List<ControllerType> list();
    public ControllerType show(int id);
    public void delete(int id);
    public void create(ControllerType controllerType);
    public void update(ControllerType controllerType);
    public void patch(Map<Object, Object> attrs);
}
