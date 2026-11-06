import { useStore as u } from "vuex";
import { computed as o } from "vue";
import { watch as c } from "vue";
const f = (e) => {
  const s = u(), t = o(() => s.state.config.loaded.users);
  if (s.state.config.loaded.users || s.dispatch("config/fetchUsers"), e) {
    const r = c(t, (i) => {
      i && setTimeout(() => {
        e(), r();
      }, 0);
    }, { immediate: true });
  }
  return { users: o(() => s.state.config.users), loaded: t };
};
export {
  f as u
};
