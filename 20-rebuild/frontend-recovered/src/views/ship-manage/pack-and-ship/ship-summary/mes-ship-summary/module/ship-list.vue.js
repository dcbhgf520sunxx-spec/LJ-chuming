import { ref as u } from "vue";
import { watch as O } from "vue";
import { resolveComponent as w } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as K } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as a } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as T } from "vue";
import { withKeys as F } from "vue";
import { createBlock as G } from "vue";
import { toDisplayString as b } from "vue";
import { unref as s } from "vue";
import { ElTag as H } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as J } from "element-plus";
import { i as Q, j as X } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { o as Y, J as Z, uo as ee, on as te, bo as k, ba as ae } from "../../../../../../shared/runtime.js";
import oe from "./package-detail-drawer.vue.js";
const le = { style: { "margin-top": "20px" } }, se = { class: "head-container" }, ne = ["onClick"], me = { __name: "ship-list", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(c, { expose: C }) {
  const N = { TRUE: { L: "已发运", K: "TRUE", V: true, COLOR: "" }, FALSE: { L: "未发运", K: "FALSE", V: false, COLOR: "" } }, x = u([["createTime", ["parse-time", "{y}-{m}-{d}"]]]), t = c, m = u([]), d = u(false), n = u({}), g = u(false), v = u({}), { maxHeight: E } = Y({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: V, handleCurrentChange: I, total: j, setTotalPage: q, queryPage: y } = Z({ fetchHook: i });
  O(() => t.showType, (l) => {
    l && (n.value = {}, i());
  }, { immediate: true, deep: true });
  async function i() {
    if (m.value = [], !!t.showType) {
      d.value = true;
      try {
        const l = t.category === ee.STRUCTURE.V ? Q : X, { content: o = [], totalElements: h } = await l({ projectId: t.projectId, ...t.query, workshopId: t.workshopId, shipEnumType: te[t.showType].V, ...n.value, ...y });
        m.value = o, q(h), d.value = false;
      } catch (l) {
        console.log("获取详情失败", l), d.value = false;
      }
    }
  }
  function z(l) {
    return ae(l, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  function L(l) {
    v.value = l, g.value = true;
  }
  return C({ refresh: i }), (l, o) => {
    const h = H, B = w("common-radio-button"), D = A, r = M, U = w("common-table"), R = $, W = J;
    return _((S(), P("div", le, [f("div", se, [a(h, { size: "default", class: "filter-item" }, { default: p(() => o[3] || (o[3] = [T("打包发运")])), _: 1, __: [3] }), a(B, { "show-option-all": "", modelValue: n.value.boolShip, "onUpdate:modelValue": o[0] || (o[0] = (e) => n.value.boolShip = e), options: N, type: "enum", class: "filter-item", onChange: i }, null, 8, ["modelValue"]), a(D, { modelValue: n.value.serialNumber, "onUpdate:modelValue": o[1] || (o[1] = (e) => n.value.serialNumber = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入包单号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: F(i, ["enter"]), onChange: i }, null, 8, ["modelValue"])]), _((S(), G(U, { data: m.value, "show-empty-symbol": false, "data-format": x.value, "show-summary": "", "summary-method": z, "max-height": s(E) - 140 }, { default: p(() => [a(r, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), a(r, { "show-overflow-tooltip": "", prop: "createTime", key: "createTime", label: "打包日期", align: "center" }), a(r, { key: "serialNumber", prop: "serialNumber", label: "包单号", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: e }) => [f("div", { onClick: (ie) => L(e), class: "tc-primary", style: { cursor: "pointer" } }, b(e.serialNumber), 9, ne)]), _: 1 }), a(r, { key: "quantity", prop: "quantity", label: "包内数量（件）", align: "center", "show-overflow-tooltip": true }), a(r, { prop: c.weightStatus === s(k).NET.V ? "totalNetWeight" : "totalGrossNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: e }) => [f("span", null, b(c.weightStatus === s(k).NET.V ? e.totalNetWeight || "-" : e.totalGrossNetWeight || "-"), 1)]), _: 1 }, 8, ["prop"]), a(r, { prop: "boolShip", label: "状态", align: "center", "show-overflow-tooltip": true, width: "120" }, { default: p(({ row: e }) => [a(h, { type: e.boolShip ? "success" : "danger", effect: "plain" }, { default: p(() => [T(b(e.boolShip ? "已发运" : "未发运"), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[W, d.value]]), a(R, { total: s(j), "current-page": s(y).pageNumber, "page-size": s(y).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(V), onCurrentChange: s(I) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(oe, { visible: g.value, "onUpdate:visible": o[2] || (o[2] = (e) => g.value = e), "detail-data": m.value, query: c.query, packageInfo: v.value, "workshop-id": t.workshopId, "project-id": t.projectId, category: t.category, "weight-status": t.weightStatus }, null, 8, ["visible", "detail-data", "query", "packageInfo", "workshop-id", "project-id", "category", "weight-status"])], 512)), [[K, t.showType]]);
  };
} };
export {
  me as default
};
