import { computed as V } from "vue";
import { ref as I } from "vue";
import { watch as M } from "vue";
import { nextTick as Y } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as u } from "vue";
import { createVNode as t } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as K } from "vue";
import { normalizeStyle as W } from "vue";
import { toDisplayString as $ } from "vue";
import { ElCheckbox as G } from "element-plus";
import { ElFormItem as H } from "element-plus";
import { ElDatePicker as Q } from "element-plus";
import { ElForm as X } from "element-plus";
import { _ as Z, fg as ee, jY as oe, i as ae, z as le, qS as b, aV as te, y3 as ue, bl as de, cy as re } from "../../../../../../../shared/runtime.js";
const ne = { __name: "preview-form", props: { formData: { type: Object, default: () => {
} }, material: { type: Object } }, setup(_, { expose: O }) {
  const w = { PLATE: { L: "整料", K: "PLATE", V: false }, SURPLUS: { L: "余料", K: "SURPLUS", V: true } }, { projectTree: v, projectMap: S, monomerMap: k } = ee(), { outboundCfg: j } = oe(), x = V(() => {
    if (ae(v.value)) {
      const l = v.value.map((o) => ({ id: o.id, name: o.id !== "common" ? le(o, { showSerialNumber: false }) : "公共库" }));
      return l.unshift({ id: "common", name: "公共库" }), l;
    } else return null;
  }), p = _, C = V(() => {
    var l, o;
    return ((l = j.value) == null ? void 0 : l.boolCanOutToOtherProject) === true && !((o = p.material) != null && o.boolPartyA);
  }), d = I(), y = { boolOutbound: void 0, projectId: void 0, monomerId: void 0, areaId: void 0, workshopId: void 0, warehouseId: void 0, recipientId: void 0, outboundAddress: b.FACTORY.V, outboundTime: void 0 }, e = I(JSON.parse(JSON.stringify(y))), N = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择仓库位置", trigger: "change" }], outboundTime: [{ required: true, message: "请选择出库日期", trigger: "change" }] };
  M(() => p.formData, (l) => {
    T(l);
  }, { deep: true, immediate: true });
  function T(l) {
    d.value && d.value.resetFields();
    let o;
    l && Object.keys(l).length > 0 ? o = l : o = JSON.parse(JSON.stringify(y)), e.value = JSON.parse(JSON.stringify(o)), d.value && Y(() => {
      d.value.clearValidate();
    });
  }
  function U() {
    d.value && d.value.resetFields();
  }
  function F() {
    const l = JSON.parse(JSON.stringify(e.value));
    Object.assign(p.formData, l);
  }
  function A() {
    e.value.monomerId = void 0, e.value.areaId = void 0;
  }
  function E() {
    e.value.areaId = void 0;
  }
  function P() {
    e.value.boolOutbound ? e.value.projectId === "common" && (e.value.projectId = void 0, e.value.outboundAddress = b.FACTORY.V) : e.value.outboundAddress = void 0;
  }
  async function J() {
    if (!await d.value.validate()) return false;
    const o = JSON.parse(JSON.stringify(e.value));
    return Object.assign(p.formData, o), true;
  }
  function D() {
  }
  function L() {
    d.value && d.value.clearValidate();
  }
  return O({ validateForm: J, resetForm: D, assignForm: F, clearValidate: L, resetFields: U }), (l, o) => {
    const z = G, r = H, g = h("common-radio"), f = h("common-select"), q = Q, R = X;
    return n(), s(R, { ref_key: "formRef", ref: d, model: e.value, rules: N, size: "default", "label-position": "right", "label-width": "100px" }, { default: u(() => [t(r, { prop: "boolOutbound", label: "是否出库", style: { "margin-top": "10px" } }, { default: u(() => [t(z, { modelValue: e.value.boolOutbound, "onUpdate:modelValue": o[0] || (o[0] = (a) => e.value.boolOutbound = a), size: "large", onChange: P }, null, 8, ["modelValue"])]), _: 1 }), e.value.boolOutbound ? (n(), s(r, { key: 0, label: "出库目的地", prop: "outboundAddress" }, { default: u(() => [t(g, { modelValue: e.value.outboundAddress, "onUpdate:modelValue": o[1] || (o[1] = (a) => e.value.outboundAddress = a), options: m(b).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })) : i("", true), t(r, { prop: "type", label: "钢板类型", style: { "margin-top": "10px" } }, { default: u(() => [t(g, { modelValue: e.value.boolSurplus, "onUpdate:modelValue": o[2] || (o[2] = (a) => e.value.boolSurplus = a), options: w, type: "enum", size: "default", disabled: "" }, null, 8, ["modelValue"])]), _: 1 }), t(r, { prop: "projectId", label: "所属项目", style: { "margin-top": "10px" } }, { default: u(() => [t(f, { modelValue: e.value.projectId, "onUpdate:modelValue": o[3] || (o[3] = (a) => e.value.projectId = a), options: x.value, "disabled-val": e.value.boolOutbound ? ["common"] : [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", type: "other", placeholder: "所属项目", style: { width: "100%" }, onChange: A, disabled: !C.value }, { view: u(({ data: a }) => [K("span", { style: W(`color:${!e.value.boolOutbound && a.id === "common" ? "#e6a23c" : ""}`) }, $(a.name), 5)]), _: 1 }, 8, ["modelValue", "options", "disabled-val", "disabled"])]), _: 1 }), e.value.projectId !== "common" ? (n(), s(r, { key: 1, prop: "monomerId", label: "单体", style: { "margin-top": "10px" } }, { default: u(() => {
      var a;
      return [t(f, { modelValue: e.value.monomerId, "onUpdate:modelValue": o[4] || (o[4] = (c) => e.value.monomerId = c), options: ((a = m(S)[e.value.projectId]) == null ? void 0 : a.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", type: "other", style: { width: "100%" }, placeholder: "单体", onChange: E }, null, 8, ["modelValue", "options"])];
    }), _: 1 })) : i("", true), e.value.projectId !== "common" ? (n(), s(r, { key: 2, prop: "areaId", label: "区域", style: { "margin-top": "10px" } }, { default: u(() => {
      var a, c;
      return [t(f, { modelValue: e.value.areaId, "onUpdate:modelValue": o[5] || (o[5] = (B) => e.value.areaId = B), options: ((c = (a = m(k)) == null ? void 0 : a[e.value.monomerId]) == null ? void 0 : c.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", style: { width: "100%" }, type: "other", placeholder: "区域" }, null, 8, ["modelValue", "options"])];
    }), _: 1 })) : i("", true), e.value.boolOutbound ? (n(), s(r, { key: 3, prop: "workshopId", label: "领用车间", style: { "margin-top": "10px" } }, { default: u(() => [t(m(te), { modelValue: e.value.workshopId, "onUpdate:modelValue": o[6] || (o[6] = (a) => e.value.workshopId = a), "factory-id": e.value.factoryId, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "factory-id"])]), _: 1 })) : i("", true), t(r, { prop: "warehouseId", label: "仓库位置", style: { "margin-top": "10px" } }, { default: u(() => [t(ue, { modelValue: e.value.warehouseId, "onUpdate:modelValue": o[7] || (o[7] = (a) => e.value.warehouseId = a), "factory-id": e.value.factoryId, "basic-class": m(de).STEEL_PLATE.V, style: { width: "100%" }, placeholder: "仓库位置" }, null, 8, ["modelValue", "factory-id", "basic-class"])]), _: 1 }), e.value.boolOutbound ? (n(), s(r, { key: 4, prop: "recipientId", label: "领用人", style: { "margin-top": "10px" } }, { default: u(() => [t(re, { modelValue: e.value.recipientId, "onUpdate:modelValue": o[8] || (o[8] = (a) => e.value.recipientId = a), "collapse-tags": false, clearable: "", filterable: "", "show-all-levels": "", placeholder: "领用人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : i("", true), e.value.boolOutbound ? (n(), s(r, { key: 5, prop: "outboundTime", label: "出库日期", style: { "margin-top": "10px" } }, { default: u(() => [t(q, { modelValue: e.value.outboundTime, "onUpdate:modelValue": o[9] || (o[9] = (a) => e.value.outboundTime = a), type: "datetime", "value-format": "x", placeholder: "出库日期", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["model"]);
  };
} }, me = Z(ne, [["__scopeId", "data-v-d7c200da"]]);
export {
  me as default
};
