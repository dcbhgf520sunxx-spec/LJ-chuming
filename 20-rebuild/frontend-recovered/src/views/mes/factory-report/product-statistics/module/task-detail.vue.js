import { ref as b } from "vue";
import { inject as M } from "vue";
import { computed as A } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as J } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as I } from "vue";
import { unref as o } from "vue";
import { isRef as O } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { a as X } from "../../../../../modules/product-statistics-2cabaaff.js";
import { u as Y, J as Z, o as $, p as ee, ba as te } from "../../../../../shared/runtime.js";
const re = { __name: "task-detail", props: { visible: { type: Boolean, default: false }, taskInfo: { type: Object }, workshopId: { type: Number }, queryDate: { type: Array, default: () => [] } }, emits: ["update:visible"], setup(c, { emit: z }) {
  const v = b(), D = z, i = c, N = M("permission"), { visible: d, handleClose: T } = Y({ emit: D, props: i, field: "visible", showHook: k }), { handleSizeChange: q, handleCurrentChange: S, total: V, setTotalPage: j, queryPage: f } = Z({ fetchHook: k }), { maxHeight: B } = $({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, v), g = b(false), h = b([]), y = A(() => {
    var l;
    return { projectId: (l = i.taskInfo.project) == null ? void 0 : l.id, workshopId: i.workshopId, startDate: i.queryDate[0], endDate: i.queryDate[1] };
  });
  function H(l) {
    return te(l, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  async function k() {
    try {
      h.value = [], g.value = true;
      const { content: l = [], totalElements: s } = await X({ ...y.value, ...f });
      h.value = l.map((m, w) => (m.rowId = w + "" + Math.random(), m)), j(s);
    } catch (l) {
      console.log("获取任务记录详情失败", l);
    } finally {
      g.value = false;
    }
  }
  return (l, s) => {
    const m = U, w = _("print-table"), t = F, R = _("common-table"), W = K, P = _("common-drawer"), E = G("permission"), L = Q;
    return x(), C(P, { ref_key: "drawerRef", ref: v, title: "任务记录", modelValue: o(d), "onUpdate:modelValue": s[0] || (s[0] = (a) => O(d) ? d.value = a : null), direction: "rtl", "before-close": o(T), size: "70%" }, { titleAfter: n(() => [e(m, { size: "default", effect: "plain" }, { default: n(() => {
      var a, r;
      return [s[1] || (s[1] = J(" 项目：")), u("span", null, p((a = c.taskInfo.project) == null ? void 0 : a.serialNumber) + "-" + p((r = c.taskInfo.project) == null ? void 0 : r.name), 1)];
    }), _: 1, __: [1] })]), titleRight: n(() => [I(e(w, { "api-key": "mesTaskStatisticsList", params: { ...y.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[E, o(N).print]])]), content: n(() => [I((x(), C(R, { data: h.value, "max-height": o(B) - 100, "show-empty-symbol": false, "row-key": "rowId", style: { width: "100%" }, "show-summary": "", "summary-method": H }, { default: n(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: n(({ row: a }) => {
      var r;
      return [u("span", null, p(a.monomer ? (r = a.monomer) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域" }, { default: n(({ row: a }) => {
      var r;
      return [u("span", null, p(a.area ? (r = a.area) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "名称" }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "netWeight", label: "单净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "grossWeight", label: "单毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalNetWeight", label: "总净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalGrossWeight", label: "总毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "completeTime", label: "排产日期", width: "120" }, { default: n(({ row: a }) => [u("span", null, p(o(ee)(a.completeTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[L, g.value]]), e(W, { total: o(V), "current-page": o(f).pageNumber, "page-size": o(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(q), onCurrentChange: o(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  re as default
};
