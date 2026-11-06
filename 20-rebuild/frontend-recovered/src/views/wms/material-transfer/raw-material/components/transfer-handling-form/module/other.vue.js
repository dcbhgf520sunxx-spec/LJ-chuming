import e from "../components/common-material-info.vue.js";
import { openBlock as t } from "vue";
import { createBlock as r } from "vue";
const i = { __name: "other", props: { material: { type: Object } }, setup(a) {
  return (o, m) => (t(), r(e, { material: a.material }, null, 8, ["material"]));
} };
export {
  i as default
};
