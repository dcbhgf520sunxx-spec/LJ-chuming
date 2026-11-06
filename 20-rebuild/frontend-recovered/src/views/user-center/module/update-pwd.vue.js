import { ref as r } from "vue";
import { computed as M } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as y } from "vue";
import { createBlock as H } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as x } from "vue";
import { createElementBlock as b } from "vue";
import { toDisplayString as j } from "vue";
import { unref as z } from "vue";
import { isRef as $ } from "vue";
import { ElMessage as D } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElFormItem as J } from "element-plus";
import { ElForm as K } from "element-plus";
import { _ as O, u as Q, G as W, af as c, ag as X, ah as Y, a as Z } from "../../../shared/runtime.js";
import { v as ee } from "../../../modules/password-validation-8d186430.js";
const oe = { class: "explain" }, le = { key: 0 }, se = { key: 1 }, ae = { class: "dialog-footer" }, ne = { __name: "update-pwd", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue"], setup(R, { emit: k }) {
  const B = k, T = R, { visible: f, handleClose: A } = Q({ emit: B, props: T, showHook: L }), w = r(), i = r([]), m = r([]), V = M(() => W(["admin"]));
  function L() {
    V.value ? (i.value = [c.NUMBER.V, c.SPECIAL_CHARACTERS.V, c.LETTER.V], w.value = 8) : S();
  }
  async function S() {
    try {
      const { containNumbers: n = false, containSpecialCharacters: e = false, containLetter: l = false, minLength: t = 8 } = await X();
      n && (m.value.push("数字"), i.value.push(c.NUMBER.V)), e && (m.value.push("特殊字符"), i.value.push(c.SPECIAL_CHARACTERS.V)), l && (m.value.push("字母"), i.value.push(c.LETTER.V)), w.value = t;
    } catch (n) {
      console.log(n);
    }
  }
  const U = { oldPwd: [{ required: true, message: "请填写旧密码", trigger: "blur" }], newPwd: { required: true, validator: (n, e, l) => {
    const t = ee(e, i.value, w.value);
    t ? l(new Error(t)) : l();
  }, trigger: "blur" }, confirmPwd: [{ required: true, validator: (n, e, l) => {
    e ? o.value.newPwd !== e ? l(new Error("两次输入的密码不一致")) : o.value.oldPwd.length >= 6 && o.value.oldPwd === o.value.newPwd ? l(new Error("新密码与旧密码一致")) : l() : l(new Error("请再次输入新密码"));
  }, trigger: "blur" }] }, v = r(), _ = r(false), a = r("password"), o = r({ oldPwd: "", newPwd: "", confirmPwd: "" });
  function h() {
    N(), A();
  }
  function I() {
    v.value.validate((n) => {
      if (n) _.value = true, Y(o.value).then((e) => {
        D.success("密码修改成功"), h();
      }).catch((e) => {
        console.log(e.response.data.message);
      }).finally(() => {
        _.value = false;
      });
      else return false;
    });
  }
  function N() {
    v.value.resetFields(), o.value = { oldPwd: "", newPwd: "", confirmPwd: "" }, m.value = [], i.value = [];
  }
  function P() {
    a.value = a.value === "password" ? "" : "password";
  }
  return (n, e) => {
    const l = G, t = Z, g = J, F = K, E = C("common-button"), q = C("common-dialog");
    return y(), H(q, { "append-to-body": "", modelValue: z(f), "onUpdate:modelValue": e[3] || (e[3] = (d) => $(f) ? f.value = d : null), width: "520px", title: "修改密码", "show-close": false, "close-on-click-modal": false }, { footer: u(() => [p("div", ae, [s(E, { link: "", type: "primary", onClick: h }, { default: u(() => e[5] || (e[5] = [x("取消")])), _: 1, __: [5] }), s(E, { loading: _.value, type: "primary", onClick: I }, { default: u(() => e[6] || (e[6] = [x("确认")])), _: 1, __: [6] }, 8, ["loading"])])]), default: u(() => [s(F, { ref_key: "formRef", ref: v, model: o.value, rules: U, size: "default", "label-width": "88px" }, { default: u(() => [s(g, { label: "旧密码", prop: "oldPwd" }, { default: u(() => [s(l, { modelValue: o.value.oldPwd, "onUpdate:modelValue": e[0] || (e[0] = (d) => o.value.oldPwd = d), type: a.value, maxlength: "20", "auto-complete": "on", style: { width: "360px" } }, null, 8, ["modelValue", "type"]), p("span", { class: "show-pwd", onClick: P }, [s(t, { "icon-class": a.value === "password" ? "eye" : "eye-open" }, null, 8, ["icon-class"])])]), _: 1 }), s(g, { label: "新密码", prop: "newPwd" }, { default: u(() => [s(l, { modelValue: o.value.newPwd, "onUpdate:modelValue": e[1] || (e[1] = (d) => o.value.newPwd = d), type: a.value, maxlength: "20", "auto-complete": "on", style: { width: "360px" } }, null, 8, ["modelValue", "type"]), p("span", { class: "show-pwd", onClick: P }, [s(t, { "icon-class": a.value === "password" ? "eye" : "eye-open" }, null, 8, ["icon-class"])])]), _: 1 }), s(g, { label: "确认密码", prop: "confirmPwd" }, { default: u(() => [s(l, { modelValue: o.value.confirmPwd, "onUpdate:modelValue": e[2] || (e[2] = (d) => o.value.confirmPwd = d), type: a.value, maxlength: "20", "auto-complete": "on", style: { width: "360px" } }, null, 8, ["modelValue", "type"]), p("span", { class: "show-pwd", onClick: P }, [s(t, { "icon-class": a.value === "password" ? "eye" : "eye-open" }, null, 8, ["icon-class"])])]), _: 1 }), p("p", oe, [e[4] || (e[4] = p("span", null, "密码规则：", -1)), V.value ? (y(), b("span", le, "数字 + 特殊字符 + 字母、长度为8-20位。")) : (y(), b("span", se, j(`${m.value.join(" + ")}、长度为${w.value}-20位。`), 1))])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, ie = O(ne, [["__scopeId", "data-v-6248e31b"]]);
export {
  ie as default
};
