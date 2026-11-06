import { ref as h } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as a } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as l } from "vue";
import { createBlock as u } from "vue";
import { unref as p } from "vue";
import { createTextVNode as k } from "vue";
import { normalizeClass as P } from "vue";
import { withDirectives as T } from "vue";
import { Fragment as $ } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as F } from "element-plus";
import { ElProgress as H } from "element-plus";
import { Edit as q } from "@element-plus/icons-vue";
import { ElIcon as K } from "element-plus";
import { ng as g, p as C, bs as O } from "../../../../shared/runtime.js";
import { p as w } from "../../../../modules/plan-d12d7ccf.js";
import U from "./user-dialog.vue.js";
import "../../../../modules/dept-task-1cfc3d1d.js";
import "../../../../modules/index-9d220fe1.js";
import "../../../../modules/use-users-4d979987.js";
const Y = { key: 1 }, G = { key: 1 }, J = { key: 0, style: { display: "flex", "align-items": "center" } }, Q = { style: { display: "inline-block", "white-space": "wrap" }, class: "tc-primary" }, se = { __name: "dept-plan", props: { projectDetail: { type: Object, default: () => ({}) }, infoList: { type: Array, default: () => [] }, maxHeight: { type: Number, default: 0 }, manageType: { type: Number }, active: { type: Number } }, emits: ["success"], setup(y, { emit: L }) {
  const N = h([]), z = L, _ = h(false), b = h({});
  function E({ row: r, column: c, rowIndex: n, columnIndex: f }) {
    if (f === 9) return r.areaList && r.areaList.length ? { rowspan: r.areaList.length + 1, colspan: 1 } : { rowspan: 1, colspan: 0 };
  }
  function S() {
    z("success");
  }
  function x(r) {
    b.value = r, _.value = true;
  }
  return (r, c) => {
    const n = A, f = F, V = H, j = q, I = K, R = D("common-button"), B = D("common-table"), v = M("permission");
    return i(), m($, null, [a(B, { ref: "tableRef", data: y.infoList, "empty-text": "暂无数据", "max-height": y.maxHeight, "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" }, "row-key": "uid", stripe: false, "expand-row-keys": N.value, "default-expand-all": "", "span-method": E, childrenPath: "areaList", "tree-props": { children: "areaList", hasChildren: "hasChildren" } }, { default: t(() => [a(n, { label: "序号", prop: "idx", align: "center", width: "55" }, { default: t(({ row: e }) => [o("span", null, l(e.idx), 1)]), _: 1 }), a(n, { prop: "name", "show-overflow-tooltip": true, label: "单体/区段", "min-width": "100px" }, { default: t(({ row: e }) => [o("span", null, l(e.name), 1)]), _: 1 }), a(n, { prop: "itemizedType", align: "center", label: "制品分类", width: "90px" }, { default: t(({ row: e }) => {
      var s;
      return [parseInt(e.itemizedType) ? (i(), u(f, { key: 0, type: (s = p(g).V[e.itemizedType]) == null ? void 0 : s.T, effect: "plain" }, { default: t(() => [k(l(parseInt(e.itemizedType) ? p(g).VL[e.itemizedType] : e.itemizedType), 1)]), _: 2 }, 1032, ["type"])) : (i(), m("span", Y))];
    }), _: 1 }), a(n, { prop: "unit", align: "center", label: "单位", width: "60px" }, { default: t(({ row: e }) => {
      var s, d;
      return [o("span", null, l((d = (s = p(g).V) == null ? void 0 : s[e.itemizedType]) == null ? void 0 : d.unit), 1)];
    }), _: 1 }), a(n, { prop: "mete", label: "工程量", align: "center", width: "70px" }, { default: t(({ row: e }) => [o("span", null, l(e.mete), 1)]), _: 1 }), a(n, { label: "深化计划", align: "center", "show-overflow-tooltip": true, width: "180px" }, { default: t(({ row: e }) => [o("span", null, l(e.deepenStartDate && e.deepenEndDate ? p(C)(e.deepenStartDate, "{y}-{m}-{d}") + " ~ " + p(C)(e.deepenEndDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(n, { prop: "allDays", align: "center", label: "工期(天)", width: "70px" }), a(n, { prop: "usedDays", align: "center", label: "已用时(天)", width: "80px" }, { default: t(({ row: e }) => [o("span", { class: P(e.usedDays < 0 || e.usedDays > e.allDays ? "tc-danger" : "") }, l(e.usedDays > 0 ? e.usedDays : "-"), 3)]), _: 1 }), a(n, { prop: "actualCompletion", align: "center", label: "实时完成量", width: "120px" }, { default: t(({ row: e }) => [e.isMonomer ? (i(), m("span", G, "-")) : (i(), u(V, { key: 0, "text-inside": true, "stroke-width": 16, percentage: e.completeRate > 100 ? 100 : e.completeRate, status: "success" }, { default: t(() => [o("span", null, l(p(O)(e.completeRate, 2)) + "%", 1)]), _: 2 }, 1032, ["percentage"]))]), _: 1 }), a(n, { "show-overflow-tooltip": "", prop: "deepenNames", align: "center", label: "深化负责人", "min-width": "240px" }, { default: t(({ row: e }) => {
      var s;
      return [(s = e.deepenIdsAndName) != null && s.length ? (i(), m("div", J, [T((i(), u(I, { onClick: (d) => x(e), class: "pointer", style: { "margin-right": "5px", "margin-top": "2px" } }, { default: t(() => [a(j)]), _: 2 }, 1032, ["onClick"])), [[v, p(w).edit]]), o("div", Q, l(e.deepenNames), 1)])) : T((i(), u(R, { key: 1, type: "primary", icon: "el-icon-plus", onClick: (d) => x(e) }, { default: t(() => c[1] || (c[1] = [k("创建")])), _: 2, __: [1] }, 1032, ["onClick"])), [[v, p(w).add]])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"]), a(U, { visible: _.value, "onUpdate:visible": c[0] || (c[0] = (e) => _.value = e), onSuccess: S, projectDetail: y.projectDetail, monomerDetail: b.value }, null, 8, ["visible", "projectDetail", "monomerDetail"])], 64);
  };
} };
export {
  se as default
};
