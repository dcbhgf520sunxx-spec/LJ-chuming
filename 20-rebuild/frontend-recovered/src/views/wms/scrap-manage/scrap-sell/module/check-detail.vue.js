import { ref as p } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as s } from "vue";
import { createElementVNode as u } from "vue";
import { createElementBlock as S } from "vue";
import { unref as E } from "vue";
import { isRef as M } from "vue";
import { ElDescriptionsItem as P } from "element-plus";
import { ElDescriptions as H } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElInputNumber as $ } from "element-plus";
import { ElInput as q } from "element-plus";
import { u as A } from "../../../../../shared/runtime.js";
import { a as G, b as C } from "../../../../../modules/scrap-sell-e306ced6.js";
const K = { style: { display: "flex", "flex-direction": "column", "align-items": "center" } }, Q = { key: 1 }, X = { key: 1 }, Y = { style: { "margin-top": "20px", display: "flex", "align-items": "center" } }, Z = { style: { "margin-top": "20px", display: "flex", "align-items": "center" } }, le = { __name: "check-detail", props: { modelValue: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(B, { emit: U }) {
  const i = B, k = U, { visible: w, handleClose: V } = A({ props: i, emit: k, showHook: z }), R = { branchCompanyName: void 0, contractWasteId: void 0, creatorRemark: void 0, id: void 0, plateNumber: void 0, saleDate: (/* @__PURE__ */ new Date()).getTime(), contractNumber: void 0, wasteSaleDetailList: [] }, d = p(JSON.parse(JSON.stringify(R))), f = p([]), b = p(), y = p(), x = p(), T = p(true);
  async function z() {
    y.value = i.rowData.auditorRemark, f.value = [], console.log(i.rowData), d.value = i.rowData, x.value = i.rowData.creatorRemark, i.rowData.wasteSaleDetailList.forEach((t) => {
      t != null && t.id && f.value.push(JSON.parse(JSON.stringify(t)));
    });
    try {
      b.value = await G(), console.log(b.value);
    } catch (t) {
      console.log(t);
    }
  }
  async function I() {
    const t = {};
    t.id = i.rowData.id, t.auditorRemark = y.value, t.auditStatusEnum = 2, t.wasteSaleDetailList = f.value.map((e) => {
      const o = {};
      return o.amount = e.amount, o.id = e.id, o.price = e.price, o.remark = e.remark, o;
    });
    try {
      await C(t), k("success"), V();
    } catch (e) {
      console.log(e, "审核废料出售");
    }
  }
  function j(t) {
    t.amount = t.saleMete * t.price;
  }
  async function L() {
    const t = {};
    t.id = i.rowData.id, t.auditorRemark = y.value, t.auditStatusEnum = 4, t.wasteSaleDetailList = f.value.map((e) => {
      const o = {};
      return o.amount = e.amount, o.id = e.id, o.price = e.price, o.remark = e.remark, o;
    });
    try {
      await C(t), k("success"), V();
    } catch (e) {
      console.log(e, "驳回废料出售");
    }
  }
  return (t, e) => {
    const o = D("common-button"), m = P, O = H, c = W, v = $, F = D("common-table"), N = q, J = D("common-drawer");
    return _(), h(J, { modelValue: E(w), "onUpdate:modelValue": e[2] || (e[2] = (a) => M(w) ? w.value = a : null), "before-close": E(V), size: "70%", title: "废料出售审核" }, { titleRight: n(() => [l(o, { type: "success", size: "default", onClick: I, disabled: i.rowData.auditStatusEnum !== 1 }, { default: n(() => e[3] || (e[3] = [r("通过")])), _: 1, __: [3] }, 8, ["disabled"]), l(o, { type: "danger", size: "default", onClick: L, disabled: i.rowData.auditStatusEnum !== 1 }, { default: n(() => e[4] || (e[4] = [r("驳回")])), _: 1, __: [4] }, 8, ["disabled"])]), content: n(() => [l(O, { column: 2, border: "", style: { "margin-bottom": "20px" } }, { default: n(() => [l(m, { label: "创建日期" }, { default: n(() => {
      var a;
      return [r(s((a = d.value) == null ? void 0 : a.createTime), 1)];
    }), _: 1 }), l(m, { label: "创建人" }, { default: n(() => [r(s(d.value.createUserName), 1)]), _: 1 }), l(m, { label: "出售单位" }, { default: n(() => [r(s(d.value.branchCompanyName), 1)]), _: 1 }), l(m, { label: "购买单位" }, { default: n(() => [r(s(d.value.purchaser), 1)]), _: 1 }), l(m, { label: "合同编号" }, { default: n(() => [r(s(d.value.serialNumber), 1)]), _: 1 }), l(m, { label: "车牌/船牌号" }, { default: n(() => [r(s(d.value.plateNumber), 1)]), _: 1 })]), _: 1 }), u("div", K, [l(F, { data: f.value, returnSourceData: "" }, { default: n(() => [l(c, { label: "序号", align: "center", width: "55", type: "index" }), l(c, { label: "类型", align: "center", width: "150" }, { default: n(({ row: a }) => [u("span", null, s(a.wasteClassificationName), 1)]), _: 1 }), l(c, { label: "核算单位", align: "center", width: "80" }, { default: n(({ row: a }) => [u("span", null, s(a.measureUnit), 1)]), _: 1 }), l(c, { label: "数量", align: "center", width: "100" }, { default: n(({ row: a }) => [u("span", null, s(a.saleMete), 1)]), _: 1 }), l(c, { label: "单价", align: "center", width: "125" }, { default: n(({ row: a }) => [b.value !== 1 || !a.price ? (_(), h(v, { key: 0, modelValue: a.price, "onUpdate:modelValue": (g) => a.price = g, controls: false, step: 0.01, max: 999999999e-2, precision: 2, onBlur: (g) => j(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])) : (_(), S("span", Q, s(a.price), 1))]), _: 1 }), l(c, { label: "金额", align: "center", width: "125" }, { default: n(({ row: a }) => [b.value !== 1 || !a.amount ? (_(), h(v, { key: 0, modelValue: a.amount, "onUpdate:modelValue": (g) => a.amount = g, controls: false, step: 0.01, max: 999999999e-2, precision: 2 }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (_(), S("span", X, s(a.amount), 1))]), _: 1 }), l(c, { label: "备注", align: "center" }, { default: n(({ row: a }) => [u("span", null, s(a.remark), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), u("div", Y, [e[5] || (e[5] = u("span", { style: { "font-size": "16px", "font-weight": "bold" } }, "创建备注：", -1)), l(N, { style: { width: "750px" }, type: "textarea", maxlength: "200", disabled: T.value, modelValue: x.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => x.value = a) }, null, 8, ["disabled", "modelValue"])]), u("div", Z, [e[6] || (e[6] = u("span", { style: { "font-size": "16px", "font-weight": "bold" } }, "审核备注：", -1)), l(N, { style: { width: "750px" }, type: "textarea", maxlength: "200", modelValue: y.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => y.value = a) }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  le as default
};
