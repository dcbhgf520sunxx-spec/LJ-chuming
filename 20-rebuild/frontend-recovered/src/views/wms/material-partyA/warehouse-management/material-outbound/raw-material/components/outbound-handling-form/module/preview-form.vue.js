import { computed as c } from "vue";
import { ref as f } from "vue";
import { watch as L } from "vue";
import { nextTick as z } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as d } from "vue";
import { createBlock as i } from "vue";
import { withCtx as u } from "vue";
import { createVNode as r } from "vue";
import { createElementVNode as R } from "vue";
import { normalizeStyle as q } from "vue";
import { toDisplayString as B } from "vue";
import { unref as v } from "vue";
import { createCommentVNode as g } from "vue";
import { ElCheckbox as M } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElForm as K } from "element-plus";
import { _ as $, fg as W, jY as G, i as H, z as Q, qS as y, aV as X, r9 as Z, bl as ee, cy as oe } from "../../../../../../../../../shared/runtime.js";
const ae = { __name: "preview-form", props: { formData: { type: Object, default: () => {
} }, material: { type: Object } }, setup(h, { expose: _ }) {
  const w = { PLATE: { L: "整料", K: "PLATE", V: false }, SURPLUS: { L: "余料", K: "SURPLUS", V: true } }, { projectTree: m, projectMap: le, monomerMap: te } = W(), { outboundCfg: I } = G(), O = c(() => {
    if (H(m.value)) {
      const a = m.value.map((o) => ({ id: o.id, name: o.id !== "common" ? Q(o, { showSerialNumber: false }) : "公共库" }));
      return a.unshift({ id: "common", name: "公共库" }), a;
    } else return null;
  }), s = h, V = c(() => {
    var a, o;
    return ((a = I.value) == null ? void 0 : a.boolCanOutToOtherProject) === true && !((o = s.material) != null && o.boolPartyA);
  }), t = f(), p = { boolOutbound: void 0, projectId: void 0, workshopId: void 0, warehouseId: void 0, recipientId: void 0, outboundAddress: y.FACTORY.V }, e = f(JSON.parse(JSON.stringify(p))), S = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择车间位置", trigger: "change" }] };
  L(() => s.formData, (a) => {
    j(a);
  }, { deep: true, immediate: true });
  function j(a) {
    t.value && t.value.resetFields();
    let o;
    a && Object.keys(a).length > 0 ? o = a : o = JSON.parse(JSON.stringify(p)), e.value = JSON.parse(JSON.stringify(o)), t.value && z(() => {
      t.value.clearValidate();
    });
  }
  function k() {
    t.value && t.value.resetFields();
  }
  function C(a) {
    e.value.boolOutbound || (e.value.workshopId = a.workshopId);
  }
  function x() {
    const a = JSON.parse(JSON.stringify(e.value));
    Object.assign(s.formData, a);
  }
  function N() {
    e.value.monomerId = void 0, e.value.areaId = void 0;
  }
  function F() {
    e.value.workshopId = void 0, e.value.boolOutbound ? e.value.projectId === "common" && (e.value.projectId = void 0, e.value.outboundAddress = y.FACTORY.V) : e.value.outboundAddress = void 0;
  }
  async function P() {
    if (!await t.value.validate()) return false;
    e.value.boolPartyA = true;
    const o = JSON.parse(JSON.stringify(e.value));
    return Object.assign(s.formData, o), true;
  }
  function T() {
  }
  function A() {
    t.value && t.value.clearValidate();
  }
  return _({ validateForm: P, resetForm: T, assignForm: x, clearValidate: A, resetFields: k }), (a, o) => {
    const E = M, n = Y, J = b("common-radio"), U = b("common-select"), D = K;
    return d(), i(D, { ref_key: "formRef", ref: t, model: e.value, rules: S, "label-position": "right", "label-width": "100px", size: "default" }, { default: u(() => [r(n, { label: "是否出库", prop: "boolOutbound", style: { "margin-top": "10px" } }, { default: u(() => [r(E, { modelValue: e.value.boolOutbound, "onUpdate:modelValue": o[0] || (o[0] = (l) => e.value.boolOutbound = l), size: "large", onChange: F }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "钢板类型", prop: "type", style: { "margin-top": "10px" } }, { default: u(() => [r(J, { modelValue: e.value.boolSurplus, "onUpdate:modelValue": o[1] || (o[1] = (l) => e.value.boolSurplus = l), options: w, disabled: "", size: "default", type: "enum" }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "所属项目", prop: "projectId", style: { "margin-top": "10px" } }, { default: u(() => [r(U, { modelValue: e.value.projectId, "onUpdate:modelValue": o[2] || (o[2] = (l) => e.value.projectId = l), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !V.value, "disabled-val": e.value.boolOutbound ? ["common"] : [], options: O.value, clearable: "", filterable: "", placeholder: "所属项目", style: { width: "100%" }, type: "other", onChange: N }, { view: u(({ data: l }) => [R("span", { style: q(`color:${!e.value.boolOutbound && l.id === "common" ? "#e6a23c" : ""}`) }, B(l.name), 5)]), _: 1 }, 8, ["modelValue", "disabled", "disabled-val", "options"])]), _: 1 }), e.value.boolOutbound ? (d(), i(n, { key: 0, label: "领用车间", prop: "workshopId", style: { "margin-top": "10px" } }, { default: u(() => [r(v(X), { modelValue: e.value.workshopId, "onUpdate:modelValue": o[3] || (o[3] = (l) => e.value.workshopId = l), "factory-id": e.value.factoryId, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "factory-id"])]), _: 1 })) : g("", true), r(n, { label: "车间位置", prop: "warehouseId", style: { "margin-top": "10px" } }, { default: u(() => [r(Z, { modelValue: e.value.warehouseId, "onUpdate:modelValue": o[4] || (o[4] = (l) => e.value.warehouseId = l), "basic-class": v(ee).STEEL_PLATE.V, "factory-id": e.value.factoryId, "show-all": true, placeholder: "车间位置", style: { width: "100%" }, onInfoChange: C }, null, 8, ["modelValue", "basic-class", "factory-id"])]), _: 1 }), e.value.boolOutbound ? (d(), i(n, { key: 1, label: "领用人", prop: "recipientId", style: { "margin-top": "10px" } }, { default: u(() => [r(oe, { modelValue: e.value.recipientId, "onUpdate:modelValue": o[5] || (o[5] = (l) => e.value.recipientId = l), "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : g("", true)]), _: 1 }, 8, ["model"]);
  };
} }, ne = $(ae, [["__scopeId", "data-v-0f755122"]]);
export {
  ne as default
};
