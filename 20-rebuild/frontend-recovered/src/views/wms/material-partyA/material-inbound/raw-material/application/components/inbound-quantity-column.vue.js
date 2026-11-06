import { ref as V } from "vue";
import { computed as M } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as h } from "vue";
import { withCtx as y } from "vue";
import { Fragment as N } from "vue";
import { createBlock as p } from "vue";
import { toDisplayString as P } from "vue";
import { createElementVNode as T } from "vue";
import { unref as j } from "vue";
import { renderSlot as Y } from "vue";
import { createCommentVNode as x } from "vue";
import { watch as B } from "vue";
import { reactive as J } from "vue";
import { Edit as K } from "@element-plus/icons-vue";
import { View as Z } from "@element-plus/icons-vue";
import { ElTableColumn as w } from "element-plus";
import { o as R, z as I, am as O, sU as S, sT as ee, i as E, v9 as te, iX as ae } from "../../../../../../../shared/runtime.js";
const ie = { key: 1 }, ne = ["onClick"], le = { key: 0 }, se = { key: 1 }, ue = { __name: "inbound-quantity-column", props: { baseUnit: { type: Object, required: true }, currentCfg: { type: Object, required: true }, form: { type: Object, required: true }, basicClass: { type: Number, required: true }, handleOverQuantity: { type: Function, required: true } }, setup(o) {
  const d = o, s = V({}), b = V(false), { maxHeight: Q } = R({ mainBox: ".inbound-requisition-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, M(() => b.value)), $ = M(() => {
    const t = [];
    let a = 0, l = 0;
    return s.value.applyPurchase.forEach((e, u) => {
      e.isBranch ? a += e.quantity : (l && t.push(...Array(l).fill(a)), a = e.quantity, l = e.spanMerge), u === s.value.applyPurchase.length - 1 && t.push(...Array(l).fill(a));
    }), t;
  });
  function L(t) {
    s.value = t, s.value.applyPurchase.forEach((a) => {
      a.specification = a.specification || t.specification, a.thickness = a.thickness || t.thickness, a.length = a.length || t.length, a.width = a.width || t.width, U(a);
    }), b.value = true;
  }
  function U(t) {
    const a = !t.theoryTotalWeight;
    d.basicClass & O.SECTION_STEEL.V && (B([() => t.length, () => t.unitWeight, d.baseUnit], async () => {
      t.theoryWeight = await S({ length: t.length, unitWeight: t.unitWeight });
    }, { immediate: a }), B([() => t.length, () => t.quantity], async () => {
      F(t);
    }, { immediate: a })), d.basicClass & O.STEEL_PLATE.V && B([() => t.length, () => t.width, () => t.thickness, d.baseUnit], async () => {
      t.theoryWeight = await ee({ classifyId: t.classifyId, name: t.classifyFullName, length: t.length, width: t.width, thickness: t.thickness });
    }, { immediate: a }), B([() => t.theoryWeight, () => t.quantity], () => {
      A(t);
    }, { immediate: a });
  }
  function F(t) {
    E(t.length) && t.quantity ? t.totalLength = te({ length: t.length, quantity: t.quantity }) : t.totalLength = void 0;
  }
  function A(t) {
    E(t.theoryWeight) && t.quantity ? t.theoryTotalWeight = ae(t.theoryWeight * t.quantity, d.baseUnit.weight.precision) : t.theoryTotalWeight = 0;
  }
  function H(t, a, l) {
    var f;
    const e = (f = d.form.selectObj) == null ? void 0 : f[s.value.mergeId], u = J({ ...l, sn: e == null ? void 0 : e.sn, specificationLabels: e == null ? void 0 : e.specificationLabels, serialNumber: e == null ? void 0 : e.serialNumber, classifyId: e == null ? void 0 : e.classifyId, classifyFullName: e == null ? void 0 : e.classifyFullName, classifyName: e == null ? void 0 : e.classifyName, classifyParentFullName: e == null ? void 0 : e.classifyParentFullName, basicClass: e == null ? void 0 : e.basicClass, specification: e == null ? void 0 : e.specification, specificationMap: e == null ? void 0 : e.specificationMap, measureUnit: e == null ? void 0 : e.measureUnit, accountingUnit: e == null ? void 0 : e.accountingUnit, measurePrecision: e == null ? void 0 : e.measurePrecision, accountingPrecision: e == null ? void 0 : e.accountingPrecision, unitWeight: e == null ? void 0 : e.unitWeight, length: e == null ? void 0 : e.length, width: e == null ? void 0 : e.width, thickness: e == null ? void 0 : e.thickness, theoryTotalWeight: null, quantity: null, originQuantity: null, isBranch: true });
    U(u), a.splice(t + 1, 0, u);
    const r = W(t, a);
    a[r].spanMerge || (a[r].spanMerge = 1), a[r].spanMerge++;
  }
  function z(t, a, l) {
    if (l.isBranch) {
      const e = W(t, a);
      a[e].spanMerge--;
    } else a[t + 1].spanMerge = l.spanMerge - 1, a[t + 1].isBranch = false;
    a.splice(t, 1);
  }
  function W(t, a, l) {
    let e = t;
    for (let u = t; u >= 0; u--) if (!a[u].isBranch) {
      e = u;
      break;
    }
    return e;
  }
  function D({ row: t, column: a, rowIndex: l, columnIndex: e }) {
    if (["serialNumber", "project", "purchaseQuantity", "inboundQuantity"].includes(a.property)) return t.isBranch ? { rowspan: 1, colspan: 0 } : { rowspan: t.spanMerge || 1, colspan: 1 };
  }
  return (t, a) => {
    const l = C("common-input-number"), e = K, u = Z, r = w, f = C("common-button"), G = C("common-table"), X = C("common-dialog");
    return c(), g(N, null, [h(r, { prop: "quantity", align: "center", width: "110px", label: `本次实收数 (${o.baseUnit.measure.unit})` }, { default: y(({ row: n }) => {
      var k, _, q, i;
      return [n.boolApplyPurchase ? (c(), g(N, { key: 1 }, [T("span", null, P(n.quantity), 1), T("span", { style: { "margin-left": "5px", cursor: "pointer" }, onClick: (m) => L(n) }, [(i = (q = o.form.selectObj) == null ? void 0 : q[n.mergeId]) != null && i.isSelected ? (c(), p(e, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } })) : (c(), p(u, { key: 1, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } }))], 8, ne)], 64)) : (c(), g(N, { key: 0 }, [!n.boolApplyPurchase && ((_ = (k = o.form.selectObj) == null ? void 0 : k[n.mergeId]) != null && _.isSelected) ? (c(), p(l, { key: 0, modelValue: n.quantity, "onUpdate:modelValue": (m) => n.quantity = m, min: 0, max: 999999999, "controls-position": "right", controls: false, step: 1, precision: o.baseUnit.measure.precision, size: "default", placeholder: "实收数", onBlur: (m) => o.handleOverQuantity(n) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (c(), g("span", ie, P(n.quantity || "-"), 1))], 64))];
    }), _: 1 }, 8, ["label"]), h(X, { title: `${s.value.classifyName}：${s.value.serialNumber}`, modelValue: b.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => b.value = n), width: "90%", "before-close": () => {
      b.value = false;
    }, "show-close": false, "close-on-click-modal": true, "custom-class": "inbound-requisition-dialog", top: "10vh" }, { default: y(() => [h(G, { data: s.value.applyPurchase, maxHeight: j(Q), style: { width: "100%" }, "span-method": D, "return-source-data": "", "show-empty-symbol": false }, { default: y(() => {
      var n, k, _, q;
      return [h(r, { label: "序号", type: "index", align: "center", width: "60" }), h(r, { prop: "applyPurchaseSN", "show-overflow-tooltip": true, label: "申购单号", "min-width": "140", align: "center" }), h(r, { prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "140", align: "center" }, { default: y(({ row: i }) => [i.project ? (c(), g("span", le, P(j(I)(i.project)), 1)) : (c(), g("span", se, "-"))]), _: 1 }), Y(t.$slots, "editColumn", { row: s.value }), (k = (n = o.form.selectObj) == null ? void 0 : n[s.value.mergeId]) != null && k.isSelected ? (c(), p(r, { key: 0, prop: "quantity", "show-overflow-tooltip": true, label: `本次实收数 (${o.baseUnit.measure.unit})`, "min-width": "100px", align: "center" }, { default: y(({ row: i, $index: m }) => [h(l, { modelValue: i.quantity, "onUpdate:modelValue": (v) => i.quantity = v, min: 0, max: 999999999, "controls-position": "right", controls: false, step: 1, style: { width: "100%" }, precision: o.baseUnit.measure.precision, size: "default", placeholder: "实收数", onChange: () => {
        i.comparePurchaseQuantity = i.purchaseQuantity - $.value[m] + i.quantity;
      }, onBlur: (v) => o.handleOverQuantity(i, true, "comparePurchaseQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange", "onBlur"])]), _: 1 }, 8, ["label"])) : x("", true), h(r, { prop: "theoryTotalWeight", align: "center", label: `理论重量 (${o.baseUnit.weight.unit})`, "min-width": "100px" }, null, 8, ["label"]), (q = (_ = o.form.selectObj) == null ? void 0 : _[s.value.mergeId]) != null && q.isSelected ? (c(), p(r, { key: 1, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: y(({ row: i, $index: m }) => [i.isBranch || i.spanMerge > 1 ? (c(), p(f, { key: 0, icon: "el-icon-delete", type: "danger", size: "default", class: "icon-button", onClick: (v) => z(m, s.value.applyPurchase, i) }, null, 8, ["onClick"])) : x("", true), h(f, { icon: "el-icon-plus", type: "success", size: "default", class: "icon-button", onClick: (v) => H(m, s.value.applyPurchase, i) }, null, 8, ["onClick"])]), _: 1 })) : x("", true)];
    }), _: 3 }, 8, ["data", "maxHeight"])]), _: 3 }, 8, ["title", "modelValue", "before-close"])], 64);
  };
} };
export {
  ue as default
};
