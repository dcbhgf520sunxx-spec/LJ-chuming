import { ref as h } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as g } from "vue";
import { createBlock as R } from "vue";
import { withCtx as r } from "vue";
import { unref as f } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as O } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as j } from "vue";
import { Fragment as D } from "vue";
import { renderList as G } from "vue";
import { toDisplayString as E } from "vue";
import { createElementVNode as m } from "vue";
import { isRef as K } from "vue";
import { nextTick as W } from "vue";
import { ElNotification as $ } from "element-plus";
import { ElCheckbox as Q } from "element-plus";
import { ElCheckboxGroup as X } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { _ as oe, u as te, af as n, l as policyRequest, i as _, G as le, bC as ne, xi as re } from "../../../../shared/runtime.js";
import { v as ie, n as x, l as L, s as S } from "../../../../modules/password-validation-8d186430.js";
import { u as ue } from "../../../../modules/user-2de6904c.js";
const de = { __name: "password-strategy", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue"], setup(k, { emit: N }) {
  const C = N, P = k, { visible: V, handleClose: y } = te({ emit: C, props: P, showHook: U }), b = { setRules: [n.NUMBER.V, n.SPECIAL_CHARACTERS.V, n.LETTER.V], minLength: 8, password: void 0, loginVerification: true }, d = h(), o = h(JSON.parse(JSON.stringify(b))), c = h(false), policyReady = h(false), policyLoading = h(false), defaultPasswordConfigured = h(false);
  function T(t, e) {
    let l = "";
    const a = [];
    if (t.includes(n.NUMBER.V) && (l += x, a.push(x)), t.includes(n.LETTER.V) && (l += L, a.push(L)), t.includes(n.SPECIAL_CHARACTERS.V) && (l += S, a.push(S)), !l) return "";
    let i = "";
    for (const p of a) i += p[Math.floor(Math.random() * p.length)];
    for (; i.length < e; ) i += l[Math.floor(Math.random() * l.length)];
    return i = A(i), i;
  }
  function A(t) {
    const e = Array.from(t), l = e.length;
    for (let a = l - 1; a > 0; a--) {
      const i = Math.floor(Math.random() * (a + 1));
      [e[a], e[i]] = [e[i], e[a]];
    }
    return e.join("");
  }
  const M = { setRules: { required: true, message: "请选择密码组成规则", trigger: "change" }, minLength: { required: true, message: "请设置最小长度", trigger: "change" }, password: { required: false, validator: (t, e, l) => {
    if (!e && defaultPasswordConfigured.value) { l(); return; }
    if (!e) { l(new Error("请输入默认密码")); return; }
    const a = ie(e, o.value.setRules, o.value.minLength);
    a ? l(new Error(a)) : l();
  }, trigger: "blur" }, loginVerification: { required: true, message: "请选择是否强制校验", trigger: "change" } };
  function B() {
    policyReady.value = false;
    defaultPasswordConfigured.value = false;
    d.value && d.value.resetFields(), o.value = JSON.parse(JSON.stringify(b)), o.value.password = "", c.value = false, d.value && W(() => {
      d.value.clearValidate();
    }), ne(d, o);
  }
  function U() {
    B(), I();
  }
  async function I() {
    policyLoading.value = true;
    policyReady.value = false;
    try {
      const t = await policyRequest({ url: "/api/config/passwordPolicy/editable", method: "get" });
      if (!t || typeof t !== "object") throw new Error("密码策略数据格式错误");
      o.value.setRules = [];
      if (t.containNumbers) o.value.setRules.push(n.NUMBER.V);
      if (t.containLetter) o.value.setRules.push(n.LETTER.V);
      if (t.containSpecialCharacters) o.value.setRules.push(n.SPECIAL_CHARACTERS.V);
      if (_(t.minLength)) o.value.minLength = t.minLength;
      o.value.password = "";
      defaultPasswordConfigured.value = t.defaultPasswordConfigured === true;
      if (_(t.loginVerification)) o.value.loginVerification = t.loginVerification;
      policyReady.value = true;
    } catch (error) {
      o.value.password = "";
      $({ title: "密码策略加载失败，请稍后重试", type: "error" });
    } finally {
      policyLoading.value = false;
    }
  }
  async function q() {
    if (!policyReady.value || policyLoading.value) return;
    try {
      if (!await d.value.validate()) return;
      const e = { containNumbers: o.value.setRules.includes(n.NUMBER.V), containLetter: o.value.setRules.includes(n.LETTER.V), containSpecialCharacters: o.value.setRules.includes(n.SPECIAL_CHARACTERS.V), minLength: o.value.minLength, loginVerification: o.value.loginVerification };
      if (o.value.password) e.password = o.value.password;
      await re(e), $({ title: "密码策略配置成功", type: "success" }), C("success"), y();
    } catch (t) {
      console.log("密码策略配置失败", t);
    }
  }
  return (t, e) => {
    const l = w("common-button"), a = Q, i = X, p = Y, z = w("common-input-number"), F = Z, H = ee, J = w("common-dialog");
    return g(), R(J, { "append-to-body": "", modelValue: f(V), "onUpdate:modelValue": e[5] || (e[5] = (s) => K(V) ? V.value = s : null), title: "密码策略", "close-on-click-modal": false, "before-close": f(y), top: "10vh", width: "550px" }, { titleRight: r(() => [f(le)(f(ue).editPasswordPolicy) ? (g(), R(l, { key: 0, type: "primary", size: "default", loading: policyLoading.value, disabled: !policyReady.value, onClick: q }, { default: r(() => e[6] || (e[6] = [v("确认")])), _: 1, __: [6] }, 8, ["loading", "disabled"])) : O("", true)]), default: r(() => [u(H, { ref_key: "formRef", ref: d, model: o.value, rules: M, size: "default", "label-width": "100px", autocomplete: "off" }, { default: r(() => [u(p, { label: "设置规则：", prop: "setRules" }, { default: r(() => [u(i, { modelValue: o.value.setRules, "onUpdate:modelValue": e[0] || (e[0] = (s) => o.value.setRules = s), size: "default" }, { default: r(() => [(g(true), j(D, null, G(f(n).ENUM, (s) => (g(), R(a, { key: s.K, label: s.V, value: s.V }, { default: r(() => [v(E(s.L), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), u(p, { label: "最小长度：", prop: "minLength" }, { default: r(() => [u(z, { modelValue: o.value.minLength, "onUpdate:modelValue": e[1] || (e[1] = (s) => o.value.minLength = s), step: 1, min: 6, max: 20, precision: 0, "controls-position": "right", size: "default", placeholder: "最小长度", style: { width: "120px" } }, null, 8, ["modelValue"]), e[7] || (e[7] = m("span", null, "    位（6-20位）", -1))]), _: 1, __: [7] }), u(p, { label: "默认密码：", prop: "password" }, { default: r(() => [u(F, { modelValue: o.value.password, disabled: !policyReady.value, "onUpdate:modelValue": e[2] || (e[2] = (s) => o.value.password = s), modelModifiers: { trim: true }, type: c.value ? "" : "password", placeholder: defaultPasswordConfigured.value ? "已设置，留空保留" : "请输入默认密码", autocomplete: "new-password", maxlength: "20", style: { width: "270px" } }, null, 8, ["modelValue", "type", "disabled", "placeholder"]), u(l, { class: "show-password-button", type: "primary", size: "default", onClick: e[3] || (e[3] = (s) => c.value = !c.value) }, { default: r(() => [v(E(c.value ? "隐藏密码" : "显示密码"), 1)]), _: 1 })]), _: 1 }), u(p, { label: "", prop: "loginVerification", class: "bool-verify" }, { default: r(() => [u(a, { modelValue: o.value.loginVerification, "onUpdate:modelValue": e[4] || (e[4] = (s) => o.value.loginVerification = s), size: "large" }, { default: r(() => e[8] || (e[8] = [v(" 密码规则调整后登录强制校验 ")])), _: 1, __: [8] }, 8, ["modelValue"])]), _: 1 }), e[9] || (e[9] = m("div", { class: "explain" }, [m("p", { class: "explain-title" }, "说明："), m("p", { class: "explain-text" }, "1、修改默认密码后，新的默认密码仅针对后续新增的用户生效。"), m("p", { class: "explain-text" }, [m("span", null, "2、当前密码规则仅对普通用户生效；超级管理员用户必须是强密码"), m("span", null, "   （8-20位，含数字、字母、特殊字符的密码）。")])], -1))]), _: 1, __: [9] }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ve = oe(de, [["__scopeId", "data-v-1f755e82"]]);
export {
  ve as default
};
