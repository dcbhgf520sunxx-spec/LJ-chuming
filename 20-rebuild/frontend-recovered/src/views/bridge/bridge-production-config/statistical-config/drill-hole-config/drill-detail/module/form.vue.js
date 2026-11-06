import { ref as m } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as E } from "vue";
import { createBlock as R } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as k } from "vue";
import { createElementVNode as z } from "vue";
import { unref as y } from "vue";
import { isRef as I } from "vue";
import { ElNotification as N } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { ElForm as P } from "element-plus";
import { l as p, u as C } from "../../../../../../../shared/runtime.js";
function j(o) {
  return p({ module: "bridge", url: "borehole/link", method: "post", data: o });
}
function U(o) {
  return p({ module: "bridge", url: "borehole/link", method: "put", data: o });
}
function T(o) {
  return p({ module: "bridge", url: "borehole/link", method: "delete", data: o });
}
const q = { __name: "form", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, layingOffRowId: { type: Number }, formData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(o, { emit: B }) {
  const c = B, b = m(), v = m(false), t = o, { visible: s, handleClose: _ } = C({ emit: c, props: t, field: "visible", showHook: V }), e = m({ id: void 0, unitPrice: void 0, numBoreDiameter: void 0 });
  function V() {
    t.isEdit ? e.value = t.formData : e.value = {};
  }
  const w = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numBoreDiameter: [{ required: true, validator: (u, l, n) => {
    !e.value.minBoreDiameter || !e.value.maxBoreDiameter ? n(new Error("请填写孔径")) : e.value.maxBoreDiameter < e.value.minBoreDiameter && n(new Error("最大孔径不得小于最小孔径")), n();
  }, message: "请填写孔径", trigger: "blur" }] };
  async function D() {
    try {
      await b.value.validate() && (v.value = true, t.isEdit ? await U({ ...e.value, layingOffRowId: t.layingOffRowId }) : await j({ ...e.value, boreholeConfigId: t.layingOffRowId }), N({ title: `${t.isEdit ? "编辑" : "新增"}成功`, type: "success" }), _(), c("refresh", e.value));
    } catch (u) {
      console.log("切割详情配置失败", u);
    } finally {
      v.value = false;
    }
  }
  return (u, l) => {
    const n = f("common-button"), d = f("common-input-number"), g = O, h = P, x = f("common-dialog");
    return E(), R(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": y(_), modelValue: y(s), "onUpdate:modelValue": l[3] || (l[3] = (a) => I(s) ? s.value = a : null), title: `${o.isEdit ? "编辑" : "新增"}切割详情`, width: "500px" }, { titleRight: r(() => [i(n, { type: "primary", size: "default", onClick: D }, { default: r(() => l[4] || (l[4] = [k("提交")])), _: 1, __: [4] })]), default: r(() => [i(h, { ref_key: "formRef", ref: b, model: e.value, rules: w, size: "default", "label-width": "170px" }, { default: r(() => [i(g, { label: "孔径数值范围（毫米）", prop: "numBoreDiameter" }, { default: r(() => [i(d, { modelValue: e.value.minBoreDiameter, "onUpdate:modelValue": l[0] || (l[0] = (a) => e.value.minBoreDiameter = a), step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小孔径(毫米)", style: { width: "45%" } }, null, 8, ["modelValue"]), l[5] || (l[5] = z("span", null, " ~ ", -1)), i(d, { modelValue: e.value.maxBoreDiameter, "onUpdate:modelValue": l[1] || (l[1] = (a) => e.value.maxBoreDiameter = a), step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大孔径(毫米)", style: { width: "45%" } }, null, 8, ["modelValue"])]), _: 1, __: [5] }), i(g, { label: "单价（元/个）", prop: "unitPrice" }, { default: r(() => [i(d, { modelValue: e.value.unitPrice, "onUpdate:modelValue": l[2] || (l[2] = (a) => e.value.unitPrice = a), step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue", "title"]);
  };
} }, $ = Object.freeze(Object.defineProperty({ __proto__: null, default: q }, Symbol.toStringTag, { value: "Module" }));
export {
  q as _,
  T as d,
  $ as f
};
