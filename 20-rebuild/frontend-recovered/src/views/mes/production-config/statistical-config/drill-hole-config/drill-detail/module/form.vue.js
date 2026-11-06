import { ref as d } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as P } from "vue";
import { createBlock as R } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as k } from "vue";
import { createElementVNode as z } from "vue";
import { unref as c } from "vue";
import { isRef as I } from "vue";
import { ElNotification as N } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { ElForm as C } from "element-plus";
import { l as p, t as j, u as U } from "../../../../../../../shared/runtime.js";
function q(o) {
  return p({ module: "mes", url: "borehole/link", method: "post", data: o });
}
function F(o) {
  return p({ module: "mes", url: "borehole/link", method: "put", data: o });
}
function H(o) {
  return p({ module: "mes", url: "borehole/link", method: "delete", data: o });
}
const G = { __name: "form", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, layingOffRowId: { type: Number }, formData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(o, { emit: B }) {
  const { decimalPrecision: V } = j(), v = B, b = d(), _ = d(false), t = o, { visible: u, handleClose: y } = U({ emit: v, props: t, field: "visible", showHook: w }), e = d({ id: void 0, unitPrice: void 0, numBoreDiameter: void 0 });
  function w() {
    t.isEdit ? e.value = t.formData : e.value = {};
  }
  const D = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], numBoreDiameter: [{ required: true, validator: (s, l, n) => {
    !e.value.minBoreDiameter || !e.value.maxBoreDiameter ? n(new Error("请填写孔径")) : e.value.maxBoreDiameter < e.value.minBoreDiameter && n(new Error("最大孔径不得小于最小孔径")), n();
  }, message: "请填写孔径", trigger: "blur" }] };
  async function h() {
    try {
      await b.value.validate() && (_.value = true, t.isEdit ? await F({ ...e.value, layingOffRowId: t.layingOffRowId }) : await q({ ...e.value, boreholeConfigId: t.layingOffRowId }), N({ title: `${t.isEdit ? "编辑" : "新增"}成功`, type: "success" }), y(), v("refresh", e.value));
    } catch (s) {
      console.log("切割详情配置失败", s);
    } finally {
      _.value = false;
    }
  }
  return (s, l) => {
    const n = f("common-button"), m = f("common-input-number"), g = O, x = C, E = f("common-dialog");
    return P(), R(E, { "append-to-body": "", "close-on-click-modal": false, "before-close": c(y), modelValue: c(u), "onUpdate:modelValue": l[3] || (l[3] = (a) => I(u) ? u.value = a : null), title: `${o.isEdit ? "编辑" : "新增"}切割详情`, width: "500px" }, { titleRight: r(() => [i(n, { type: "primary", size: "default", onClick: h }, { default: r(() => l[4] || (l[4] = [k("提交")])), _: 1, __: [4] })]), default: r(() => [i(x, { ref_key: "formRef", ref: b, model: e.value, rules: D, size: "default", "label-width": "170px" }, { default: r(() => [i(g, { label: "孔径数值范围（毫米）", prop: "numBoreDiameter" }, { default: r(() => [i(m, { modelValue: e.value.minBoreDiameter, "onUpdate:modelValue": l[0] || (l[0] = (a) => e.value.minBoreDiameter = a), step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小孔径(毫米)", style: { width: "45%" } }, null, 8, ["modelValue"]), l[5] || (l[5] = z("span", null, " ~ ", -1)), i(m, { modelValue: e.value.maxBoreDiameter, "onUpdate:modelValue": l[1] || (l[1] = (a) => e.value.maxBoreDiameter = a), step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大孔径(毫米)", style: { width: "45%" } }, null, 8, ["modelValue"])]), _: 1, __: [5] }), i(g, { label: "单价（元/个）", prop: "unitPrice" }, { default: r(() => [i(m, { modelValue: e.value.unitPrice, "onUpdate:modelValue": l[2] || (l[2] = (a) => e.value.unitPrice = a), step: 1, min: 0, precision: c(V).mes, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue", "title"]);
  };
} }, L = Object.freeze(Object.defineProperty({ __proto__: null, default: G }, Symbol.toStringTag, { value: "Module" }));
export {
  G as _,
  H as d,
  L as f
};
