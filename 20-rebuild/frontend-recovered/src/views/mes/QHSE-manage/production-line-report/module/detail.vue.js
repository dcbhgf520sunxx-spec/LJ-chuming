import { ref as d } from "vue";
import { inject as M } from "vue";
import { computed as O } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as F } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { withDirectives as N } from "vue";
import { unref as l } from "vue";
import { isRef as J } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElPagination as G } from "element-plus";
import { vLoading as K } from "element-plus";
import { l as z, u as W, J as X, o as Y } from "../../../../../shared/runtime.js";
function Z(i) {
  return z({ module: "mes", url: "report/inspection/summary/passrate", method: "get", params: i });
}
function ee(i) {
  return z({ module: "mes", url: "report/inspection/summary/review/page", method: "get", params: i });
}
const re = { get: Z }, te = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object }, query: { type: Object } }, emits: ["update:visible"], setup(i, { emit: j }) {
  const b = d(), q = j, p = i, { visible: m, handleClose: S } = W({ emit: q, props: p, field: "visible", showHook: y }), { handleSizeChange: T, handleCurrentChange: k, total: D, setTotalPage: V, queryPage: f } = X({ fetchHook: y }), H = M("permission"), I = d([["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: L } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b), g = d(false), _ = d([]), v = O(() => ({ productionLineId: p.info.productionLineId, startDate: p.query.startDate, endDate: p.query.endDate }));
  async function y() {
    try {
      _.value = [], g.value = true;
      const { content: u, totalElements: s } = await ee({ ...v.value, ...f });
      V(s), _.value = u.map((c, w) => (c.rowId = w + "" + Math.random(), c));
    } catch (u) {
      console.log("获取质检报表详情", u);
    } finally {
      g.value = false;
    }
  }
  return (u, s) => {
    const c = Q, w = h("print-table"), o = $, P = h("common-table"), R = G, B = h("common-drawer"), E = A("permission"), U = K;
    return x(), C(B, { ref_key: "drawerRef", ref: b, title: "产线质检不合格列表", modelValue: l(m), "onUpdate:modelValue": s[0] || (s[0] = (e) => J(m) ? m.value = e : null), direction: "rtl", "before-close": l(S), size: "70%" }, { titleAfter: t(() => [a(c, { size: "large", effect: "plain" }, { default: t(() => [s[1] || (s[1] = F(" 生产线：")), r("span", null, n(i.info.productionLineName), 1)]), _: 1, __: [1] })]), titleRight: t(() => [N(a(w, { "api-key": "mesQHSEProductionLineReport", params: { ...v.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[E, l(H).print]])]), content: t(() => [N((x(), C(P, { data: _.value, "max-height": l(L), "data-format": I.value, "row-key": "rowId", style: { width: "100%" } }, { default: t(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "150" }, { default: t(({ row: e }) => [r("span", null, n(e.project), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "artifactSerialNumber", label: "编号", align: "center" }, { default: t(({ row: e }) => [r("span", null, n(e.artifactSerialNumber), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "qualityType", label: "问题", align: "center" }, { default: t(({ row: e }) => [r("span", null, n(e.qualityType), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "productUserName", label: "制造人" }, { default: t(({ row: e }) => [r("span", null, n(e.productUserName), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "InspectionUserName", label: "检验人" }, { default: t(({ row: e }) => [r("span", null, n(e.InspectionUserName), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "processName", label: "工序", width: "120" }, { default: t(({ row: e }) => [r("span", null, n(e.processName), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量", width: "100" }, { default: t(({ row: e }) => [r("span", null, n(e.quantity), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "createTime", label: "日期", width: "120" }, { default: t(({ row: e }) => [r("span", null, n(e.createTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[U, g.value]]), a(R, { total: l(D), "current-page": l(f).pageNumber, "page-size": l(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(T), onCurrentChange: l(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = Object.freeze(Object.defineProperty({ __proto__: null, default: te }, Symbol.toStringTag, { value: "Module" }));
export {
  te as _,
  re as c,
  ne as d
};
