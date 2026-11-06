import { aS as I } from "../shared/runtime.js";
import { ref as T } from "vue";
function N({ CRUD: c, crud: i, editEnabled: l }, { enabledField: n = "enabled", enumObj: o = I, refresh: g = true, t: a = "TRUE", f: h = "FALSE" } = {}) {
  const f = T(false);
  return { enabledLoading: f, handleEnabledChange: async (r, s = "name") => {
    try {
      f.value = true, r.enabledLoading = true;
      const e = { id: r.id };
      e[n] = r[n], await l(e);
      let E = "";
      s && (Array.isArray(s) ? E = s.map((C) => r[C]).join(" / ") : E = `“${r[s]}”`), i.notify(E + o.VL[r[n]], r[n] === o[a].V ? c.NOTIFICATION_TYPE.SUCCESS : c.NOTIFICATION_TYPE.WARNING), g && i.refresh();
    } catch (e) {
      console.log("使用状态", e), r[n] = r[n] === o[a].V ? o[h].V : o[a].V;
    } finally {
      f.value = false, r.enabledLoading = false;
    }
  } };
}
export {
  N as u
};
