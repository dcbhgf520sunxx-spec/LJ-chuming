import { ref as d } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as o } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as x } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as U } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as S, d as j } from "./module/detail.vue.js";
import { x as q, o as A, aU as $, F as T, G as z, P as G } from "../../../../shared/runtime.js";
import { L as w } from "../../../../modules/bridge-86f96a4f.js";
import K from "./module/header.vue.js";
const W = { class: "app-container" }, J = { class: "head-container" }, ae = { __name: "index", setup(X) {
  const C = { add: false, edit: false, del: false, download: false }, y = d(), { crud: u, columns: n, CRUD: L } = q({ title: "分段工单", sort: [], permission: { ...w }, optShow: { ...C }, crudApi: { ...S }, requiredQuery: ["productType"] }, y), E = d([["scheduleTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: D } = A({ paginate: true });
  L.HOOK.handleRefresh = (m, s) => {
    s.data.content = s.data.content.map((r) => (r.boolPrinted = !!r.printQuantity, r.boolIntellect = r.productionLineTypeEnum === $.INTELLECT.V, r));
  };
  const R = d(), v = d({}), h = d(false);
  function V(m) {
    h.value = true, v.value = m, R.value = Object.assign({}, m);
  }
  return (m, s) => {
    const r = f("table-cell-tag"), a = M, N = U, O = f("common-button"), P = f("common-table"), B = F("permission"), Q = H;
    return t(), I("div", W, [b("div", J, [p(e(K))]), k((t(), o(P, { ref_key: "tableRef", ref: y, data: e(u).data, "empty-text": e(u).emptyText, dataFormat: E.value, "max-height": e(D), style: { width: "100%" } }, { default: c(() => [p(a, { label: "序号", type: "index", align: "center", width: "70" }, { default: c(({ row: l, $index: g }) => [p(r, { show: l.boolPrinted, color: "#e64242", name: "已打印", type: "printed" }, null, 8, ["show"]), b("span", null, _(g + 1), 1)]), _: 1 }), e(n).visible("scheduleTime") ? (t(), o(a, { key: 0, "show-overflow-tooltip": true, prop: "scheduleTime", label: "排产日期", width: "110px", align: "center" })) : i("", true), e(n).visible("scheduleOrder") ? (t(), o(a, { key: 1, "show-overflow-tooltip": true, prop: "scheduleOrder", label: "任务工单号", "min-width": "110px", align: "center" }, { default: c(({ row: l }) => [p(r, { show: l.boolIntellect, name: "智" }, null, 8, ["show"]), b("span", null, _(l.scheduleOrder), 1)]), _: 1 })) : i("", true), e(n).visible("userName") ? (t(), o(a, { key: 2, "show-overflow-tooltip": true, prop: "userName", label: "排产人", "min-width": "110px", align: "center" })) : i("", true), e(n).visible("productType") ? (t(), o(a, { key: 3, "show-overflow-tooltip": true, prop: "productType", label: "类型", width: "100px", align: "center" }, { default: c(({ row: l }) => [p(N, { type: l.productType & e(T).CELL.V ? "" : "success", effect: "plain" }, { default: c(() => [x(_(e(T).VL[l.productType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), e(n).visible("workshop.name") ? (t(), o(a, { key: 4, "show-overflow-tooltip": true, prop: "workshop.name", label: "车间", "min-width": "110px", align: "center" })) : i("", true), e(n).visible("productionLine.name") ? (t(), o(a, { key: 5, "show-overflow-tooltip": true, prop: "productionLine.name", label: "生产线", "min-width": "110px", align: "center" })) : i("", true), e(n).visible("group.name") ? (t(), o(a, { key: 6, "show-overflow-tooltip": true, prop: "group.name", label: "生产组", "min-width": "80px", align: "center" })) : i("", true), e(n).visible("taskQuantity") ? (t(), o(a, { key: 7, "show-overflow-tooltip": true, prop: "taskQuantity", label: "任务数（件）", "min-width": "110px", align: "center" })) : i("", true), e(n).visible("taskMete") ? (t(), o(a, { key: 8, "show-overflow-tooltip": true, prop: "taskMete", label: "任务量（kg）", align: "center" })) : i("", true), e(z)([...e(w).detail]) ? (t(), o(a, { key: 9, label: "操作", "min-width": "60px", align: "center" }, { default: c(({ row: l }) => [k((t(), o(O, { type: "primary", size: "default", onClick: (g) => V(l) }, { default: c(() => s[1] || (s[1] = [x("查看")])), _: 2, __: [1] }, 1032, ["onClick"])), [[B, e(w).detail]])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "dataFormat", "max-height"])), [[Q, e(u).loading]]), p(e(G)), p(j, { visible: h.value, "onUpdate:visible": s[0] || (s[0] = (l) => h.value = l), "detail-data": v.value, onRefresh: e(u).toQuery }, null, 8, ["visible", "detail-data", "onRefresh"])]);
  };
} };
export {
  ae as default
};
