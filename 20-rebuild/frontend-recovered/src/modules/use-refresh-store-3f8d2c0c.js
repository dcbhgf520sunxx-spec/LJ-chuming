import { i as c, j as a } from "../shared/runtime.js";
function t(i = [], e = false) {
  c(i) && (typeof i == "string" && (i = [i]), i.forEach((s) => {
    switch (s) {
      case "classification":
        e && a.commit("SET_LOADED", { key: "matClsTree", loaded: false }), a.dispatch("config/fetchMatClsTree");
        break;
      case "classificationTree":
        e && a.commit("SET_LOADED", { key: "clsTree", loaded: false }), a.dispatch("config/fetchClassificationTree");
        break;
      case "wmsConfig":
        a.dispatch("wms/fetchWmsConfig");
        break;
    }
  }));
}
export {
  t as u
};
