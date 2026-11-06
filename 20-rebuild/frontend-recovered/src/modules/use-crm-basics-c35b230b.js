import { useStore as c } from "vuex";
import { computed as o } from "vue";
import { watch as r } from "vue";
const f = (i) => {
  const s = c(), t = o(() => s.state.crm.basicsLoaded);
  if (t.value || s.dispatch("crm/fetchBasicsConfig"), i) {
    const e = r(t, (a) => {
      a && setTimeout(() => {
        i(), e();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: t, basicsConfigMap: o(() => s.state.crm.basicsConfigMap) };
};
export {
  f as u
};
