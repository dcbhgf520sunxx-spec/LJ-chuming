import { ref as h } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as g } from "vue";
import { createBlock as G } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as a } from "vue";
import { createElementVNode as y } from "vue";
import { unref as _ } from "vue";
import { createElementBlock as M } from "vue";
import { Fragment as v } from "vue";
import { renderList as N } from "vue";
import { toDisplayString as K } from "vue";
import { createCommentVNode as O } from "vue";
import { isRef as S } from "vue";
import { ElMessage as H } from "element-plus";
import { nextTick as z } from "vue";
import { ElFormItem as P } from "element-plus";
import { InfoFilled as q } from "@element-plus/icons-vue";
import { ElIcon as $ } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElForm as Q } from "element-plus";
import { a as X } from "../../../../../../modules/inventory-error-config-927b9f3e.js";
import { _ as Y, a3 as i, u as Z, fv as ee, V as te, c as le } from "../../../../../../shared/runtime.js";
const oe = { class: "form-title" }, ae = { class: "form-list" }, se = { __name: "form", props: { visible: { type: Boolean, default: false } }, emits: ["success", "update:visible"], setup(C, { emit: I }) {
  const T = I, W = C, r = h(), A = h(false), u = h({ boolGeneralConfig: false, projectId: void 0, detailDTOList: [{ title: "构件误差", productType: i.ARTIFACT.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: "部件误差", productType: i.ASSEMBLE.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: "零件误差", productType: i.MACHINE_PART.V, length: 0, netWeight: 0, grossWeight: 0, thickness: 0, width: 0, surfaceArea: 0 }] }), { visible: V, handleClose: w } = Z({ emit: T, props: W, field: "visible", showHook: U, closeHook: F }), E = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }] };
  function U() {
  }
  async function k() {
    try {
      if (A.value = true, !await r.value.validate()) return false;
      const e = te(u.value);
      e.detailDTOList = D(e.detailDTOList), await X(e), H.success("新增成功！"), T("success"), x(), w();
    } catch (d) {
      console.log(d);
    } finally {
      A.value = false;
    }
  }
  function D(d) {
    return d.map((e) => (e.surfaceArea && (e.surfaceArea = le(e.surfaceArea, "m²", "mm²")), e));
  }
  function x() {
    z(() => {
      r.value && r.value.resetFields(), r.value && r.value.clearValidate(), u.value.detailDTOList = [{ title: "构件误差", productType: i.ARTIFACT.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: "部件误差", productType: i.ASSEMBLE.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: "零件误差", productType: i.MACHINE_PART.V, length: 0, netWeight: 0, grossWeight: 0, thickness: 0, width: 0, surfaceArea: 0 }];
    });
  }
  function F() {
    x();
  }
  return (d, e) => {
    const L = b("common-button"), n = P, m = q, p = $, f = J, c = b("common-input-number"), R = Q, B = b("common-drawer");
    return g(), G(B, { customClass: "assistance-record", ref: "drawerRef", title: "新增配置", modelValue: _(V), "onUpdate:modelValue": e[1] || (e[1] = (o) => S(V) ? V.value = o : null), "before-close": _(w), size: "60%" }, { titleRight: l(() => [t(L, { type: "primary", size: "default", onClick: k }, { default: l(() => e[2] || (e[2] = [a("确认")])), _: 1, __: [2] })]), content: l(() => [t(R, { ref_key: "formRef", ref: r, model: u.value, rules: E, size: "default", "label-width": "160px" }, { default: l(() => [e[15] || (e[15] = y("div", { class: "form-title" }, "应用项目", -1)), t(n, { label: "选择项目：", prop: "projectId" }, { default: l(() => [t(_(ee), { modelValue: u.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (o) => u.value.projectId = o), class: "filter-item", style: { width: "450px" }, placeholder: "请选择项目", onChange: d.projectChange }, null, 8, ["modelValue", "onChange"])]), _: 1 }), (g(true), M(v, null, N(u.value.detailDTOList, (o, j) => (g(), M(v, { key: j }, [y("div", oe, K(o.title), 1), y("div", ae, [t(n, { label: "长度（MM）：", class: "form-item" }, { label: l(() => [e[3] || (e[3] = a(" 长度（MM） ")), t(f, { class: "item", effect: "light", content: "长度最大误差100MM", placement: "top" }, { default: l(() => [t(p, null, { default: l(() => [t(m)]), _: 1 })]), _: 1 }), e[4] || (e[4] = a(" ： "))]), default: l(() => [t(c, { modelValue: o.length, "onUpdate:modelValue": (s) => o.length = s, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(n, { label: "单净重（KG）：", class: "form-item" }, { label: l(() => [e[5] || (e[5] = a(" 单净重（KG） ")), t(f, { class: "item", effect: "light", content: "单净重最大误差100KG", placement: "top" }, { default: l(() => [t(p, null, { default: l(() => [t(m)]), _: 1 })]), _: 1 }), e[6] || (e[6] = a(" ： "))]), default: l(() => [t(c, { modelValue: o.netWeight, "onUpdate:modelValue": (s) => o.netWeight = s, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(n, { label: "单毛重（KG）：", class: "form-item" }, { label: l(() => [e[7] || (e[7] = a(" 单毛重（KG） ")), t(f, { class: "item", effect: "light", content: "单毛重最大误差100KG", placement: "top" }, { default: l(() => [t(p, null, { default: l(() => [t(m)]), _: 1 })]), _: 1 }), e[8] || (e[8] = a(" ： "))]), default: l(() => [t(c, { modelValue: o.grossWeight, "onUpdate:modelValue": (s) => o.grossWeight = s, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), o.productType === _(i).MACHINE_PART.V ? (g(), M(v, { key: 0 }, [t(n, { label: "规格（厚度 MM）" }, { label: l(() => [e[9] || (e[9] = a(" 规格（厚度 MM） ")), t(f, { class: "item", effect: "light", content: "截面厚度最大误差200MM", placement: "top" }, { default: l(() => [t(p, null, { default: l(() => [t(m)]), _: 1 })]), _: 1 }), e[10] || (e[10] = a(" ： "))]), default: l(() => [t(c, { modelValue: o.thickness, "onUpdate:modelValue": (s) => o.thickness = s, "controls-position": "right", precision: 2, min: 0, max: 200, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(n, { label: "规格（宽度 MM）" }, { label: l(() => [e[11] || (e[11] = a(" 规格（宽度 MM） ")), t(f, { class: "item", effect: "light", content: "截面宽度最大误差200MM", placement: "top" }, { default: l(() => [t(p, null, { default: l(() => [t(m)]), _: 1 })]), _: 1 }), e[12] || (e[12] = a(" ： "))]), default: l(() => [t(c, { modelValue: o.width, "onUpdate:modelValue": (s) => o.width = s, "controls-position": "right", precision: 2, min: 0, max: 200, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)], 64)) : O("", true), t(n, { label: "单面积（M²）：", class: "form-item" }, { label: l(() => [e[13] || (e[13] = a(" 单面积（M²） ")), t(f, { class: "item", effect: "light", content: "单面积最大误差1M²", placement: "top" }, { default: l(() => [t(p, null, { default: l(() => [t(m)]), _: 1 })]), _: 1 }), e[14] || (e[14] = a(" ： "))]), default: l(() => [t(c, { modelValue: o.surfaceArea, "onUpdate:modelValue": (s) => o.surfaceArea = s, "controls-position": "right", precision: 3, min: 0, max: 1e6, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)])], 64))), 128))]), _: 1, __: [15] }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = Y(se, [["__scopeId", "data-v-9e89ec5e"]]);
export {
  ue as default
};
