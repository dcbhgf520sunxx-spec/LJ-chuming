import { useStore as c } from "vuex";
import { computed as t } from "vue";
import { watch as a } from "vue";
const f = (o) => {
  const e = c(), s = t(() => e.state.config.loaded.bridgeProcess);
  if (s.value || e.dispatch("config/fetchBridgeProcess"), o) {
    const r = a(s, (i) => {
      i && setTimeout(() => {
        o(), r();
      }, 0);
    }, { immediate: true });
  }
  return { process: t(() => e.state.config.bridgeProcess), loaded: s };
};
export {
  f as u
};
