import { inject as E } from "vue";
import { ref as f } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as o } from "vue";
import { createVNode as _ } from "vue";
import { unref as n } from "vue";
import { Fragment as r } from "vue";
import { withCtx as b } from "vue";
import { renderList as m } from "vue";
import { createBlock as p } from "vue";
import { createCommentVNode as v } from "vue";
import { ElOption as x } from "element-plus";
import { ElSelect as B } from "element-plus";
import { am as Q, sy as S } from "../../../../shared/runtime.js";
import T from "./basic-class-classification.vue.js";
const U = { __name: "steel-query", emits: ["toQuery"], setup(q, { emit: V }) {
  const g = V, a = E("steel-query", {}), y = f(), c = f({}), i = f([]);
  function I(s) {
    console.log(s), a.thickness = void 0, a.specId = void 0, d(), C(s);
  }
  function d() {
    g("toQuery");
  }
  async function C(s) {
    if (s) try {
      i.value = [], c.value = {};
      const l = await S(s);
      i.value = l, c.value = y.value.getOption(s);
    } catch (l) {
      console.log(l, "获取已入库钢板的厚度列表");
    }
  }
  return (s, l) => {
    const h = x, k = B;
    return t(), o(r, null, [_(T, { ref_key: "classificationRef", ref: y, class: "filter-item", modelValue: n(a).classifyId, "onUpdate:modelValue": l[0] || (l[0] = (e) => n(a).classifyId = e), "basic-class": n(Q).STEEL_PLATE.V, placeholder: "请选择钢板类", onChange: I }, null, 8, ["modelValue", "basic-class"]), n(a).classifyId ? (t(), o(r, { key: 0 }, [_(k, { modelValue: n(a).thickness, "onUpdate:modelValue": l[1] || (l[1] = (e) => n(a).thickness = e), clearable: "", placeholder: "请选择厚度", class: "filter-item", filterable: "", style: { width: "130px" }, onChange: d }, { default: b(() => [(t(true), o(r, null, m(i.value, (e) => (t(), p(h, { key: e, label: e, value: e }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), (t(true), o(r, null, m(c.value.specifications, (e) => (t(), o(r, { key: e.id }, [e.name === "材质" ? (t(), p(k, { key: 0, clearable: "", modelValue: n(a).specId, "onUpdate:modelValue": l[2] || (l[2] = (u) => n(a).specId = u), filterable: "", placeholder: `请选择${e.name}`, class: "filter-item", onChange: d }, { default: b(() => [(t(true), o(r, null, m(e.list, (u) => (t(), p(h, { key: u.id, label: u.value, value: u.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "placeholder"])) : v("", true)], 64))), 128))], 64)) : v("", true)], 64);
  };
} };
export {
  U as default
};
