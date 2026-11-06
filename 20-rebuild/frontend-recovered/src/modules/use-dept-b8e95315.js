import { useStore as a } from "vuex";
import { computed as s } from "vue";
import { watch as f } from "vue";
const p = (o) => {
  const t = a(), e = s(() => t.state.config.loaded.dept);
  if (e.value || t.dispatch("config/fetchDept"), o) {
    const i = f(e, (c) => {
      c && setTimeout(() => {
        o(), i();
      }, 0);
    }, { immediate: true });
  }
  return { dept: s(() => t.state.config.dept), loaded: e };
};
export {
  p as u
};
