import { ref as V } from "vue";
import { computed as M } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as h } from "vue";
import { withCtx as y } from "vue";
import { Fragment as B } from "vue";
import { createBlock as p } from "vue";
import { toDisplayString as N } from "vue";
import { createElementVNode as T } from "vue";
import { unref as j } from "vue";
import { renderSlot as X } from "vue";
import { createCommentVNode as P } from "vue";
import { watch as U } from "vue";
import { reactive as Y } from "vue";
import { Edit as J } from "@element-plus/icons-vue";
import { View as K } from "@element-plus/icons-vue";
import { ElTableColumn as Z } from "element-plus";
import { o as R, z as I, am as O, sU as S, sT as ee, i as Q, v9 as te, iX as ae } from "../../../../../../shared/runtime.js";
const ie = { key: 1 }, ne = ["onClick"], le = { key: 0 }, se = { key: 1 }, ue = { __name: "inbound-quantity-column", props: { baseUnit: { type: Object, required: true }, currentCfg: { type: Object, required: true }, form: { type: Object, required: true }, basicClass: { type: Number, required: true }, handleOverQuantity: { type: Function, required: true } }, setup(l) {
  const d = l, o = V({}), b = V(false), { maxHeight: $ } = R({ mainBox: ".inbound-requisition-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, M(() => b.value)), E = M(() => {
    const t = [];
    let a = 0, s = 0;
    return o.value.applyPurchase.forEach((e, r) => {
      e.isBranch ? a += e.quantity : (s && t.push(...Array(s).fill(a)), a = e.quantity, s = e.spanMerge), r === o.value.applyPurchase.length - 1 && t.push(...Array(s).fill(a));
    }), t;
  });
  function L(t) {
    o.value = t, o.value.applyPurchase.forEach((a) => {
      a.specification = a.specification || t.specification, a.thickness = a.thickness || t.thickness, a.length = a.length || t.length, a.width = a.width || t.width, x(a);
    }), b.value = true;
  }
  function x(t) {
    const a = !t.theoryTotalWeight;
    d.basicClass & O.SECTION_STEEL.V && (U([() => t.length, () => t.unitWeight, d.baseUnit], async () => {
      t.theoryWeight = await S({ length: t.length, unitWeight: t.unitWeight });
    }, { immediate: a }), U([() => t.length, () => t.quantity], async () => {
      F(t);
    }, { immediate: a })), d.basicClass & O.STEEL_PLATE.V && U([() => t.length, () => t.width, () => t.thickness, d.baseUnit], async () => {
      t.theoryWeight = await ee({ classifyId: t.classifyId, name: t.classifyFullName, length: t.length, width: t.width, thickness: t.thickness });
    }, { immediate: a }), U([() => t.theoryWeight, () => t.quantity], () => {
      A(t);
    }, { immediate: a });
  }
  function F(t) {
    Q(t.length) && t.quantity ? t.totalLength = te({ length: t.length, quantity: t.quantity }) : t.totalLength = void 0;
  }
  function A(t) {
    Q(t.theoryWeight) && t.quantity ? t.theoryTotalWeight = ae(t.theoryWeight * t.quantity, d.baseUnit.weight.precision) : t.theoryTotalWeight = 0;
  }
  function H(t, a, s) {
    var f;
    const e = (f = d.form.selectObj) == null ? void 0 : f[o.value.mergeId], r = Y({ ...s, sn: e == null ? void 0 : e.sn, specificationLabels: e == null ? void 0 : e.specificationLabels, serialNumber: e == null ? void 0 : e.serialNumber, classifyId: e == null ? void 0 : e.classifyId, classifyFullName: e == null ? void 0 : e.classifyFullName, classifyName: e == null ? void 0 : e.classifyName, classifyParentFullName: e == null ? void 0 : e.classifyParentFullName, basicClass: e == null ? void 0 : e.basicClass, specification: e == null ? void 0 : e.specification, specificationMap: e == null ? void 0 : e.specificationMap, measureUnit: e == null ? void 0 : e.measureUnit, accountingUnit: e == null ? void 0 : e.accountingUnit, measurePrecision: e == null ? void 0 : e.measurePrecision, accountingPrecision: e == null ? void 0 : e.accountingPrecision, unitWeight: e == null ? void 0 : e.unitWeight, length: e == null ? void 0 : e.length, width: e == null ? void 0 : e.width, thickness: e == null ? void 0 : e.thickness, theoryTotalWeight: null, quantity: null, originQuantity: null, isBranch: true });
    x(r), a.splice(t + 1, 0, r);
    const c = W(t, a);
    a[c].spanMerge || (a[c].spanMerge = 1), a[c].spanMerge++;
  }
  function z(t, a, s) {
    if (s.isBranch) {
      const e = W(t, a);
      a[e].spanMerge--;
    } else a[t + 1].spanMerge = s.spanMerge - 1, a[t + 1].isBranch = false;
    a.splice(t, 1);
  }
  function W(t, a, s) {
    let e = t;
    for (let r = t; r >= 0; r--) if (!a[r].isBranch) {
      e = r;
      break;
    }
    return e;
  }
  function D({ row: t, column: a, rowIndex: s, columnIndex: e }) {
    if (["serialNumber", "project", "purchaseQuantity", "inboundQuantity"].includes(a.property)) return t.isBranch ? { rowspan: 1, colspan: 0 } : { rowspan: t.spanMerge || 1, colspan: 1 };
  }
  return (t, a) => {
    const s = C("common-input-number"), e = J, r = K, c = Z, f = C("common-button"), w = C("common-table"), G = C("common-dialog");
    return u(), g(B, null, [h(c, { prop: "quantity", align: "center", width: "110px", label: `本次实收数 (${l.baseUnit.measure.unit})` }, { default: y(({ row: n }) => {
      var k, v, q, i;
      return [n.boolApplyPurchase ? (u(), g(B, { key: 1 }, [T("span", null, N(n.quantity), 1), T("span", { style: { "margin-left": "5px", cursor: "pointer" }, onClick: (m) => L(n) }, [(i = (q = l.form.selectObj) == null ? void 0 : q[n.mergeId]) != null && i.isSelected ? (u(), p(e, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } })) : (u(), p(r, { key: 1, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } }))], 8, ne)], 64)) : (u(), g(B, { key: 0 }, [!n.boolApplyPurchase && ((v = (k = l.form.selectObj) == null ? void 0 : k[n.mergeId]) != null && v.isSelected) ? (u(), p(s, { key: 0, modelValue: n.quantity, "onUpdate:modelValue": (m) => n.quantity = m, min: 0, max: 999999999, "controls-position": "right", controls: false, step: 1, precision: l.baseUnit.measure.precision, size: "default", placeholder: "实收数", onBlur: (m) => l.handleOverQuantity(n) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (u(), g("span", ie, N(n.quantity || "-"), 1))], 64))];
    }), _: 1 }, 8, ["label"]), h(G, { title: `${o.value.classifyName}：${o.value.serialNumber}`, modelValue: b.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => b.value = n), width: "90%", "before-close": () => {
      b.value = false;
    }, "show-close": false, "close-on-click-modal": true, "custom-class": "inbound-requisition-dialog", top: "10vh" }, { default: y(() => [h(w, { data: o.value.applyPurchase, maxHeight: j($), style: { width: "100%" }, "span-method": D, "return-source-data": "", "show-empty-symbol": false }, { default: y(() => {
      var n, k, v, q;
      return [h(c, { label: "序号", type: "index", align: "center", width: "60" }), h(c, { prop: "applyPurchaseSN", "show-overflow-tooltip": true, label: "申购单号", "min-width": "140", align: "center" }), h(c, { prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "140", align: "center" }, { default: y(({ row: i }) => [i.project ? (u(), g("span", le, N(j(I)(i.project)), 1)) : (u(), g("span", se, "-"))]), _: 1 }), h(c, { prop: "purchaseQuantity", "show-overflow-tooltip": true, label: `采购数量 (${l.baseUnit.measure.unit})`, width: "100", align: "center" }, null, 8, ["label"]), h(c, { prop: "inboundQuantity", "show-overflow-tooltip": true, label: `已入库数量 (${l.baseUnit.measure.unit})`, width: "110", align: "center" }, null, 8, ["label"]), X(t.$slots, "editColumn", { row: o.value }), (k = (n = l.form.selectObj) == null ? void 0 : n[o.value.mergeId]) != null && k.isSelected ? (u(), p(c, { key: 0, prop: "quantity", "show-overflow-tooltip": true, label: `本次实收数 (${l.baseUnit.measure.unit})`, "min-width": "100px", align: "center" }, { default: y(({ row: i, $index: m }) => [h(s, { modelValue: i.quantity, "onUpdate:modelValue": (_) => i.quantity = _, min: 0, max: 999999999, "controls-position": "right", controls: false, step: 1, precision: l.baseUnit.measure.precision, size: "default", placeholder: "实收数", onChange: () => {
        i.comparePurchaseQuantity = i.purchaseQuantity - E.value[m] + i.quantity;
      }, onBlur: (_) => l.handleOverQuantity(i, true, "comparePurchaseQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange", "onBlur"])]), _: 1 }, 8, ["label"])) : P("", true), h(c, { prop: "theoryTotalWeight", align: "center", label: `理论重量 (${l.baseUnit.weight.unit})`, "min-width": "100px" }, null, 8, ["label"]), (q = (v = l.form.selectObj) == null ? void 0 : v[o.value.mergeId]) != null && q.isSelected ? (u(), p(c, { key: 1, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: y(({ row: i, $index: m }) => [i.isBranch || i.spanMerge > 1 ? (u(), p(f, { key: 0, icon: "el-icon-delete", type: "danger", size: "default", class: "icon-button", onClick: (_) => z(m, o.value.applyPurchase, i) }, null, 8, ["onClick"])) : P("", true), h(f, { icon: "el-icon-plus", type: "success", size: "default", class: "icon-button", onClick: (_) => H(m, o.value.applyPurchase, i) }, null, 8, ["onClick"])]), _: 1 })) : P("", true)];
    }), _: 3 }, 8, ["data", "maxHeight"])]), _: 3 }, 8, ["title", "modelValue", "before-close"])], 64);
  };
} };
export {
  ue as default
};
