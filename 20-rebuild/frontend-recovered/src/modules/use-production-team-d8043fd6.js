import { useStore as n } from "vuex";
import { computed as e } from "vue";
import { watch as r } from "vue";
const u = (i) => {
  const o = n(), t = e(() => o.state.config.loaded.productionTeam);
  if (t.value || o.dispatch("config/fetchProductionTeam"), i) {
    const c = r(t, (a) => {
      a && setTimeout(() => {
        i(), c();
      }, 0);
    }, { immediate: true });
  }
  return { productionTeam: e(() => o.state.config.productionTeam), productionTeamKV: e(() => o.state.config.productionTeamKV), loaded: t };
};
export {
  u
};
