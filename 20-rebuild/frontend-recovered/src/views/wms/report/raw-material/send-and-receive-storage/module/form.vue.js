import { ref as d } from "vue";
import { watch as B } from "vue";
import { nextTick as J } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as R } from "vue";
import { createBlock as q } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as E } from "vue";
import { createElementVNode as y } from "vue";
import { unref as f } from "vue";
import { isRef as j } from "vue";
import { ElNotification as I } from "element-plus";
import { ElInput as U } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElDatePicker as L } from "element-plus";
import { ElForm as P } from "element-plus";
import { _ as W, u as A, i as T, bC as G, Cl as H, j as K } from "../../../../../../shared/runtime.js";
const M = { style: { display: "flex" } }, Q = { __name: "form", props: { modelValue: { type: Boolean, require: true }, lastTime: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(c, { emit: V }) {
  const u = c, s = d(), w = d(), m = d(false), p = { name: void 0, startDate: void 0, endDate: void 0, dateTimeList: [] }, e = d(JSON.parse(JSON.stringify(p))), x = { name: [{ required: true, message: "请输入本次关账名称", trigger: "blur" }], dateTimeList: [{ required: true, message: "请选择本次关账日期", trigger: "change" }], startDate: [{ required: true, message: "请选择开始日期", trigger: "change" }], endDate: [{ required: true, message: "请选择结束日期", trigger: "change" }] }, g = V, { visible: i, handleClose: v } = A({ emit: g, props: u });
  function h(t) {
    return e.value.endDate ? t.getTime() > e.value.endDate || t.getTime() > (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3 : t.getTime() > (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3;
  }
  function N(t) {
    return e.value.startDate ? t.getTime() < e.value.startDate || t.getTime() > (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3 : t.getTime() > (/* @__PURE__ */ new Date()).getTime() - 1 * 24 * 60 * 60 * 1e3;
  }
  B(() => i.value, (t) => {
    t && k();
  }, { deep: true, immediate: true });
  function k(t) {
    s.value && s.value.resetFields(), t && Object.keys(t).length > 0 ? e.value = JSON.parse(JSON.stringify(t)) : e.value = JSON.parse(JSON.stringify(p)), T(u.lastTime) && (e.value.startDate = Number(u.lastTime.endTime) + 1 * 1e3), s.value && J(() => {
      s.value.clearValidate();
    }), G(s, e);
  }
  async function O() {
    m.value = true;
    try {
      if (!await s.value.validate()) return;
      const a = Number(e.value.endDate) + (1 * 24 * 60 * 60 * 1e3 - 1e3);
      e.value.dateTimeList = [e.value.startDate, a], await H(e.value), K.dispatch("config/fetchCloseTime"), I({ title: "新增成功", type: "success" }), g("success"), v();
    } catch (t) {
      console.log("提交失败", t);
    } finally {
      m.value = false;
    }
  }
  return (t, a) => {
    const _ = b("common-button"), F = U, r = z, D = L, S = P, C = b("common-dialog");
    return R(), q(C, { ref_key: "drawerRef", ref: w, "append-to-body": "", modelValue: f(i), "onUpdate:modelValue": a[3] || (a[3] = (n) => j(i) ? i.value = n : null), title: "关账", center: false, "close-on-click-modal": false, "before-close": f(v), width: "550px" }, { titleRight: o(() => [l(_, { loading: m.value, type: "primary", size: "default", onClick: O }, { default: o(() => a[4] || (a[4] = [E("提交")])), _: 1, __: [4] }, 8, ["loading"])]), default: o(() => [l(S, { ref_key: "formRef", ref: s, model: e.value, rules: x, size: "default", "label-width": "140px" }, { default: o(() => [l(r, { label: "本次关账", prop: "name" }, { default: o(() => [l(F, { modelValue: e.value.name, "onUpdate:modelValue": a[0] || (a[0] = (n) => e.value.name = n), type: "text", placeholder: "本次关账", style: { width: "250px" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "本次关账日期", prop: "startDate" }, { default: o(() => [y("div", M, [l(r, { "label-width": "0", prop: "startDate" }, { default: o(() => [l(D, { modelValue: e.value.startDate, "onUpdate:modelValue": a[1] || (a[1] = (n) => e.value.startDate = n), type: "date", "value-format": "x", placeholder: "开始日期", style: { width: "160px" }, disabledDate: h, disabled: f(T)(c.lastTime.endTime) }, null, 8, ["modelValue", "disabled"])]), _: 1 }), a[5] || (a[5] = y("span", null, "：", -1)), l(r, { "label-width": "0", prop: "endDate" }, { default: o(() => [l(D, { modelValue: e.value.endDate, "onUpdate:modelValue": a[2] || (a[2] = (n) => e.value.endDate = n), type: "date", "value-format": "x", placeholder: "完成日期", style: { width: "160px" }, disabledDate: N }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Z = W(Q, [["__scopeId", "data-v-e7f888ad"]]);
export {
  Z as default
};
