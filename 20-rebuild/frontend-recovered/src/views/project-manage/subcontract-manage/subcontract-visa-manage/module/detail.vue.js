import { ref as k } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { unref as r } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as p } from "vue";
import { withDirectives as N } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as o } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as B } from "vue";
import { renderList as U } from "vue";
import { isRef as F } from "vue";
import { ElNotification as L } from "element-plus";
import { ElTag as O } from "element-plus";
import { ElFormItem as $ } from "element-plus";
import { ElImage as J } from "element-plus";
import { ElDatePicker as q } from "element-plus";
import { ElForm as G } from "element-plus";
import { vLoading as H } from "element-plus";
import { l as V, _ as M, u as K, c3 as c, G as Q, L as W, cy as X } from "../../../../../shared/runtime.js";
function Y(t) {
  return V({ module: "project", url: "sub-visa", method: "get", params: t });
}
function Z(t) {
  return V({ module: "project", url: "sub-visa/check", method: "put", data: t });
}
function ee(t) {
  return V({ module: "project", url: `sub-visa/print/${t}`, method: "get", responseType: "blob" });
}
const me = { get: Y };
const te = { style: { display: "flex" } }, ae = { style: { display: "flex" } }, le = { class: "imgs-box" }, se = { style: { display: "flex" } }, oe = { key: 1 }, ne = { key: 1 }, ue = { key: 0, style: { display: "flex" } }, ie = { __name: "detail", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: "detail" } }, emits: ["success", "update:modelValue"], setup(t, { emit: j }) {
  const T = j, _ = t, { visible: b, handleClose: S } = K({ emit: T, props: _ }), m = k(false), g = k(), R = k();
  async function x(h) {
    m.value = true;
    const l = h === c.PASS.V ? "通过" : "驳回";
    try {
      const f = { auditStatus: h, id: _.currentRow.id, approverId: g.value, approveTime: R.value };
      await Z(f), m.value = false, L({ title: "审核" + l, type: "success" }), T("success"), S();
    } catch (f) {
      m.value = false, console.log("分包签证审核失败", f);
    }
  }
  return (h, l) => {
    const f = O, E = D("common-button"), n = $, z = J, A = q, I = G, P = D("common-drawer"), C = H;
    return u(), d(P, { "append-to-body": "", "close-on-click-modal": false, "before-close": r(S), modelValue: r(b), "onUpdate:modelValue": l[4] || (l[4] = (e) => F(b) ? b.value = e : null), title: t.showType === "audit" ? "分包签证审核" : "分包签证详情", "wrapper-closable": false, size: "800px" }, { titleAfter: a(() => [t.currentRow.auditStatus ? (u(), d(f, { key: 0, size: "large", type: t.currentRow.auditStatus === r(c).REJECT.V ? "info" : t.currentRow.auditStatus === r(c).PASS.V ? "success" : "warning" }, { default: a(() => [w(i(t.currentRow.auditStatus === r(c).REJECT.V ? "已驳回" : t.currentRow.auditStatus === r(c).PASS.V ? "已通过" : "审核中"), 1)]), _: 1 }, 8, ["type"])) : p("", true)]), titleRight: a(() => [r(Q)(t.permission.download) ? (u(), d(W, { key: 0, params: t.currentRow.id, fn: r(ee) }, { default: a(() => l[5] || (l[5] = [w("下载签证单")])), _: 1, __: [5] }, 8, ["params", "fn"])) : p("", true), t.showType === "audit" ? N((u(), d(E, { key: 1, size: "default", type: "info", onClick: l[0] || (l[0] = (e) => x(r(c).REJECT.V)) }, { default: a(() => l[6] || (l[6] = [w("驳回")])), _: 1, __: [6] })), [[C, m.value]]) : p("", true), t.showType === "audit" ? N((u(), d(E, { key: 2, size: "default", type: "success", onClick: l[1] || (l[1] = (e) => x(r(c).PASS.V)) }, { default: a(() => l[7] || (l[7] = [w("通过")])), _: 1, __: [7] })), [[C, m.value]]) : p("", true)]), content: a(() => [s(I, { ref: "formRef", size: "default", "label-width": "130px" }, { default: a(() => [s(n, { label: "所属项目" }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.project), 1)];
    }), _: 1 }), o("div", te, [s(n, { label: "签证单位", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.supplierName), 1)];
    }), _: 1 }), s(n, { label: "分类", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.subcontractClassName), 1)];
    }), _: 1 })]), o("div", ae, [s(n, { label: "申请日期", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.applyDate), 1)];
    }), _: 1 }), s(n, { label: "签证原因", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.visaReasonName), 1)];
    }), _: 1 })]), s(n, { label: "申请签证额" }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.visaAmount), 1)];
    }), _: 1 }), s(n, { label: "描述" }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.remark), 1)];
    }), _: 1 }), s(n, { label: "图片" }, { default: a(() => [o("div", le, [(u(true), v(B, null, U(t.currentRow.attachments, (e) => (u(), d(z, { "preview-src-list": t.currentRow.imgSrc, "initial-index": 1, key: e.id, src: e.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 }), o("div", se, [s(n, { label: "审批人", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [t.showType === "audit" ? (u(), d(X, { key: 0, modelValue: g.value, "onUpdate:modelValue": l[2] || (l[2] = (y) => g.value = y), filterable: "", "collapse-tags": false, clearable: "", "show-all-levels": "", style: { width: "220px" }, placeholder: "审批人" }, null, 8, ["modelValue"])) : (u(), v("span", oe, i((e = t.currentRow) == null ? void 0 : e.approverName), 1))];
    }), _: 1 }), s(n, { label: "日期", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [t.showType === "audit" ? (u(), d(A, { key: 0, modelValue: R.value, "onUpdate:modelValue": l[3] || (l[3] = (y) => R.value = y), type: "date", "value-format": "x", placeholder: "审批日期", style: { width: "260px" }, disabledDate: (y) => y.getTime() > (/* @__PURE__ */ new Date()).getTime() }, null, 8, ["modelValue", "disabledDate"])) : (u(), v("span", ne, i((e = t.currentRow) == null ? void 0 : e.approveTime), 1))];
    }), _: 1 })]), t.showType === "detail" ? (u(), v("div", ue, [s(n, { label: "审核人", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.auditUserName), 1)];
    }), _: 1 }), s(n, { label: "日期", style: { width: "50%" } }, { default: a(() => {
      var e;
      return [o("span", null, i((e = t.currentRow) == null ? void 0 : e.auditTime), 1)];
    }), _: 1 })])) : p("", true)]), _: 1 }, 512)]), _: 1 }, 8, ["before-close", "modelValue", "title"]);
  };
} }, re = M(ie, [["__scopeId", "data-v-e66132e2"]]), fe = Object.freeze(Object.defineProperty({ __proto__: null, default: re }, Symbol.toStringTag, { value: "Module" }));
export {
  me as c,
  fe as d,
  re as m
};
