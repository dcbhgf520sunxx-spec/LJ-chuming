import { ref as w } from "vue";
import { inject as W } from "vue";
import { computed as M } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as i } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as A } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as m } from "vue";
import { withDirectives as I } from "vue";
import { unref as r } from "vue";
import { isRef as G } from "vue";
import { ElTag as J } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as F } from "element-plus";
import { b as K } from "../../../../../modules/product-statistics-2cabaaff.js";
import { u as Q, J as X, o as Y } from "../../../../../shared/runtime.js";
const oe = { __name: "process-detail", props: { visible: { type: Boolean, default: false }, processInfo: { type: Object }, processData: { type: Object }, workshopId: { type: Number } }, emits: ["update:visible"], setup(c, { emit: z }) {
  const _ = w(), j = z, p = c, D = W("permission"), { visible: u, handleClose: N } = Q({ emit: j, props: p, field: "visible", showHook: k }), { handleSizeChange: V, handleCurrentChange: P, total: B, setTotalPage: H, queryPage: d } = X({ fetchHook: k }), { maxHeight: R } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, _), f = w(false), g = w([]), y = M(() => {
    var s, a, n;
    return { projectId: (s = p.processData.project) == null ? void 0 : s.id, processId: (a = p.processInfo) == null ? void 0 : a.id, taskTypeEnum: (n = p.processInfo) == null ? void 0 : n.productType, workshopId: p.workshopId };
  });
  async function k() {
    try {
      g.value = [], f.value = true;
      const { content: s = [], totalElements: a } = await K({ ...y.value, ...d });
      g.value = s.map((n, h) => (n.rowId = h + "" + Math.random(), n)), H(a);
    } catch (s) {
      console.log("获取工序在制品统计详情失败", s);
    } finally {
      f.value = false;
    }
  }
  return (s, a) => {
    const n = J, h = b("print-table"), t = U, S = b("common-table"), T = $, E = b("common-drawer"), q = O("permission"), L = F;
    return x(), C(E, { ref_key: "drawerRef", ref: _, title: `${c.processInfo.name} 工序在制品统计`, modelValue: r(u), "onUpdate:modelValue": a[0] || (a[0] = (o) => G(u) ? u.value = o : null), direction: "rtl", "before-close": r(N), size: "70%" }, { titleAfter: i(() => [e(n, { size: "default", effect: "plain" }, { default: i(() => {
      var o, l;
      return [a[1] || (a[1] = A(" 项目：")), v("span", null, m((o = c.processData.project) == null ? void 0 : o.serialNumber) + "-" + m((l = c.processData.project) == null ? void 0 : l.name), 1)];
    }), _: 1, __: [1] })]), titleRight: i(() => [I(e(h, { "api-key": "mesProcessStatisticsList", params: { ...y.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[q, r(D).print]])]), content: i(() => [I((x(), C(S, { data: g.value, "show-empty-symbol": false, "max-height": r(R) - 100, "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: i(({ row: o }) => {
      var l;
      return [v("span", null, m(o.monomer ? (l = o.monomer) == null ? void 0 : l.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域" }, { default: i(({ row: o }) => {
      var l;
      return [v("span", null, m(o.area ? (l = o.area) == null ? void 0 : l.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "名称" }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "netWeight", label: "单净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "grossWeight", label: "单毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalNetWeight", label: "总净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalGrossWeight", label: "总毛重（kg）" })]), _: 1 }, 8, ["data", "max-height"])), [[L, f.value]]), e(T, { total: r(B), "current-page": r(d).pageNumber, "page-size": r(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(V), onCurrentChange: r(P) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  oe as default
};
