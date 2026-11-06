import { m, c0 as r, a3 as o } from "../shared/runtime.js";
import { ref as s } from "vue";
import { watch as l } from "vue";
import { nextTick as p } from "vue";
function E({ resetQuery: a }) {
  const { globalProject: n } = m("globalProject"), u = s([]), t = s(false);
  l(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.mode;
  }, () => {
    typeof a == "function" && a(), u.value = c(n.value.mode), t.value = true, p(() => {
      t.value = true;
    });
  }, { deep: true, immediate: true });
  function c(e) {
    switch (e) {
      case r.STRUCTURE.V:
        return [o.ASSEMBLE.V, o.MACHINE_PART.V];
      case r.STRUCTURE_ASSEMBLE.V:
        return [o.MACHINE_PART.V];
      default:
        return [];
    }
  }
  return { unshowVal: u, showComponent: t };
}
export {
  E as u
};
