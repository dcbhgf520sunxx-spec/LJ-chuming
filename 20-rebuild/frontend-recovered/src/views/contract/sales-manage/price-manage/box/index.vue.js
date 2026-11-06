import { ref as d } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as p } from "vue";
import { mergeProps as B } from "vue";
import { unref as i } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as s } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as c } from "vue";
import { normalizeClass as C } from "vue";
import { toDisplayString as E } from "vue";
import { withModifiers as O } from "vue";
import { ElMessage as j } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as I, m as T } from "./module/header.vue.js";
import { O as U } from "../../../../../modules/contract-9b18cc88.js";
import { x as Y, o as G, D as K, G as L, P as J, fK as D } from "../../../../../shared/runtime.js";
import X from "./module/detail.vue.js";
import "../preview.vue.js";
import "../../../../../modules/common-913d415d.js";
import "../../../../../modules/index-61ce89a1.js";
const Z = { key: 1 }, ue = { __name: "index", setup(ee, { expose: M }) {
  const w = { add: false, edit: false, del: false, download: false }, _ = d({}), P = d(), g = d(), v = d(false), R = d([["unitPrice", ["to-thousand-ck", "YUAN"]]]), { crud: u, columns: f } = Y({ title: "分段价格", sort: [], permission: { ...U }, crudApi: { ...I }, optShow: { ...w }, requiredQuery: ["monomerId"] }, P), { maxHeight: A } = G({ paginate: true, extraHeight: 100 }), k = { unitPrice: [{ validator: (e, t) => t.pricingManner !== t.originPricingManner || t.unitPrice !== t.originUnitPrice && t.unitPrice > 0 ? !!t.newUnitPrice : true, message: "请填写单价", trigger: "blur" }] };
  function V({ row: e, column: t }) {
    if (!e) return;
    const a = k;
    let o = true;
    e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (o = D(t.property, a[t.property], e)), o && (e.verify[t.property] = true));
    let r = "";
    return t.property === "unitPrice" && e.unitPrice !== e.originUnitPrice && (r = "mask-td"), o ? r : "wrong-td";
  }
  async function H(e) {
    const t = k;
    let a = true;
    return u.data.map((o) => {
      o.verify = {};
      for (const r in t) o.verify[r] = D(r, t[r], o), o.verify[r] || (a = false);
    }), a ? (v.value = true, true) : (j.error("请填写表格中标红数据"), v.value = false, false);
  }
  function N(e) {
    e.unitPrice = e.newUnitPrice, e.totalPrice = e.totalWeight * (e.unitPrice || 0);
  }
  function Q(e) {
    _.value = e, u.toDetail(e);
  }
  return M({ refresh: u.refresh }), (e, t) => {
    const a = q, o = b("common-input-number"), r = b("common-button"), S = b("common-table"), W = z("thousand"), $ = F;
    return n(), m("div", null, [p(i(T), B({ ref_key: "headerRef", ref: g }, e.$attrs, { onCheckSubmit: H, showAble: v.value }), null, 16, ["showAble"]), x((n(), s(S, { ref_key: "tableRef", ref: P, data: i(u).data, "return-source-data": "", "data-format": R.value, style: { width: "100%" }, class: "businessTable", "max-height": i(A), "cell-class-name": V }, { default: h(() => [p(a, { label: "序号", type: "index", align: "center", width: "60" }), i(f).visible("specification") ? (n(), s(a, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" })) : c("", true), i(f).visible("material") ? (n(), s(a, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "120" })) : c("", true), i(f).visible("totalQuantity") ? (n(), s(a, { key: "totalQuantity", prop: "totalQuantity", label: "数量", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : c("", true), i(f).visible("totalWeight") ? (n(), s(a, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "总量(t)", align: "center", "min-width": "120" })) : c("", true), i(f).visible("unitPrice") ? (n(), s(a, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": "", label: "综合单价", align: "center", "min-width": "120" }, { default: h(({ row: l }) => [g.value && g.value.modifying ? (n(), s(o, { key: 0, modelValue: l.newUnitPrice, "onUpdate:modelValue": (y) => l.newUnitPrice = y, step: 1, min: 0, max: 99999999, precision: i(K).YUAN, size: "default", style: { width: "100%" }, onChange: (y) => N(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (n(), m("span", { key: 1, class: C(l.status === 1 ? "tc-danger" : "") }, E(l.unitPrice), 3))]), _: 1 })) : c("", true), i(f).visible("totalPrice") ? (n(), s(a, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: h(({ row: l }) => [l.totalPrice ? x((n(), m("span", { key: 0, class: C(l.status === 1 ? "tc-danger" : "") }, null, 2)), [[W, l.totalPrice]]) : (n(), m("span", Z, "-"))]), _: 1 })) : c("", true), i(L)([...i(U).detail]) ? (n(), s(a, { key: 6, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: h(({ row: l }) => [p(r, { icon: "el-icon-view", type: "info", size: "default", onClick: O((y) => Q(l), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[$, i(u).loading]]), p(i(J)), p(i(X), { "detail-info": _.value, onRefresh: i(u).refresh }, null, 8, ["detail-info", "onRefresh"])]);
  };
} };
export {
  ue as default
};
