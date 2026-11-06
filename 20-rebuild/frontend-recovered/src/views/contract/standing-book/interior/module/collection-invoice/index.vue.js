import { ref as f } from "vue";
import { computed as D } from "vue";
import { inject as Q } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as d } from "vue";
import { createBlock as m } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as s } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as v } from "vue";
import { toDisplayString as _ } from "vue";
import { isRef as W } from "vue";
import { ElRadioButton as Y } from "element-plus";
import { ElRadioGroup as Z } from "element-plus";
import { ElDescriptionsItem as ee } from "element-plus";
import { ElDescriptions as ae } from "element-plus";
import { _ as te, u as oe, l6 as le, ec as R, l7 as ne, bD as ie, G as q, eb as z } from "../../../../../../shared/runtime.js";
import se from "./collection.vue.js";
import ce from "./invoice.vue.js";
import { u as A } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { X as N } from "../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../modules/useTableHeight-90797a0b.js";
const re = { class: "head" }, ue = { class: "print" }, de = { class: "table-container" }, me = { __name: "index", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(B, { emit: H }) {
  const P = B, L = H, { visible: b, handleClose: M } = oe({ emit: L, props: P, field: "visible", showHook: G }), S = f(), n = f(), I = D(() => n.value === "collection"), { projectId: p, projectName: U, itemData: c } = Q("common");
  function G() {
    n.value = "collection", Promise.all([C(), T()]);
  }
  const { requestData: y, total: k } = A(), w = f([]);
  async function C(r) {
    try {
      const { totalElements: a, content: i } = await le({ projectId: p.value, ...y });
      k.value = a, w.value = R(i);
    } catch (a) {
      console.error("获取收款记录失败:fetchCollectionData", a);
    }
  }
  const g = f([]), { requestData: $, total: h } = A();
  async function T() {
    try {
      const { content: r, totalElements: a } = await ne({ projectId: p.value, ...y });
      g.value = R(r), g.value.forEach((i) => {
        i.invoiceTypeName = ie.VL[i.invoiceType];
      }), h.value = a;
    } catch (r) {
      console.error("获取开票信息失败:fetchInvoiceData", r);
    }
  }
  const F = D(() => n.value === "collection" ? "54%" : "65%"), X = D(() => c.value.contractAmount || c.value.settlementAmount);
  return (r, a) => {
    const i = Y, J = Z, x = j("print-table"), u = ee, K = ae, O = j("common-drawer");
    return d(), m(O, { ref_key: "drawerRef", ref: S, modelValue: e(b), "onUpdate:modelValue": a[1] || (a[1] = (t) => W(b) ? b.value = t : null), "append-to-body": true, "before-close": e(M), size: F.value, title: "项目收款与开票" }, { content: o(() => [V("div", re, [l(J, { modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => n.value = t), class: "box-container", size: "default" }, { default: o(() => [l(i, { value: "collection" }, { default: o(() => a[2] || (a[2] = [s("收款信息")])), _: 1, __: [2] }), l(i, { value: "invoice" }, { default: o(() => a[3] || (a[3] = [s("开票信息")])), _: 1, __: [3] })]), _: 1 }, 8, ["modelValue"]), V("div", ue, [n.value === "collection" && e(q)(e(N).print) ? (d(), m(x, { key: 0, params: e(p), "api-key": "collectionInfoV2", class: "filter-item animate__animated animate__fadeIn animate__faster", size: "default", type: "warning" }, null, 8, ["params"])) : v("", true), n.value === "invoice" && e(q)(e(N).print) ? (d(), m(x, { key: 1, params: e(p), "api-key": "invoiceInfoV2", class: "filter-item animate__animated animate__fadeIn animate__faster", size: "default", type: "warning" }, null, 8, ["params"])) : v("", true)])]), l(K, { column: 3, border: "", class: "box-container", size: "large" }, { default: o(() => [l(u, { label: "项目", "label-align": "center" }, { default: o(() => [s(_(e(U)), 1)]), _: 1 }), l(u, { label: "项目经理", "label-align": "center" }, { default: o(() => {
      var t, E;
      return [s(_((E = (t = e(c)) == null ? void 0 : t.project) == null ? void 0 : E.projectManagerName), 1)];
    }), _: 1 }), l(u, { label: "合同/结算额", "label-align": "center" }, { default: o(() => [s(_(X.value), 1)]), _: 1 }), l(u, { label: "累计收款", "label-align": "center" }, { default: o(() => {
      var t;
      return [s(_((t = e(c)) == null ? void 0 : t.collectionAmountSum), 1)];
    }), _: 1 }), l(u, { label: "累计开票", "label-align": "center" }, { default: o(() => {
      var t;
      return [s(_((t = e(c)) == null ? void 0 : t.invoiceAmountSum), 1)];
    }), _: 1 })]), _: 1 }), V("div", de, [I.value ? (d(), m(se, { key: 0, data: w.value }, { default: o(() => [l(z, { "request-data": e(y), total: e(k), onHandleChange: C }, null, 8, ["request-data", "total"])]), _: 1 }, 8, ["data"])) : v("", true), I.value ? v("", true) : (d(), m(ce, { key: 1, data: g.value }, { default: o(() => [l(z, { "request-data": e($), total: e(h), onHandleChange: T }, null, 8, ["request-data", "total"])]), _: 1 }, 8, ["data"]))])]), _: 1 }, 8, ["modelValue", "before-close", "size"]);
  };
} }, Ve = te(me, [["__scopeId", "data-v-7b6a56e6"]]);
export {
  Ve as default
};
