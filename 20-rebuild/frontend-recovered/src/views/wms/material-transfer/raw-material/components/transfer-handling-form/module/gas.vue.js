import e from "../components/common-material-info.vue.js";
import { openBlock as t } from "vue";
import { createBlock as r } from "vue";
const s = { __name: "gas", props: { material: { type: Object } }, setup(a) {
  return (m, o) => (t(), r(e, { material: a.material }, null, 8, ["material"]));
} };
export {
  s as default
};
