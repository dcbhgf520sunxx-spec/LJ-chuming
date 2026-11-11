package com.ljaps.rebuild.auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class IfcMenuProbe {
    public static void main(String[] args) {
        Map<String,Object> parent = AuthService.map("id",1008L,"pid",0L,"name","BIM","type",3);
        Map<String,Object> original = AuthService.map("id",1009L,"pid",1008L,"name","模型展示",
            "component","/bim/model-show/index","component_name","ModelShow","path","/bim/model-show","type",1);
        List<Map<String,Object>> tree = AuthService.buildTree(Arrays.asList(parent, original));
        List<?> children = (List<?>)tree.get(0).get("children");
        if(children.size()!=2) throw new AssertionError("IFC sibling menu missing");
        Map<?,?> menu=(Map<?,?>)children.get(1);
        if(!"/bim/ifc-model-show/index".equals(menu.get("component"))) throw new AssertionError("IFC route mismatch");
        tree=AuthService.buildTree(Collections.singletonList(parent));
        if(tree.get(0).get("children")!=null) throw new AssertionError("IFC menu requires original menu grant");
        System.out.println("IFC sibling menu and inherited permission checks passed");
    }
}
