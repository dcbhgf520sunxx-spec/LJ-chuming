import { inject as k } from "vue";
import { ref as p } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as v } from "vue";
import { unref as n } from "vue";
import { Fragment as r } from "vue";
import { withCtx as I } from "vue";
import { renderList as y } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as S } from "vue";
import { ElOption as E } from "element-plus";
import { ElSelect as B } from "element-plus";
import { am as Q, r7 as q } from "../../../../shared/runtime.js";
import x from "./basic-class-classification.vue.js";
const O = { __name: "section-query", emits: ["toQuery"], setup(F, { emit: V }) {
  const g = V, a = k("section-query", {}), b = p(), d = p({}), f = p([]);
  function C(o) {
    console.log(o), a.sectionSteelSpecId = void 0, a.specId = void 0, m(), h(o);
  }
  function m() {
    g("toQuery");
  }
  async function h(o) {
    if (o) try {
      f.value = [], d.value = {};
      const e = await q(o), { list: u = [] } = e == null ? void 0 : e.nationalStandard.find((i) => i.boolDefault);
      f.value = u, d.value = b.value.getOption(o);
    } catch (e) {
      console.log(e, "获取型材的规格");
    }
  }
  return (o, e) => {
    const u = E, i = B;
    return t(), s(r, null, [v(x, { ref_key: "classificationRef", ref: b, class: "filter-item", modelValue: n(a).classifyId, "onUpdate:modelValue": e[0] || (e[0] = (l) => n(a).classifyId = l), "basic-class": n(Q).SECTION_STEEL.V, placeholder: "请选择型材类", onChange: C }, null, 8, ["modelValue", "basic-class"]), n(a).classifyId ? (t(), s(r, { key: 0 }, [v(i, { modelValue: n(a).sectionSteelSpecId, "onUpdate:modelValue": e[1] || (e[1] = (l) => n(a).sectionSteelSpecId = l), clearable: "", filterable: "", placeholder: "请选择规格", class: "filter-item", onChange: m }, { default: I(() => [(t(true), s(r, null, y(f.value, (l) => (t(), _(u, { key: l.id, label: l.name, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), (t(true), s(r, null, y(d.value.specifications, (l) => (t(), s(r, { key: l.id }, [l.name === "材质" ? (t(), _(i, { key: 0, clearable: "", filterable: "", modelValue: n(a).specId, "onUpdate:modelValue": e[2] || (e[2] = (c) => n(a).specId = c), placeholder: `请选择${l.name}`, class: "filter-item", onChange: m }, { default: I(() => [(t(true), s(r, null, y(l.list, (c) => (t(), _(u, { key: c.id, label: c.value, value: c.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "placeholder"])) : S("", true)], 64))), 128))], 64)) : S("", true)], 64);
  };
} };
export {
  O as default
};
