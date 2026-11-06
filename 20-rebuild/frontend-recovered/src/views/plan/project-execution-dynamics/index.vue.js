import { ref as p } from "vue";
import { computed as D } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as $ } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as t } from "vue";
import { unref as s } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as k } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as g } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { createCommentVNode as T } from "vue";
import { nextTick as q } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElProgress as E } from "element-plus";
import { vLoading as S } from "element-plus";
import { _ as B, x as F, o as H, iG as I, P as A } from "../../../shared/runtime.js";
import { k as L } from "../../../modules/project-execution-dynamics-721a6cb4.js";
import M from "./module/header.vue.js";
import { k as U } from "../../../modules/plan-d12d7ccf.js";
import G from "./detail/deepen-detail.vue.js";
import z from "./detail/scheduling-detail.vue.js";
import J from "./detail/produced-detail.vue.js";
import K from "./detail/not-produced-detail.vue.js";
import O from "./detail/delivery-detail.vue.js";
const Q = { class: "app-container" }, X = { class: "head-container" }, Y = ["onClick"], Z = ["onClick"], ee = ["onClick"], te = ["onClick"], oe = { __name: "index", setup(re) {
  const f = p(), h = p(false), v = p(), W = p(), { crud: m } = F({ title: "项目执行动态", sort: [], permission: { get: U.get }, crudApi: { ...L }, hasPagination: true }, f), { maxHeight: y } = H({ paginate: true });
  function l(a) {
    return () => a.toFixed(2) + "吨";
  }
  function c(a, i) {
    return ((a / i || 0) * 100).toFixed(2);
  }
  function u(a, i) {
    v.value = a, W.value = i, q(() => {
      h.value = true;
    });
  }
  const x = D(() => {
    switch (W.value) {
      case "deepenWeight":
        return G;
      case "schedulingWeight":
        return z;
      case "producedWeight":
        return J;
      case "notProducedWeight":
        return K;
      case "deliveryWeight":
        return O;
      default:
        return null;
    }
  });
  return (a, i) => {
    const o = R, d = E, b = V("common-table"), C = A, P = S;
    return _(), $("div", Q, [r("div", X, [t(s(M))]), j((_(), k(b, { ref_key: "tableRef", ref: f, data: s(m).data, "empty-text": s(m).emptyText, "max-height": s(y), style: { width: "100%" } }, { default: n(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { key: "projectInfo", prop: "projectInfo", "show-overflow-tooltip": "", label: "结构形式", align: "center", width: "140px" }, { default: n((e) => [r("span", null, g(s(I).VL[e.row.structureType]), 1)]), _: 1 }), t(o, { key: "projectShortName", prop: "projectShortName", "show-overflow-tooltip": "", label: "项目", align: "center", width: "260px" }, { default: n((e) => [r("span", null, g(e.row.projectSerialNumber) + " " + g(e.row.projectShortName || "-"), 1)]), _: 1 }), t(o, { key: "contractWeight", prop: "contractWeight", "show-overflow-tooltip": "", label: "合同量（吨）", align: "center", width: "120px" }, { default: n((e) => [r("span", null, g(e.row.contractWeight.toFixed(2) ?? "-"), 1)]), _: 1 }), t(o, { align: "center", key: "deepenWeight", prop: "deepenWeight", "show-overflow-tooltip": "", label: "深化量" }, { default: n((e) => [r("span", null, [t(d, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: c(e.row.deepenWeight, e.row.contractWeight), format: l(e.row.deepenWeight), status: e.$index % 2 === 0 ? "success" : "warning" }, null, 8, ["percentage", "format", "status"])])]), _: 1 }), t(o, { align: "center", key: "schedulingWeight", prop: "schedulingWeight", "show-overflow-tooltip": "", label: "排产量" }, { default: n((e) => [r("span", { class: "progress", onClick: (w) => u(e.row, "schedulingWeight") }, [t(d, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: c(e.row.schedulingWeight, e.row.deepenWeight), format: l(e.row.schedulingWeight), status: e.$index % 2 === 0 ? "success" : "warning" }, null, 8, ["percentage", "format", "status"])], 8, Y)]), _: 1 }), t(o, { align: "center", key: "producedWeight", prop: "producedWeight", "show-overflow-tooltip": "", label: "已生产" }, { default: n((e) => [r("span", { class: "progress", onClick: (w) => u(e.row, "producedWeight") }, [t(d, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: c(e.row.producedWeight, e.row.deepenWeight), format: l(e.row.producedWeight, "producedWeight"), status: e.$index % 2 === 0 ? "success" : "warning" }, null, 8, ["percentage", "format", "status"])], 8, Z)]), _: 1 }), t(o, { align: "center", key: "notProducedWeight", prop: "notProducedWeight", "show-overflow-tooltip": "", label: "未生产" }, { default: n((e) => [r("span", { class: "progress", onClick: (w) => u(e.row, "notProducedWeight") }, [t(d, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: c(e.row.notProducedWeight, e.row.deepenWeight), format: l(e.row.notProducedWeight), status: e.$index % 2 === 0 ? "success" : "warning" }, null, 8, ["percentage", "format", "status"])], 8, ee)]), _: 1 }), t(o, { align: "center", key: "deliveryWeight", prop: "deliveryWeight", "show-overflow-tooltip": "", label: "发货量" }, { default: n((e) => [r("span", { class: "progress", onClick: (w) => u(e.row, "deliveryWeight") }, [t(d, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: c(e.row.deliveryWeight, e.row.deepenWeight), format: l(e.row.deliveryWeight), status: e.$index % 2 === 0 ? "success" : "warning" }, null, 8, ["percentage", "format", "status"])], 8, te)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[P, s(m).loading]]), x.value ? (_(), k(N(x.value), { key: 0, modelValue: h.value, "onUpdate:modelValue": i[0] || (i[0] = (e) => h.value = e), currentRow: v.value }, null, 8, ["modelValue", "currentRow"])) : T("", true), t(C)]);
  };
} }, me = B(oe, [["__scopeId", "data-v-c14e37b4"]]);
export {
  me as default
};
