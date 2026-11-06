import t from "../components/common-material-info.vue.js";
import { openBlock as e } from "vue";
import { createBlock as r } from "vue";
const i = { __name: "aux-mat", props: { material: { type: Object } }, setup(a) {
  return (m, o) => (e(), r(t, { material: a.material }, null, 8, ["material"]));
} };
export {
  i as default
};
