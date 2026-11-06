import { reactive as x } from "vue";
import { ref as w } from "vue";
import { watch as C } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as z } from "vue";
import { withCtx as n } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as A } from "vue";
import { unref as o } from "vue";
import { createElementBlock as E } from "vue";
import { toDisplayString as S } from "vue";
import { createCommentVNode as U } from "vue";
import { isRef as B } from "vue";
import { ElNotification as F } from "element-plus";
import { ElFormItem as T } from "element-plus";
import { ElCheckbox as D } from "element-plus";
import { ElForm as I } from "element-plus";
import { d as N } from "../../../../../../modules/painting-26fedd54.js";
import { _ as j, u as M, bY as O, D as R, V as L, c as P } from "../../../../../../shared/runtime.js";
const Y = { key: 0 }, q = { __name: "edit-form", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(b, { emit: y }) {
  const c = y, m = b, { visible: d, handleClose: f } = M({ emit: c, props: m, field: "visible" });
  let e = x({});
  const r = w(false);
  C(() => m.visible, (l) => {
    l && (e = Object.assign(e, m.info));
  }, { immediate: true });
  async function v() {
    try {
      r.value = true;
      const l = L(e);
      l.surfaceArea = P(l.surfaceArea, "㎡", "mm²"), l.loss = l.loss / 100, l.volumeSolids = l.volumeSolids / 100, e.applyAll && delete l.monomerId, await N(l), F({ title: "保存成功", type: "success" }), f(), c("refresh");
    } catch (l) {
      console.log("保存失败", l);
    } finally {
      r.value = false;
    }
  }
  return (l, t) => {
    const V = u("common-button"), i = T, p = u("common-input-number"), g = D, h = I, k = u("common-dialog");
    return _(), z(k, { title: "涂装计算", modelValue: o(d), "onUpdate:modelValue": t[4] || (t[4] = (a) => B(d) ? d.value = a : null), width: "450px", "before-close": o(f) }, { titleRight: n(() => [s(V, { loading: r.value, type: "primary", size: "default", onClick: v }, { default: n(() => t[5] || (t[5] = [A(" 保 存 ")])), _: 1, __: [5] }, 8, ["loading"])]), default: n(() => [s(h, { ref: "formRef", model: o(e), size: "default", "label-width": "120px" }, { default: n(() => [s(i, { label: "油漆类别" }, { default: n(() => [o(e).paintingType ? (_(), E("span", Y, S(o(O).VL[o(e).paintingType]), 1)) : U("", true)]), _: 1 }), s(i, { label: "干膜厚度(μm)", prop: "thickness" }, { default: n(() => [s(p, { modelValue: o(e).thickness, "onUpdate:modelValue": t[0] || (t[0] = (a) => o(e).thickness = a), step: 1, min: 0, precision: o(R).COM_T__MM, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "请输入干膜厚度" }, null, 8, ["modelValue", "precision"])]), _: 1 }), s(i, { label: "体积固体份(%)", prop: "volumeSolids" }, { default: n(() => [s(p, { modelValue: o(e).volumeSolids, "onUpdate:modelValue": t[1] || (t[1] = (a) => o(e).volumeSolids = a), step: 1, min: 0, precision: 2, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "请输入体积固体份" }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "损耗(%)", prop: "loss" }, { default: n(() => [s(p, { modelValue: o(e).loss, "onUpdate:modelValue": t[2] || (t[2] = (a) => o(e).loss = a), step: 1, min: 0, precision: 2, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "请输入损耗" }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "应用全部单体", prop: "applyAll" }, { default: n(() => [s(g, { modelValue: o(e).applyAll, "onUpdate:modelValue": t[3] || (t[3] = (a) => o(e).applyAll = a), label: "全部单体" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, K = j(q, [["__scopeId", "data-v-63eaea87"]]);
export {
  K as default
};
