import { useStore as n } from "vuex";
import { computed as o } from "vue";
import { watch as f } from "vue";
const u = (i) => {
  const t = n(), e = o(() => t.state.config.loaded.filterItemsEnum);
  if (e.value || t.dispatch("config/fetchFilterItemsEnumConfig"), i) {
    const s = f(e, (m) => {
      m && setTimeout(() => {
        i(), s();
      }, 0);
    }, { immediate: true });
  }
  return { filterItemsEnum: o(() => t.state.config.filterItemsEnum), loaded: e };
};
export {
  u
};
