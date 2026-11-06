import { useStore as e } from "vuex";
import { computed as o } from "vue";
const c = () => {
  const t = e();
  return t.state.config.loaded.productLines || t.dispatch("config/fetchProductLines"), { productLines: o(() => t.state.config.productLines), loaded: o(() => t.state.config.loaded.productLines) };
};
export {
  c as u
};
