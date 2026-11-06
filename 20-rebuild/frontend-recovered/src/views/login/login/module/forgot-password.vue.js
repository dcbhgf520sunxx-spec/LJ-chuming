import { ref as t } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as $ } from "vue";
import { createBlock as x } from "vue";
import { ElMessage as _ } from "element-plus";
import { nextTick as P } from "vue";
import { ElInput as R } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElLink as D } from "element-plus";
import { ElForm as G } from "element-plus";
import { _ as M, b as S, a1 as A, a2 as H, a as J } from "../../../../shared/runtime.js";
const K = { class: "verification-code" }, O = { __name: "forgot-password", emits: ["returnLogin"], setup(Q, { emit: k }) {
  const g = k, F = { phone: [{ required: true, message: "请输入手机号", trigger: "blur" }, { validator: (s, e, l) => {
    /^1[3-9]\d{9}$/.test(o.value.phone) ? l() : l(new Error("请输入正确的手机号"));
  }, trigger: "blur" }], verifyCode: [{ required: true, message: "请输入验证码", trigger: "blur" }], password: [{ required: true, message: "请输入密码", trigger: "blur" }], confirmPassword: [{ required: true, message: "请再次输入密码", trigger: "blur" }, { validator: (s, e, l) => {
    o.value.password && o.value.password !== o.value.confirmPassword ? l(new Error("两次输入的密码不一致")) : l();
  }, trigger: "blur" }] }, m = t(false), o = t({ password: void 0, verifyCode: void 0, phone: void 0, confirmPassword: void 0 }), y = t(), u = t(false), p = t(60), i = t("password"), b = t(), d = t("password"), C = t();
  E();
  function E() {
    o.value = {}, d.value = "password", i.value = "password";
  }
  async function z() {
    let s;
    try {
      if (S(o.value.phone)) {
        _.error("请输入手机号");
        return;
      }
      if (!/^1[3-9]\d{9}$/.test(o.value.phone)) {
        _.error("请输入正确的手机号");
        return;
      }
      const e = { phone: o.value.phone };
      p.value = 60, u.value = true, await A(e), s = setInterval(() => {
        p.value--, p.value <= 0 && (u.value = false, clearInterval(s));
      }, 1e3);
    } catch (e) {
      console.log(e, "获取失败"), u.value = false, clearInterval(s);
    }
  }
  function B() {
    d.value === "password" ? d.value = "" : d.value = "password", P(() => {
      C.value.focus();
    });
  }
  function I() {
    i.value === "password" ? i.value = "" : i.value = "password", P(() => {
      b.value.focus();
    });
  }
  async function q() {
    var s;
    m.value = true;
    try {
      await ((s = y.value) == null ? void 0 : s.validate()), await H(o.value), _.success("重置成功"), g("returnLogin", "login");
    } catch (e) {
      console.log(e);
    } finally {
      m.value = false;
    }
  }
  return (s, e) => {
    const l = R, c = j, V = T("common-button"), h = J, L = D, N = G;
    return v(), U("div", null, [e[7] || (e[7] = f("div", { class: "title-container" }, [f("h3", { class: "title" }, " 重置密码 ")], -1)), a(N, { ref_key: "resetFormRef", ref: y, model: o.value, rules: F, "auto-complete": "off", class: "reset-form", "label-position": "left" }, { default: n(() => [a(c, { label: "手机号：", "label-width": "100", prop: "phone" }, { default: n(() => [a(l, { ref: "username", modelValue: o.value.phone, "onUpdate:modelValue": e[0] || (e[0] = (r) => o.value.phone = r), "auto-complete": "off", name: "phone", placeholder: "手机号", size: "default", tabindex: "1", type: "text" }, null, 8, ["modelValue"])]), _: 1 }), a(c, { class: "verification-code-item", label: "验证码：", "label-width": "100", prop: "verifyCode" }, { default: n(() => [f("div", K, [a(l, { ref: "username", modelValue: o.value.verifyCode, "onUpdate:modelValue": e[1] || (e[1] = (r) => o.value.verifyCode = r), "auto-complete": "off", class: "input-verification-code", name: "verifyCode", placeholder: "验证码", size: "default", tabindex: "1", type: "text" }, null, 8, ["modelValue"]), a(V, { disabled: u.value, class: "get-verification-code", plain: "", onClick: z }, { default: n(() => [w($(u.value ? `${p.value}秒后重新获取` : "获取验证码"), 1)]), _: 1 }, 8, ["disabled"])])]), _: 1 }), a(c, { label: "密  码：", "label-width": "100", prop: "password" }, { default: n(() => [(v(), x(l, { key: i.value, ref_key: "password", ref: b, modelValue: o.value.password, "onUpdate:modelValue": e[2] || (e[2] = (r) => o.value.password = r), type: i.value, "auto-complete": "off", name: "password", placeholder: "密码", size: "default", tabindex: "1" }, null, 8, ["modelValue", "type"])), f("span", { class: "show-pwd", onClick: I }, [a(h, { "icon-class": i.value === "password" ? "eye" : "eye-open" }, null, 8, ["icon-class"])])]), _: 1 }), a(c, { label: "确认密码：", "label-width": "100", prop: "confirmPassword" }, { default: n(() => [(v(), x(l, { key: d.value, ref_key: "confirmPassword", ref: C, modelValue: o.value.confirmPassword, "onUpdate:modelValue": e[3] || (e[3] = (r) => o.value.confirmPassword = r), type: d.value, "auto-complete": "off", name: "confirmPassword", placeholder: "请再次输入密码", size: "default", tabindex: "1" }, null, 8, ["modelValue", "type"])), f("span", { class: "show-pwd", onClick: B }, [a(h, { "icon-class": d.value === "password" ? "eye" : "eye-open" }, null, 8, ["icon-class"])])]), _: 1 }), a(V, { loading: m.value, size: "default", style: { width: "396px", "margin-bottom": "10px", "margin-left": "54px" }, type: "primary", onClick: q }, { default: n(() => e[5] || (e[5] = [w(" 确认重置 ")])), _: 1, __: [5] }, 8, ["loading"]), a(L, { underline: false, size: "default", style: { width: "396px", "margin-bottom": "30px", "margin-left": "54px" }, onClick: e[4] || (e[4] = (r) => g("returnLogin", "login")) }, { default: n(() => e[6] || (e[6] = [w(" 返回登录 > ")])), _: 1, __: [6] })]), _: 1 }, 8, ["model"])]);
  };
} }, ee = M(O, [["__scopeId", "data-v-83572c71"]]);
export {
  ee as default
};
