import { ref as j } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as w } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as n } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as A } from "vue";
import { createElementVNode as L } from "vue";
import { withDirectives as F } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as r } from "vue";
import { normalizeStyle as M } from "vue";
import { isRef as G } from "vue";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as U } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as W } from "element-plus";
import { l as V, u as X, J as Y, o as Z, G as ee, z as te, p as ae, ba as oe } from "../../../../../shared/runtime.js";
function le(a) {
  return V({ module: "mes", url: "task/process/dull/processV2", method: "get", params: a });
}
function ne(a) {
  return V({ module: "mes", url: "task/process/dull/process/detail/pageV2", method: "get", params: a });
}
const de = { get: le }, ie = { class: "head-container" }, re = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(a, { emit: I }) {
  const S = I, v = j([]), T = j(), s = a, { visible: u, handleClose: B } = X({ emit: S, props: s, field: "visible", showHook: D }), { handleSizeChange: N, handleCurrentChange: Q, total: E, setTotalPage: q, queryPage: g } = Y({ fetchHook: D }), { maxHeight: P } = Z({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], paginate: true }, u);
  async function D() {
    var p, b, i, f, o;
    let d = [];
    try {
      const { content: m = [], totalElements: y } = await ne({ processId: (p = s.detailData.process) == null ? void 0 : p.id, productType: s.detailData.productType, projectId: (i = (b = s.detailData) == null ? void 0 : b.project) == null ? void 0 : i.id, productionLineId: (f = s.detailData.productionLine) == null ? void 0 : f.id, teamId: (o = s.detailData.team) == null ? void 0 : o.id, ...g });
      q(y), d = m;
    } catch (m) {
      console.log("获取任务滞后挺行详情失败", m);
    } finally {
      v.value = d;
    }
  }
  function R(d) {
    return oe(d, { props: ["completeQuantity", "quantity"] });
  }
  return (d, p) => {
    const b = h("print-table"), i = J, f = U, o = $, m = h("common-table"), y = K, H = h("common-drawer"), O = W;
    return w(), _(H, { ref: "drawerRef", title: "滞后详情", "close-on-click-modal": false, "custom-class": "detail-drawer", modelValue: l(u), "onUpdate:modelValue": p[0] || (p[0] = (e) => G(u) ? u.value = e : null), direction: "rtl", "before-close": l(B), size: "80%" }, { titleRight: n(() => {
      var e, k, C, x, z;
      return [l(ee)(a.permission.print) ? (w(), _(b, { key: 0, "api-key": "mesTaskDelayNotifyReport", params: { processId: (e = a.detailData.process) == null ? void 0 : e.id, productType: a.detailData.productType, projectId: (C = (k = a.detailData) == null ? void 0 : k.project) == null ? void 0 : C.id, productionLineId: (x = a.detailData.productionLine) == null ? void 0 : x.id, teamId: (z = a.detailData.team) == null ? void 0 : z.id, ...l(g) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : A("", true)];
    }), content: n(() => [L("div", ie, [F((w(), _(f, { column: 3, border: "" }, { default: n(() => [t(i, { align: "center", "label-class-name": "contractLabel", label: "项目" }, { default: n(() => [c(r(l(te)(a.detailData.project)), 1)]), _: 1 }), t(i, { align: "center", "label-class-name": "contractLabel", label: "车间" }, { default: n(() => {
      var e;
      return [c(r((e = a.detailData.workshop) == null ? void 0 : e.name), 1)];
    }), _: 1 }), t(i, { align: "center", "label-class-name": "contractLabel", label: "班组" }, { default: n(() => {
      var e;
      return [c(r((e = a.detailData.team) == null ? void 0 : e.name), 1)];
    }), _: 1 }), t(i, { align: "center", "label-class-name": "contractLabel", label: "工序" }, { default: n(() => {
      var e;
      return [c(r((e = a.detailData.process) == null ? void 0 : e.name), 1)];
    }), _: 1 }), t(i, { align: "center", "label-class-name": "contractLabel", label: "数量" }, { default: n(() => [c(r(a.detailData.unQuantity), 1)]), _: 1 })]), _: 1 })), [[O, T.value]])]), t(m, { ref: "tableRef", "max-height": l(P), data: v.value, "show-summary": "", "summary-method": R, style: { width: "100%" } }, { default: n(() => [t(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "areaBatch.name", key: "areaBatch.name", label: "批次", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "name", key: "name", label: "名称", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", "min-width": "120", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "length", key: "length", label: "长度", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "material", key: "material", label: "材质", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "任务数", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: n(({ row: e }) => [L("span", { style: M(`color: ${!e.completeQuantity || e.completeQuantity === 0 ? "#f56c6c" : e.completeQuantity < e.quantity ? "#E6A23C" : "#67C23A"}`) }, r(e.completeQuantity), 5)]), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "completeDate", key: "completeDate", label: "完成日期", align: "center" }, { default: n(({ row: e }) => [c(r(l(ae)(e.completeDate, "{y}-{m}-{d}") || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["max-height", "data"]), t(y, { total: l(E), "current-page": l(g).pageNumber, "page-size": l(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(N), onCurrentChange: l(Q) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, pe = Object.freeze(Object.defineProperty({ __proto__: null, default: re }, Symbol.toStringTag, { value: "Module" }));
export {
  re as _,
  de as c,
  pe as d
};
