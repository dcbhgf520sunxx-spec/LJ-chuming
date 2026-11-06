import { useStore as o } from "vuex";
import { computed as t } from "vue";
const s = () => {
  const e = o();
  return e.state.config.loaded.productLines || e.dispatch("config/fetchBridgeProductLines"), { productLines: t(() => e.state.config.bridgeProductLines), loaded: t(() => e.state.config.loaded.bridgeProductLines) };
};
export {
  s as u
};
