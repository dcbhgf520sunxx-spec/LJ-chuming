import { ref as w } from "vue";
import { inject as W } from "vue";
import { computed as M } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as C } from "vue";
import { createBlock as k } from "vue";
import { withCtx as i } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as A } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as m } from "vue";
import { withDirectives as z } from "vue";
import { unref as l } from "vue";
import { isRef as G } from "vue";
import { ElTag as J } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as F } from "element-plus";
import { b as K } from "../../../../../modules/wip-statistics-f9d24ea0.js";
import { u as Q, J as X, o as Y } from "../../../../../shared/runtime.js";
const oe = { __name: "process-detail", props: { visible: { type: Boolean, default: false }, processInfo: { type: Object }, processData: { type: Object } }, emits: ["update:visible"], setup(p, { emit: I }) {
  const _ = w(), j = I, c = p, D = W("permission"), { visible: u, handleClose: V } = Q({ emit: j, props: c, field: "visible", showHook: x }), { handleSizeChange: N, handleCurrentChange: P, total: B, setTotalPage: H, queryPage: f } = X({ fetchHook: x }), { maxHeight: R } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, _), d = w(false), g = w([]), y = M(() => {
    var s, a, n;
    return { projectId: (s = c.processData.project) == null ? void 0 : s.id, processId: (a = c.processInfo) == null ? void 0 : a.id, taskTypeEnum: (n = c.processInfo) == null ? void 0 : n.productType };
  });
  async function x() {
    try {
      g.value = [], d.value = true;
      const { content: s = [], totalElements: a } = await K({ ...y.value, ...f });
      g.value = s.map((n, h) => (n.rowId = h + "" + Math.random(), n)), H(a);
    } catch (s) {
      console.log("获取工序在制品统计详情失败", s);
    } finally {
      d.value = false;
    }
  }
  return (s, a) => {
    const n = J, h = b("print-table"), t = U, S = b("common-table"), T = $, E = b("common-drawer"), q = O("permission"), L = F;
    return C(), k(E, { ref_key: "drawerRef", ref: _, title: `${p.processInfo.name}工序在制品统计`, modelValue: l(u), "onUpdate:modelValue": a[0] || (a[0] = (o) => G(u) ? u.value = o : null), direction: "rtl", "before-close": l(V), size: "70%" }, { titleAfter: i(() => [e(n, { size: "default", effect: "plain" }, { default: i(() => {
      var o, r;
      return [a[1] || (a[1] = A(" 项目：")), v("span", null, m((o = p.processData.project) == null ? void 0 : o.serialNumber) + "-" + m((r = p.processData.project) == null ? void 0 : r.name), 1)];
    }), _: 1, __: [1] })]), titleRight: i(() => [z(e(h, { "api-key": "mesProcessStatisticsList", params: { ...y.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[q, l(D).print]])]), content: i(() => [z((C(), k(S, { data: g.value, "show-empty-symbol": false, "max-height": l(R) - 100, "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: i(({ row: o }) => {
      var r;
      return [v("span", null, m(o.monomer ? (r = o.monomer) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域" }, { default: i(({ row: o }) => {
      var r;
      return [v("span", null, m(o.area ? (r = o.area) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "名称" }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "netWeight", label: "单净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "grossWeight", label: "单毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalNetWeight", label: "总净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalGrossWeight", label: "总毛重（kg）" })]), _: 1 }, 8, ["data", "max-height"])), [[L, d.value]]), e(T, { total: l(B), "current-page": l(f).pageNumber, "page-size": l(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(N), onCurrentChange: l(P) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  oe as default
};
