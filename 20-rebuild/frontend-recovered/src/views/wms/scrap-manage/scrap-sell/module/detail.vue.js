import { ref as c } from "vue";
import { nextTick as A } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as H } from "vue";
import { createBlock as q } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as k } from "vue";
import { createElementVNode as D } from "vue";
import { toDisplayString as G } from "vue";
import { unref as I } from "vue";
import { isRef as K } from "vue";
import { watch as Q } from "vue";
import { ElMessage as C } from "element-plus";
import { ElDatePicker as X } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { ElInputNumber as le } from "element-plus";
import { u as te } from "../../../../../shared/runtime.js";
import { a as ne, g as oe, f as ue, h as se, i as ie } from "../../../../../modules/scrap-sell-e306ced6.js";
import { b as re } from "../../../../../modules/scrap-ledger-452ee452.js";
const de = { style: { display: "flex", "flex-direction": "column", "align-items": "center" } }, ce = { style: { "margin-top": "10px" } }, ge = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, typeList: { type: Array, default: () => [] }, title: { type: String, default: "创建废料出售" }, rowData: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(S, { emit: E }) {
  const u = S, g = E, { visible: y, handleClose: v } = te({ props: u, emit: g, showHook: B }), x = { branchCompanyId: void 0, contractWasteId: void 0, creatorRemark: void 0, id: void 0, plateNumber: void 0, saleDate: (/* @__PURE__ */ new Date()).getTime(), contractNumber: void 0, wasteSaleDetailList: [] }, n = c(JSON.parse(JSON.stringify(x))), r = c([]), U = c([]), _ = c([]), N = c([]), p = c(), V = c([]);
  async function B() {
    try {
      const { content: e } = await re();
      console.log(e), V.value = e;
    } catch (e) {
      console.log(e);
    }
    u.title === "创建废料出售" ? (r.value = [], n.value = JSON.parse(JSON.stringify(x))) : (console.log(u.rowData), r.value = [], u.rowData.wasteSaleDetailList.forEach((e) => {
      e != null && e.id && r.value.push(JSON.parse(JSON.stringify(e)));
    }), A(() => {
      n.value.branchCompanyId = u.rowData.branchCompanyId, n.value.contractWasteId = u.rowData.contractWasteId, n.value.creatorRemark = u.rowData.creatorRemark, n.value.id = u.rowData.id, n.value.plateNumber = u.rowData.plateNumber, n.value.saleDate = new Date(u.rowData.saleDate).getTime(), n.value.contractNumber = u.rowData.serialNumber;
    })), _.value = [];
    try {
      p.value = await ne(), console.log(p.value);
    } catch (e) {
      console.log(e);
    }
    try {
      const { content: e } = await oe();
      _.value = e, U.value = e.map((a) => {
        const i = {};
        return i.id = a.id, i.name = a.purchaser, i;
      });
    } catch (e) {
      console.log("获取购买单位失败", e);
    }
    try {
      const { content: e } = await ue();
      console.log(e), N.value = e.map((a) => {
        const i = {};
        return i.id = a.id, i.name = a.name, i;
      });
    } catch (e) {
      console.log("获取出售单位失败", e);
    }
  }
  function M() {
    r.value.push({ amount: void 0, price: void 0, remark: void 0, saleMete: void 0, id: void 0, measureUnit: void 0, wasteClassificationId: void 0 }), r.value.forEach((e) => {
      j(e);
    });
  }
  function T(e) {
    r.value.splice(e, 1);
  }
  function L(e) {
    _.value.forEach((a) => {
      a.id === e && (n.value.contractNumber = a.serialNumber);
    });
  }
  function O(e) {
    V.value.forEach((a) => {
      a.id === e.wasteClassificationId && (e.measureUnit = a.measureUnit);
    });
  }
  function R(e) {
    e.amount = e.saleMete * e.price;
  }
  function W(e) {
    e.amount = e.saleMete * e.price;
  }
  function j(e) {
    Q([() => e.saleMete, () => e.price], () => {
      e.amount = e.saleMete * e.price;
    });
  }
  async function F() {
    const e = [];
    if (n.value.wasteSaleDetailList = [], r.value.length === 0) throw C({ message: "列表信息不能为空", type: "error" }), new Error("列表信息不能为空");
    if (r.value.forEach((a) => {
      n.value.wasteSaleDetailList.push(a);
    }), e.push(n.value), u.title === "创建废料出售") try {
      await se(e), g("success"), C({ message: "创建成功", type: "success" }), v();
    } catch (a) {
      console.log(a, "创建废料出售");
    }
    else try {
      await ie(e), g("success"), C({ message: "修改成功", type: "success" }), v();
    } catch (a) {
      console.log(a, "修改废料出售");
    }
  }
  return (e, a) => {
    const i = b("common-button"), J = X, m = Y, h = b("common-select"), f = Z, $ = ee, d = ae, w = le, z = b("common-table"), P = b("common-drawer");
    return H(), q(P, { modelValue: I(y), "onUpdate:modelValue": a[6] || (a[6] = (l) => K(y) ? y.value = l : null), "before-close": I(v), size: "70%", title: u.title }, { titleRight: o(() => [t(i, { type: "primary", size: "default", onClick: F }, { default: o(() => a[7] || (a[7] = [k("确认")])), _: 1, __: [7] })]), content: o(() => [t($, { inline: true }, { default: o(() => [t(m, { label: "出售日期：", style: { "margin-right": "50px" } }, { default: o(() => [t(J, { class: "input-underline", placeholder: "请填写出售日期", modelValue: n.value.saleDate, "onUpdate:modelValue": a[0] || (a[0] = (l) => n.value.saleDate = l), "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "购买单位：", style: { "margin-right": "50px" } }, { default: o(() => [t(h, { class: "input-underline", style: { width: "250px" }, placeholder: "请填写购买单位", modelValue: n.value.contractWasteId, "onUpdate:modelValue": a[1] || (a[1] = (l) => n.value.contractWasteId = l), filterable: "", options: U.value, onChange: L }, null, 8, ["modelValue", "options"])]), _: 1 }), t(m, { label: "出售单位：", style: { "margin-right": "50px" } }, { default: o(() => [t(h, { class: "input-underline", style: { width: "250px" }, placeholder: "请填写出售单位", modelValue: n.value.branchCompanyId, "onUpdate:modelValue": a[2] || (a[2] = (l) => n.value.branchCompanyId = l), options: N.value }, null, 8, ["modelValue", "options"])]), _: 1 }), t(m, { label: "合同号：", style: { "margin-right": "50px" } }, { default: o(() => [t(f, { class: "input-underline", placeholder: "请填写合同号", modelValue: n.value.contractNumber, "onUpdate:modelValue": a[3] || (a[3] = (l) => n.value.contractNumber = l), disabled: true }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "车牌/船牌号：", style: { "margin-right": "50px" } }, { default: o(() => [t(f, { class: "input-underline", placeholder: "请填写车牌/船牌号", modelValue: n.value.plateNumber, "onUpdate:modelValue": a[4] || (a[4] = (l) => n.value.plateNumber = l) }, null, 8, ["modelValue"])]), _: 1 }), t(m, { label: "备注：", style: { width: "800px", "min-height": "55px" } }, { default: o(() => [t(f, { type: "textarea", maxlength: "200", style: { width: "700px" }, modelValue: n.value.creatorRemark, "onUpdate:modelValue": a[5] || (a[5] = (l) => n.value.creatorRemark = l) }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), D("div", de, [t(z, { data: r.value, returnSourceData: "" }, { default: o(() => [t(d, { label: "序号", align: "center", width: "55", type: "index" }), t(d, { label: "类型", align: "center", width: "150" }, { default: o(({ row: l }) => [t(h, { modelValue: l.wasteClassificationId, "onUpdate:modelValue": (s) => l.wasteClassificationId = s, options: V.value, "data-structure": { key: "id", label: "name", value: "id" }, onChange: (s) => O(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), t(d, { label: "核算单位", align: "center", width: "80" }, { default: o(({ row: l }) => [D("span", null, G(l.measureUnit), 1)]), _: 1 }), t(d, { label: "数量", align: "center", width: "100" }, { default: o(({ row: l }) => [t(w, { modelValue: l.saleMete, "onUpdate:modelValue": (s) => l.saleMete = s, controls: false, onBlur: (s) => W(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 1 }), t(d, { label: "单价", align: "center", width: "125" }, { default: o(({ row: l }) => [t(w, { modelValue: l.price, "onUpdate:modelValue": (s) => l.price = s, controls: false, step: 0.01, max: 999999999e-2, precision: 2, onBlur: (s) => R(l), disabled: p.value !== 1 }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur", "disabled"])]), _: 1 }), t(d, { label: "金额", align: "center", width: "125" }, { default: o(({ row: l }) => [t(w, { modelValue: l.amount, "onUpdate:modelValue": (s) => l.amount = s, controls: false, step: 0.01, max: 999999999e-2, precision: 2, disabled: p.value !== 1 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), t(d, { label: "备注", align: "center" }, { default: o(({ row: l }) => [t(f, { modelValue: l.remark, "onUpdate:modelValue": (s) => l.remark = s }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(d, { label: "操作", align: "center", width: "120" }, { default: o(({ $index: l }) => [t(i, { type: "danger", icon: "el-icon-delete", onClick: (s) => T(l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"]), D("div", ce, [t(i, { type: "success", icon: "el-icon-plus", onClick: M }, { default: o(() => a[8] || (a[8] = [k("添加一行")])), _: 1, __: [8] })])])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} };
export {
  ge as default
};
