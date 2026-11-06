import { b as i } from "../../../../modules/base-6bc46ddf.js";
import { _ as p, aT as o } from "../../../../shared/runtime.js";
import _ from "./areaPiecework/index.vue.js";
import m from "./weightPiecework/index.vue.js";
import { provide as d } from "vue";
import { ref as u } from "vue";
import { computed as f } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as r } from "vue";
import { createBlock as l } from "vue";
import { resolveDynamicComponent as v } from "vue";
import "./areaPiecework/module/form.vue.js";
import "./areaPiecework/module/header.vue.js";
import "./weightPiecework/module/form.vue.js";
import "./weightPiecework/module/header.vue.js";
const g = { key: 1, class: "hint" }, y = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(c) {
  d("projectData", c.projectData);
  const t = u();
  async function n() {
    try {
      const e = await i() || void 0;
      t.value = e;
    } catch (e) {
      console.log("获取涂装配置方式", e);
    }
  }
  n();
  const s = f(() => {
    switch (t.value) {
      case o.AREA.V:
        return _;
      case o.WEIGHT.V:
        return m;
      default:
        return;
    }
  });
  return (e, x) => (a(), r("div", null, [t.value ? (a(), l(v(s.value), { key: 0 })) : (a(), r("div", g, "* 请先设置涂装配置方式"))]));
} }, T = p(y, [["__scopeId", "data-v-fedcb163"]]);
export {
  T as default
};
