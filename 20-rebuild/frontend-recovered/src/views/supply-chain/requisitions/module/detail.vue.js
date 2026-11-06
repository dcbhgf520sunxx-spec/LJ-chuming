import { inject as j } from "vue";
import { ref as b } from "vue";
import { computed as L } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as m } from "vue";
import { createBlock as d } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as x } from "vue";
import { withDirectives as M } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as T } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { _ as z, jX as O, gt as A, o as F, j_ as P, cO as Y, am as X, wc as w, jl as $, iX as G, i as K, z as W, wp as J, jG as Q, jH as Z, k5 as ee, ba as ae, jN as te } from "../../../../shared/runtime.js";
const ie = { class: "print-wrap" }, oe = { class: "table-header" }, le = { __name: "detail", setup(se) {
  const C = j("permission"), y = b([["arrivalTime", ["parse-time", "{y}-{m}-{d}"]]]), k = b([...O, ...y.value]), V = b(), { CRUD: D, crud: _, detail: o } = A(), { maxHeight: v } = F({ mainBox: ".requisitions-application-record-detail", extraBox: [".el-drawer__header", ".table-header", ".table-remark"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => L(() => !_.detailLoading)), f = L(() => !!(o.materialType & P.MANUFACTURED.V));
  D.HOOK.beforeDetailLoaded = async (g, n) => {
    f.value ? n.detailList.forEach((l) => {
      l.mete = G(l.quantity * l.netWeight, 2);
    }) : (await Y(n.detailList), n.detailList.forEach((l) => {
      l.basicClass === X.STEEL_COIL.V && (l.measureUnit = "米", l.measurePrecision = 3), l.materialInventoryId ? l.requisitionMode = w.USE_INVENTORY.V : l.requisitionMode = w.PURCHASE.V;
    }), n.detailList = await $(n.detailList));
  };
  function I(g) {
    return ae(g, { props: [["quantity", 3], ["mete", te.weight.precision]] });
  }
  return (g, n) => {
    const l = h("print-table"), p = H, R = h("table-cell-tag"), i = U, E = h("common-table"), q = h("common-drawer"), B = S("permission");
    return m(), d(q, { ref_key: "drawerRef", ref: V, "before-close": e(_).cancelDetail, "content-loading": e(_).detailLoading, "show-close": true, visible: e(_).detailVisible, "custom-class": "requisitions-application-record-detail", size: "80%", title: "申购详情" }, { titleRight: s(() => {
      var t, r, N;
      return [x("div", ie, [M(a(l, { "api-key": f.value ? "scmManufRequisitionsDetail" : "scmRequisitionsDetail", params: f.value ? { id: (t = e(o)) == null ? void 0 : t.id } : (r = e(o)) == null ? void 0 : r.id, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[B, (N = e(C)) == null ? void 0 : N.print]])])];
    }), content: s(() => [x("div", oe, [a(p, { effect: "plain", size: "large" }, { default: s(() => {
      var t;
      return [u("申购编号：" + c((t = e(o)) == null ? void 0 : t.serialNumber), 1)];
    }), _: 1 }), e(K)(e(o).project) ? (m(), d(p, { key: 0, effect: "plain", size: "large" }, { default: s(() => [u(" 申购项目：" + c(e(W)(e(o).project)), 1)]), _: 1 })) : T("", true), a(p, { effect: "plain", size: "large" }, { default: s(() => {
      var t, r;
      return [u("备料类型：" + c((r = e(J).VL) == null ? void 0 : r[(t = e(o)) == null ? void 0 : t.type]), 1)];
    }), _: 1 }), a(p, { effect: "plain", size: "large", type: "success" }, { default: s(() => {
      var t;
      return [u("申购人：" + c((t = e(o)) == null ? void 0 : t.applicantName), 1)];
    }), _: 1 }), e(o).boolInitiateApprove ? (m(), d(p, { key: 1, effect: "plain", size: "large", type: "success" }, { default: s(() => {
      var t;
      return [u(" 审批流程：" + c(((t = e(o)) == null ? void 0 : t.approveInfoName) || "-"), 1)];
    }), _: 1 })) : T("", true)]), f.value ? (m(), d(E, { key: 1, data: e(o).detailList, "data-format": y.value, "max-height": e(v), "show-summary": "" }, { default: s(() => [a(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), a(i, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "数量", prop: "quantity", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "重量(kg)", prop: "mete", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "到厂日期", prop: "arrivalTime", "show-overflow-tooltip": "", width: "120px" })]), _: 1 }, 8, ["data", "data-format", "max-height"])) : (m(), d(E, { key: 0, data: e(o).detailList, "data-format": k.value, "max-height": e(v), "summary-method": I, "show-summary": "" }, { default: s(() => [a(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: s(({ row: t, $index: r }) => [a(R, { name: e(w).USE_INVENTORY.L, show: t.requisitionMode === e(w).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), x("span", null, c(r + 1), 1)]), _: 1 }), a(Q, { showIndex: false, fixed: "left" }), a(Z), a(ee), a(i, { align: "center", label: "到厂日期", prop: "arrivalTime", "show-overflow-tooltip": "", width: "120px" })]), _: 1 }, 8, ["data", "data-format", "max-height"]))]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, ce = z(le, [["__scopeId", "data-v-04eb0a5f"]]);
export {
  ce as default
};
