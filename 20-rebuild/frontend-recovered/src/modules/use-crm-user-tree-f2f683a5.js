import { useStore as m } from "vuex";
import { computed as s } from "vue";
import { watch as c } from "vue";
const a = (r) => {
  const e = m(), t = s(() => e.state.crm.userLoaded);
  if (t.value || e.dispatch("crm/fetchUserTree"), r) {
    const o = c(t, (u) => {
      u && setTimeout(() => {
        r(), o();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: t, userTree: s(() => e.state.crm.userTreeList) };
};
export {
  a as u
};
