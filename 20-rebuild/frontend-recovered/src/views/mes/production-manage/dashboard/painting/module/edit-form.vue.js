import { reactive as S } from "vue";
import { ref as c } from "vue";
import { watch as z } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as g } from "vue";
import { createBlock as A } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as U } from "vue";
import { unref as o } from "vue";
import { createElementBlock as B } from "vue";
import { toDisplayString as D } from "vue";
import { createCommentVNode as F } from "vue";
import { isRef as T } from "vue";
import { ElNotification as I } from "element-plus";
import { ElFormItem as N } from "element-plus";
import { ElCheckbox as R } from "element-plus";
import { ElForm as j } from "element-plus";
import { d as M } from "../../../../../../modules/painting-22de8667.js";
import { _ as O, u as q, bY as L, D as P, V as Y, c as G } from "../../../../../../shared/runtime.js";
const H = { key: 0 }, J = { __name: "edit-form", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(V, { emit: h }) {
  const _ = h, d = V, { visible: m, handleClose: v } = q({ emit: _, props: d, field: "visible" });
  let l = S({});
  const b = c(), u = c(false), y = (i, e, r) => {
    e || r(new Error("填写数据必须大于0")), r();
  }, k = c({ thickness: [{ required: true, validator: y, trigger: "blur" }], volumeSolids: [{ required: true, validator: y, trigger: "blur" }] });
  z(() => d.visible, (i) => {
    i && (l = Object.assign(l, d.info));
  }, { immediate: true });
  async function w() {
    try {
      if (u.value = true, !await b.value.validate()) return false;
      const e = Y(l);
      e.surfaceArea = G(e.surfaceArea, "㎡", "mm²"), e.loss = e.loss / 100, e.volumeSolids = e.volumeSolids / 100, l.applyAll && delete e.monomerId, await M(e), I({ title: "保存成功", type: "success" }), v(), _("refresh");
    } catch (i) {
      console.log("保存失败", i);
    } finally {
      u.value = false;
    }
  }
  return (i, e) => {
    const r = f("common-button"), n = N, p = f("common-input-number"), x = R, C = j, E = f("common-dialog");
    return g(), A(E, { title: "涂装计算", modelValue: o(m), "onUpdate:modelValue": e[4] || (e[4] = (s) => T(m) ? m.value = s : null), width: "450px", "before-close": o(v) }, { titleRight: a(() => [t(r, { loading: u.value, type: "primary", size: "default", onClick: w }, { default: a(() => e[5] || (e[5] = [U(" 保 存 ")])), _: 1, __: [5] }, 8, ["loading"])]), default: a(() => [t(C, { ref_key: "formRef", ref: b, model: o(l), rules: k.value, size: "default", "label-width": "120px" }, { default: a(() => [t(n, { label: "油漆类别" }, { default: a(() => [o(l).paintingType ? (g(), B("span", H, D(o(L).VL[o(l).paintingType]), 1)) : F("", true)]), _: 1 }), t(n, { label: "干膜厚度(μm)", prop: "thickness" }, { default: a(() => [t(p, { modelValue: o(l).thickness, "onUpdate:modelValue": e[0] || (e[0] = (s) => o(l).thickness = s), step: 1, precision: o(P).COM_T__MM, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "请输入干膜厚度" }, null, 8, ["modelValue", "precision"])]), _: 1 }), t(n, { label: "体积固体份(%)", prop: "volumeSolids" }, { default: a(() => [t(p, { modelValue: o(l).volumeSolids, "onUpdate:modelValue": e[1] || (e[1] = (s) => o(l).volumeSolids = s), step: 1, precision: 2, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "请输入体积固体份" }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "损耗(%)", prop: "loss" }, { default: a(() => [t(p, { modelValue: o(l).loss, "onUpdate:modelValue": e[2] || (e[2] = (s) => o(l).loss = s), step: 1, min: 0, precision: 2, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "请输入损耗" }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "应用全部单体", prop: "applyAll" }, { default: a(() => [t(x, { modelValue: o(l).applyAll, "onUpdate:modelValue": e[3] || (e[3] = (s) => o(l).applyAll = s), label: "全部单体" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = O(J, [["__scopeId", "data-v-a03289cf"]]);
export {
  X as default
};
