import { inject as L } from "vue";
import { computed as D } from "vue";
import { watchEffect as O } from "vue";
import { watch as b } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as R } from "vue";
import { createBlock as W } from "vue";
import { withCtx as u } from "vue";
import { createVNode as n } from "vue";
import { unref as r } from "vue";
import { withModifiers as j } from "vue";
import { ElTableColumn as H } from "element-plus";
import { i as m, iX as h, D as K, v3 as q, aT as d, fE as z, aw as B, v0 as I } from "../../../../../../../shared/runtime.js";
const Y = { __name: "index", props: { maxHeight: { type: Number } }, setup(_, { expose: w }) {
  var g;
  const x = /* @__PURE__ */ new Map([["destination", -1]]), P = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], pricingMethod: [{ required: true, message: "请选择计价方式", trigger: "change" }], destination: [{ required: true, message: "请选择目的地", trigger: "change" }] }, { tableValidate: V, cleanUpData: v, wrongCellMask: y } = B({ rules: P, ditto: x }), o = (g = L("cu")) == null ? void 0 : g.form, c = D(() => {
    const e = [];
    for (const i in o.manufListObj) {
      const t = o.manufListObj[i];
      e.length > 0 && !(t != null && t.destination) && (t.destination = -1), e.length === 0 && (t == null ? void 0 : t.destination) === -1 && (t.destination = void 0), e.push(t), E(t);
    }
    return e;
  });
  O(() => {
    let e = 0, i = 0;
    m(c.value) && c.value.forEach((t) => {
      e += t.curPurchaseWeight || 0, i += Number(t.amount) || 0;
    }), o.amount = h(i, K.YUAN), o.mete = e, o.meteUnit = "kg";
  });
  function E(e) {
    b([() => e.unitPrice, () => e.pricingMethod, () => e.mergeIds, () => e.destination], () => {
      o.manufListObj[e.rowKey] = e;
    }), b([() => e.curPurchaseWeight, () => e.unitPrice, () => e.pricingMethod], () => {
      M(e);
    });
  }
  function M(e) {
    const i = q(e.unitPrice);
    let t = e.unitPrice;
    i > 10 && (e.unitPrice = h(e.unitPrice, 10), t = e.unitPrice);
    let l;
    e.pricingMethod & d.WEIGHT.V && (l = e.curPurchaseWeight), e.pricingMethod & d.LENGTH.V && (l = e.length), e.amount = m(t) && m(l) ? h(t * (l / 1e3), 2) : void 0;
  }
  function U(e, i) {
    var t;
    (t = o.manufListObj) == null || delete t[e.rowKey];
  }
  function T() {
    const { validResult: e } = V(c.value);
    return o.basicClass = I.STRUC_MANUFACTURED.V, e;
  }
  function N() {
    return v(c.value);
  }
  return w({ validate: T, fetchResList: N }), (e, i) => {
    const t = H, l = p("common-select"), C = p("common-input-number"), k = p("common-button"), A = p("common-table");
    return R(), W(A, { data: c.value, "return-source-data": "", "show-empty-symbol": false, "max-height": _.maxHeight, "cell-class-name": r(y), style: { width: "100%" } }, { default: u(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }), n(t, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), n(t, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), n(t, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), n(t, { prop: "length", label: "总长度(m)", align: "center", "show-overflow-tooltip": "" }), n(t, { prop: "curPurchaseQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), n(t, { prop: "curPurchaseWeight", label: "重量(kg)", align: "center", "show-overflow-tooltip": "" }), n(t, { prop: "pricingMethod", "show-overflow-tooltip": true, label: "计量方式", width: "160" }, { default: u(({ row: a }) => [n(l, { modelValue: a.pricingMethod, "onUpdate:modelValue": (s) => a.pricingMethod = s, options: r(d).ENUM, type: "enum", unshowOptions: [r(d).AREA.K, r(d).QUANTITY.K], placeholder: "计量方式", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshowOptions"])]), _: 1 }), n(t, { prop: "unitPrice", align: "center", width: "135px", label: "单价（元/吨）" }, { default: u(({ row: a }) => [n(C, { modelValue: a.unitPrice, "onUpdate:modelValue": (s) => a.unitPrice = s, min: 0, max: 9999999999, controls: false, step: 1, size: "default", placeholder: "单价" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(t, { prop: "amount", align: "center", width: "135px", label: "金额（元）" }), n(t, { prop: "destination", align: "center", width: "135px", label: "目的地" }, { default: u(({ row: a, $index: s }) => [n(l, { modelValue: a.destination, "onUpdate:modelValue": (f) => a.destination = f, options: r(z).ENUM, type: "enum", size: "default", clearable: "", showExtra: s !== 0, placeholder: "目的地", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "showExtra"])]), _: 1 }), n(t, { label: "操作", align: "center", width: "70px" }, { default: u(({ row: a, $index: s }) => [n(k, { type: "danger", icon: "el-icon-delete", size: "default", onClick: j((f) => U(a, s), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]);
  };
} };
export {
  Y as default
};
