import { useStore as o } from "vuex";
import { computed as a } from "vue";
import { watch as s } from "vue";
const n = (i) => {
  const t = o(), c = a(() => t.state.config.loaded.cappDict);
  if (c.value || t.dispatch("config/fetchCappDict"), i) {
    const p = s(c, (e) => {
      e && setTimeout(() => {
        i(), p();
      }, 0);
    }, { immediate: true });
  }
  return { cappDict: a(() => t.state.config.cappDict), cappDictMap: a(() => t.state.config.cappDictMap), fetchCappDict: async () => await t.dispatch("config/fetchCappDict"), loaded: c };
};
export {
  n as u
};
