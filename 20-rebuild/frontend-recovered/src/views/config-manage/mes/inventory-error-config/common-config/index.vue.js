import { ref as p } from "vue";
import { onMounted as S } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as b } from "vue";
import { unref as _ } from "vue";
import { createBlock as E } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as n } from "vue";
import { createCommentVNode as k } from "vue";
import { withDirectives as B } from "vue";
import { Fragment as A } from "vue";
import { renderList as F } from "vue";
import { toDisplayString as R } from "vue";
import { createVNode as t } from "vue";
import { ElMessage as D } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as P } from "element-plus";
import { ElTooltip as z } from "element-plus";
import { ElFormItem as H } from "element-plus";
import { ElForm as J } from "element-plus";
import { vLoading as j } from "element-plus";
import { g as q, e as Q } from "../../../../../modules/inventory-error-config-927b9f3e.js";
import { _ as X, a3 as r, G as T, fr as v, c as U, V as Y } from "../../../../../shared/runtime.js";
const Z = { class: "type-title" }, $ = { class: "form-list" }, ee = { key: 1 }, te = { __name: "index", setup(le) {
  const V = p({ boolGeneralConfig: true, detailDTOList: [{ title: r.ARTIFACT.L, productType: r.ARTIFACT.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: r.ASSEMBLE.L, productType: r.ASSEMBLE.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: r.MACHINE_PART.L, productType: r.MACHINE_PART.V, length: 0, netWeight: 0, grossWeight: 0, thickness: 0, width: 0, surfaceArea: 0 }] }), y = p([]), M = p(false);
  async function x() {
    var i;
    try {
      if (M.value = true, !T(v.get)) {
        D.error("暂无权限！");
        return;
      }
      const e = { boolGeneralConfig: true, pageSize: 20, pageNumber: 1 }, { content: h } = await q(e);
      y.value = ((i = h[0]) == null ? void 0 : i.detailDTOList) || [], y.value.length && y.value.map((a) => (a.title = r.VL[a.productType], a.surfaceArea = a.surfaceArea && U(a.surfaceArea, "mm²", "m²"), a)), V.value.detailDTOList = JSON.parse(JSON.stringify(y.value));
    } catch (e) {
      console.log(e);
    } finally {
      M.value = false;
    }
  }
  const L = p(false), w = p();
  async function I() {
    try {
      if (L.value = true, !await w.value.validate()) return false;
      const e = Y(V.value);
      e.detailDTOList = N(e.detailDTOList), await Q(e), D.success("保存成功！"), x();
    } catch (i) {
      console.log(i);
    } finally {
      L.value = false;
    }
  }
  function N(i) {
    return i.map((e) => (e.surfaceArea && (e.surfaceArea = U(e.surfaceArea, "m²", "mm²")), e));
  }
  return S(() => {
    x();
  }), (i, e) => {
    const h = C("common-button"), a = K, d = P, m = z, f = C("common-input-number"), c = H, O = J, W = j;
    return u(), g("div", null, [b("div", null, [_(T)(_(v).edit) ? (u(), E(h, { key: 0, size: "default", type: "success", onClick: I, style: { "margin-bottom": "10px" } }, { default: l(() => e[0] || (e[0] = [n(" 保存 ")])), _: 1, __: [0] })) : k("", true)]), _(T)(_(v).get) ? B((u(), E(O, { key: 0, ref_key: "formRef", ref: w, model: V.value, "label-width": "160px" }, { default: l(() => [(u(true), g(A, null, F(V.value.detailDTOList, (o, G) => (u(), g(A, { key: G }, [b("div", Z, R(o.title), 1), b("div", $, [t(c, { class: "form-item" }, { label: l(() => [e[1] || (e[1] = n(" 长度（MM） ")), t(m, { class: "item", effect: "light", content: "长度最大误差100MM", placement: "top" }, { default: l(() => [t(d, null, { default: l(() => [t(a)]), _: 1 })]), _: 1 }), e[2] || (e[2] = n(" ： "))]), default: l(() => [t(f, { modelValue: o.length, "onUpdate:modelValue": (s) => o.length = s, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(c, { label: "单净重（KG）：", class: "form-item" }, { label: l(() => [e[3] || (e[3] = n(" 单净重（KG） ")), t(m, { class: "item", effect: "light", content: "单净重最大误差100KG", placement: "top" }, { default: l(() => [t(d, null, { default: l(() => [t(a)]), _: 1 })]), _: 1 }), e[4] || (e[4] = n(" ： "))]), default: l(() => [t(f, { modelValue: o.netWeight, "onUpdate:modelValue": (s) => o.netWeight = s, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(c, { label: "单毛重（KG）：", class: "form-item" }, { label: l(() => [e[5] || (e[5] = n(" 单毛重（KG） ")), t(m, { class: "item", effect: "light", content: "单毛重最大误差100KG", placement: "top" }, { default: l(() => [t(d, null, { default: l(() => [t(a)]), _: 1 })]), _: 1 }), e[6] || (e[6] = n(" ： "))]), default: l(() => [t(f, { modelValue: o.grossWeight, "onUpdate:modelValue": (s) => o.grossWeight = s, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), o.productType === _(r).MACHINE_PART.V ? (u(), g(A, { key: 0 }, [t(c, { label: "规格（厚度 MM）" }, { label: l(() => [e[7] || (e[7] = n(" 规格（厚度 MM） ")), t(m, { class: "item", effect: "light", content: "截面厚度最大误差200MM", placement: "top" }, { default: l(() => [t(d, null, { default: l(() => [t(a)]), _: 1 })]), _: 1 }), e[8] || (e[8] = n(" ： "))]), default: l(() => [t(f, { modelValue: o.thickness, "onUpdate:modelValue": (s) => o.thickness = s, "controls-position": "right", precision: 2, min: 0, max: 200, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(c, { label: "规格（宽度 MM）" }, { label: l(() => [e[9] || (e[9] = n(" 规格（宽度 MM） ")), t(m, { class: "item", effect: "light", content: "截面宽度最大误差200MM", placement: "top" }, { default: l(() => [t(d, null, { default: l(() => [t(a)]), _: 1 })]), _: 1 }), e[10] || (e[10] = n(" ： "))]), default: l(() => [t(f, { modelValue: o.width, "onUpdate:modelValue": (s) => o.width = s, "controls-position": "right", precision: 2, min: 0, max: 200, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)], 64)) : k("", true), t(c, { label: "单面积（M²）：", class: "form-item" }, { label: l(() => [e[11] || (e[11] = n(" 单面积（M²） ")), t(m, { class: "item", effect: "light", content: "单面积最大误差1M²", placement: "top" }, { default: l(() => [t(d, null, { default: l(() => [t(a)]), _: 1 })]), _: 1 }), e[12] || (e[12] = n(" ： "))]), default: l(() => [t(f, { modelValue: o.surfaceArea, "onUpdate:modelValue": (s) => o.surfaceArea = s, "controls-position": "right", precision: 3, min: 0, max: 1e6, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)])], 64))), 128))]), _: 1 }, 8, ["model"])), [[W, M.value]]) : (u(), g("div", ee, "暂无权限！"))]);
  };
} }, se = X(te, [["__scopeId", "data-v-1a9c73a2"]]);
export {
  se as default
};
