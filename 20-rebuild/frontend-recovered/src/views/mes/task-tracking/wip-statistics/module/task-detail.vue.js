import { ref as w } from "vue";
import { inject as M } from "vue";
import { computed as G } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as J } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as i } from "vue";
import { withDirectives as z } from "vue";
import { unref as a } from "vue";
import { isRef as O } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { a as X } from "../../../../../modules/wip-statistics-f9d24ea0.js";
import { u as Y, J as Z, o as $, p as ee, ba as te } from "../../../../../shared/runtime.js";
const re = { __name: "task-detail", props: { visible: { type: Boolean, default: false }, taskInfo: { type: Object } }, emits: ["update:visible"], setup(c, { emit: T }) {
  const _ = w(), I = T, v = c, N = M("permission"), { visible: u, handleClose: S } = Y({ emit: I, props: v, field: "visible", showHook: k }), { handleSizeChange: V, handleCurrentChange: j, total: B, setTotalPage: H, queryPage: f } = Z({ fetchHook: k }), { maxHeight: R } = $({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, _), g = w(false), d = w([]), y = G(() => {
    var l;
    return { projectId: (l = v.taskInfo.project) == null ? void 0 : l.id };
  });
  function W(l) {
    return te(l, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  async function k() {
    try {
      d.value = [], g.value = true;
      const { content: l = [], totalElements: s } = await X({ ...y.value, ...f });
      d.value = l.map((p, h) => (p.rowId = h + "" + Math.random(), p)), H(s);
    } catch (l) {
      console.log("获取排产记录记录详情失败", l);
    } finally {
      g.value = false;
    }
  }
  return (l, s) => {
    const p = U, h = b("print-table"), t = F, q = b("common-table"), P = K, D = b("common-drawer"), E = A("permission"), L = Q;
    return x(), C(D, { ref_key: "drawerRef", ref: _, title: "排产记录", modelValue: a(u), "onUpdate:modelValue": s[0] || (s[0] = (o) => O(u) ? u.value = o : null), direction: "rtl", "before-close": a(S), size: "70%" }, { titleAfter: n(() => [e(p, { size: "default", effect: "plain" }, { default: n(() => {
      var o, r;
      return [s[1] || (s[1] = J(" 项目：")), m("span", null, i((o = c.taskInfo.project) == null ? void 0 : o.serialNumber) + "-" + i((r = c.taskInfo.project) == null ? void 0 : r.name), 1)];
    }), _: 1, __: [1] })]), titleRight: n(() => [z(e(h, { "api-key": "mesTaskStatisticsList", params: { ...y.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[E, a(N).print]])]), content: n(() => [z((x(), C(q, { data: d.value, "max-height": a(R) - 100, "show-empty-symbol": false, "row-key": "rowId", style: { width: "100%" }, "show-summary": "", "summary-method": W }, { default: n(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: n(({ row: o }) => {
      var r;
      return [m("span", null, i(o.monomer ? (r = o.monomer) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域" }, { default: n(({ row: o }) => {
      var r;
      return [m("span", null, i(o.area ? (r = o.area) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "名称" }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "netWeight", label: "单净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "grossWeight", label: "单毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalNetWeight", label: "总净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalGrossWeight", label: "总毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "completeTime", label: "排产日期", width: "120" }, { default: n(({ row: o }) => [m("span", null, i(a(ee)(o.completeTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[L, g.value]]), e(P, { total: a(B), "current-page": a(f).pageNumber, "page-size": a(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(V), onCurrentChange: a(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  re as default
};
