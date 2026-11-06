import { ref as g } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as u } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as d } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as v } from "vue";
import { unref as s } from "vue";
import { vShow as b } from "vue";
import { createCommentVNode as z } from "vue";
import { Fragment as w } from "vue";
import { renderList as W } from "vue";
import { toDisplayString as j } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as O } from "element-plus";
import { g as A, b as F } from "../../../../modules/process-381d77e4.js";
import { t as I, x as q, pk as T, o as K, pl as Y, aT as h, b as G } from "../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import X from "./module/preview.vue.js";
import "../../../../modules/index-61ce89a1.js";
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = { key: 0 }, ae = { key: 1 }, oe = { key: 1 }, de = { __name: "index", setup(se) {
  const { decimalPrecision: M } = I(), C = { add: false, edit: false, del: false, download: false }, Q = [["wageQuotaTypeStr", ["parse-enum", h, { bit: true }], { source: "wageQuotaType" }]], k = g(), { crud: m, columns: S, CRUD: $ } = q({ title: "工序", sort: [], optShow: { ...C }, permission: { ...T }, hasPagination: false, crudApi: { get: A, edit: F } }, k), { maxHeight: D } = K({ paginate: false }), _ = g(false), i = g(false);
  function x(f, e = "id") {
    if (G(f)) return {};
    const t = {};
    for (const n of f) t[n[e]] = n.price || 0;
    return t;
  }
  return $.HOOK.handleRefresh = (f, { data: e }) => {
    e.content = e.map((t, n) => (t.rowId = n + "" + Math.random(), t.wageQuotaType = Y[t.productType], t.priceMap = x(t.processWageList, "wageQuotaType"), t.originPriceMap = x(t.processWageList, "wageQuotaType"), t));
  }, (f, e) => {
    const t = y("common-button"), n = H, U = y("common-input-number"), B = y("common-table"), L = V("permission"), N = V("to-fixed"), P = O;
    return o(), l("div", Z, [E("div", ee, [u(s(J), null, { optLeft: p(() => [d((o(), c(t, { type: "primary", size: "default", onClick: e[0] || (e[0] = (a) => i.value = true) }, { default: p(() => e[5] || (e[5] = [v(" 编辑 ")])), _: 1, __: [5] })), [[L, s(T).edit], [b, !i.value]]), d(u(t, { type: "success", size: "default", style: { "margin-left": "0px" }, onClick: e[1] || (e[1] = (a) => _.value = true) }, { default: p(() => e[6] || (e[6] = [v(" 预览并保存 ")])), _: 1, __: [6] }, 512), [[b, i.value]]), d(u(t, { type: "info", size: "default", onClick: e[2] || (e[2] = (a) => i.value = false) }, { default: p(() => e[7] || (e[7] = [v("取消")])), _: 1, __: [7] }, 512), [[b, i.value]])]), _: 1 })]), d((o(), c(B, { ref_key: "tableRef", ref: k, "return-source-data": "", "data-format": Q, data: s(m).data, "empty-text": s(m).emptyText, "max-height": s(D), "row-key": "rowId", style: { width: "100%" } }, { default: p(() => [u(n, { label: "序号", type: "index", align: "center", width: "60" }), s(S).visible("name") ? (o(), c(n, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序名称", "min-width": "140px", align: "center" })) : z("", true), (o(true), l(w, null, W(s(h).ENUM, (a) => (o(), c(n, { key: a.V, label: `${a.L} (${a.unit})`, "min-width": "170px", align: "center" }, { default: p(({ row: r }) => [i.value ? (o(), l(w, { key: 1 }, [a.V & r.wageQuotaType ? (o(), c(U, { key: 0, modelValue: r.priceMap[a.V], "onUpdate:modelValue": (R) => r.priceMap[a.V] = R, precision: s(M).mes, controls: false, size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (o(), l("span", oe, "/"))], 64)) : (o(), l(w, { key: 0 }, [r.priceMap[a.V] ? d((o(), l("span", te, null, 512)), [[N, { k: "YUAN", val: r.priceMap[a.V] }]]) : (o(), l("span", ae, j(a.V & r.wageQuotaType ? "未设置" : "/"), 1))], 64))]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[P, s(m).loading]]), u(s(X), { visible: _.value, "onUpdate:visible": e[3] || (e[3] = (a) => _.value = a), data: s(m).data, onSaveSuccess: e[4] || (e[4] = (a) => i.value = false) }, null, 8, ["visible", "data"])]);
  };
} };
export {
  de as default
};
