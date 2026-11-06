import { useStore as n } from "vuex";
import { computed as e } from "vue";
import { watch as d } from "vue";
const u = (r, i = true) => {
  const t = n(), a = e(() => t.state.config.loaded.notPrintedMaterialNumber);
  if ((!a.value || i) && t.dispatch("wms/fetchNotPrintedMaterialNumber"), r) {
    const o = d(a, (s) => {
      s && setTimeout(() => {
        r(), o();
      }, 0);
    }, { immediate: true });
  }
  return { notPrintedMaterialNumber: e(() => t.state.wms.notPrintedMaterialNumber), loaded: e(() => t.state.wms.loaded.notPrintedMaterialNumber), refresh: () => {
    t.dispatch("wms/fetchNotPrintedMaterialNumber");
  } };
};
export {
  u
};
