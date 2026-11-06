import { ref as c } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as x } from "vue";
import { createBlock as D } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as B } from "vue";
import { toDisplayString as E } from "vue";
import { unref as g } from "vue";
import { isRef as N } from "vue";
import R from "moment";
import { ElFormItem as j } from "element-plus";
import { ElTimePicker as z } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElForm as I } from "element-plus";
import { l as d, u as P } from "../../../../shared/runtime.js";
function U(t) {
  return d({ url: "/api/trip/list", method: "get", params: t });
}
function q(t) {
  return d({ url: "/api/trip/create", method: "post", data: t });
}
function Y(t) {
  return d({ url: "/api/trip/delete", method: "delete", params: t });
}
function F() {
  const t = c([]);
  async function u({ params: s }) {
    try {
      const o = await U(s);
      console.log(o), t.value = o;
    } catch (o) {
      console.log(o);
    }
  }
  async function r(s) {
    try {
      await q(s);
    } catch (o) {
      console.log(o);
    }
  }
  return { nowMonthList: t, fetchScheduleData: u, submit: r };
}
const L = { __name: "schedule-dialog", props: { modelVlue: { type: Boolean, default: void 0 }, nowDate: { type: [String, Number], default: void 0 } }, emits: ["update:modelValue", "createSuccess"], setup(t, { emit: u }) {
  const r = t, s = u, { visible: o, handleClose: p } = P({ emit: s, props: r }), { submit: v } = F(), f = c(), l = c({ setTime: void 0, title: void 0 }), b = { setTime: [{ required: true, message: "请选择日期", trigger: "blur" }], title: [{ required: true, message: "请输入日程标题", trigger: "blur" }] };
  async function h() {
    if (await f.value.validate()) try {
      const e = R(l.value.setTime).format("HH:mm:ss");
      l.value.setTime = (/* @__PURE__ */ new Date(r.nowDate + " " + e)).getTime(), await v(l.value), p(), s("createSuccess", l.value), l.value = {};
    } catch (e) {
      console.log(e);
    }
  }
  return (w, e) => {
    const y = _("common-button"), m = j, V = z, T = H, S = I, k = _("common-dialog");
    return x(), D(k, { modelValue: g(o), "onUpdate:modelValue": e[2] || (e[2] = (i) => N(o) ? o.value = i : null), "before-close": g(p), title: "创建日程", width: "450px" }, { titleRight: a(() => [n(y, { type: "primary", size: "mini", onClick: h }, { default: a(() => e[3] || (e[3] = [C("确认")])), _: 1, __: [3] })]), default: a(() => [n(S, { ref_key: "formRef", ref: f, "label-width": "55px", model: l.value, rules: b }, { default: a(() => [n(m, { label: "日期" }, { default: a(() => [B("span", null, E(r.nowDate), 1)]), _: 1 }), n(m, { label: "时间", prop: "setTime" }, { default: a(() => [n(V, { modelValue: l.value.setTime, "onUpdate:modelValue": e[0] || (e[0] = (i) => l.value.setTime = i), placeholder: "请选择时间", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), n(m, { label: "标题", prop: "title" }, { default: a(() => [n(T, { modelValue: l.value.title, "onUpdate:modelValue": e[1] || (e[1] = (i) => l.value.title = i), placeholder: "请输入标题，最多支持20个字符", style: { width: "100%" }, maxlength: "20", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, A = Object.freeze(Object.defineProperty({ __proto__: null, default: L }, Symbol.toStringTag, { value: "Module" }));
export {
  L as _,
  Y as d,
  A as s,
  F as u
};
