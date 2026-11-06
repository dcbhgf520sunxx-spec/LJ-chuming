import { ref as i } from "vue";
import { useRouter as ee } from "vue-router";
import { computed as k } from "vue";
import { resolveComponent as le } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as l } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as a } from "vue";
import { createTextVNode as o } from "vue";
import { toDisplayString as p } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as z } from "vue";
import { ElTabs as te } from "element-plus";
import { ElTabPane as M } from "element-plus";
import { ElRadioGroup as ae } from "element-plus";
import { Fragment as se } from "vue";
import { renderList as oe } from "vue";
import { createBlock as I } from "vue";
import { ElMessage as V } from "element-plus";
import { ElCard as ne } from "element-plus";
import { ElCol as ue } from "element-plus";
import { ElInput as re } from "element-plus";
import { ElFormItem as ie } from "element-plus";
import { ElForm as de } from "element-plus";
import { ElOption as pe } from "element-plus";
import { ElSelect as me } from "element-plus";
import { ElPopover as fe } from "element-plus";
import { ElRow as ve } from "element-plus";
import { ElRadio as _e } from "element-plus";
import { _ as ge, m as be, g as ye, d as xe, e as ce, f as Ve, v as Ce, h as Ee, j as q, k as Ue } from "../../shared/runtime.js";
import we from "./module/update-pwd.vue.js";
import "../../modules/password-validation-8d186430.js";
const ke = { class: "app-container" }, Re = { class: "user-info" }, ze = { class: "user-right" }, Ie = { class: "user-right" }, qe = { class: "user-right" }, Se = { class: "user-right" }, Te = { class: "user-right" }, je = { key: 0 }, Be = { class: "user-right" }, Fe = { class: "reg-company-box" }, Ne = { style: { "text-align": "right", margin: "0" } }, De = { __name: "index", setup(Le) {
  var j, B, F, N;
  const { user: u } = be("user"), O = { name: [{ required: true, message: "请填写用户姓名", trigger: "blur" }, { min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur" }], phone: [{ required: true, message: "请填写手机号", trigger: "blur" }, { pattern: Ce, message: "请填写正确的手机号", trigger: "blur" }] }, _ = i(), $ = i(), h = ee(), C = i(false), g = i(false), E = i({ id: (j = u.value) == null ? void 0 : j.id, name: (B = u.value) == null ? void 0 : B.name, sex: (F = u.value) == null ? void 0 : F.sex, phone: (N = u.value) == null ? void 0 : N.phone }), r = i({}), b = i(false), A = i(false), y = i("https://"), x = i(""), U = ye(), K = k(() => !xe(r.value, E.value)), c = k(() => y.value + x.value), Q = k(() => c.value !== U);
  T(), S();
  function S() {
    const d = U.split("://");
    y.value = d[0] + "://", x.value = d[1];
  }
  async function H() {
    try {
      Ee(c.value) ? c.value === U ? V.warning("未对公司域名进行修改") : (V.success("修改成功，请重新登录"), q.dispatch("user/setRequestUrl", c.value), setTimeout(() => {
        q.dispatch("user/logout"), h.push("/"), setTimeout(() => {
          location.reload();
        }, 300);
      }, 1e3)) : V.warning("错误格式的域名");
    } catch (d) {
      console.log(d);
    } finally {
      b.value = false;
    }
  }
  function T() {
    r.value = { ...E.value }, _.value && _.value.clearValidate();
  }
  function J() {
    _.value && _.value.validate((d) => {
      d && (g.value = true, Ue(r.value).then(() => {
        V.success("修改成功"), E.value = { ...r.value }, q.dispatch("user/getInfo").then(() => {
        }), g.value = false;
      }).catch(() => {
        g.value = false;
      }));
    });
  }
  return (d, e) => {
    const D = ne, L = ue, w = re, m = ie, W = _e, f = le("common-button"), P = de, G = pe, X = me, Y = fe, Z = ve;
    return v(), R("div", ke, [l(Z, { gutter: 20 }, { default: t(() => [l(L, { xs: 24, sm: 24, md: 8, lg: 6, xl: 5, style: { "margin-bottom": "10px" } }, { default: t(() => [l(D, { class: "box-card" }, { header: t(() => e[9] || (e[9] = [a("span", null, "个人信息", -1)])), default: t(() => [a("div", null, [e[16] || (e[16] = a("div", { style: { "text-align": "center" } }, [a("img", { src: ce, class: "avatar" })], -1)), a("ul", Re, [a("li", null, [e[10] || (e[10] = o(" 用户姓名 ")), a("div", ze, p(n(u).name), 1)]), a("li", null, [e[11] || (e[11] = o(" 员工编号 ")), a("div", Ie, p(n(u).username), 1)]), a("li", null, [e[12] || (e[12] = o(" 手机号码 ")), a("div", qe, p(n(u).phone), 1)]), a("li", null, [e[13] || (e[13] = o(" 用户邮箱 ")), a("div", Se, p(n(u).email), 1)]), a("li", null, [e[14] || (e[14] = o(" 所属部门 ")), a("div", Te, [o(p(n(u).dept) + " ", 1), n(u).job ? (v(), R("span", je, "/ " + p(n(u).job), 1)) : z("", true)])]), a("li", null, [e[15] || (e[15] = o(" 安全设置 ")), a("div", Be, [a("a", { onClick: e[0] || (e[0] = (s) => C.value = true) }, "修改密码")])])])])]), _: 1 })]), _: 1 }), l(L, { xs: 24, sm: 24, md: 16, lg: 18, xl: 19 }, { default: t(() => [l(D, { class: "box-card" }, { default: t(() => [l(n(te), null, { default: t(() => [l(n(M), { label: "用户资料" }, { default: t(() => [l(P, { ref_key: "formRef", ref: _, model: r.value, rules: O, size: "default", "label-width": "65px" }, { default: t(() => [l(m, { label: "姓名", prop: "name" }, { default: t(() => [l(w, { modelValue: r.value.name, "onUpdate:modelValue": e[1] || (e[1] = (s) => r.value.name = s), style: { width: "35%" } }, null, 8, ["modelValue"]), e[17] || (e[17] = a("span", { style: { color: "#C0C0C0", "margin-left": "10px" } }, "用户姓名不作为登录使用", -1))]), _: 1, __: [17] }), l(m, { label: "手机号", prop: "phone" }, { default: t(() => [l(w, { modelValue: r.value.phone, "onUpdate:modelValue": e[2] || (e[2] = (s) => r.value.phone = s), style: { width: "35%" } }, null, 8, ["modelValue"]), e[18] || (e[18] = a("span", { style: { color: "#C0C0C0", "margin-left": "10px" } }, "手机号码不能重复", -1))]), _: 1, __: [18] }), l(m, { label: "性别", prop: "sex" }, { default: t(() => [l(n(ae), { modelValue: r.value.sex, "onUpdate:modelValue": e[3] || (e[3] = (s) => r.value.sex = s), style: { width: "178px" } }, { default: t(() => [(v(true), R(se, null, oe(n(Ve).ENUM, (s) => (v(), I(W, { key: s.V, value: s.V }, { default: t(() => [o(p(s.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), K.value ? (v(), I(m, { key: 0, label: "" }, { default: t(() => [l(f, { loading: g.value, size: "default", type: "primary", onClick: J }, { default: t(() => e[19] || (e[19] = [o("保存配置")])), _: 1, __: [19] }, 8, ["loading"]), l(f, { size: "default", type: "warning", onClick: T }, { default: t(() => e[20] || (e[20] = [o("取消修改")])), _: 1, __: [20] })]), _: 1 })) : z("", true)]), _: 1 }, 8, ["model"])]), _: 1 }), l(n(M), { label: "公司资料" }, { default: t(() => [l(P, { size: "default", "label-width": "75px" }, { default: t(() => [l(m, { label: "公司域名" }, { default: t(() => [a("div", Fe, [l(w, { modelValue: x.value, "onUpdate:modelValue": e[5] || (e[5] = (s) => x.value = s), placeholder: "请填写公司域名", class: "input-with-select" }, { prepend: t(() => [l(X, { modelValue: y.value, "onUpdate:modelValue": e[4] || (e[4] = (s) => y.value = s), placeholder: "请选择" }, { default: t(() => [l(G, { label: "https://", value: "https://" }), l(G, { label: "http://", value: "http://" })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue"])])]), _: 1 }), Q.value ? (v(), I(m, { key: 0 }, { default: t(() => [l(Y, { visible: b.value, "onUpdate:visible": e[7] || (e[7] = (s) => b.value = s), placement: "bottom", width: 180 }, { reference: t(() => [l(f, { loading: A.value, size: "default", type: "primary" }, { default: t(() => e[23] || (e[23] = [o("保存配置")])), _: 1, __: [23] }, 8, ["loading"])]), default: t(() => [e[24] || (e[24] = a("p", null, "确认更换公司域名?", -1)), e[25] || (e[25] = a("p", null, "修改完成后需要重新登录", -1)), a("div", Ne, [l(f, { size: "default", link: "", type: "primary", onClick: e[6] || (e[6] = (s) => b.value = false) }, { default: t(() => e[21] || (e[21] = [o("取消")])), _: 1, __: [21] }), l(f, { type: "primary", size: "default", onClick: H }, { default: t(() => e[22] || (e[22] = [o("确定")])), _: 1, __: [22] })])]), _: 1, __: [24, 25] }, 8, ["visible"]), l(f, { size: "default", type: "warning", onClick: S }, { default: t(() => e[26] || (e[26] = [o("取消修改")])), _: 1, __: [26] })]), _: 1 })) : z("", true)]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }), l(n(we), { ref_key: "pwdRef", ref: $, modelValue: C.value, "onUpdate:modelValue": e[8] || (e[8] = (s) => C.value = s) }, null, 8, ["modelValue"])]);
  };
} }, $e = ge(De, [["__scopeId", "data-v-fb5f72ba"]]);
export {
  $e as default
};
