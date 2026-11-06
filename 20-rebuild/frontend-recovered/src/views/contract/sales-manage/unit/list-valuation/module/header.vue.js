import { inject as T } from "vue";
import { ref as y } from "vue";
import { watch as x } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as V } from "vue";
import { vShow as k } from "vue";
import { unref as t } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as r } from "vue";
import { withKeys as p } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as b } from "vue";
import { createBlock as U } from "vue";
import { Fragment as $ } from "vue";
import { ElInput as B } from "element-plus";
import { ElTag as P } from "element-plus";
import { b as q } from "../../../../../../modules/list-valuation-9a754659.js";
import { B as z, kQ as D, C as K, bV as R, E as S } from "../../../../../../shared/runtime.js";
import A from "./list-drawer.vue.js";
import "../components/list-drawer-table/structure.vue.js";
import "../components/list-drawer-table/enclosure.vue.js";
import "../components/list-drawer-table/auxiliary-material.vue.js";
import "./list-create.vue.js";
import "../components/list-create-table/structure.vue.js";
import "../components/list-create-table/enclosure.vue.js";
import "../components/list-create-table/auxiliary-material.vue.js";
const ee = { __name: "header", setup(O) {
  const _ = T("permission"), w = {}, i = y({}), u = y(false), { crud: n, query: l } = z(w);
  x(() => n.query.projectId, () => {
    c();
  }, { immediate: true });
  async function c() {
    try {
      const a = await q({ projectId: n.query.projectId, productType: l.productType });
      i.value = a, n.toQuery();
    } catch (a) {
      console.log(a);
    }
  }
  return (a, e) => {
    const j = v("common-radio-button"), m = B, f = P, N = v("common-button"), Q = C("permission");
    return g(), I($, null, [V(E("div", null, [r(j, { modelValue: t(l).productType, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(l).productType = o), options: t(D).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: c }, null, 8, ["modelValue", "options"]), r(m, { modelValue: t(l).pricingName, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(l).pricingName = o), placeholder: "按计价名称搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: e[2] || (e[2] = p((o) => t(n).toQuery(), ["enter"])) }, null, 8, ["modelValue"]), r(f, { size: "large", effect: "plain", class: "filter-item" }, { default: s(() => [d(" 剩余：" + b(i.value.unPricingQuantity || 0) + "件未计价 ", 1)]), _: 1 }), r(t(K))], 512), [[k, t(n).searchToggle]]), r(t(S), null, { optLeft: s(() => [V((g(), U(N, { size: "small", class: "filter-item", type: "success", icon: "el-icon-plus", onClick: e[3] || (e[3] = (o) => u.value = true) }, { default: s(() => e[9] || (e[9] = [d(" 创建清单计价 ")])), _: 1, __: [9] })), [[Q, t(_).create]]), r(f, { type: "success", size: "large", effect: "plain", class: "filter-item" }, { default: s(() => [d(" 金额：" + b(t(R)(i.value.pricingAmount || 0)) + "元 ", 1)]), _: 1 }), r(m, { modelValue: t(l).name, "onUpdate:modelValue": e[4] || (e[4] = (o) => t(l).name = o), placeholder: "按产品名称搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: e[5] || (e[5] = p((o) => t(n).toQuery(), ["enter"])) }, null, 8, ["modelValue"]), r(m, { modelValue: t(l).serialNumber, "onUpdate:modelValue": e[6] || (e[6] = (o) => t(l).serialNumber = o), placeholder: "按产品编号搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: e[7] || (e[7] = p((o) => t(n).toQuery(), ["enter"])) }, null, 8, ["modelValue"])]), _: 1 }), r(A, { visible: u.value, "onUpdate:visible": e[8] || (e[8] = (o) => u.value = o), onRefresh: t(n).toQuery }, null, 8, ["visible", "onRefresh"])], 64);
  };
} };
export {
  ee as default
};
