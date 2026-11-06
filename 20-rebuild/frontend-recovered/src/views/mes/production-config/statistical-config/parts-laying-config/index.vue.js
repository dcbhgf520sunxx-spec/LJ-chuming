import { ref as b } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as f } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as T } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as A } from "element-plus";
import { l as s, x as k, pj as c, o as N, aT as h, G as O, an as R } from "../../../../../shared/runtime.js";
import B from "./module/header.vue.js";
import D from "./module/batch-form.vue.js";
import E from "./module/form.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
import "../../../../../modules/cut-config-select-6e1b2706.js";
function I(a) {
  return s({ module: "mes", url: "layingOff", method: "get", params: a });
}
function L(a) {
  return s({ module: "mes", url: "layingOff", method: "post", data: [a] });
}
function Q(a) {
  return s({ module: "mes", url: "layingOff", method: "post", data: a });
}
function V(a) {
  return s({ module: "mes", url: "layingOff", method: "put", data: a });
}
function G(a) {
  return s({ module: "mes", url: "layingOff", method: "delete", data: a });
}
const H = { get: I, add: L, batchAdd: Q, del: G, edit: V }, M = { class: "app-container" }, $ = { class: "head-container" }, W = { __name: "index", setup(a) {
  const _ = { add: true, batchAdd: true, edit: false, del: true, download: false }, g = [["wageQuotaType", ["parse-enum", h]]], u = b(), { crud: d } = k({ title: "零件-下料配置", sort: [], formStore: true, formStoreKey: "MES_STATISTICAL_PARTS_LAYING_CONFIG", permission: { ...c }, optShow: { ..._ }, crudApi: { ...H }, hasPagination: false, dataPath: "" }, u), { maxHeight: w } = N();
  return (F, p) => {
    const n = P, x = v("common-table"), y = A;
    return m(), S("div", M, [l("div", $, [t(e(B))]), C((m(), f(x, { ref_key: "tableRef", ref: u, data: e(d).data, "empty-text": e(d).emptyText, "max-height": e(w), "data-format": g, style: { width: "100%" }, "row-key": "id", onSelectionChange: e(d).selectionChangeHandler }, { default: i(() => [t(n, { type: "selection", width: "55", align: "center", fixed: "left" }), t(n, { label: "序号", type: "index", align: "center", width: "60" }), t(n, { prop: "specPrefix", "show-overflow-tooltip": true, label: "截面类型", align: "center", "min-width": "160px" }), t(n, { prop: "name", "show-overflow-tooltip": true, label: "下料方式", align: "center", "min-width": "160px" }, { default: i(({ row: o }) => [l("span", null, r(o.name), 1)]), _: 1 }), t(n, { "show-overflow-tooltip": true, label: "板厚范围", align: "center", "min-width": "200px" }, { default: i(({ row: o }) => [l("span", null, r(o.minNumerical), 1), p[0] || (p[0] = l("span", null, " ~ ", -1)), l("span", null, r(o.maxNumerical), 1)]), _: 1 }), t(n, { prop: "wageQuotaType", "show-overflow-tooltip": true, label: "计量方式", align: "center", "min-width": "160px" }), t(n, { "show-overflow-tooltip": true, prop: "unitPrice", label: "单价", align: "center", "min-width": "100px" }, { default: i(({ row: { sourceRow: o } }) => [l("span", null, r(o.unitPrice), 1), l("span", null, r(e(h).V[o.wageQuotaType].unit), 1)]), _: 1 }), e(O)([...e(c).edit, ...e(c).del]) ? (m(), f(n, { key: 0, label: "操作", width: "150px", align: "center" }, { default: i((o) => [t(e(R), { data: o.row }, null, 8, ["data"])]), _: 1 })) : T("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[y, e(d).loading]]), t(e(D)), t(e(E))]);
  };
} };
export {
  W as default
};
