import { computed as I } from "vue";
import { ref as V } from "vue";
import { watch as Y } from "vue";
import { nextTick as K } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as u } from "vue";
import { createVNode as t } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as $ } from "vue";
import { normalizeStyle as W } from "vue";
import { toDisplayString as G } from "vue";
import { ElCheckbox as H } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElDatePicker as X } from "element-plus";
import { ElForm as Z } from "element-plus";
import { _ as ee, fg as oe, jY as le, i as ae, z as te, qS as b, aV as ue, r9 as re, bl as de, cy as ne } from "../../../../../../../shared/runtime.js";
const se = { __name: "preview-form", props: { formData: { type: Object, default: () => {
} }, material: { type: Object } }, setup(_, { expose: w }) {
  const O = { PLATE: { L: "整料", K: "PLATE", V: false }, SURPLUS: { L: "余料", K: "SURPLUS", V: true } }, { projectTree: v, projectMap: k, monomerMap: S } = oe(), { outboundCfg: j } = le(), x = I(() => {
    if (ae(v.value)) {
      const a = v.value.map((o) => ({ id: o.id, name: o.id !== "common" ? te(o, { showSerialNumber: false }) : "公共库" }));
      return a.unshift({ id: "common", name: "公共库" }), a;
    } else return null;
  }), p = _, C = I(() => {
    var a, o;
    return ((a = j.value) == null ? void 0 : a.boolCanOutToOtherProject) === true && !((o = p.material) != null && o.boolPartyA);
  }), r = V(), y = { boolOutbound: void 0, projectId: void 0, monomerId: void 0, areaId: void 0, workshopId: void 0, warehouseId: void 0, recipientId: void 0, outboundAddress: b.FACTORY.V, outboundTime: void 0 }, e = V(JSON.parse(JSON.stringify(y))), N = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择仓库位置", trigger: "change" }], outboundTime: [{ required: true, message: "请选择出库日期", trigger: "change" }] };
  Y(() => p.formData, (a) => {
    T(a);
  }, { deep: true, immediate: true });
  function T(a) {
    r.value && r.value.resetFields();
    let o;
    a && Object.keys(a).length > 0 ? o = a : o = JSON.parse(JSON.stringify(y)), e.value = JSON.parse(JSON.stringify(o)), r.value && K(() => {
      r.value.clearValidate();
    });
  }
  function U() {
    r.value && r.value.resetFields();
  }
  function A(a) {
    e.value.boolOutbound || (e.value.workshopId = a.workshopId);
  }
  function F() {
    const a = JSON.parse(JSON.stringify(e.value));
    Object.assign(p.formData, a);
  }
  function E() {
    e.value.monomerId = void 0, e.value.areaId = void 0;
  }
  function P() {
    e.value.areaId = void 0;
  }
  function J() {
    e.value.boolOutbound ? e.value.projectId === "common" && (e.value.projectId = void 0, e.value.outboundAddress = b.FACTORY.V) : e.value.outboundAddress = void 0;
  }
  async function D() {
    if (!await r.value.validate()) return false;
    const o = JSON.parse(JSON.stringify(e.value));
    return Object.assign(p.formData, o), true;
  }
  function L() {
  }
  function z() {
    r.value && r.value.clearValidate();
  }
  return w({ validateForm: D, resetForm: L, assignForm: F, clearValidate: z, resetFields: U }), (a, o) => {
    const q = H, d = Q, g = h("common-radio"), f = h("common-select"), R = X, B = Z;
    return n(), s(B, { ref_key: "formRef", ref: r, model: e.value, rules: N, size: "default", "label-position": "right", "label-width": "100px" }, { default: u(() => [t(d, { prop: "boolOutbound", label: "是否出库", style: { "margin-top": "10px" } }, { default: u(() => [t(q, { modelValue: e.value.boolOutbound, "onUpdate:modelValue": o[0] || (o[0] = (l) => e.value.boolOutbound = l), size: "large", onChange: J }, null, 8, ["modelValue"])]), _: 1 }), e.value.boolOutbound ? (n(), s(d, { key: 0, label: "出库目的地", prop: "outboundAddress" }, { default: u(() => [t(g, { modelValue: e.value.outboundAddress, "onUpdate:modelValue": o[1] || (o[1] = (l) => e.value.outboundAddress = l), options: m(b).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })) : i("", true), t(d, { prop: "type", label: "钢板类型", style: { "margin-top": "10px" } }, { default: u(() => [t(g, { modelValue: e.value.boolSurplus, "onUpdate:modelValue": o[2] || (o[2] = (l) => e.value.boolSurplus = l), options: O, type: "enum", size: "default", disabled: "" }, null, 8, ["modelValue"])]), _: 1 }), t(d, { prop: "projectId", label: "所属项目", style: { "margin-top": "10px" } }, { default: u(() => [t(f, { modelValue: e.value.projectId, "onUpdate:modelValue": o[3] || (o[3] = (l) => e.value.projectId = l), options: x.value, "disabled-val": e.value.boolOutbound ? ["common"] : [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", placeholder: "所属项目", style: { width: "100%" }, onChange: E, disabled: !C.value }, { view: u(({ data: l }) => [$("span", { style: W(`color:${!e.value.boolOutbound && l.id === "common" ? "#e6a23c" : ""}`) }, G(l.name), 5)]), _: 1 }, 8, ["modelValue", "options", "disabled-val", "disabled"])]), _: 1 }), e.value.projectId !== "common" ? (n(), s(d, { key: 1, prop: "monomerId", label: "单体", style: { "margin-top": "10px" } }, { default: u(() => {
      var l;
      return [t(f, { modelValue: e.value.monomerId, "onUpdate:modelValue": o[4] || (o[4] = (c) => e.value.monomerId = c), options: ((l = m(k)[e.value.projectId]) == null ? void 0 : l.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", type: "other", style: { width: "100%" }, placeholder: "单体", onChange: P }, null, 8, ["modelValue", "options"])];
    }), _: 1 })) : i("", true), e.value.projectId !== "common" ? (n(), s(d, { key: 2, prop: "areaId", label: "区域", style: { "margin-top": "10px" } }, { default: u(() => {
      var l, c;
      return [t(f, { modelValue: e.value.areaId, "onUpdate:modelValue": o[5] || (o[5] = (M) => e.value.areaId = M), options: ((c = (l = m(S)) == null ? void 0 : l[e.value.monomerId]) == null ? void 0 : c.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", style: { width: "100%" }, type: "other", placeholder: "区域" }, null, 8, ["modelValue", "options"])];
    }), _: 1 })) : i("", true), e.value.boolOutbound ? (n(), s(d, { key: 3, prop: "workshopId", label: "领用车间", style: { "margin-top": "10px" } }, { default: u(() => [t(m(ue), { modelValue: e.value.workshopId, "onUpdate:modelValue": o[6] || (o[6] = (l) => e.value.workshopId = l), "factory-id": e.value.factoryId, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "factory-id"])]), _: 1 })) : i("", true), t(d, { prop: "warehouseId", label: "仓库位置", style: { "margin-top": "10px" } }, { default: u(() => [t(re, { modelValue: e.value.warehouseId, "onUpdate:modelValue": o[7] || (o[7] = (l) => e.value.warehouseId = l), "factory-id": e.value.factoryId, showAll: "", "basic-class": m(de).STEEL_PLATE.V, style: { width: "100%" }, placeholder: "仓库位置", onInfoChange: A }, null, 8, ["modelValue", "factory-id", "basic-class"])]), _: 1 }), e.value.boolOutbound ? (n(), s(d, { key: 4, prop: "recipientId", label: "领用人", style: { "margin-top": "10px" } }, { default: u(() => [t(ne, { modelValue: e.value.recipientId, "onUpdate:modelValue": o[8] || (o[8] = (l) => e.value.recipientId = l), "collapse-tags": false, clearable: "", filterable: "", "show-all-levels": "", placeholder: "领用人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : i("", true), e.value.boolOutbound ? (n(), s(d, { key: 5, prop: "outboundTime", label: "出库日期", style: { "margin-top": "10px" } }, { default: u(() => [t(R, { modelValue: e.value.outboundTime, "onUpdate:modelValue": o[9] || (o[9] = (l) => e.value.outboundTime = l), type: "datetime", "value-format": "x", placeholder: "出库日期", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["model"]);
  };
} }, pe = ee(se, [["__scopeId", "data-v-0d629a81"]]);
export {
  pe as default
};
