import { computed as b } from "vue";
import { ref as v } from "vue";
import { watch as L } from "vue";
import { nextTick as z } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as p } from "vue";
import { createBlock as m } from "vue";
import { withCtx as n } from "vue";
import { createVNode as r } from "vue";
import { createElementVNode as B } from "vue";
import { normalizeStyle as R } from "vue";
import { toDisplayString as q } from "vue";
import { unref as y } from "vue";
import { createCommentVNode as h } from "vue";
import { ElCheckbox as M } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElForm as K } from "element-plus";
import { _ as $, fg as W, jY as G, i as H, z as Q, qS as _, aV as X, r9 as Z, bl as ee, cy as oe, b as ae } from "../../../../../../../../../shared/runtime.js";
const le = { __name: "preview-form", props: { formData: { type: Object, default: () => {
} }, material: { type: Object } }, setup(w, { expose: O }) {
  const I = { PLATE: { L: "整料", K: "PLATE", V: false }, SURPLUS: { L: "余料", K: "SURPLUS", V: true } }, { projectTree: c, projectMap: te, monomerMap: re } = W(), { outboundCfg: V } = G(), j = b(() => {
    if (H(c.value)) {
      const a = c.value.map((o) => ({ id: o.id, name: o.id !== "common" ? Q(o, { showSerialNumber: false }) : "公共库" }));
      return a.unshift({ id: "common", name: "公共库" }), a;
    } else return null;
  }), s = w, S = b(() => {
    var a, o;
    return ((a = V.value) == null ? void 0 : a.boolCanOutToOtherProject) === true && !((o = s.material) != null && o.boolPartyA);
  }), t = v(), f = { boolOutbound: void 0, projectId: void 0, workshopId: void 0, warehouseId: void 0, recipientId: void 0, outboundAddress: _.FACTORY.V }, e = v(JSON.parse(JSON.stringify(f))), k = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }], projectId: [{ validator: (a, o, d) => {
    var u, i;
    if (((i = (u = s.material) == null ? void 0 : u.project) != null && i.id || e.value.boolOutbound) && ae(o)) return d(new Error("请选择项目"));
    d();
  }, trigger: "change" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择车间位置", trigger: "change" }] };
  L(() => s.formData, (a) => {
    C(a);
  }, { deep: true, immediate: true });
  function C(a) {
    t.value && t.value.resetFields();
    let o;
    a && Object.keys(a).length > 0 ? o = a : o = JSON.parse(JSON.stringify(f)), e.value = JSON.parse(JSON.stringify(o)), t.value && z(() => {
      t.value.clearValidate();
    });
  }
  function x() {
    t.value && t.value.resetFields();
  }
  function N() {
    const a = JSON.parse(JSON.stringify(e.value));
    Object.assign(s.formData, a);
  }
  function F() {
  }
  function P(a) {
    e.value.boolOutbound || (e.value.workshopId = a.workshopId);
  }
  function T() {
    e.value.workshopId = void 0, e.value.boolOutbound ? e.value.projectId === "common" && (e.value.projectId = void 0, e.value.outboundAddress = _.FACTORY.V) : e.value.outboundAddress = void 0;
  }
  async function A() {
    if (!await t.value.validate()) return false;
    e.value.boolPartyA = false;
    const o = JSON.parse(JSON.stringify(e.value));
    return Object.assign(s.formData, o), true;
  }
  function E() {
  }
  function J() {
    t.value && t.value.clearValidate();
  }
  return O({ validateForm: A, resetForm: E, assignForm: N, clearValidate: J, resetFields: x }), (a, o) => {
    const d = M, u = Y, i = g("common-radio"), U = g("common-select"), D = K;
    return p(), m(D, { ref_key: "formRef", ref: t, model: e.value, rules: k, size: "default", "label-position": "right", "label-width": "100px" }, { default: n(() => [r(u, { prop: "boolOutbound", label: "是否出库", style: { "margin-top": "10px" } }, { default: n(() => [r(d, { modelValue: e.value.boolOutbound, "onUpdate:modelValue": o[0] || (o[0] = (l) => e.value.boolOutbound = l), size: "large", onChange: T }, null, 8, ["modelValue"])]), _: 1 }), r(u, { prop: "type", label: "钢板类型", style: { "margin-top": "10px" } }, { default: n(() => [r(i, { modelValue: e.value.boolSurplus, "onUpdate:modelValue": o[1] || (o[1] = (l) => e.value.boolSurplus = l), options: I, type: "enum", size: "default", disabled: "" }, null, 8, ["modelValue"])]), _: 1 }), r(u, { prop: "projectId", label: "所属项目", style: { "margin-top": "10px" } }, { default: n(() => [r(U, { modelValue: e.value.projectId, "onUpdate:modelValue": o[2] || (o[2] = (l) => e.value.projectId = l), options: j.value, "disabled-val": e.value.boolOutbound ? ["common"] : [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", placeholder: "所属项目", style: { width: "100%" }, onChange: F, disabled: !S.value }, { view: n(({ data: l }) => [B("span", { style: R(`color:${!e.value.boolOutbound && l.id === "common" ? "#e6a23c" : ""}`) }, q(l.name), 5)]), _: 1 }, 8, ["modelValue", "options", "disabled-val", "disabled"])]), _: 1 }), e.value.boolOutbound ? (p(), m(u, { key: 0, prop: "workshopId", label: "领用车间", style: { "margin-top": "10px" } }, { default: n(() => [r(y(X), { modelValue: e.value.workshopId, "onUpdate:modelValue": o[3] || (o[3] = (l) => e.value.workshopId = l), "factory-id": e.value.factoryId, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "factory-id"])]), _: 1 })) : h("", true), r(u, { prop: "warehouseId", label: "车间位置", style: { "margin-top": "10px" } }, { default: n(() => [r(Z, { modelValue: e.value.warehouseId, "onUpdate:modelValue": o[4] || (o[4] = (l) => e.value.warehouseId = l), "factory-id": e.value.factoryId, "basic-class": y(ee).STEEL_PLATE.V, "show-all": true, style: { width: "100%" }, placeholder: "车间位置", onInfoChange: P }, null, 8, ["modelValue", "factory-id", "basic-class"])]), _: 1 }), e.value.boolOutbound ? (p(), m(u, { key: 1, prop: "recipientId", label: "领用人", style: { "margin-top": "10px" } }, { default: n(() => [r(oe, { modelValue: e.value.recipientId, "onUpdate:modelValue": o[5] || (o[5] = (l) => e.value.recipientId = l), "collapse-tags": false, clearable: "", filterable: "", "show-all-levels": "", placeholder: "领用人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["model"]);
  };
} }, de = $(le, [["__scopeId", "data-v-3622bb78"]]);
export {
  de as default
};
