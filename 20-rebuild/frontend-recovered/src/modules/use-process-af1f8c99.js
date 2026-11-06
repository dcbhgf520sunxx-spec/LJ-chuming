import { useStore as i } from "vuex";
import { computed as t } from "vue";
import { watch as a } from "vue";
const n = (o) => {
  const s = i(), e = t(() => s.state.config.loaded.process);
  if (e.value || s.dispatch("config/fetchProcess"), o) {
    const c = a(e, (r) => {
      r && setTimeout(() => {
        o(), c();
      }, 0);
    }, { immediate: true });
  }
  return { process: t(() => s.state.config.process), loaded: e };
};
export {
  n as u
};
