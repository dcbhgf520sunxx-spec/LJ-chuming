import { ref as I } from "vue";
import { reactive as N } from "vue";
import C from "moment";
import { resolveComponent as E } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as v } from "vue";
import { vShow as Q } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as s } from "vue";
import { Fragment as x } from "vue";
import { withCtx as r } from "vue";
import { createBlock as y } from "vue";
import { createTextVNode as P } from "vue";
import { ElDatePicker as A } from "element-plus";
import { ElTooltip as K } from "element-plus";
import { d as L } from "../../../../../../modules/psi-b34aaded.js";
import { cE as m, B as M, cO as R, cV as T, jl as B, bV as z, v3 as F, I as H, C as q, L as j, E as $ } from "../../../../../../shared/runtime.js";
const Y = { class: "head-container" }, Z = { __name: "header", setup(G) {
  const k = I([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), o = N({ list: [], KV: {}, update: true }), w = { times: [C().subtract(1, "month").startOf("day").valueOf(), C().endOf("day").valueOf()], basicClass: m.STEEL_PLATE.V, material: void 0, thickness: void 0, classifyId: void 0 }, { CRUD: V, crud: i, query: t } = M(w);
  function U(b) {
    return b > /* @__PURE__ */ new Date();
  }
  V.HOOK.beforeToQuery = () => {
    t.times || (t.times = void 0);
  }, V.HOOK.handleRefresh = async (b, { data: a }) => {
    o.update && (o.list = a.spec || [], o.KV = {}, o.list.forEach((n) => {
      o.KV[n.label] = n;
    }), o.update = false), a.content = await R(a.content), a.content.forEach((n) => {
      n.basicClass & T && (n.accountingUnit = "千克", n.accountingPrecision = 3);
    }), a.content = await B(a.content, { toNum: true }, { quantity: ["inboundQuantity", "outboundQuantity", "inventoryQuantity"], mete: ["inboundMete", "outboundMete", "inventoryMete"] }), a.content.forEach((n) => {
      n.unitPriceExcludingVAT = z(n.unitPriceExcludingVAT, F(n.unitPriceExcludingVAT));
    });
  };
  function _() {
    t.material = void 0, t.thickness = void 0, t.classifyId = void 0, o.update = true, i.toQuery();
  }
  return (b, a) => {
    const n = E("common-radio-button"), O = A, f = E("common-select"), p = K, D = S("permission");
    return u(), g("div", Y, [v(c("div", null, [s(n, { modelValue: e(t).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).basicClass = l), options: e(m).ENUM, unshowVal: [e(m).STRUC_MANUFACTURED.V, e(m).ENCL_MANUFACTURED.V], type: "enum", size: "default", class: "filter-item", onChange: _ }, null, 8, ["modelValue", "options", "unshowVal"]), s(O, { modelValue: e(t).times, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).times = l), clearable: false, "default-time": k.value, "disabled-date": U, shortcuts: e(H), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "value-format": "x", onChange: _ }, null, 8, ["modelValue", "default-time", "shortcuts"]), e(t).basicClass & e(T) ? (u(), g(x, { key: 0 }, [s(p, { "show-after": 100, content: "材质", placement: "top" }, { default: r(() => [c("span", null, [s(f, { modelValue: e(t).material, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).material = l), "data-structure": { key: "label", label: "value", value: "label" }, options: o.list, class: "filter-item", clearable: "", filterable: "", type: "other", size: "default", placeholder: "可选择材质", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"])])]), _: 1 }), e(t).basicClass === e(m).SECTION_STEEL.V ? (u(), y(p, { key: 0, "show-after": 100, content: "科目", placement: "top" }, { default: r(() => {
      var l, d;
      return [c("span", null, [s(f, { modelValue: e(t).classifyId, "onUpdate:modelValue": a[3] || (a[3] = (h) => e(t).classifyId = h), "data-structure": { key: "label", label: "value", value: "label" }, options: ((d = (l = o.KV) == null ? void 0 : l[e(t).material]) == null ? void 0 : d.list) || [], class: "filter-item", clearable: "", filterable: "", type: "other", size: "default", placeholder: "可选择科目", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"])])];
    }), _: 1 })) : (u(), y(p, { key: 1, "show-after": 100, content: "厚度", placement: "top" }, { default: r(() => {
      var l, d;
      return [c("span", null, [s(f, { modelValue: e(t).thickness, "onUpdate:modelValue": a[4] || (a[4] = (h) => e(t).thickness = h), "data-structure": { key: "value", label: "value", value: "value" }, options: ((d = (l = o.KV) == null ? void 0 : l[e(t).material]) == null ? void 0 : d.list) || [], class: "filter-item", clearable: "", filterable: "", type: "other", size: "default", placeholder: "可选择厚度", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"])])];
    }), _: 1 }))], 64)) : (u(), y(p, { key: 1, "show-after": 100, content: "科目", placement: "top" }, { default: r(() => [c("span", null, [s(f, { modelValue: e(t).classifyId, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).classifyId = l), "data-structure": { key: "label", label: "value", value: "label" }, options: o.list, class: "filter-item", clearable: "", filterable: "", type: "other", size: "default", placeholder: "可选择科目", onChange: e(i).toQuery }, null, 8, ["modelValue", "options", "onChange"])])]), _: 1 })), s(e(q))], 512), [[Q, e(i).searchToggle]]), s(e($), null, { optLeft: r(() => [v((u(), y(j, { fn: e(L), params: e(t), "response-header-result": "" }, { default: r(() => a[6] || (a[6] = [P(" 下载进销存明细（根据查询条件） ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[D, e(i).permission.get]])]), _: 1 })]);
  };
} };
export {
  Z as default
};
